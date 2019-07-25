package com.leicx.xxz.service.impl;

import com.leicx.xxz.constant.ParamConstant;
import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.entity.UsersFans;
import com.leicx.xxz.mapper.UsersFansMapper;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.service.UsersFansService;
import com.leicx.xxz.util.MD5Util;
import com.leicx.xxz.util.MapUtil;
import com.leicx.xxz.util.RedisUtils;
import com.leicx.xxz.vo.UserVO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersFansService usersFansService;

    @Override
    public void insertUser(UserEntity user) {
        // 创建时间和更新时间
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        usersMapper.insert(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        user.setUpdateTime(new Date());
        usersMapper.update(user);
    }

    @Override
    public UserEntity getUserByName(String name, int del) {
        return usersMapper.getUserByName(name, del);
    }

    @Override
    public List<UserEntity> getUserList(Map<String, Object> params) {
        return usersMapper.getUserList(params);
    }

    @Override
    public UserEntity getUserById(Integer userId) {
        if (userId == null) {
            return null;
        }
        return usersMapper.getUserById(userId);
    }

    @Override
    public boolean userExistsByName(String name) {
        return userExistsByName(name, 0);
    }

    @Override
    public boolean userExistsByName(String name, int del) {
        UserEntity userEntity = getUserByName(name, del);
        return userEntity != null;
    }

    @Override
    public UserEntity getUserByNameAndPwd(String name, String pwd, int del) {
        // 密码进行md5转换
        pwd = MD5Util.EncoderByMd5(pwd);
        return usersMapper.getUserByNameAndPwd(name, pwd, del);
    }


    @Override
    public boolean userExistsByNameAndPwd(String name, String pwd) {
        return userExistsByNameAndPwd(name, pwd, 0);
    }

    @Override
    public UserVO doLogin(UserEntity userEntity) {
        // TODO 参数校验

        userEntity = getUserByNameAndPwd(userEntity.getName(), userEntity.getPassword(), 0);
        UserVO userVO = null;
        if (userEntity != null) {
            userVO = new UserVO();
            userVO.setUserEntity(userEntity);
            // 利用uuid获取token信息
            UUID uuid = UUID.randomUUID();
            String token = uuid.toString().replaceAll("-", "");
            userVO.setToken(token);

            // 将用户token存入redis
            redisUtils.set(SysConstant.REDIS_USER_TOKEN_KEY + ":" + userEntity.getId(), token, SysConstant.REDIS_KEY_TTL);
        }
        return userVO;
    }

    @Override
    public void doLogout(Integer userId) {
        redisUtils.del(SysConstant.REDIS_USER_TOKEN_KEY + ":" + userId);
    }

    @Override
    public boolean isFollow(Integer userId, Integer followUserId) {
        UsersFans usersFans = usersFansService.getByUserIdAndFanId(userId, followUserId);
        return usersFans != null && usersFans.getDel() != 1;
    }

    @Override
    public UserEntity unFollowUser(Integer userId, Integer followUserId) {
        usersFansService.cancelFollow(userId, followUserId);

        return setUserFollowFan(userId, followUserId, -1);
    }

    /**
     * 更改用户的关注数和粉丝数
     * @param userId
     * @param followUserId
     * @param mark  1：粉丝数、关注数+1；   -1：粉丝数、关注数-1
     * @return
     */
    public UserEntity setUserFollowFan(Integer userId, Integer followUserId, Integer mark) {
        Map<String, Object> param = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        MapUtil.addToMap(param, ParamConstant.ID_IN, Arrays.asList(userId, followUserId));
        List<UserEntity> userList = getUserList(param);
        Map<Integer, UserEntity> userMap = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        userList.forEach(item -> userMap.put(item.getId(), item));
        // 被关注用户粉丝数减少
        UserEntity followUser = userMap.get(userId);
        Long fansCounts = followUser.getFansCounts();
        followUser.setFansCounts(fansCounts + mark);
        saveUser(followUser);

        // 粉丝用户关注数减少
        UserEntity fansUser = userMap.get(followUserId);
        Long followsCounts = fansUser.getFollowsCounts();
        fansUser.setFollowsCounts(followsCounts + mark);
        saveUser(fansUser);
        return followUser;
    }

    @Override
    public UserEntity followUser(Integer userId, Integer followUserId) {
        UsersFans usersFans = usersFansService.getByUserIdAndFanId(userId, followUserId);
        if (usersFans != null) {
            usersFans.setDel(0);
        } else {
            usersFans = new UsersFans();
            usersFans.setUserId(userId);
            usersFans.setFanId(followUserId);
        }
        usersFansService.saveUsersFans(usersFans);

        return setUserFollowFan(userId, followUserId, 1);
    }

    @Override
    public String saveUserAvatar(Integer userId, MultipartFile files) {
        // 本地文件路径前缀
        String filePathPrefix = SysConstant.STATIC_PATH_REFIX;
        // 数据库保存的文件路径前缀
        String fileDbPathPrefix = "/avatar/" + userId + "/";

        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {
            String fileName = files.getOriginalFilename();
            // 最终文件DB路径
            fileDbPathPrefix += fileName;
            // 最终文件路径
            String finalFilePath = filePathPrefix + fileDbPathPrefix;
            File file = new File(finalFilePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            outputStream = new FileOutputStream(finalFilePath);
            inputStream = files.getInputStream();
            IOUtils.copy(inputStream, outputStream);

            // 保存到数据库
            UserEntity userEntity = getUserById(userId);
            userEntity.setAvatar(fileDbPathPrefix);
            updateUser(userEntity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileDbPathPrefix;
    }

    @Override
    public UserVO saveUser(UserEntity user) {
        Integer id = user.getId();
        UserVO userVO = new UserVO();
        userVO.setUserEntity(user);

        if (id == null) {
            // 用户密码加密
            String password = user.getPassword();
            String md5 = MD5Util.EncoderByMd5(password);
            user.setPassword(md5);
            insertUser(user);

            // 利用uuid获取token信息
            UUID uuid = UUID.randomUUID();
            String token = uuid.toString().replaceAll("-", "");
            userVO.setToken(token);

            // 将用户token存入redis
            redisUtils.set(SysConstant.REDIS_USER_TOKEN_KEY + ":" + user.getId(), token, SysConstant.REDIS_KEY_TTL);

        } else {
            updateUser(user);
        }
        return userVO;
}

    @Override
    public boolean userExistsByNameAndPwd(String name, String pwd, int del) {
        UserEntity userEntity = getUserByNameAndPwd(name, pwd, del);
        return userEntity != null;
    }
}

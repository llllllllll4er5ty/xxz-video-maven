package com.leicx.xxz.controller;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.enums.ErrorCodeEnum;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.LcxJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户注册的controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/changeAvatar")
    public LcxJSONResult changeAvatar(@RequestParam Integer userId, MultipartFile[] files) {
        // 校验
        if (userId == null || files == null || files.length == 0) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }
        // 用户头像上传服务器，并保存到数据库中
        String dbPath = userService.saveUserAvatar(userId, files[0]);
        return LcxJSONResult.ok(dbPath);
    }

    /**
     * 根据id获取用户信息
     * @author daxiong
     * @date 2019-07-25 10:14
     * @param userId    用户id
     * @return com.leicx.xxz.util.LcxJSONResult
     **/
    @RequestMapping("/get")
    public LcxJSONResult getUser(@RequestParam Integer userId) {
        // 校验
        if (userId == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }
        // 用户头像上传服务器，并保存到数据库中
        UserEntity userEntity = userService.getUserById(userId);
        return LcxJSONResult.ok(userEntity);
    }

    @RequestMapping("/follow")
    public LcxJSONResult follow(@RequestParam Integer userId, @RequestParam Integer followUserId) {
        // 校验
        if (userId == null || followUserId == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }

        UserEntity userEntity = userService.followUser(userId, followUserId);
        return LcxJSONResult.ok(userEntity);
    }
    @RequestMapping("/unFollow")
    public LcxJSONResult unFollow(@RequestParam Integer userId, @RequestParam Integer followUserId) {
        // 校验
        if (userId == null || followUserId == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }

        UserEntity userEntity = userService.unFollowUser(userId, followUserId);
        return LcxJSONResult.ok(userEntity);
    }
    @RequestMapping("/isFollow")
    public LcxJSONResult isFollow(@RequestParam Integer userId, @RequestParam Integer followUserId) {
        // 校验
        if (userId == null || followUserId == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }

        boolean isFollow = userService.isFollow(userId, followUserId);
        return LcxJSONResult.ok(isFollow);
    }
}

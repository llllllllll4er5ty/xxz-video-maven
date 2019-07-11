package com.leicx.xxz.controller;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.enums.ErrorCodeEnum;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.LcxJSONResult;
import com.leicx.xxz.util.StringUtils;
import com.leicx.xxz.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册的controller
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userEntity 封装了前端传入属性的用户实体
     * @return
     */
    @RequestMapping("/doLogin")
    public LcxJSONResult doLogin(@RequestBody UserEntity userEntity) {
        // 校验用户名和密码
        String name = userEntity.getName();
        String password = userEntity.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_200002);
        }

        // 用户校验
        UserVO userVO = userService.doLogin(userEntity);
        boolean exists = userVO != null;
        if (!exists) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_200004);
        }

        // 返回
        return LcxJSONResult.ok(userVO);
    }
    /**
     * 用户登出
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/doLogout")
    public LcxJSONResult doLogout(@RequestParam("userId") Integer userId) {
        // 校验用户名和密码
        if (userId == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }

        // 用户校验
        userService.doLogout(userId);

        // 返回
        return LcxJSONResult.ok(null);
    }
}

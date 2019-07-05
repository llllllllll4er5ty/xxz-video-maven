package com.leicx.xxz.controller;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.service.RegisterService;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.LcxJSONResult;
import com.leicx.xxz.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册的controller
 */
@RestController("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService userService;

    /**
     * 保存注册用户
     * @param userEntity 封装了前端传入属性的用户实体
     * @return
     */
    @RequestMapping("/save")
    public LcxJSONResult save(UserEntity userEntity) {
        // 校验用户名和密码
        if (userEntity == null) {
//            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_200001);
        }
        String name = userEntity.getName();
        String password = userEntity.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
//            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_200002);
        }

        // 用户校验
        boolean exists = userService.userExistsByName(name);
        if (exists) {
//            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_200002);
        }

        // 保存用户信息
        registerService.saveUser(userEntity);
        // 返回
        return LcxJSONResult.ok(userEntity);
    }
}

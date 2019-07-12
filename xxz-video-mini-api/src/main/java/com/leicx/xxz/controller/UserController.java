package com.leicx.xxz.controller;

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
        // 静态文件路径以static开头
        dbPath = "/static" + dbPath;
        return LcxJSONResult.ok(dbPath);
    }
}

package com.grgbanking.blockchain.controller;

import com.grgbanking.blockchain.service.IUserService;
import com.grgbanking.blockchain.common.jwt.JwtUser;
import com.grgbanking.blockchain.vo.LoginUser;
import com.grgbanking.blockchain.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/10/29 10:49
 * @describe：
 * @version: 1.0
 */
@Slf4j
@Api(tags = "登录")
@RestController
public class AuthController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录", notes = "用户名，密码登录格式 {\"username\":\"admin\",\"password\":\"admin\"}")
    @PostMapping(value = "${jwt.route.login}")
    public Result<String> login(@RequestBody LoginUser user) {
        log.info("LoginUser : {}", user);
        return Result.success("登录成功", userService.login(user.getUsername(), user.getPassword()));
    }

    @ApiOperation(value = "刷新Token", notes = "只需要在请求头中附带token即可，无需任何参数")
    @PostMapping(value = "${jwt.route.refresh}")
    public Result<String> refresh(@RequestHeader(value = "${jwt.tokenHeader}") String token) {
        JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("principal: {}", principal);
        return Result.success("刷新token成功!", userService.refreshToken(token));
    }

}

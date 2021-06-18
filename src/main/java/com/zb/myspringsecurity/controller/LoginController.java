package com.zb.myspringsecurity.controller;

import com.zb.myspringsecurity.config.security.ZxUser;
import com.zb.myspringsecurity.config.security.ZxUserDetailsServiceImpl;
import com.zb.myspringsecurity.config.vo.CommonResponse;
import com.zb.myspringsecurity.config.vo.LoginParamVo;
import com.zb.myspringsecurity.config.vo.TokenVo;
import com.zb.myspringsecurity.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zb
 * @since 2021/6/18
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/test")
    public String hello() {
        return "hello test";
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    ZxUserDetailsServiceImpl userDetailsService;
    
    @Resource
    TokenService tokenService;

    @RequestMapping("/login-in")
    public CommonResponse<TokenVo> login(@RequestBody LoginParamVo loginParamVo) {
        try {
            // 1 创建UsernamePasswordAuthenticationToken
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(loginParamVo.getUsername(), loginParamVo.getPassword());
            // 2 认证
            Authentication authentication = this.authenticationManager.authenticate(token);
            // 3 保存认证信息
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 4 加载UserDetails
            ZxUser zxUser = this.userDetailsService.loadUserByUsername(loginParamVo.getUsername());
            // 5 生成自定义token
            TokenVo tokenVo = tokenService.createToken(zxUser);
            return CommonResponse.successWithData(tokenVo);
        } catch (Exception e) {
            return CommonResponse.fail(401, e.getMessage());
        }

    }
}

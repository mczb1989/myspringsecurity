package com.zb.myspringsecurity.service;

import com.zb.myspringsecurity.config.vo.TokenVo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zb
 * @since 2021/6/18
 */
public interface TokenService {
    
    TokenVo createToken(UserDetails details);
    
    boolean verifyToken(String token);
    
    String getUserNameByToken(String token);
}

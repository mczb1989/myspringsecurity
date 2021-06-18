package com.zb.myspringsecurity.service.impl;

import com.zb.myspringsecurity.config.vo.TokenVo;
import com.zb.myspringsecurity.service.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zb
 * @since 2021/6/18
 */
@Service
public class TokenServiceImpl implements TokenService {
    
    // todo 可以存redis, 设置过期时间
    private static final Map<String, String> tokenMap = new HashMap<>();
    
    @Override
    public TokenVo createToken(UserDetails details) {
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, details.getUsername());
        
        TokenVo tokenVo = new TokenVo();
        tokenVo.setToken(token);
        tokenVo.setExpireTime(60*60);
        
        return tokenVo;
    }

    @Override
    public boolean verifyToken(String token) {
        return tokenMap.get(token) != null;
    }

    @Override
    public String getUserNameByToken(String token) {
        return tokenMap.get(token);
    }

}

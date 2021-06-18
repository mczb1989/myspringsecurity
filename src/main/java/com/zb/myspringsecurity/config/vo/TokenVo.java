package com.zb.myspringsecurity.config.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zb
 * @since 2021/6/18
 */
@Data
public class TokenVo implements Serializable {
    
    private String token;
    
    private long expireTime;
}

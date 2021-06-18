package com.zb.myspringsecurity.config.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zb
 * @since 2021/6/18
 */
@Data
public class LoginParamVo implements Serializable {
    
    private String username;
    
    private String password;
}

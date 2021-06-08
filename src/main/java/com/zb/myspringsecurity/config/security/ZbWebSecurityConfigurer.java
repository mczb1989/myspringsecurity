package com.zb.myspringsecurity.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zb
 * @since 2021/6/8
 */
@EnableWebSecurity
public class ZbWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .and()
                .withUser("lisi")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .and()
                .withUser(passwordEncoder().encode("123"))
                .password("123")
                .roles("ADMIN")
                ;
    }
    
}

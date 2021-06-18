package com.zb.myspringsecurity.config.security;

import com.zb.myspringsecurity.config.security.customer.ZbTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zb
 * @since 2021/6/8
 */
@EnableWebSecurity
public class ZbWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    ZxUserDetailsServiceImpl zxUserDetailsService;
    
    @Autowired
    ZbTokenAuthenticationFilter zbTokenAuthenticationFilter;
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
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
         */
        auth.userDetailsService(zxUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                //"/**/*.html",
                "/**/*.js",
                "/**/*.css",
                "/**/*.ico",
                "/**/*.jpg",
                "/**/*.png",
                "/test/**",// 忽略test
                "/login/**" // 忽略login
        );
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
//                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                ;

        httpSecurity.addFilterBefore(zbTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 认证管理器
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

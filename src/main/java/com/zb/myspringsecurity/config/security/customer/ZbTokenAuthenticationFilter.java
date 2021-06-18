package com.zb.myspringsecurity.config.security.customer;

import com.zb.myspringsecurity.config.security.ZxUser;
import com.zb.myspringsecurity.config.security.ZxUserDetailsServiceImpl;
import com.zb.myspringsecurity.service.IUserRoleService;
import com.zb.myspringsecurity.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zb
 * @since 2021/6/18
 */
@Service
public class ZbTokenAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    IUserRoleService iUserRoleService;
    @Autowired
    ZxUserDetailsServiceImpl userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("TokenAuthenticationFilter.doFilterInternal start ...");
        String token = request.getHeader("token");

        if (token == null || "".equals(token)) {
            logger.info("token is null , return .");
            filterChain.doFilter(request, response);
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

       boolean result = tokenService.verifyToken(token);
        if (!result) {
            logger.info("ssoService.verifyToken not pass , return .");
            filterChain.doFilter(request, response);
            return;
        }

        ZxUser zxUser = userDetailsService.loadUserByUsername(tokenService.getUserNameByToken(token));

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                zxUser, null, zxUser.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
        logger.info("token valid pass , username : " + zxUser.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

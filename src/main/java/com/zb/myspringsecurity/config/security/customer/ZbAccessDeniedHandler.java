package com.zb.myspringsecurity.config.security.customer;

import com.zb.myspringsecurity.config.vo.CommonResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zb
 * @since 2021/6/18
 */
@Component
public class ZbAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(403);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.getWriter().write("Permission Forbidden:" + e.getMessage());
    }
}

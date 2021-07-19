package com.zb.myspringsecurity.controller;


import com.zb.myspringsecurity.entity.User;
import com.zb.myspringsecurity.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author system
 * @since 2021-06-08
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PreAuthorize("hasPermission('UserController', 'system:user:read')")
    @RequestMapping("/list")
    public List<User> list(HttpServletRequest request) {
        log.info("session id: {}" , request.getSession().getId());
        return iUserService.list();
    }
}

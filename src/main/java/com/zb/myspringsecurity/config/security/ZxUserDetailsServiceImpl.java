package com.zb.myspringsecurity.config.security;

import com.zb.myspringsecurity.entity.User;
import com.zb.myspringsecurity.entity.UserRole;
import com.zb.myspringsecurity.service.IUserRoleService;
import com.zb.myspringsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zb
 * @since 2021/6/9
 */
@Component
public class ZxUserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IUserService iUserService;
    @Autowired
    IUserRoleService iUserRoleService;
    
    @Override
    public ZxUser loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         // DEMO:
         
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("Admin"));
        
        ZxUser zxUser = new ZxUser();
        zxUser.setUserName("zhangsanfeng");
        zxUser.setPassword(passwordEncoder.encode("123"));
        zxUser.setAuthorities(authorityList);
        return zxUser;
         
         */
        
        List<User> userList = iUserService.lambdaQuery().eq(User::getUserName, username).list();
        if (CollectionUtils.isEmpty(userList)) {
            throw new UsernameNotFoundException("不存在的用户");
        }
        User user = userList.get(0);
        ZxUser zxUser = new ZxUser();
        zxUser.setUserName(user.getUserName());
        zxUser.setPassword(passwordEncoder.encode(user.getPassword()));
        zxUser.setId(user.getId());
        
        List<UserRole> userRoleList = iUserRoleService.lambdaQuery().eq(UserRole::getUserId, zxUser.getId()).list();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userRoleList)) {
            for (UserRole userRole : userRoleList) {
                authorityList.add(new SimpleGrantedAuthority(String.valueOf(userRole.getRoleId())));
            }
        }
        zxUser.setAuthorities(authorityList);
        return zxUser;
    }
}

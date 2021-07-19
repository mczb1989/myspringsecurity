package com.zb.myspringsecurity.config.security.customer;

import com.zb.myspringsecurity.config.security.ZxUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

/**
 * @author zb
 * @since 2021/6/18
 */
@Slf4j
@Component
public class ZbPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        ZxUser user = (ZxUser) authentication.getPrincipal();
        Set<String> permissonSet = user.getPermissionSet();
        if (permission == null) {
            log.info("permission valid not pass , permission is null");
            return false;
        }
        if (permissonSet.contains(permission.toString())) {
            log.info("permission valid pass , permission : {}", permission.toString());
            return true;
        }
        log.info("permission valid not pass , permission : {}", permission.toString());
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}

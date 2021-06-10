package com.zb.myspringsecurity.service.impl;

import com.zb.myspringsecurity.entity.UserRole;
import com.zb.myspringsecurity.mapper.UserRoleMapper;
import com.zb.myspringsecurity.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system
 * @since 2021-06-08
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}

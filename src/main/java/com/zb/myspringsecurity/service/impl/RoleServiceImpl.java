package com.zb.myspringsecurity.service.impl;

import com.zb.myspringsecurity.entity.Role;
import com.zb.myspringsecurity.mapper.RoleMapper;
import com.zb.myspringsecurity.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}

package com.zb.myspringsecurity.service.impl;

import com.zb.myspringsecurity.entity.Permission;
import com.zb.myspringsecurity.mapper.PermissionMapper;
import com.zb.myspringsecurity.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system
 * @since 2021-06-18
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}

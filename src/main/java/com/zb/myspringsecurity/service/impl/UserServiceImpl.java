package com.zb.myspringsecurity.service.impl;

import com.zb.myspringsecurity.entity.User;
import com.zb.myspringsecurity.mapper.UserMapper;
import com.zb.myspringsecurity.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.insurgency.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.insurgency.dao.entity.User;
import com.insurgency.dao.mapper.UserMapper;
import com.insurgency.service.IUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lynx123
 * @since 2020-07-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

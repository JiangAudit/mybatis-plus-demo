package com.tdk.mybatisplus.demo.sys.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.tdk.mybatisplus.demo.sys.entity.User;
import com.tdk.mybatisplus.demo.sys.dao.UserMapper;
import com.tdk.mybatisplus.demo.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tdk
 * @since 2021-05-18
 */
@Service
@DS("test2")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

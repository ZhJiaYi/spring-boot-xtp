package com.xtp.project.service.impl;

import com.xtp.project.dao.UserMapper;
import com.xtp.project.model.User;
import com.xtp.project.service.UserService;
import com.xtp.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author CodeGenerator
 * @data 2020/06/11.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}

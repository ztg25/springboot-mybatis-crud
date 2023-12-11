package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.query.UserQuery;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService接口实现类2
 */
@Service("rootUserService")
public class RootUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public PageInfo<User> listUsersByName(UserQuery userQuery) {
        System.out.println("UserService接口实现类2: RootUserServiceImpl");
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<User>(userMapper.listUsersByName(userQuery));
    }

    @Override
    public boolean deleteUserById(Integer id) {
        int result = userMapper.deleteUserById(id);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int countUserByName(String name) {
        return userMapper.countUserByName(name.trim());
    }
}

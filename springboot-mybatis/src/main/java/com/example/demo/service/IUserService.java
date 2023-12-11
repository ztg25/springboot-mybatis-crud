package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;


import java.util.List;

/**
 * 一个接口对应多实现类
 */
public interface IUserService {

    // 查询所有用户
    public List<User> listUsers();

    // 根据用户名来查询用户  并分页展示
    public PageInfo<User> listUsersByName(UserQuery userQuery);

    //根据id删除用户
    public boolean deleteUserById(Integer id);

    // 根据id查询用户
    public User queryUserById(Integer id);

    // 修改用户
    public boolean updateUser(User user);

    // 新增用户
    public boolean addUser(User user);

    public int countUserByName(String name);
}

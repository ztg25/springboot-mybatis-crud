package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> listUsers();

    public List<User> listUsersByName(UserQuery userQuery);

    public int deleteUserById(Integer id);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public User queryUserById(Integer id);

    public int countUserByName(String name);

}

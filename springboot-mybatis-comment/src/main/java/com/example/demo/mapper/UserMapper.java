package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper  // 运行时，自动生成该接口实现类对象，并加入到容器中。
public interface UserMapper {

    @Select("select * from mybatis.user")
    public List<User> userList();

    @Select("select * from mybatis.user where id=#{id}")
    public User searchUserById(int id);

    @Select("select * from mybatis.user where name like concat('%', #{name}, '%')") // like使用concat防止SQL注入
    public List<User> searchUserByName(String name);

    @Delete("delete from mybatis.user where id = #{id}")
    public int userDel(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true)   // 配置是否返回新增数据的主键
    @Insert("Insert into mybatis.user(name, pwd) values (#{name}, #{pwd})")
    public int addUser(User user);

    @Update("Update mybatis.user set name=#{name}, pwd=#{pwd} where id=#{id}")
    public int updateUser(User user);

}

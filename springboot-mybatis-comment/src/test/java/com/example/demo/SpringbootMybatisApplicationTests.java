package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void userListTest(){
		List<User> users = userMapper.userList();
		users.stream().forEach(user -> {
			System.out.println(user.getName());
		});
	}

	@Test
	public void userDelTest(){
		int result = userMapper.userDel(10);
		System.out.println("delete count:" + result);
	}

	@Test
	public void addUserTest(){
		User user = new User();
		user.setName("JJJ1");
		user.setPwd("111");
		int result = userMapper.addUser(user);
		// 返回新增数据的主键
		System.out.println(user.getId());
	}

	@Test
	public void updateUserTest(){
		User user = new User();
		user.setName("TTT");
		user.setPwd("123");
		user.setId(12);
		int result = userMapper.updateUser(user);
	}

	@Test
	public void searchUserByIdTest(){
		User user = userMapper.searchUserById(12);
		System.out.println(user);
	}

	@Test
	public void searchUserByNameTest(){
		List<User> users = userMapper.searchUserByName("T");
		users.stream().forEach(user -> {
			System.out.println(user.getName());
		});
	}

}

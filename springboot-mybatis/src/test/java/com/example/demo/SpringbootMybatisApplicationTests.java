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
		List<User> users = userMapper.listUsers();
		users.stream().forEach(user -> {
			System.out.println(user.getName());
		});
	}

}

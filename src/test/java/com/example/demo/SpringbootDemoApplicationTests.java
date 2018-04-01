package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		User user = new User();
		this.userService.add(user);
	}

}

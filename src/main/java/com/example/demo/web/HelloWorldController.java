package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AddUserRequestDTO;
import com.example.demo.model.User;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/user")
public class HelloWorldController {

	@PostMapping(value = "/add")
	@ApiOperation(value = "新增用户信息", notes = "新增用户信息")
	public User hello(@RequestBody AddUserRequestDTO addUserRequestDTO) {
		return new User();
	}

}

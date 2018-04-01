package com.example.demo.mapper;

import org.springframework.stereotype.Repository;
import com.example.demo.model.User;
@Repository
public interface UserMapper {
	int insert(User record);

	int insertSelective(User record);
}
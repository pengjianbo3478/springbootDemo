package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "�û���Ϣmodel")
public class AddUserRequestDTO {

	@ApiModelProperty(value = "�û�����", allowEmptyValue = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

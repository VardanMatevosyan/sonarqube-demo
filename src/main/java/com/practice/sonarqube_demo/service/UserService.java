package com.practice.sonarqube_demo.service;

import com.practice.sonarqube_demo.model.dto.UserDto;

public interface UserService {

    UserDto getUserById(Integer id);

}

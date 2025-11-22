package com.practice.sonarqube_demo.service;

import com.practice.sonarqube_demo.mapper.UserMapper;
import com.practice.sonarqube_demo.model.dto.UserDto;
import com.practice.sonarqube_demo.persistence.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserDao userDao;
    final UserMapper userMapper;

    public UserDto getUserById(Integer id) {
        return userDao.getUserById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

}

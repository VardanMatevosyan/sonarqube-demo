package com.practice.sonarqube_demo.persistence;

import com.practice.sonarqube_demo.model.entities.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUserById(Integer id);

}

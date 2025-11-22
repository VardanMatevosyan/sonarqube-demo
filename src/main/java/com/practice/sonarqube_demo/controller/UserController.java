package com.practice.sonarqube_demo.controller;

import com.practice.sonarqube_demo.model.dto.UserDto;
import com.practice.sonarqube_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}

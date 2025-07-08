package com.example.demo.controller;

import com.example.demo.controller.request.SignUpRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public User signUp(@RequestBody SignUpRequest request) {
        log.info("signUp() -> request: {}", request);

        User user = request.toUser();
        return userRepository.save(user);
    }
}

package com.example.demo.controller;

import com.example.demo.controller.request.SignInRequest;
import com.example.demo.controller.request.SignUpRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/sign-in")
    public Boolean signIn(@RequestBody SignInRequest request) {
        log.info("signIn() -> request: {}", request);

        String userId = request.getUserId();
        Optional<User> maybeUser = userRepository.findByUserId(userId);
        if (maybeUser.isEmpty()) {
            log.info("signIn() -> 아이디 없음.");
            return Boolean.FALSE;
        }
        User user = maybeUser.get();
        String encryptedUserPassword = user.getPassword();
        Boolean loginSuccess = request.checkPassword(encryptedUserPassword);
        if (!loginSuccess) {
            log.info("signIn() -> 암호 불일치.");
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}

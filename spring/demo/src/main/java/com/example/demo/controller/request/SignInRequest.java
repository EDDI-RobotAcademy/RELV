package com.example.demo.controller.request;

import com.example.demo.entity.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    String userId;
    String password;

    public Boolean checkPassword(String encodedPassword) {
        // 일치하면 참(True)
        return encoder.matches(password, encodedPassword);
    }
}

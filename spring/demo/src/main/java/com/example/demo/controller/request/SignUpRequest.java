package com.example.demo.controller.request;

import com.example.demo.entity.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    // 별도의 유틸리티 함수를 만들면 더 좋음
    // 현재 여기서는 복잡도가 상승하므로 고려하지 않겠음.
    static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    String userId;
    String password;
    String nickname;
    String email;

    public User toUser() {
        String encryptedPassword = encoder.encode(password);

        return new User(userId, encryptedPassword, nickname, email);
    }
}

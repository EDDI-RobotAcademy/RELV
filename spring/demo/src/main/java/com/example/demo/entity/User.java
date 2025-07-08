package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 이것을 가지고 회원 가입, 로그인, 탈퇴, 비밀 번호 변경
@Entity
@ToString
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userId;
    String password;
    String nickname;
    String email;

    public User(String userId, String password, String nickname, String email) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 현재 Frontend 요청은 없으므로 CORS 상황은 고려할 필요 없음
    // csrf(csrf -> csrf.disable())
    // CSRF 공격에 대한것은 현재 셀프 테스트이므로 배제
    // .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
    // HTTP를 사용하는 모든 경로 허용
    // .httpBasic(Customizer.withDefaults())
    // 기본적으로 보안 프로토콜인 HTTPS를 선호하지만 HTTP로도 동작이 가능하도록 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                auth -> auth.anyRequest().permitAll())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

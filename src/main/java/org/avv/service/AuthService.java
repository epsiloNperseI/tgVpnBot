package org.avv.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.avv.dto.LoginDto;
import org.avv.entity.Session;
import org.avv.feign.FeignAuthClient;
import org.avv.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    public static final String KEY = "3x-ui=";
    public static final String HEADER_NAME = "set-cookie";
    private final SessionRepository sessionRepository;
    private final FeignAuthClient feignAuthClient;

    @Value("${api.username}")
    private String username;

    @Value("${api.password}")
    private String password;

    @Transactional
    public Session login(Long userId) {
        Session session = sessionRepository.findLatestByUserId(userId).orElse(null);

        if (session != null) {
            LocalDateTime createdAt = session.getCreatedAt();
            if (Duration.between(createdAt, LocalDateTime.now()).toHours() < 1) {
                return session;
            }
        }

        ResponseEntity<String> response = feignAuthClient.login(
            LoginDto.builder()
                .username(username)
                .password(password)
                .build()
        );

        List<String> cookies = response.getHeaders().getValuesAsList(HEADER_NAME);
        Session newSession = (session == null) ? new Session() : session;
        newSession.setCookie(cookies.get(0));
        newSession.setUserId(userId);
        newSession.setSessionId(extractToken(cookies, KEY));
        newSession.setCreatedAt(LocalDateTime.now());
        sessionRepository.save(newSession);

        return newSession;
    }


    private String extractToken(List<String> cookies, String key) {
        for (String cookie : cookies) {
            if (cookie.startsWith(key)) {
                int valueStart = key.length();
                int semicolonIndex = cookie.indexOf(';', valueStart);
                return (semicolonIndex != -1)
                    ? cookie.substring(valueStart, semicolonIndex)
                    : cookie.substring(valueStart);
            }
        }
        return null;
    }
}
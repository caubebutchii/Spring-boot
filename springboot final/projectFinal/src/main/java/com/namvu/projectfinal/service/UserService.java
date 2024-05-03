package com.namvu.projectfinal.service;

import com.namvu.projectfinal.entity.User;
import com.namvu.projectfinal.enumStatic.UserStatus;
import com.namvu.projectfinal.repository.UserRepository;
import com.namvu.projectfinal.request.user.SignUpRequest;
import com.namvu.projectfinal.response.user.UserResponse;
import com.namvu.projectfinal.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserResponse createUser(SignUpRequest request) {
        log.info("Sign up request: {}", request);
        // check username, email, phone
        if(userRepository.existsByUsername(request.getUsername())) {
                throw new SecurityException("Username already exists");
        }
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new SecurityException("Email already exists");
        }
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .status(UserStatus.WAITING_CONFIRM)
                .password(encoder.encode(request.getPassword()))
                .build();
        user = userRepository.save(user);
        UserResponse response =  MapperUtil.mapObject(user, UserResponse.class);
        System.out.println(response);
        return response;
    }
}

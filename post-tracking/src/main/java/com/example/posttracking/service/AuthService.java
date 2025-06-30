package com.example.posttracking.service;

import com.example.posttracking.dto.AuthResponse;
import com.example.posttracking.dto.LoginRequest;
import com.example.posttracking.dto.RegisterRequest;
import com.example.posttracking.entity.Role;
import com.example.posttracking.entity.User;
import com.example.posttracking.repository.RoleRepository;
import com.example.posttracking.repository.UserRepository;
import com.example.posttracking.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Transactional
    public void register(RegisterRequest request) {
        Role role = roleRepository.findById(request.getRoleId()).orElseThrow();
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = tokenProvider.generateToken(request.getUsername());
        return new AuthResponse(token);
    }
}

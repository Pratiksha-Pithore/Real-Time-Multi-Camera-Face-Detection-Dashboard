package com.example.Controller;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
import com.example.securityconfig.Jwtutil;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3003")
public class AuthController {
	
	private final AuthenticationManager authManager;
    private final Jwtutil jwtUtil;
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager, Jwtutil jwtUtil, UserRepository repo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> req) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.get("username"), req.get("password"))
        );
        String token = jwtUtil.generateToken(req.get("username"));
        return Map.of("token", token);
    }
}



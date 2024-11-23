package com.MITM142.controller;

import com.MITM142.data.User;
import com.MITM142.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User userData = userService.verifyLogin(email, password);
        session.setAttribute("loggedInUser", userData);
        return ResponseEntity.ok(userData);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registration(@RequestBody Map<String, String> registrationRequest) {
        User user = User.builder()
                .email(registrationRequest.get("email"))
                .password(registrationRequest.get("password"))
                .firstName(registrationRequest.get("firstName"))
                .lastName(registrationRequest.get("lastName"))
                .phoneNumber(registrationRequest.get("phoneNumber"))
                .build();

        userService.registerUser(user);
        return ResponseEntity.ok(user);
    }

}

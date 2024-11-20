package com.MITM142.controller;

import com.MITM142.data.User;
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
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/reg")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User user = new User();
        session.setAttribute("loggedInUser", user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registration(@RequestBody Map<String, String> registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.get("email"));
        user.setPassword(registrationRequest.get("password"));
        user.setFirstName(registrationRequest.get("firstName"));
        user.setLastName(registrationRequest.get("lastName"));
        user.setPhoneNumber(registrationRequest.get("phoneNumber"));
        return ResponseEntity.ok(user);
    }

}

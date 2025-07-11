package com.example.ecommerce.controller;

import com.example.ecommerce.model.UserProfile;
import com.example.ecommerce.requests.LoginRequest;
import com.example.ecommerce.responses.Response;
import com.example.ecommerce.responses.TokenResponse;
import com.example.ecommerce.responses.UserProfileResponse;
import com.example.ecommerce.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("")
    public ResponseEntity<Response> get(@AuthenticationPrincipal String username) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UserProfileResponse("User Retrieved successfully!"
                        ,userAuthService.getUserData(username)));
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserProfile userProfile) {
            userAuthService.registerUser(userProfile);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new TokenResponse("Registration Successful!",
                            userAuthService.getUserData(userProfile.getUsername())));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isValid = userAuthService.validateUserCredentials(loginRequest.getUsername(), loginRequest.getPassword());

            if (isValid) {
                return ResponseEntity.ok(new TokenResponse("Login Successful!",
                        userAuthService.getUserData(loginRequest.getUsername())));
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response("Invalid credentials."));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("An error occurred during login."));
        }
    }
}

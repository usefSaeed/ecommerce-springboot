package com.example.ecommerce.responses;

import com.example.ecommerce.middleware.JWTUtil;
import com.example.ecommerce.model.UserProfile;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenResponse extends UserProfileResponse {
    private String token;

    public TokenResponse(String message, UserProfile user) {
        super(message, user);
        this.token = JWTUtil.generateToken(user.getUsername());
    }
}
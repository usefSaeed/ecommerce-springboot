package com.example.ecommerce.responses;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.UserProfile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class UserProfileResponse extends Response{
    private UserProfile userData;

    public UserProfileResponse(String message, UserProfile user) {
        super(message);
        this.userData = user;
    }
}

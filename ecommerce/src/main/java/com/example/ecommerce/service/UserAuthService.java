package com.example.ecommerce.service;

import com.example.ecommerce.exceptions.BadRequestException;
import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.*;
import com.example.ecommerce.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Base64;


@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUserData(String username){
        return userProfileRepository.findById(username).orElse(null);
    }

    @Transactional
    public void registerUser(UserProfile userProfile) {
        // Check if the user already exists
        if (userAuthRepository.findById(userProfile.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists!");
        }

        if (!Validation.isValidEmail(userProfile.getEmail())) {
            throw new BadRequestException("Email is not valid");
        }

        if (!Validation.isValidPhoneNumber(userProfile.getPhone())) {
            throw new BadRequestException("Phone Number is not valid");
        }

        if (userProfileRepository.findByPhone(userProfile.getPhone()).isPresent()) {
            throw new BadRequestException("Phone Number already exists!");
        }

        if (userProfileRepository.findByEmail(userProfile.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists!");
        }

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);

        String hashedPassword = passwordEncoder.encode(userProfile.getPassword() + encodedSalt);

        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(userProfile.getUsername());
        userAuth.setHashedPassword(hashedPassword);
        userAuth.setSalt(encodedSalt);
        userAuthRepository.save(userAuth);

        userProfile.setUsername(userProfile.getUsername());
        userProfileRepository.save(userProfile);
    }

    public boolean validateUserCredentials(String username, String rawPassword) {
        UserAuth userAuth = userAuthRepository.findById(username).orElse(null);
        if (userAuth == null) {
            return false;
        }
        return passwordEncoder.matches(rawPassword + userAuth.getSalt(), userAuth.getHashedPassword());
    }
}

package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_info")
@Getter
@Setter
public class UserProfile {

    @Id
    private String username;

    @Transient
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}

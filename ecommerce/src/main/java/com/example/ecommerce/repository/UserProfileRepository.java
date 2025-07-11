package com.example.ecommerce.repository;
import com.example.ecommerce.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
    Optional<UserProfile> findByPhone(String phone);
    Optional<UserProfile> findByEmail(String email);
}

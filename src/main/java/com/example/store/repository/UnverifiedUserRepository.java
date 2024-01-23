package com.example.store.repository;

import com.example.store.model.UnverifiedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnverifiedUserRepository extends JpaRepository<UnverifiedUser, String> {
	UnverifiedUser findByUsername(String username);

	UnverifiedUser findByEmail(String email);
	
	UnverifiedUser findByEmailEqualsAndOtpEquals(String email, Integer otp);
}

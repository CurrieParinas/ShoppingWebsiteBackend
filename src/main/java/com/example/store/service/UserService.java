package com.example.store.service;

import java.util.List;
import java.util.Random;

import com.example.store.model.UnverifiedUser;
import com.example.store.model.User;
import com.example.store.repository.UnverifiedUserRepository;
import com.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UnverifiedUserRepository unverifiedUserRepository;
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private User loggedInUser;

    @Autowired
    public UserService(UnverifiedUserRepository unverifiedUserRepository, UserRepository userRepository, JavaMailSender javaMailSender) {
        this.unverifiedUserRepository = unverifiedUserRepository;
		this.userRepository = userRepository;
		this.javaMailSender = javaMailSender;
    }
    
    public void sendVerification(String email, Integer code) {
        String subject = "Account Verification";
        sendVerificationEmail(email, subject, code);
	}

    public String addUser(User user) {
    	User u = userRepository.findByUsername(user.getUsername());
    	UnverifiedUser unv = unverifiedUserRepository.findByUsername(user.getUsername());
    	User uemail = userRepository.findByEmail(user.getEmail());
    	UnverifiedUser unvemail = unverifiedUserRepository.findByEmail(user.getEmail());
    	
    	if (u != null || unv != null) {
    		return "Username is already in use.";
    	} else {
    		if (uemail != null || unvemail != null) {
        		return "Email is already in use.";
    		} else {
    			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		    	String encryptedPassword = bcrypt.encode(user.getPassword());
		    	user.setPassword(encryptedPassword);
		    	int otp = generateVerificationCode();
		    	
		    	sendVerification(user.getEmail(), otp);
		    	UnverifiedUser newUser = new UnverifiedUser(user, otp);
		    	
		        unverifiedUserRepository.save(newUser);
		        
				return "User registered successfully";
    		}
    	}
    }
    
    public boolean verifyUser(String email, Integer otp) {
    	UnverifiedUser unvUser = unverifiedUserRepository.findByEmailEqualsAndOtpEquals(email, otp);
    	
    	if (unvUser != null) {
    		User user = new User(unvUser);
    		userRepository.save(user);
    		unverifiedUserRepository.deleteById(user.getUsername());
    		return true;
    	} else {
    		return false;
    	}
	}

    public boolean login(String username, String password) {
    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(username);
        if (user != null && bcrypt.matches(password, user.getPassword())) {
            setLoggedInUser(user);
            return true;
        }
        return false;
    }

    public void logout() {
        setLoggedInUser(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public void sendVerificationEmail(String to, String subject, Integer code) {
        SimpleMailMessage message = new SimpleMailMessage();
        String link = "http://localhost:8080/verify?email=" + to + "&otp=" + code;
        message.setTo(to);
        message.setSubject(subject);
        message.setText("To verify your account, please enter this code: " + String.valueOf(code) + "\n\nOr follow this link in your browser: " + link);
        javaMailSender.send(message);
    }
    
    private Integer generateVerificationCode() {
    	Random random = new Random();
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    
    public List<User> getAllUsers() {
        // Retrieve all registered users from the UserRepository
        return userRepository.findAll();
    }
}

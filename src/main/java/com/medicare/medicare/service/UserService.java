package com.medicare.medicare.service;

import com.medicare.medicare.entity.Role;
import com.medicare.medicare.entity.User;
import com.medicare.medicare.exception.DuplicateResourceException;
import com.medicare.medicare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public void save(User user) throws DuplicateResourceException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new DuplicateResourceException("User already exist!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnabled(false); // usually it is false and turns true after verification
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        mailService.sendEmail(user.getEmail(), "Please veify your email", "Hi " + user.getName() + "\n" +
                "Please verify your account by clicking on this link <a href=\"http://localhost:8080/user/verify?email="
                + user.getEmail() + "&token=" + user.getVerifyToken() +"\">Activate</a>");

    }

    public void verifyUser(String email, String token) throws Exception {
        Optional<User> userOptional = userRepository.findByEmailAndVerifyToken(email, token);
        if (userOptional.isEmpty()){
            throw new Exception("user does not exist with this email and token");
        }
        User user = userOptional.get();
        if (user.isEnabled()){
            throw new Exception("User already enabled!");
        }
        user.setEnabled(true); //user turns enabled after verification
        user.setVerifyToken(null); //deleting user's token field
        userRepository.save(user);
    }
}

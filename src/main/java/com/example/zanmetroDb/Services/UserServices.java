package com.example.zanmetroDb.Services;


import com.example.zanmetroDb.Model.User;
import com.example.zanmetroDb.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public List<User> getUsersByRoleName(String roleName) {
        return userRepository.findByRoles_RoleName(roleName);
    }


    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User save(User user) {
        return userRepository.save(user); // Save updated user
    }

    public boolean changePassword(String userId, String currentPassword, String newPassword) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && passwordEncoder.matches(currentPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword)); // Update password
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

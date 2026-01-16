package com.example.zanmetroDb.Services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.zanmetroDb.Model.Roles;
import com.example.zanmetroDb.Model.User;
import com.example.zanmetroDb.Repository.RoleRepository;
import com.example.zanmetroDb.Repository.UserRepository;
import com.example.zanmetroDb.dto.LoginUserDto;
import com.example.zanmetroDb.dto.RegisterUserDto;
import com.example.zanmetroDb.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private EmailService emailService;


    @Autowired
    private RoleRepository roleRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Roles saveRole(RoleDTO dto){
        Roles role = new Roles();
        role.setRoleName(dto.getRoleName());
        role.setRoleStatus(1);
        return roleRepository.save(role);
    }

    public List<RoleDTO> getAllRoles() {
        List<Roles> roles = roleRepository.findAll();

        return roles.stream().map(role -> {
            RoleDTO dto = new RoleDTO();
            dto.setRoleId(role.getRoleId());
            dto.setRoleName(role.getRoleName());
            dto.setRoleStatus(role.getRoleStatus());
            return dto;
        }).collect(Collectors.toList());
    }

    public User signup(RegisterUserDto input) {
        Optional<Roles> roles = roleRepository.findById(input.getRoleId());
        User user = new User();
        user.setUsername(input.getEmail());
        user.setEmail(input.getEmail());

        user.setPassword(passwordEncoder.encode(input.getPassword()));

        if (roles.isPresent()) {
            user.setRoles(roles.get());
        } else {
            user.setRoles(new Roles());
        }

        // Generate activation token
        String token = UUID.randomUUID().toString();
        user.setActivationToken(token);

        // Save the user
        User savedUser = userRepository.save(user);

        // Send activation email
        String activationLink = "http://localhost:4200/result/auth/activate?token=" + token;
        emailService.sendActivationEmail(user.getEmail(), activationLink);

        return savedUser;
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }

    public Roles updateRole(String roleId, RoleDTO dto) {
        Roles role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setRoleName(dto.getRoleName());
        role.setRoleStatus(dto.getRoleStatus());
        return roleRepository.save(role);
    }

    public void deleteRole(String roleId) {
        roleRepository.deleteById(roleId);
    }

    public Roles hideRole(String roleId) {
        Roles role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setRoleStatus(0); // Assuming 0 means hidden
        return roleRepository.save(role);
    }

//    public Optional<Roles> hideRole(String roleId) {
//        Optional<Roles> role = roleRepository.findById(roleId);
//        role.ifPresent(roleName -> {
//            roleName.setHidden(true);
//            roleRepository.save(roleName);
//        });
//        return role;
//    }

    public Roles getRoleById(String roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public long countUsersByRole(Roles roles) {
        return userRepository.countByRoles(roles);
    }

}


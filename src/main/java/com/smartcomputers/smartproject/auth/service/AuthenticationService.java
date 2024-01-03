package com.smartcomputers.smartproject.auth.service;

import com.smartcomputers.smartproject.auth.role.entity.Role;
import com.smartcomputers.smartproject.auth.role.enums.RoleEnum;
import com.smartcomputers.smartproject.auth.role.repository.RoleRepository;
import com.smartcomputers.smartproject.user.dao.UserDao;
import com.smartcomputers.smartproject.user.entity.User;
import com.smartcomputers.smartproject.user.payload.LoginUserDTO;
import com.smartcomputers.smartproject.user.payload.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;

    @Autowired
    public AuthenticationService(
            UserDao userDao,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User signup(RegisterUserDTO input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = User.builder()
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .role(optionalRole.get())
                .build();

        return userDao.registerUser(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userDao.findUserByEmail(input.getEmail());
    }
}


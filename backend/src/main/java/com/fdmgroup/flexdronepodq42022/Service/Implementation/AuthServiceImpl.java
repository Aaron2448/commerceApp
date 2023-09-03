package com.fdmgroup.flexdronepodq42022.Service.Implementation;

import com.fdmgroup.flexdronepodq42022.DTO.LoginDto;
import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
import com.fdmgroup.flexdronepodq42022.Model.Role;
import com.fdmgroup.flexdronepodq42022.Model.User;
import com.fdmgroup.flexdronepodq42022.Repository.RoleRepository;
import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
import com.fdmgroup.flexdronepodq42022.Security.JwtTokenProvider;
import com.fdmgroup.flexdronepodq42022.Service.AuthService;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final Validator validator;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider, Validator validator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.validator = validator;
    }


    @Override
    public String login(@Validated @RequestBody LoginDto loginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
        }

        Authentication authentication = null;
        User user = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: " + loginDto.getUsernameOrEmail()));

        if (user.is_using2FA() && StringUtils.isEmpty(loginDto.getTwoFactorCode())) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Two-factor code is required!");
        }

        if (user.is_using2FA()) {
            GoogleAuthenticator gAuth = new GoogleAuthenticator();
            int code = 0;

            try {
                code = Integer.parseInt(loginDto.getTwoFactorCode());
            } catch (NumberFormatException e) {
                throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Invalid two-factor code format!");
            }

            // Verify the 2FA code
            boolean isCodeValid = gAuth.authorize(user.getSecret(), code);
            if (!isCodeValid) {
                throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Invalid two-factor code!");
            }

            // If the code is valid, authenticate the user
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        } else {
            // If the user is not using 2FA, authenticate the user with their password
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }


    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        // Validation logic
        Set<ConstraintViolation<RegisterDto>> violations = validator.validate(registerDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        String passwordRegex = "^(?=.*[0-9]).{10,}$";
        if (!registerDto.getPassword().matches(passwordRegex)) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST,
                    "Password should contain at least one digit and be at least 10 characters long.");
        }

        passwordRegex = "^(?=.*[a-z]).{10,}$";
        if (!registerDto.getPassword().matches(passwordRegex)) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST,
                    "Password should contain at least one lowercase letter and be at least 10 characters long.");
        }

        passwordRegex = "^(?=.*[A-Z]).{10,}$";
        if (!registerDto.getPassword().matches(passwordRegex)) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST,
                    "Password should contain at least one uppercase letter and be at least 10 characters long.");
        }

        passwordRegex = "^(?=.*[!@#$%^&*()-+=]).{10,}$";
        if (!registerDto.getPassword().matches(passwordRegex)) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST,
                    "Password should contain at least one special character and be at least 10 characters long.");
        }

        User user = new User();
        user.setFirst_name(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.set_using2FA(false);

        // Generate a new secret key for the user
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey credentials = gAuth.createCredentials();
        String secretKey = credentials.getKey();
        user.setSecret(secretKey);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!.";
    }

    @Override
    public String registerAdmin(RegisterDto registerDto) {
        // add check for username exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        // Validation logic
        Set<ConstraintViolation<RegisterDto>> violations = validator.validate(registerDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=]).{10,}$";
        if (!registerDto.getPassword().matches(passwordRegex)) {
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST,
                    "Password should contain at least one uppercase letter, one lowercase letter, one digit, and one special character, and be at least 10 characters long.");
        }

        User user = new User();
        user.setFirst_name(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.set_using2FA(false);

        // Generate a new secret key for the user
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey credentials = gAuth.createCredentials();
        String secretKey = credentials.getKey();
        user.setSecret(secretKey);

        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
        roles.add(adminRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "Admin registered successfully!.";
    }

    @Override
    public String updateUserById(Long user_id, UpdateDto updateUserDto) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new EcommerceAPIException(HttpStatus.BAD_REQUEST, "User not found."));

        user.setFirst_name(updateUserDto.getName());
        user.setUsername(updateUserDto.getUsername());
        user.setEmail(updateUserDto.getEmail());

        if (!updateUserDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updateUserDto.getPassword()));
        }

        userRepository.save(user);
        return "User saved successfully!";
    }

    @Override
    public String updateUser(UpdateDto updateDto) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        user.setFirst_name(updateDto.getName());
        user.setUsername(updateDto.getUsername());
        user.setEmail(updateDto.getEmail());
        user.setPassword(passwordEncoder.encode(updateDto.getPassword()));

        userRepository.save(user);
        return "User saved successfully!";
    }

    @Override
    public String updateCurrentUser(UpdateDto updateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User currentUserDto = userRepository.findByEmail(currentUserName);

        currentUserDto.setFirst_name(updateDto.getName());
        currentUserDto.setUsername(updateDto.getUsername());
        currentUserDto.setEmail(updateDto.getEmail());
        currentUserDto.setPassword(passwordEncoder.encode(updateDto.getPassword()));

        return "Current user saved successfully!";
    }
}

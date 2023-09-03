package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.DTO.*;
import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
import com.fdmgroup.flexdronepodq42022.Model.User;
import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
import com.fdmgroup.flexdronepodq42022.Service.AuthService;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

 
    public AuthController(AuthService authService,
                          UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    /**
     * Validation Exception handler
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        violation -> violation.getMessage()
                ));
        log.info(errors.toString());
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Login user
     *
     * @param loginDto
     * @return
     */
    @PostMapping(value = {"/login"})
    public ResponseEntity<JWTAuthResponse> login(@Validated @RequestBody LoginDto loginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            log.info(bindingResult.getFieldError().getDefaultMessage());
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        }

        try {

            String token = authService.login(loginDto, bindingResult);
            JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
            jwtAuthResponse.setAccessToken(token);
            log.info("User logged in: " + jwtAuthResponse);
            return ResponseEntity.ok(jwtAuthResponse);

        } catch (EcommerceAPIException e) {

            log.info(e.getMessage());
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    /**
     * Enable 2FA
     *
     * @param twoFactorAuthDto
     * @return
     */
    @PostMapping("/enable")
    public ResponseEntity<?> enable2FA(@RequestBody TwoFactorAuthDto twoFactorAuthDto) {
        User user = userRepository.findByUsername(twoFactorAuthDto.getUsername())
                .orElseThrow(() -> new EcommerceAPIException(HttpStatus.NOT_FOUND, "User not found!"));

        if (user.is_using2FA()) {
            log.info("2FA is already enabled for user: " + user.getUsername());
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "User is already using 2FA!.");
        }

        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey credentials = gAuth.createCredentials();
        String secretKey = credentials.getKey();

        // Generate the QR code URL
        String barCodeUrl = GoogleAuthenticatorQRGenerator.getOtpAuthURL("EcommerceAPI", user.getEmail(), credentials);
        log.info("Generated QR code URL: " + barCodeUrl);

        // Save the user's 2FA secret key and update the 2FA flag
        user.setSecret(secretKey);
        user.set_using2FA(true);
        userRepository.save(user);
        log.info("2FA enabled successfully for user: " + user.getUsername());

        return ResponseEntity.ok(new TwoFactorAuthResponseDto(barCodeUrl));
    }

    /**
     * Disable 2FA
     *
     * @param twoFactorAuthDto
     * @return
     */
    @PostMapping("/disable")
    public ResponseEntity<?> disable2FA(@RequestBody TwoFactorAuthDto twoFactorAuthDto) {
        User user = userRepository.findByUsername(twoFactorAuthDto.getUsername())
                .orElseThrow(() -> new EcommerceAPIException(HttpStatus.NOT_FOUND, "User not found!"));

        if (!user.is_using2FA()) {
            log.info("User is not using 2FA!: " + user.getUsername());
            throw new EcommerceAPIException(HttpStatus.BAD_REQUEST, "User is not using 2FA!.");
        }

        user.set_using2FA(false);
        userRepository.save(user);
        log.info("2FA disabled successfully for user: " + user.getUsername());
        return ResponseEntity.ok("Two-factor authentication disabled successfully!.");
    }

    /**
     * Logout user
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            log.info("User logged out successfully");
            request.getSession().invalidate();
            return ResponseEntity.ok("User logged out successfully.");
        }
        log.info("No user to log out.");
        return ResponseEntity.ok("No user to log out.");
    }

    /**
     * Register User
     *
     * @param registerDto
     * @return
     */
    @PostMapping(value = {"/register"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        log.info("User registered: " + response);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * View User Profile
     *
     * @param user
     * @return
     */
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@AuthenticationPrincipal User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User currentUserDto = userRepository.findByEmail(currentUserName);
        log.info("Current user: " + currentUserDto);

        return ResponseEntity.ok(currentUserDto);
    }

    /**
     * Update logged in user
     *
     * @param updateDto
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UpdateDto updateDto) {
        authService.updateUser(updateDto);
        log.info("User updated: " + updateDto);

        return ResponseEntity.ok("Updated user");
    }

    /**
     * Delete logged in user
     *
     * @param user
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserProfile(@AuthenticationPrincipal User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User currentUserDto = userRepository.findByEmail(currentUserName);
        log.info("User deleted: " + currentUserDto);
        userRepository.delete(currentUserDto);

        return ResponseEntity.ok("User Deleted");
    }
}
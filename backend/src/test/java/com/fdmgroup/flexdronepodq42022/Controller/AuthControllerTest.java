//package com.fdmgroup.flexdronepodq42022.Controller;
//
//import com.fdmgroup.flexdronepodq42022.DTO.JWTAuthResponse;
//import com.fdmgroup.flexdronepodq42022.DTO.LoginDto;
//import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
//import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
//import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
//import com.fdmgroup.flexdronepodq42022.Model.User;
//import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
//import com.fdmgroup.flexdronepodq42022.Service.AuthService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;
//import jakarta.validation.Path;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthControllerTest {
//
//    @Mock
//    private AuthService authService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private Authentication authentication;
//
//    @InjectMocks
//    private AuthController authController;
//
//    @Mock
//    private SecurityContext securityContext;
//
//
//    @Test
//    public void testGetUserProfile() {
//        Authentication authentication = mock(Authentication.class);
//        User user = mock(User.class);
//        when(authentication.getName()).thenReturn("test@example.com");
//        when(userRepository.findByEmail("test@example.com")).thenReturn(user);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        ResponseEntity<User> responseEntity = authController.getUserProfile(user);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(user, responseEntity.getBody());
//    }
//
//
//    @Test
//    public void loginTest() {
//        LoginDto loginDto = new LoginDto();
//        loginDto.setUsernameOrEmail("user");
//        loginDto.setPassword("password");
//
//        when(authService.login(any(LoginDto.class))).thenReturn("jwt_token");
//
//        ResponseEntity<JWTAuthResponse> result = authController.login(loginDto);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertEquals("jwt_token", result.getBody().getAccessToken());
//    }
//
//    @Test
//    public void testLogout() {
//        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//        Authentication authentication = Mockito.mock(Authentication.class);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//
//        ResponseEntity<String> responseEntity = authController.logout(request, response);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void registerTest() {
//        RegisterDto registerDto = new RegisterDto();
//        registerDto.setUsername("user");
//        registerDto.setPassword("password");
//        registerDto.setEmail("user@email.com");
//
//        when(authService.register(any(RegisterDto.class))).thenReturn("User registered");
//
//        ResponseEntity<String> result = authController.register(registerDto);
//
//        assertEquals(HttpStatus.CREATED, result.getStatusCode());
//        assertEquals("User registered", result.getBody());
//    }
//
//    @Test
//    public void testHandleConstraintViolationException() {
//        ConstraintViolationException e = mock(ConstraintViolationException.class);
//        Set<ConstraintViolation<?>> violations = new HashSet<>();
//        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
//        when(violation.getPropertyPath()).thenReturn(mock(Path.class));
//        when(violation.getMessage()).thenReturn("Error message");
//        violations.add(violation);
//        when(e.getConstraintViolations()).thenReturn(violations);
//
//        ResponseEntity<Map<String, String>> responseEntity = authController.handleConstraintViolationException(e);
//
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody().get(""));
//    }
//
//    @Test
//    public void testUpdateUserSuccess() {
//        UpdateDto updateDto = new UpdateDto();
//        when(authService.updateUser(updateDto)).thenReturn("User updated successfully");
//
//        ResponseEntity<String> response = authController.updateUser(updateDto);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Updated user", response.getBody());
//    }
//
//    @Test
//    public void testUpdateUserFailure() {
//        UpdateDto updateDto = new UpdateDto();
//        EcommerceAPIException exception = new EcommerceAPIException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating user");
//        when(authService.updateUser(updateDto)).thenThrow(exception);
//
//        ResponseEntity<String> response = authController.updateUser(updateDto);
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//        assertNull(response.getBody());
//    }
//}
//

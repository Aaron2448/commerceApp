//package com.fdmgroup.flexdronepodq42022.Service;
//
//import com.fdmgroup.flexdronepodq42022.DTO.LoginDto;
//import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
//import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
//import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
//import com.fdmgroup.flexdronepodq42022.Model.Role;
//import com.fdmgroup.flexdronepodq42022.Model.User;
//import com.fdmgroup.flexdronepodq42022.Repository.RoleRepository;
//import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
//import com.fdmgroup.flexdronepodq42022.Security.JwtTokenProvider;
//import com.fdmgroup.flexdronepodq42022.Service.Implementation.AuthServiceImpl;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;
//import jakarta.validation.Validator;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.TestingAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;
//import java.util.Set;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthServiceImplTest {
//
//    @InjectMocks
//    private AuthServiceImpl authService;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private RoleRepository roleRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Mock
//    private Validator validator;
//    @BeforeEach
//    public void setUp() {
//        authService = new AuthServiceImpl(authenticationManager, userRepository, roleRepository, passwordEncoder, jwtTokenProvider, validator);
//    }
//
//    @Test
//    public void testLoginSuccess() {
//        LoginDto loginDto = new LoginDto();
//        loginDto.setUsernameOrEmail("user");
//        loginDto.setPassword("password");
//
//        Authentication authentication = new UsernamePasswordAuthenticationToken("user", "password");
//
//        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
//                .thenReturn(authentication);
//
//        when(jwtTokenProvider.generateToken(authentication)).thenReturn("token");
//
//        String result = authService.login(loginDto);
//
//        assertEquals("token", result);
//    }
//
//    @Test
//    public void register_whenInputIsValid_shouldReturnSuccessMessage() {
//
//        RegisterDto registerDto = new RegisterDto();
//        registerDto.setName("John Doe");
//        registerDto.setUsername("johndoe");
//        registerDto.setEmail("johndoe@example.com");
//        registerDto.setPassword("password");
//
//        Role role = new Role();
//        role.setName("ROLE_USER");
//
//        when(roleRepository.findByName("ROLE_USER")).thenReturn(Optional.of(role));
//        when(userRepository.existsByUsername("johndoe")).thenReturn(false);
//        when(userRepository.existsByEmail("johndoe@example.com")).thenReturn(false);
//        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
//
//        String result = authService.register(registerDto);
//
//        assertEquals("User registered successfully!.", result);
//        verify(userRepository).save(any(User.class));
//    }
//
//    @Test
//    public void whenUsernameExists_thenThrowException() {
//        RegisterDto registerDto = new RegisterDto("Test", "test", "test@email.com", "testpassword");
//        User user = new User();
//        user.setUsername(registerDto.getUsername());
//        when(userRepository.existsByUsername(registerDto.getUsername())).thenReturn(true);
//
//
//        assertThatThrownBy(() -> authService.register(registerDto))
//                .isInstanceOf(EcommerceAPIException.class)
//                .hasMessageContaining("Username is already exists!.");
//    }
//
//    @Test
//    public void whenEmailExists_thenThrowException() {
//        RegisterDto registerDto = new RegisterDto("Test", "test", "test@email.com", "testpassword");
//        User user = new User();
//        user.setEmail(registerDto.getEmail());
//        when(userRepository.existsByEmail(registerDto.getEmail())).thenReturn(true);
//
//        assertThatThrownBy(() -> authService.register(registerDto))
//                .isInstanceOf(EcommerceAPIException.class)
//                .hasMessageContaining("Email is already exists!.");
//    }
//
//    @Test
//    public void whenValidationFails_thenThrowException() {
//        RegisterDto registerDto = new RegisterDto("", "test", "test@email.com", "testpassword");
//        when(validator.validate(registerDto)).thenReturn(Set.of(mock(ConstraintViolation.class)));
//
//        assertThatThrownBy(() -> authService.register(registerDto))
//                .isInstanceOf(ConstraintViolationException.class);
//    }
//
//    @Test
//    public void updateUserByIdTest() {
//        UpdateDto updateUserDto = new UpdateDto();
//        updateUserDto.setName("John");
//        updateUserDto.setUsername("john");
//        updateUserDto.setEmail("john@example.com");
//        updateUserDto.setPassword("password");
//
//        User user = new User();
//        user.setName(updateUserDto.getName());
//        user.setUsername(updateUserDto.getUsername());
//        user.setEmail(updateUserDto.getEmail());
//
//        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
//        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
//
//        String result = authService.updateUserById(1L, updateUserDto);
//
//        verify(userRepository).save(user);
//        assertEquals("User saved successfully!", result);
//    }
//    @Test
//    public void testUpdateUser() {
//        UpdateDto updateDto = new UpdateDto();
//        updateDto.setName("John");
//        updateDto.setUsername("john123");
//        updateDto.setEmail("john@example.com");
//        updateDto.setPassword("password");
//
//        User user = new User();
//        user.setEmail("john@example.com");
//        when(userRepository.findByEmail(any(String.class))).thenReturn(user);
//        when(passwordEncoder.encode(any(String.class))).thenReturn("encoded_password");
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken("john@example.com", ""));
//
//        String result = authService.updateUser(updateDto);
//        assertEquals("User saved successfully!", result);
//    }
//}
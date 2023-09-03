package com.fdmgroup.flexdronepodq42022.Security;

import com.fdmgroup.flexdronepodq42022.Model.Role;
import com.fdmgroup.flexdronepodq42022.Model.User;
import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService userDetailsService;

    private User user;

    @Test
    public void testLoadUserByUsername() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Role role = new Role();
        role.setRole_id(1L);
        role.setName("ROLE_USER");
        user.setRoles(Collections.singleton(role));
        when(userRepository.findByUsernameOrEmail("test@example.com", "test@example.com"))
                .thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("test@example.com");

        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        Set<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        assertTrue(roles.contains("ROLE_USER"));
    }

    @Test
    public void testLoadUserByUsernameUserNotFound() {
        String usernameOrEmail = "notfound@test.com";
        when(userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)).thenReturn(Optional.empty());

        UsernameNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(usernameOrEmail));
        assertEquals("User not found with username or email: " + usernameOrEmail, exception.getMessage());
    }

}
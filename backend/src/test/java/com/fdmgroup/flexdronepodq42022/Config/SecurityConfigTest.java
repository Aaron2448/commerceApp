package com.fdmgroup.flexdronepodq42022.Config;

import com.fdmgroup.flexdronepodq42022.Security.JwtAuthenticationEntryPoint;
import com.fdmgroup.flexdronepodq42022.Security.JwtAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SecurityConfigTest {

    @Mock
    UserDetailsService userDetailsService;

    @Mock
    JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Mock
    JwtAuthenticationFilter authenticationFilter;
    @Mock
    private HttpSecurity http;

    @Test
    void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = SecurityConfig.passwordEncoder();
        String password = "test123";
        String encodedPassword = passwordEncoder.encode(password);
        assertTrue(passwordEncoder.matches(password, encodedPassword));
    }

    @Test
    void testAuthenticationManager() throws Exception {
        AuthenticationConfiguration authenticationConfiguration = mock(AuthenticationConfiguration.class);
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(authenticationManager);

        SecurityConfig config = new SecurityConfig(userDetailsService, authenticationEntryPoint, authenticationFilter);
        AuthenticationManager result = config.authenticationManager(authenticationConfiguration);

        assertEquals(authenticationManager, result);
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void testAuthentication() throws Exception {
        SecurityConfig config = new SecurityConfig(userDetailsService, authenticationEntryPoint, authenticationFilter);

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(config)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/test"));
    }
}
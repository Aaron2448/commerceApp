package com.fdmgroup.flexdronepodq42022.Security;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.AuthenticationException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JwtAuthenticationEntryPointTest {
    @Test
    public void shouldSendError() throws ServletException, IOException, jakarta.servlet.ServletException {
        JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint = new JwtAuthenticationEntryPoint();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        AuthenticationException authException = mock(AuthenticationException.class);

        jakarta.servlet.http.HttpServletRequest servletRequest = mock(jakarta.servlet.http.HttpServletRequest.class);
        jakarta.servlet.http.HttpServletResponse servletResponse = mock(jakarta.servlet.http.HttpServletResponse.class);

        lenient().when(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(401);
        lenient().when(request.getAttribute(RequestDispatcher.ERROR_MESSAGE)).thenReturn("Unauthorized");

        jwtAuthenticationEntryPoint.commence(servletRequest, servletResponse, authException);

        verify(servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}

package com.fdmgroup.flexdronepodq42022.Dto;

import com.fdmgroup.flexdronepodq42022.DTO.JWTAuthResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class JWTAuthResponseTest {

    private final String accessToken = "access-token";
    private JWTAuthResponse jwtAuthResponse;

    @Before
    public void setUp() {
        jwtAuthResponse = new JWTAuthResponse(accessToken, "Bearer");
    }

    @Test
    public void testGetAccessToken() {
        assertEquals(accessToken, jwtAuthResponse.getAccessToken());
    }

    @Test
    public void testSetAccessToken() {
        jwtAuthResponse.setAccessToken("new-access-token");

        assertEquals("new-access-token", jwtAuthResponse.getAccessToken());
    }

    @Test
    public void testGetTokenType() {
        assertEquals("Bearer", jwtAuthResponse.getTokenType());
    }

    @Test
    public void testSetTokenType() {
        jwtAuthResponse.setTokenType("new-token-type");

        assertEquals("new-token-type", jwtAuthResponse.getTokenType());
    }

    @Test
    public void testNoArgsConstructor() {
        JWTAuthResponse emptyJwtAuthResponse = new JWTAuthResponse();

        assertNotNull(emptyJwtAuthResponse);
        assertNull(emptyJwtAuthResponse.getAccessToken());
        assertEquals("Bearer", emptyJwtAuthResponse.getTokenType());
    }

    @Test
    public void testAllArgsConstructor() {
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse("access-token", "Bearer");

        assertNotNull(jwtAuthResponse);
        assertEquals("access-token", jwtAuthResponse.getAccessToken());
        assertEquals("Bearer", jwtAuthResponse.getTokenType());
    }
}

package com.fdmgroup.flexdronepodq42022.Security;

import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class JwtTokenProviderTest {
    @Mock
    private Authentication authentication;

    @InjectMocks
    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    public void setUp() {
        jwtTokenProvider.jwtSecret = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb";
        jwtTokenProvider.jwtExpirationDate = 604800000;
        Mockito.lenient().when(authentication.getName()).thenReturn("testUser");
    }


    @Test
    public void testGenerateToken() {
        String token = jwtTokenProvider.generateToken(authentication);
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void testGetUsername() {
        String token = jwtTokenProvider.generateToken(authentication);
        String username = jwtTokenProvider.getUsername(token);
        assertEquals(username, authentication.getName());
    }

    @Test
    public void testValidateToken() {
        String token = jwtTokenProvider.generateToken(authentication);
        boolean isValid = jwtTokenProvider.validateToken(token);
        assertTrue(isValid);
    }


    @Test
    public void testValidateTokenWithInvalidToken() {
        assertThrows(EcommerceAPIException.class, () -> jwtTokenProvider.validateToken("invalid-token"));
    }

    @Test
    public void testValidateTokenWithExpiredToken() {
        // generate token with expired date
        Date currentDate = new Date();
        Date expiredDate = new Date(currentDate.getTime() - 604800000);
        String token = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(currentDate)
                .setExpiration(expiredDate)
                .signWith(key())
                .compact();

        assertThrows(EcommerceAPIException.class, () -> jwtTokenProvider.validateToken(token));
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb"));
    }
}
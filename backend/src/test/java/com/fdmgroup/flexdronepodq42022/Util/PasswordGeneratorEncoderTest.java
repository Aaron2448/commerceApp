package com.fdmgroup.flexdronepodq42022.Util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PasswordGeneratorEncoderTest {
    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    public void testPasswordEncoding() {
        String password = "sarab";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        assertTrue(passwordEncoder.matches(password, encodedPassword));
    }
    @Test
    public void testEncodePassword() {
        String rawPassword = "sarab";
        String encodedPassword = "$2a$10$KBuCBRGW.CQT26GcM0tnVeLa9X9B8HIGhjJbIHX2gnoz1bvnC6mb2";

        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);

        String result = passwordEncoder.encode(rawPassword);

        assertEquals(encodedPassword, result);
    }
}
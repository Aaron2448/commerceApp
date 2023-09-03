//package com.fdmgroup.flexdronepodq42022.Dto;
//
//import com.fdmgroup.flexdronepodq42022.DTO.LoginDto;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.lang.reflect.Field;
//
//import static org.junit.Assert.*;
//
//@ExtendWith(MockitoExtension.class)
//public class LoginDtoTest {
//    private LoginDto loginDto;
//
//    @Before
//    public void setUp() {
//        loginDto = new LoginDto("johndoe@example.com", "password123");
//    }
//
//    @Test
//    public void testGetUsernameOrEmail() throws NoSuchFieldException, IllegalAccessException {
//        final Field field = loginDto.getClass().getDeclaredField("usernameOrEmail");
//        field.setAccessible(true);
//        field.set(loginDto, "janedoe@example.com");
//
//        assertEquals("janedoe@example.com", loginDto.getUsernameOrEmail());
//    }
//
//    @Test
//    public void testSetUsernameOrEmail() throws NoSuchFieldException, IllegalAccessException {
//        loginDto.setUsernameOrEmail("janedoe@example.com");
//
//        final Field field = loginDto.getClass().getDeclaredField("usernameOrEmail");
//        field.setAccessible(true);
//
//        assertEquals("janedoe@example.com", field.get(loginDto));
//    }
//
//    @Test
//    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
//        final Field field = loginDto.getClass().getDeclaredField("password");
//        field.setAccessible(true);
//        field.set(loginDto, "password456");
//
//        assertEquals("password456", loginDto.getPassword());
//    }
//
//    @Test
//    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
//        loginDto.setPassword("password456");
//
//        final Field field = loginDto.getClass().getDeclaredField("password");
//        field.setAccessible(true);
//
//        assertEquals("password456", field.get(loginDto));
//    }
//
//    @Test
//    public void testNoArgsConstructor() {
//        LoginDto emptyDto = new LoginDto();
//
//        assertNotNull(emptyDto);
//        assertNull(emptyDto.getUsernameOrEmail());
//        assertNull(emptyDto.getPassword());
//    }
//
//    @Test
//    public void testAllArgsConstructor() {
//        LoginDto loginDto = new LoginDto("johndoe@example.com", "password123");
//
//        assertNotNull(loginDto);
//        assertEquals("johndoe@example.com", loginDto.getUsernameOrEmail());
//        assertEquals("password123", loginDto.getPassword());
//    }
//}

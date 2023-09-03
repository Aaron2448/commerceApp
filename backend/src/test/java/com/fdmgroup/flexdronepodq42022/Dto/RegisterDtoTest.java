package com.fdmgroup.flexdronepodq42022.Dto;

import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.Assert.*;


@ExtendWith(MockitoExtension.class)
public class RegisterDtoTest {

    private Validator validator;
    private RegisterDto registerDto;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        registerDto = new RegisterDto("John Doe", "johndoe", "johndoe@example.com", "password123");
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {
        final Field field = registerDto.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(registerDto, "Jane Doe");

        assertEquals("Jane Doe", registerDto.getName());
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {
        registerDto.setName("Jane Doe");

        final Field field = registerDto.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Jane Doe", field.get(registerDto));
    }

    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
        final Field field = registerDto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(registerDto, "janedoe");

        assertEquals("janedoe", registerDto.getUsername());
    }

    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {
        registerDto.setUsername("janedoe");

        final Field field = registerDto.getClass().getDeclaredField("username");
        field.setAccessible(true);

        assertEquals("janedoe", field.get(registerDto));
    }

    @Test
    public void testGetEmail() throws NoSuchFieldException, IllegalAccessException {
        final Field field = registerDto.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(registerDto, "janedoe@example.com");

        assertEquals("janedoe@example.com", registerDto.getEmail());
    }

    @Test
    public void testSetEmail() throws NoSuchFieldException, IllegalAccessException {
        registerDto.setEmail("janedoe@example.com");

        final Field field = registerDto.getClass().getDeclaredField("email");
        field.setAccessible(true);

        assertEquals("janedoe@example.com", field.get(registerDto));
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        final Field field = registerDto.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(registerDto, "password456");

        assertEquals("password456", registerDto.getPassword());
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
        registerDto.setPassword("password456");

        final Field field = registerDto.getClass().getDeclaredField("password");
        field.setAccessible(true);

        assertEquals("password456", field.get(registerDto));
    }

    @Test
    public void testNoArgsConstructor() {
        RegisterDto emptyDto = new RegisterDto();

        assertNotNull(emptyDto);
        assertNull(emptyDto.getName());
        assertNull(emptyDto.getUsername());
        assertNull(emptyDto.getEmail());
        assertNull(emptyDto.getPassword());
    }

    @Test
    public void testAllArgsConstructor() {
        RegisterDto registerDto = new RegisterDto("John Doe", "johndoe", "johndoe@example.com", "password123");

        assertNotNull(registerDto);
        assertEquals("John Doe", registerDto.getName());
        assertEquals("johndoe", registerDto.getUsername());
        assertEquals("johndoe@example.com", registerDto.getEmail());
        assertEquals("password123", registerDto.getPassword());
    }
}

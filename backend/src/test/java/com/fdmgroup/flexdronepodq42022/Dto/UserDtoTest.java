package com.fdmgroup.flexdronepodq42022.Dto;

import com.fdmgroup.flexdronepodq42022.DTO.UserDto;
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
public class UserDtoTest {

    private Validator validator;
    private UserDto userDto;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        userDto = new UserDto("John Doe", "johndoe", "johndoe@example.com", "password123");
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {
        final Field field = userDto.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(userDto, "Jane Doe");

        assertEquals("Jane Doe", userDto.getName());
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {
        userDto.setName("Jane Doe");

        final Field field = userDto.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Jane Doe", field.get(userDto));
    }

    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
        final Field field = userDto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(userDto, "janedoe");

        assertEquals("janedoe", userDto.getUsername());
    }

    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {
        userDto.setUsername("janedoe");

        final Field field = userDto.getClass().getDeclaredField("username");
        field.setAccessible(true);

        assertEquals("janedoe", field.get(userDto));
    }

    @Test
    public void testGetEmail() throws NoSuchFieldException, IllegalAccessException {
        final Field field = userDto.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(userDto, "janedoe@example.com");

        assertEquals("janedoe@example.com", userDto.getEmail());
    }

    @Test
    public void testSetEmail() throws NoSuchFieldException, IllegalAccessException {
        userDto.setEmail("janedoe@example.com");

        final Field field = userDto.getClass().getDeclaredField("email");
        field.setAccessible(true);

        assertEquals("janedoe@example.com", field.get(userDto));
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        final Field field = userDto.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(userDto, "password456");

        assertEquals("password456", userDto.getPassword());
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
        userDto.setPassword("password456");

        final Field field = userDto.getClass().getDeclaredField("password");
        field.setAccessible(true);

        assertEquals("password456", field.get(userDto));
    }

    @Test
    public void testNoArgsConstructor() {
        UserDto emptyDto = new UserDto();

        assertNotNull(emptyDto);
        assertNull(emptyDto.getName());
        assertNull(emptyDto.getUsername());
        assertNull(emptyDto.getEmail());
        assertNull(emptyDto.getPassword());
    }

    @Test
    public void testAllArgsConstructor() {
        UserDto userDto = new UserDto("John Doe", "johndoe", "johndoe@example.com", "password123");

        assertNotNull(userDto);
        assertEquals("John Doe", userDto.getName());
        assertEquals("johndoe", userDto.getUsername());
        assertEquals("johndoe@example.com", userDto.getEmail());
        assertEquals("password123", userDto.getPassword());
    }
}

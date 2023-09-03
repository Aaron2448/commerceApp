package com.fdmgroup.flexdronepodq42022.Dto;

import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
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
public class UpdateDtoTest {

    private Validator validator;
    private UpdateDto updateDto;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        updateDto = new UpdateDto("John Doe", "johndoe", "johndoe@example.com", "password123");
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {
        final Field field = updateDto.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(updateDto, "Jane Doe");

        assertEquals("Jane Doe", updateDto.getName());
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {
        updateDto.setName("Jane Doe");

        final Field field = updateDto.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Jane Doe", field.get(updateDto));
    }

    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
        final Field field = updateDto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(updateDto, "janedoe");

        assertEquals("janedoe", updateDto.getUsername());
    }

    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {
        updateDto.setUsername("janedoe");

        final Field field = updateDto.getClass().getDeclaredField("username");
        field.setAccessible(true);

        assertEquals("janedoe", field.get(updateDto));
    }

    @Test
    public void testGetEmail() throws NoSuchFieldException, IllegalAccessException {
        final Field field = updateDto.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(updateDto, "janedoe@example.com");

        assertEquals("janedoe@example.com", updateDto.getEmail());
    }

    @Test
    public void testSetEmail() throws NoSuchFieldException, IllegalAccessException {
        updateDto.setEmail("janedoe@example.com");

        final Field field = updateDto.getClass().getDeclaredField("email");
        field.setAccessible(true);

        assertEquals("janedoe@example.com", field.get(updateDto));
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        final Field field = updateDto.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(updateDto, "password456");

        assertEquals("password456", updateDto.getPassword());
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
        updateDto.setPassword("password456");

        final Field field = updateDto.getClass().getDeclaredField("password");
        field.setAccessible(true);

        assertEquals("password456", field.get(updateDto));
    }

    @Test
    public void testNoArgsConstructor() {
        UpdateDto emptyDto = new UpdateDto();

        assertNotNull(emptyDto);
        assertNull(emptyDto.getName());
        assertNull(emptyDto.getUsername());
        assertNull(emptyDto.getEmail());
        assertNull(emptyDto.getPassword());
    }

    @Test
    public void testAllArgsConstructor() {
        UpdateDto updateDto = new UpdateDto("John Doe", "johndoe", "johndoe@example.com", "password123");

        assertNotNull(updateDto);
        assertEquals("John Doe", updateDto.getName());
        assertEquals("johndoe", updateDto.getUsername());
        assertEquals("johndoe@example.com", updateDto.getEmail());
        assertEquals("password123", updateDto.getPassword());
    }
}

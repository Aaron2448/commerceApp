package com.fdmgroup.flexdronepodq42022.Exception;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class ResourceNotFoundExceptionTest {

    @Test
    void testConstructor_withFieldNameAndFieldValue() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Post", "id", 1);

        assertEquals("Post not found with id : '1'", exception.getMessage());
        assertEquals("Post", exception.getResourceName());
        assertEquals("id", exception.getFieldName());
        assertEquals(1, exception.getFieldValue());
    }

    @Test
    void testConstructor_withResourceName() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Post");

        assertNull(exception.getMessage());
        assertNull(exception.getResourceName());
    }

    @Test
    void testResponseStatus() {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ResourceNotFoundException exception = new ResourceNotFoundException("Post", "id", 1);

        assertEquals("Post not found with id : '1'", exception.getMessage());
    }
}
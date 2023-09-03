package com.fdmgroup.flexdronepodq42022.Dto;

import com.fdmgroup.flexdronepodq42022.DTO.ErrorDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class ErrorDetailsTest {
    private final Date timestamp = new Date();
    private final String message = "Error message";
    private final String details = "Error details";
    private ErrorDetails errorDetails;

    @Before
    public void setUp() {
        errorDetails = new ErrorDetails(timestamp, message, details);
    }

    @Test
    public void testConstructor() {
        assertNotNull(errorDetails);
        assertEquals(timestamp, errorDetails.getTimestamp());
        assertEquals(message, errorDetails.getMessage());
        assertEquals(details, errorDetails.getDetails());
    }

    @Test
    public void testGetTimestamp() {
        assertEquals(timestamp, errorDetails.getTimestamp());
    }

    @Test
    public void testGetMessage() {
        assertEquals(message, errorDetails.getMessage());
    }

    @Test
    public void testGetDetails() {
        assertEquals(details, errorDetails.getDetails());
    }
}

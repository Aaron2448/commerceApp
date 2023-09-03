package com.fdmgroup.flexdronepodq42022.Exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class EcommerceAPIExceptionTest {
    @Test
    public void testEcommerceAPIException() {
        String message = "Test message";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        EcommerceAPIException exception = new EcommerceAPIException(status, message);

        Assertions.assertEquals(status, exception.getStatus());
        Assertions.assertEquals(message, exception.getMessage());
    }
}

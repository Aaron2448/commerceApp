package com.fdmgroup.flexdronepodq42022.Exception;

import com.fdmgroup.flexdronepodq42022.DTO.ErrorDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {
    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private FieldError fieldError;

    @Mock
    private WebRequest webRequest;

    @Test
    public void handleResourceNotFoundException_returnsNotFoundHttpStatus() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Some description");

        ResponseEntity<ErrorDetails> response = globalExceptionHandler.handleResourceNotFoundException(exception, webRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody().getMessage());
    }

    @Test
    public void handleBlogAPIException_returnsBadRequestHttpStatus() {
        EcommerceAPIException exception = new EcommerceAPIException("Bad request", HttpStatus.BAD_REQUEST, "Some error");

        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Some description");

        ResponseEntity<ErrorDetails> response = globalExceptionHandler.handleBlogAPIException(exception, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Some error", response.getBody().getMessage());
    }

    @Test
    public void handleGlobalException_returnsInternalServerErrorHttpStatus() {
        Exception exception = new Exception("Internal server error");

        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Some description");

        ResponseEntity<ErrorDetails> response = globalExceptionHandler.handleGlobalException(exception, webRequest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error", response.getBody().getMessage());
    }

    @Test
    public void handleAccessDeniedException_returnsUnauthorizedHttpStatus() {
        AccessDeniedException exception = new AccessDeniedException("Unauthorized");

        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Some description");

        ResponseEntity<ErrorDetails> response = globalExceptionHandler.handleAccessDeniedException(exception, webRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Unauthorized", response.getBody().getMessage());
    }

    @Test
    public void handleMethodArgumentNotValid() {
        List<ObjectError> errorsList = new ArrayList<>();
        errorsList.add(fieldError);

        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getAllErrors()).thenReturn(errorsList);
        when(fieldError.getField()).thenReturn("fieldName");
        when(fieldError.getDefaultMessage()).thenReturn("message");

        ResponseEntity<Object> responseEntity = globalExceptionHandler.handleMethodArgumentNotValid(methodArgumentNotValidException, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);

        Map<String, String> expectedErrors = new HashMap<>();
        expectedErrors.put("fieldName", "message");
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(expectedErrors, responseEntity.getBody());
    }
}

//package com.fdmgroup.flexdronepodq42022.Controller;
//
//import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
//import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
//import com.fdmgroup.flexdronepodq42022.Model.User;
//import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
//import com.fdmgroup.flexdronepodq42022.Service.AuthService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class AdminControllerTest {
//    @Mock
//    private AuthService authService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private Authentication authentication;
//
//    @InjectMocks
//    private AdminController adminController;
//
//    @Mock
//    private SecurityContext securityContext;
//
//    @Test
//    public void getUserByIdTest() {
//        User user = new User();
//        user.setUser_id(1L);
//        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
//
//        ResponseEntity<User> result = adminController.getUserById(1L);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertEquals(user, result.getBody());
//    }
//
//    @Test
//    public void testGetAllUsers() {
//        User user1 = new User();
//        user1.setUser_id(1L);
//        user1.setUsername("john");
//        User user2 = new User();
//        user2.setUser_id(2L);
//        user2.setUsername("jane");
//        List<User> users = Arrays.asList(user1, user2);
//        when(userRepository.findAll()).thenReturn(users);
//
//        ResponseEntity<List<User>> response = adminController.getAllUsers();
//
//        assertEquals(2, response.getBody().size());
//        assertEquals(200, response.getStatusCodeValue());
//    }
//
//    @Test
//    public void deleteUserTest() {
//        User user = new User();
//        user.setUser_id(1L);
//        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
//
//        ResponseEntity<?> result = adminController.deleteUser(1L);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    @Test
//    public void testUpdateUserByIdSuccess() {
//        UpdateDto updateDto = new UpdateDto();
//        when(authService.updateUserById(eq(1L), any(UpdateDto.class))).thenReturn("User updated successfully");
//
//        ResponseEntity<String> response = adminController.updateUserById(1L, updateDto);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("User updated successfully", response.getBody());
//    }
//
//    @Test
//    public void testUpdateUserByIdFailure() {
//        UpdateDto updateDto = new UpdateDto();
//        when(authService.updateUserById(eq(1L), any(UpdateDto.class)))
//                .thenThrow(new EcommerceAPIException(HttpStatus.NOT_FOUND, "User not found"));
//
//        ResponseEntity<String> response = adminController.updateUserById(1L, updateDto);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertNull(response.getBody());
//    }
//}

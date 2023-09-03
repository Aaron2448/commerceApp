//package com.fdmgroup.flexdronepodq42022.Model;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserTest {
//    private final Long id = 1L;
//    private final String name = "John Doe";
//    private final String username = "johndoe";
//    private final String email = "johndoe@example.com";
//    private final String password = "password123";
//    private final Set<Role> roles = new HashSet<>();
//    private User user;
//
//    @Before
//    public void setUp() {
//        user = new User(id, name, username, email, password, roles);
//    }
//
//    @Test
//    public void testGetId() {
//        assertEquals(id, user.getId());
//    }
//
//    @Test
//    public void testSetId() {
//        user.setId(2L);
//
//        assertEquals(2L, user.getId().longValue());
//    }
//
//    @Test
//    public void testGetName() {
//        assertEquals(name, user.getName());
//    }
//
//    @Test
//    public void testSetName() {
//        user.setName("Jane Doe");
//
//        assertEquals("Jane Doe", user.getName());
//    }
//
//    @Test
//    public void testGetUsername() {
//        assertEquals(username, user.getUsername());
//    }
//
//    @Test
//    public void testSetUsername() {
//        user.setUsername("janedoe");
//
//        assertEquals("janedoe", user.getUsername());
//    }
//
//    @Test
//    public void testGetEmail() {
//        assertEquals(email, user.getEmail());
//    }
//
//    @Test
//    public void testSetEmail() {
//        user.setEmail("janedoe@example.com");
//
//        assertEquals("janedoe@example.com", user.getEmail());
//    }
//
//    @Test
//    public void testGetPassword() {
//        assertEquals(password, user.getPassword());
//    }
//
//    @Test
//    public void testSetPassword() {
//        user.setPassword("new-password");
//
//        assertEquals("new-password", user.getPassword());
//    }
//
//    @Test
//    public void testGetRoles() {
//        assertNotNull(user.getRoles());
//    }
//
//    @Test
//    public void testSetRoles() {
//        Set<Role> newRoles = new HashSet<>();
//        user.setRoles(newRoles);
//
//        assertEquals(newRoles, user.getRoles());
//    }
//
//    @Test
//    public void testNoArgsConstructor() {
//        User emptyUser = new User();
//
//        assertNotNull(emptyUser);
//        assertNull(emptyUser.getId());
//        assertNull(emptyUser.getName());
//        assertNull(emptyUser.getUsername());
//        assertNull(emptyUser.getEmail());
//        assertNull(emptyUser.getPassword());
//    }
//
//    @Test
//    public void testAllArgsConstructor() {
//        Set<Role> roles = new HashSet<>();
//        User user = new User(id, name, username, email, password, roles);
//
//        assertNotNull(user);
//        assertEquals(id, user.getId());
//        assertEquals(name, user.getName());
//        assertEquals(username, user.getUsername());
//        assertEquals(email, user.getEmail());
//        assertEquals(password, user.getPassword());
//        assertEquals(roles, user.getRoles());
//    }
//}

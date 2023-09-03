package com.fdmgroup.flexdronepodq42022.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class RoleTest {
    private final Long id = 1L;
    private final String name = "ROLE_ADMIN";
    private Role role;

    @Before
    public void setUp() {
        role = new Role(id, name);
    }

    @Test
    public void testGetId() {
        assertEquals(id, role.getRole_id());
    }

    @Test
    public void testSetId() {
        role.setRole_id(2L);

        assertEquals(2L, role.getRole_id().longValue());
    }

    @Test
    public void testGetName() {
        assertEquals(name, role.getName());
    }

    @Test
    public void testSetName() {
        role.setName("ROLE_USER");

        assertEquals("ROLE_USER", role.getName());
    }

    @Test
    public void testNoArgsConstructor() {
        Role emptyRole = new Role();

        assertNotNull(emptyRole);
        assertNull(emptyRole.getRole_id());
        assertNull(emptyRole.getName());
    }

    @Test
    public void testAllArgsConstructor() {
        Role role = new Role(id, name);

        assertNotNull(role);
        assertEquals(id, role.getRole_id());
        assertEquals(name, role.getName());
    }

    @Test
    public void testConstructorWithName() {
        Role role = new Role(name);

        assertNotNull(role);
        assertNull(role.getRole_id());
        assertEquals(name, role.getName());
    }
}

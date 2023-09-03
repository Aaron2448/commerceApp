package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleRepositoryTest {

    @Mock
    private RoleRepository roleRepository;

    @Test
    public void whenFindByName_thenReturnRole() {
        Role role = new Role("admin");
        when(roleRepository.findByName("admin")).thenReturn(Optional.of(role));

        Optional<Role> foundRole = roleRepository.findByName("admin");
        assertTrue(foundRole.isPresent());
        assertEquals(foundRole.get().getName(), "admin");
    }
}

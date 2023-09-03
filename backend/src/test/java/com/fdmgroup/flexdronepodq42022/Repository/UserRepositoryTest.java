package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Role;
import com.fdmgroup.flexdronepodq42022.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepositoryMock;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUser_id(1L);
        user.setFirst_name("John Doe");
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
    }

    @Test
    public void testFindByEmail() {
        when(userRepositoryMock.findByEmail("johndoe@example.com")).thenReturn(user);

        User result = userRepositoryMock.findByEmail("johndoe@example.com");

        assertThat(result).isEqualTo(user);
    }

    @Test
    public void testFindByUsernameOrEmail_WithEmail() {
        when(userRepositoryMock.findByUsernameOrEmail("johndoe", "johndoe@example.com")).thenReturn(Optional.of(user));

        Optional<User> result = userRepositoryMock.findByUsernameOrEmail("johndoe", "johndoe@example.com");

        assertThat(result).isPresent().contains(user);
    }

    @Test
    public void testFindByUsername() {
        when(userRepositoryMock.findByUsername("johndoe")).thenReturn(Optional.of(user));

        Optional<User> result = userRepositoryMock.findByUsername("johndoe");

        assertThat(result).isPresent().contains(user);
    }

    @Test
    public void testExistsByUsername_WithExistingUsername() {
        when(userRepositoryMock.existsByUsername("johndoe")).thenReturn(true);

        boolean result = userRepositoryMock.existsByUsername("johndoe");

        assertThat(result).isTrue();
    }

    @Test
    public void testExistsByUsername_WithNonExistingUsername() {
        when(userRepositoryMock.existsByUsername("janedoe")).thenReturn(false);

        boolean result = userRepositoryMock.existsByUsername("janedoe");

        assertThat(result).isFalse();
    }

    @Test
    public void testExistsByEmail_WithExistingEmail() {
        when(userRepositoryMock.existsByEmail("johndoe@example.com")).thenReturn(true);

        boolean result = userRepositoryMock.existsByEmail("johndoe@example.com");

        assertThat(result).isTrue();
    }

    @Test
    public void testExistsByEmail_WithNonExistingEmail() {
        when(userRepositoryMock.existsByEmail("janedoe@example.com")).thenReturn(false);

        boolean result = userRepositoryMock.existsByEmail("janedoe@example.com");

        assertThat(result).isFalse();
    }
}
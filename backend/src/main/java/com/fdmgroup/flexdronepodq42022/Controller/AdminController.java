package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
import com.fdmgroup.flexdronepodq42022.Exception.EcommerceAPIException;
import com.fdmgroup.flexdronepodq42022.Exception.ResourceNotFoundException;
import com.fdmgroup.flexdronepodq42022.Model.Role;
import com.fdmgroup.flexdronepodq42022.Model.User;
import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
import com.fdmgroup.flexdronepodq42022.Service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/user")
public class AdminController {
    private final AuthService authService;
    private final UserRepository userRepository;

  
    public AdminController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    /**
     * Return all users for admin
     *
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        log.info("Found " + users.size() + " users");

        return ResponseEntity.ok(users);
    }

    /**
     * Returns users by given id, ADMIN ONLY!
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        log.info("User found: " + user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Update User by given id
     *
     * @param id
     * @param updateUserDto
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody UpdateDto updateUserDto) {
        try {
            String message = authService.updateUserById(id, updateUserDto);
            log.info("User updated: " + message);
            return ResponseEntity.ok(message);
        } catch (EcommerceAPIException e) {
            return ResponseEntity.status(e.getStatus()).body(null);
        }
    }

    /**
     * Delete User by given id
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        Set<Role> userRole = user.getRoles();

        if (userRole.stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.badRequest().body("Admin user cannot be deleted.");
        }

        log.info("User deleted: " + user);
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}

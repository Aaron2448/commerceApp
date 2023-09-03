package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String secret; // secret key used for generating 2FA code
    @Column(nullable = false)
    private boolean is_using2FA = false; // flag to indicate whether user is using 2FA or not
    @Column
    private String address;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String dob;
    @Column
    private String gender;
    @Column
    private String job_industry;
    @Column
    private String mobile;
    @Column
    private int postcode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles;
}

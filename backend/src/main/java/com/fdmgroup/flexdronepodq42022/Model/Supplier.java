package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplier_id;

    private String name;
    private String location;
    private String email;
    private String phone;
    private boolean is_active;

    @OneToMany(mappedBy = "supplier")
    private List<ProductSupplier> products;

    public Supplier(long id, String name, String location, String email, String phone) {
        super();
        this.supplier_id = id;
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
    }

    public Supplier(String name, String location, String email, String phone) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
    }
}

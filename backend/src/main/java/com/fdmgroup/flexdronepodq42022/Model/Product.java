package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(length=5000)
    private String description;

    @Column
    private float retail_price;

    @Column
    public String category;

    @Column
    private String name;

    @Column
    private long external_stock;

    @Column
    private long internal_stock;

    @Column
    private long min_stock_level;

    @Column
    private boolean isPart;

    @Column
    private String external_note;

    @Column
    private String internal_note;

    @Column(length=1000)
    private String image_url;

    @Column
    private int quantity_in_cart = 1;
    
    @Column
    private long reorder_point;

}

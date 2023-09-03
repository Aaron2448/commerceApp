package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "product_order")
public class ProductOrderObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long product_order_id;
    @Column(nullable = false)
    private long order_id;
    @Column
    private long product_id;
    @Column(nullable = false)
    private String sku;
    @Column(nullable = false)
    private float sold_price;
    @Column(nullable = false)
    private long quantity;


}
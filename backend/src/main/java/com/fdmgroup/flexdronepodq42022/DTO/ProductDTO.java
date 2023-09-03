package com.fdmgroup.flexdronepodq42022.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String sku;
    private float retailPrice;
    private int quantity_in_cart;
}
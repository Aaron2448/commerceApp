package com.fdmgroup.flexdronepodq42022.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    private long customer_id;
    private String name;
    private String address;
    private String email;
    private List<ProductDTO> product;
    private String payment_method;
    
}
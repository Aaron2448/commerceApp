package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Model.ProductSupplier;
import com.fdmgroup.flexdronepodq42022.Repository.ProductSupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/productSupplier")
public class ProductSupplierController {
    private final ProductSupplierRepository productSupplierRepository;

    @Autowired
    public ProductSupplierController(ProductSupplierRepository productSupplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
    }

    @GetMapping("/getAll")
    public List<ProductSupplier> getAllProductSuppliers() {
        log.info("Get All Product Suppliers: " + productSupplierRepository.findAll());
        return productSupplierRepository.findAll();
    }

    @PostMapping("/create")
    public ProductSupplier createProductSupplier(@RequestBody ProductSupplier productSupplier) {
        log.info("Created Product Supplier: " + productSupplier);
        return productSupplierRepository.save(productSupplier);
    }

    @GetMapping("/{id}")
    public Optional<ProductSupplier> getProductSupplierById(@PathVariable Long id) {
        log.info("Get Product Supplier By ID: " + id);
        return productSupplierRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public ProductSupplier updateProductSupplier(@PathVariable Long id, @RequestBody ProductSupplier productSupplier) {
        productSupplier.setProduct_supplier_id(id);
        log.info("Updated Product Supplier By ID: " + productSupplier);
        return productSupplierRepository.save(productSupplier);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductSupplier(@PathVariable Long id) {
        log.info("Delete Product Supplier By ID: " + id);
        productSupplierRepository.deleteById(id);
    }
}

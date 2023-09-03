package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Exception.ResourceNotFoundException;
import com.fdmgroup.flexdronepodq42022.Model.Product;
import com.fdmgroup.flexdronepodq42022.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        log.info("Get all products: " + productRepository.findAll());

        return productRepository.findAll();
    }

    @GetMapping("/collections")
    public List<Product> getCollections() {
        log.info("Get all collections: " + productRepository.findAll());

        return productRepository.findAllCollection();
    }

    @GetMapping("/base")
    public List<Product> getBaseModel() {
        log.info("Get all collections: " + productRepository.findAllBaseModel());

        return productRepository.findAllBaseModel();
    }

    @GetMapping("/battery")
    public List<Product> getBattery() {
        log.info("Get all collections: " + productRepository.findAllBattery());

        return productRepository.findAllBattery();
    }

    @GetMapping("/camera")
    public List<Product> getCamera() {
        log.info("Get all collections: " + productRepository.findAllCamera());

        return productRepository.findAllCamera();
    }

    @GetMapping("/propeller")
    public List<Product> getPropeller() {
        log.info("Get all collections: " + productRepository.findAllPropeller());

        return productRepository.findAllPropeller();
    }

    @GetMapping("/parts")
    public List<Product> getParts() {
        log.info("Get all Parts: " + productRepository.findAll());

        return productRepository.findAllPart();
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        log.info("Get product by id: " + id);

        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        log.info("Created product: " + product);

        return productRepository.save(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product productDetails) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        product.setSku(productDetails.getSku());
        product.setDescription(productDetails.getDescription());
        product.setRetail_price(productDetails.getRetail_price());
        product.setCategory(productDetails.getCategory());
        product.setName(productDetails.getName());
        product.setExternal_stock(productDetails.getExternal_stock());
        product.setInternal_stock(productDetails.getInternal_stock());
        product.setMin_stock_level(productDetails.getMin_stock_level());
        product.setPart(productDetails.isPart());
        product.setExternal_note(productDetails.getExternal_note());
        product.setInternal_note(productDetails.getInternal_note());

        log.info("Updated product: " + product);

        return productRepository.save(product);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        log.info("Product deleted: " + product);
        productRepository.delete(product);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        log.info("Search products by keyword: " + keyword);

        List<Product> products = productRepository.searchByKeyword(keyword);

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }
}
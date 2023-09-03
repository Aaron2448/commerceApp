package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Model.Product;
import com.fdmgroup.flexdronepodq42022.Repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository repository;

    private Product product1;
    private Product product2;

    @Before
    public void setup() {
        product1 = new Product();
        product1.setProduct_id(1L);
        product1.setName("product1");

        product2 = new Product();
        product2.setProduct_id(2L);
        product2.setName("product2");
    }

    @Test
    public void testGetAllProducts() {
        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> result = productController.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("product1", result.get(0).getName());
        assertEquals("product2", result.get(1).getName());
    }

    @Test
    public void testCreateProduct() {
        when(repository.save(product1)).thenReturn(product1);

        Product result = productController.createProduct(product1);

        assertEquals("product1", result.getName());
    }

    @Test
    public void testGetProduct() {
        when(repository.findById(1L)).thenReturn(Optional.of(product1));

        Product result = productController.getProduct(1L);

        assertEquals("product1", result.getName());
    }

    @Test
    public void testUpdateProduct() {
        when(repository.findById(1L)).thenReturn(Optional.of(product1));
        when(repository.save(product1)).thenReturn(product1);

        Product result = productController.updateProduct(1L, product1);

        assertEquals("product1", result.getName());
    }

    @Test
    public void testDeleteProduct() {
        when(repository.findById(1L)).thenReturn(Optional.of(product1));

        ResponseEntity<?> result = productController.deleteProduct(1L);

        assertEquals(200, result.getStatusCodeValue());
    }
}
package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {
    @Mock
    private ProductRepository productRepository;


    @Test
    public void testFindAllProducts() {
        Product drone = new Product(0, "sku123", "A quadcopter drone with HD camera", 199.99f, "Drones", "Quadcopter Drone", 100, 50, 10, false, null, null, null, 1, 0);
        Product car = new Product(0, "sku456", "A remote controlled car with realistic engine sounds", 39.99f, "Toys", "RC Car", 50, 30, 5, false, null, null, null, 1, 0);

        List<Product> productList = Arrays.asList(drone, car);
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> returnedProducts = productRepository.findAll();
        assertEquals(2, returnedProducts.size());
    }

    @Test
    public void testFindProductBySku() {
        Product drone = new Product(0, "sku123", "A quadcopter drone with HD camera", 199.99f, "Drones", "Quadcopter Drone", 100, 50, 10, false, null, null, null, 1, 0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(drone));

        Optional<Product> returnedProduct = productRepository.findById(1L);
        assertEquals("Quadcopter Drone", returnedProduct.get().getName());
    }

    @Test
    public void testSaveProduct() {
        Product drone = new Product(0, "sku123", "A quadcopter drone with HD camera", 199.99f, "Drones", "Quadcopter Drone", 100, 50, 10, false, null, null, null, 1, 0);
        when(productRepository.save(drone)).thenReturn(drone);

        Product savedProduct = productRepository.save(drone);
        assertEquals("sku123", savedProduct.getSku());
    }

    @Test
    public void deleteProduct_success() {
        Product product = new Product(0, "SKU001", "Drone with camera", 1000.00f, "Drones", "Camera Drone", 50L, 10L, 5L, false, "External note", "Internal note", null, 1, 0);
        product.setProduct_id(1L);

        productRepository.deleteById(1L);

        assertEquals(productRepository.count(), 0);
    }


    @Test
    public void deleteProduct_productNotFound() {
        doThrow(new EmptyResultDataAccessException(1)).when(productRepository).deleteById(1L);

        assertThrows(EmptyResultDataAccessException.class, () -> {
            productRepository.deleteById(1L);
        });
    }
}

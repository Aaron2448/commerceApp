package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Model.ProductSupplier;
import com.fdmgroup.flexdronepodq42022.Repository.ProductSupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductSupplierControllerTest {

    @Mock
    private ProductSupplierRepository productSupplierRepository;

    @InjectMocks
    private ProductSupplierController productSupplierController;

    @Test
    public void testGetAllProductSuppliers() {
        when(productSupplierRepository.findAll()).thenReturn(List.of(new ProductSupplier()));

        List<ProductSupplier> productSuppliers = productSupplierController.getAllProductSuppliers();
        assertEquals(1, productSuppliers.size());
    }

    @Test
    public void testCreateProductSupplier() {
        ProductSupplier productSupplier = new ProductSupplier();
        when(productSupplierRepository.save(productSupplier)).thenReturn(productSupplier);

        ProductSupplier createdProductSupplier = productSupplierController.createProductSupplier(productSupplier);
        assertNotNull(createdProductSupplier);
    }

    @Test
    public void testGetProductSupplierById() {
        Long id = 1L;
        ProductSupplier productSupplier = new ProductSupplier();

        when(productSupplierRepository.findById(id)).thenReturn(Optional.of(productSupplier));

        Optional<ProductSupplier> retrievedProductSupplier = productSupplierController.getProductSupplierById(id);
        assertTrue(retrievedProductSupplier.isPresent());
    }

    @Test
    public void testUpdateProductSupplier() {
        Long id = 1L;
        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setLead_time(7L);
        productSupplier.setCost_price(10.99F);

        when(productSupplierRepository.save(any(ProductSupplier.class))).thenReturn(productSupplier);

        ProductSupplier updatedProductSupplier = productSupplierController.updateProductSupplier(id, productSupplier);
        assertNotNull(updatedProductSupplier);
        assertEquals(productSupplier.getLead_time(), updatedProductSupplier.getLead_time());
        assertEquals(productSupplier.getCost_price(), updatedProductSupplier.getCost_price(), 0.001);
    }

    @Test
    public void testDeleteProductSupplier() {
        Long id = 1L;

        productSupplierController.deleteProductSupplier(id);
        verify(productSupplierRepository, times(1)).deleteById(id);
    }
}
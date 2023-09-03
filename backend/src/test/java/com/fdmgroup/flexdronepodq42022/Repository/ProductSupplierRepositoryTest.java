package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Product;
import com.fdmgroup.flexdronepodq42022.Model.ProductSupplier;
import com.fdmgroup.flexdronepodq42022.Model.Supplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductSupplierRepositoryTest {

    @Mock
    private ProductSupplierRepository productSupplierRepository;

    @Test
    public void whenFindById_thenReturnProductSupplier() {
        ProductSupplier testProductSupplier = new ProductSupplier();
        testProductSupplier.setProduct_supplier_id(1L);

        when(productSupplierRepository.findById(any(Long.class))).thenReturn(Optional.of(testProductSupplier));

        ProductSupplier foundProductSupplier = productSupplierRepository.findById(1L).orElse(null);

        assertNotNull(foundProductSupplier);
        assertEquals(foundProductSupplier.getProduct_supplier_id(), testProductSupplier.getProduct_supplier_id());
    }

    @Test
    public void whenFindAllByProductId_thenReturnListOfProductSuppliers() {
        Product testProduct = new Product();
        testProduct.setProduct_id(1L);

        ProductSupplier testProductSupplier = new ProductSupplier(testProduct, new Supplier(), 5L, 100F);

        when(productSupplierRepository.findById(any(Long.class))).thenReturn(Optional.of(testProductSupplier));

        Optional<ProductSupplier> foundProductSupplierOptional = productSupplierRepository.findById(1L);

        assertTrue(foundProductSupplierOptional.isPresent());

        ProductSupplier foundProductSupplier = foundProductSupplierOptional.get();
        assertEquals(foundProductSupplier.getProduct(), testProductSupplier.getProduct());
        assertEquals(foundProductSupplier.getSupplier(), testProductSupplier.getSupplier());
        assertEquals(foundProductSupplier.getLead_time(), testProductSupplier.getLead_time());
        assertEquals(foundProductSupplier.getCost_price(), testProductSupplier.getCost_price());
    }

    @Test
    public void whenSaveProductSupplier_thenProductSupplierIsPersisted() {
        Product testProduct = new Product();
        testProduct.setProduct_id(1L);

        ProductSupplier testProductSupplier = new ProductSupplier(testProduct, new Supplier(), 5L, 100F);

        when(productSupplierRepository.save(any(ProductSupplier.class))).thenReturn(testProductSupplier);

        ProductSupplier savedProductSupplier = productSupplierRepository.save(testProductSupplier);

        assertNotNull(savedProductSupplier);
        assertEquals(savedProductSupplier, testProductSupplier);
    }

    @Test
    public void whenDeleteById_thenProductSupplierIsDeleted() {
        doNothing().when(productSupplierRepository).deleteById(any(Long.class));

        productSupplierRepository.deleteById(1L);

        verify(productSupplierRepository, times(1)).deleteById(1L);
    }
}

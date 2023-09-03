package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Model.Supplier;
import com.fdmgroup.flexdronepodq42022.Repository.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplierControllerTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierController supplierController;

    @Test
    public void testGetAllSuppliers() {
        when(supplierRepository.findAll()).thenReturn(List.of(new Supplier()));

        List<Supplier> suppliers = supplierController.getAllSuppliers();
        assertEquals(1, suppliers.size());
    }

    @Test
    public void testCreateSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        Supplier createdSupplier = supplierController.createSupplier(supplier);
        assertNotNull(createdSupplier);
    }

    @Test
    public void testUpdateSupplier() {
        Long id = 1L;
        Supplier supplier = new Supplier();
        supplier.setName("Acme");
        supplier.setLocation("USA");
        supplier.setEmail("acme@example.com");
        supplier.setPhone("1234567890");

        when(supplierRepository.findById(id)).thenReturn(Optional.of(new Supplier()));
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);

        Supplier updatedSupplier = supplierController.updateSupplier(id, supplier);
        assertNotNull(updatedSupplier);
        assertEquals(supplier.getName(), updatedSupplier.getName());
        assertEquals(supplier.getLocation(), updatedSupplier.getLocation());
        assertEquals(supplier.getEmail(), updatedSupplier.getEmail());
        assertEquals(supplier.getPhone(), updatedSupplier.getPhone());
    }

    @Test
    public void testDeleteSupplier() {
        Long id = 1L;

        supplierController.deleteSupplier(id);
        verify(supplierRepository, times(1)).deleteById(id);
    }
}
package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SupplierRepositoryTest {
    @Mock
    private SupplierRepository supplierRepository;

    private Supplier testSupplier;
    private final List<Supplier> testSuppliers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        testSupplier = new Supplier("Test Supplier", "Test Location", "testsupplier@test.com", "0123456789");
        testSupplier.setSupplier_id(1L);
        testSuppliers.add(testSupplier);
    }

    @Test
    public void whenFindById_thenReturnSupplier() {
        when(supplierRepository.findById(anyLong())).thenReturn(Optional.of(testSupplier));

        Optional<Supplier> foundSupplier = supplierRepository.findById(1L);

        assertTrue(foundSupplier.isPresent());
        assertEquals(foundSupplier.get().getName(), testSupplier.getName());
        assertEquals(foundSupplier.get().getLocation(), testSupplier.getLocation());
        assertEquals(foundSupplier.get().getEmail(), testSupplier.getEmail());
        assertEquals(foundSupplier.get().getPhone(), testSupplier.getPhone());
    }

    @Test
    public void whenFindAll_thenReturnListOfSuppliers() {
        when(supplierRepository.findAll()).thenReturn(testSuppliers);

        List<Supplier> foundSuppliers = supplierRepository.findAll();

        assertNotNull(foundSuppliers);
        assertEquals(foundSuppliers.size(), 1);
        assertEquals(foundSuppliers.get(0).getName(), testSupplier.getName());
        assertEquals(foundSuppliers.get(0).getLocation(), testSupplier.getLocation());
        assertEquals(foundSuppliers.get(0).getEmail(), testSupplier.getEmail());
        assertEquals(foundSuppliers.get(0).getPhone(), testSupplier.getPhone());
    }

    @Test
    public void whenSaveSupplier_thenSupplierShouldBeSaved() {
        when(supplierRepository.save(any(Supplier.class))).thenReturn(testSupplier);

        Supplier savedSupplier = supplierRepository.save(testSupplier);

        assertNotNull(savedSupplier);
        assertEquals(savedSupplier.getName(), testSupplier.getName());
        assertEquals(savedSupplier.getLocation(), testSupplier.getLocation());
        assertEquals(savedSupplier.getEmail(), testSupplier.getEmail());
        assertEquals(savedSupplier.getPhone(), testSupplier.getPhone());
    }

    @Test
    public void whenDeleteSupplier_thenSupplierShouldBeDeleted() {
        supplierRepository.deleteById(1L);

        when(supplierRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Optional<Supplier> deletedSupplier = supplierRepository.findById(1L);

        assertEquals(deletedSupplier, Optional.empty());
    }
}

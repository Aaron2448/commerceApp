package com.fdmgroup.flexdronepodq42022.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class SupplierTest {
    private final long supplierId = 1L;
    private final String name = "Supplier name";
    private final String location = "Supplier location";
    private final String email = "Supplier email";
    private final String phone = "Supplier phone";
    private Supplier supplier;
    private List<ProductSupplier> products;

    @Before
    public void setUp() {
        products = new ArrayList<>();
        supplier = new Supplier(supplierId, name, location, email, phone, false, products);
    }

    @Test
    public void testGetId() {
        assertEquals(supplierId, supplier.getSupplier_id());
    }

    @Test
    public void testSetId() {
        supplier.setSupplier_id(2L);

        assertEquals(2L, supplier.getSupplier_id());
    }

    @Test
    public void testGetName() {
        assertEquals(name, supplier.getName());
    }

    @Test
    public void testSetName() {
        supplier.setName("New supplier name");

        assertEquals("New supplier name", supplier.getName());
    }

    @Test
    public void testGetLocation() {
        assertEquals(location, supplier.getLocation());
    }

    @Test
    public void testSetLocation() {
        supplier.setLocation("New supplier location");

        assertEquals("New supplier location", supplier.getLocation());
    }

    @Test
    public void testGetEmail() {
        assertEquals(email, supplier.getEmail());
    }

    @Test
    public void testSetEmail() {
        supplier.setEmail("New supplier email");

        assertEquals("New supplier email", supplier.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals(phone, supplier.getPhone());
    }

    @Test
    public void testSetPhone() {
        supplier.setPhone("New supplier phone");

        assertEquals("New supplier phone", supplier.getPhone());
    }

    @Test
    public void testGetProducts() {
        assertEquals(products, supplier.getProducts());
    }

    @Test
    public void testSetProducts() {
        List<ProductSupplier> newProducts = new ArrayList<>();
        supplier.setProducts(newProducts);

        assertEquals(newProducts, supplier.getProducts());
    }

    @Test
    public void testEqualsSameObject() {
        assertEquals(supplier, supplier);
    }

    @Test
    public void testEqualsDifferentClass() {
        Object object = new Object();

        assertFalse(supplier.equals(object));
    }

    @Test
    public void testEqualsDifferentId() {
        Supplier otherSupplier = new Supplier(2L, name, location, email, phone, false, products);

        assertFalse(supplier.equals(otherSupplier));
    }

    @Test
    public void testHashCode() {
        assertEquals(supplier.hashCode(), supplier.hashCode());
    }
}

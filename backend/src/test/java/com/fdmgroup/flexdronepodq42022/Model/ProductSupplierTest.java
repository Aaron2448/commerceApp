package com.fdmgroup.flexdronepodq42022.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class ProductSupplierTest {

    private final Long id = 1L;
    private final Product product = new Product();
    private final Supplier supplier = new Supplier();
    private final Long leadTime = 2L;
    private final Float costPrice = 1.23f;
    private ProductSupplier productSupplier;

    @Before
    public void setUp() {
        productSupplier = new ProductSupplier(id, product, supplier, leadTime, costPrice, id);
    }

    @Test
    public void testGetId() {
        assertEquals(id, productSupplier.getProduct_supplier_id());
    }

    @Test
    public void testSetId() {
        productSupplier.setProduct_supplier_id(2L);

        assertEquals(Optional.of(2L), Optional.ofNullable(productSupplier.getProduct_supplier_id()));
    }

    @Test
    public void testGetProduct() {
        assertEquals(product, productSupplier.getProduct());
    }

    @Test
    public void testSetProduct() {
        Product newProduct = new Product();
        productSupplier.setProduct(newProduct);

        assertEquals(newProduct, productSupplier.getProduct());
    }

    @Test
    public void testGetSupplier() {
        assertEquals(supplier, productSupplier.getSupplier());
    }

    @Test
    public void testSetSupplier() {
        Supplier newSupplier = new Supplier();
        productSupplier.setSupplier(newSupplier);

        assertEquals(newSupplier, productSupplier.getSupplier());
    }

    @Test
    public void testGetLeadTime() {
        assertEquals(leadTime, productSupplier.getLead_time());
    }

    @Test
    public void testSetLeadTime() {
        productSupplier.setLead_time(3L);

        assertEquals(Optional.of(3L), Optional.ofNullable(productSupplier.getLead_time()));
    }

    @Test
    public void testGetCostPrice() {
        assertEquals(costPrice, productSupplier.getCost_price(), 0.01f);
    }

    @Test
    public void testSetCostPrice() {
        productSupplier.setCost_price(4.56f);

        assertEquals(4.56f, productSupplier.getCost_price(), 0.01f);
    }

    @Test
    public void testEqualsSameObject() {
        assertEquals(productSupplier, productSupplier);
    }

    @Test
    public void testEqualsDifferentClass() {
        Object object = new Object();

        assertFalse(productSupplier.equals(object));
    }

    @Test
    public void testEqualsDifferentId() {
        ProductSupplier otherProductSupplier = new ProductSupplier(2L, product, supplier, leadTime, costPrice, id);

        assertFalse(productSupplier.equals(otherProductSupplier));
    }

    @Test
    public void testEqualsSameId() {
        ProductSupplier otherProductSupplier = new ProductSupplier(id, product, supplier, leadTime, costPrice, id);

        assertTrue(productSupplier.equals(otherProductSupplier));
    }

    @Test
    public void testHashCode() {
        assertEquals(productSupplier.hashCode(), productSupplier.hashCode());
    }

}

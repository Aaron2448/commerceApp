package com.fdmgroup.flexdronepodq42022.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProductTest {
    private final long id = 1L;
    private final String sku = "SKU123";
    private final String description = "Product description";
    private final float retailPrice = 9.99f;
    private final String category = "Electronics";
    private final String name = "Product name";
    private final long externalStock = 50L;
    private final long internalStock = 10L;
    private final long minStockLevel = 5L;
    private final boolean isPart = false;
    private final String externalNote = "External note";
    private final String internalNote = "Internal note";
    private final String imageUrl = "dronesAreUs.com.au/orangeDrone.jpg";
    private final int quantityInCart = 1;
    private Product product;

    @Before
    public void setUp() {
        product = new Product(id, sku, description, retailPrice, category, name, externalStock, internalStock, minStockLevel, isPart, externalNote, internalNote, imageUrl, quantityInCart, externalStock);
    }

    @Test
    public void testGetId() {
        assertEquals(id, product.getProduct_id());
    }

    @Test
    public void testSetId() {
        product.setProduct_id(2L);

        assertEquals(2L, product.getProduct_id());
    }

    @Test
    public void testGetSku() {
        assertEquals(sku, product.getSku());
    }

    @Test
    public void testSetSku() {
        product.setSku("SKU456");

        assertEquals("SKU456", product.getSku());
    }

    @Test
    public void testGetDescription() {
        assertEquals(description, product.getDescription());
    }

    @Test
    public void testSetDescription() {
        product.setDescription("New product description");

        assertEquals("New product description", product.getDescription());
    }

    @Test
    public void testGetRetailPrice() {
        assertEquals(retailPrice, product.getRetail_price(), 0.01f);
    }

    @Test
    public void testSetRetailPrice() {
        product.setRetail_price(12.34f);

        assertEquals(12.34f, product.getRetail_price(), 0.01f);
    }

    @Test
    public void testGetCategory() {
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testSetCategory() {
        product.setCategory("Toys");

        assertEquals("Toys", product.getCategory());
    }

    @Test
    public void testGetName() {
        assertEquals(name, product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("New product name");

        assertEquals("New product name", product.getName());
    }

    @Test
    public void testGetExternalStock() {
        assertEquals(externalStock, product.getExternal_stock());
    }

    @Test
    public void testSetExternalStock() {
        product.setExternal_stock(100L);

        assertEquals(100L, product.getExternal_stock());
    }

    @Test
    public void testGetInternalStock() {
        assertEquals(internalStock, product.getInternal_stock());
    }

    @Test
    public void testSetInternalStock() {
        product.setInternal_stock(20L);

        assertEquals(20L, product.getInternal_stock());
    }

    @Test
    public void testGetMinStockLevel() {
        assertEquals(minStockLevel, product.getMin_stock_level());
    }

    @Test
    public void testSetMinStockLevel() {
        product.setMin_stock_level(2L);

        assertEquals(2L, product.getMin_stock_level());
    }

    @Test
    public void testIsPart() {
        assertEquals(isPart, product.isPart());
    }

    @Test
    public void testSetIsPart() {
        product.setPart(true);

        assertTrue(product.isPart());
    }

    @Test
    public void testGetExternalNote() {
        assertEquals(externalNote, product.getExternal_note());
    }

    @Test
    public void testSetExternalNote() {
        product.setExternal_note("New external note");

        assertEquals("New external note", product.getExternal_note());
    }

    @Test
    public void testGetInternalNote() {
        assertEquals(internalNote, product.getInternal_note());
    }

    @Test
    public void testSetInternalNote() {
        product.setInternal_note("New internal note");

        assertEquals("New internal note", product.getInternal_note());
    }

    @Test
    public void testGetImageUrl() {
        assertEquals(imageUrl, product.getImage_url());
    }

    @Test
    public void testSetImageUrl() {
        product.setImage_url("newImageUrl.jpg");

        assertEquals("newImageUrl.jpg", product.getImage_url());
    }

    @Test
    public void testGetQuantityInCart() {
        assertEquals(quantityInCart, product.getQuantity_in_cart());
    }

    @Test
    public void testSetQuantityInCart() {
        product.setQuantity_in_cart(2);

        assertEquals(2, product.getQuantity_in_cart());
    }

}

//package com.fdmgroup.flexdronepodq42022.Model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.Assert.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductOrderObjTest {
//    private ProductOrderObj productOrderObj;
//
//    @Mock
//    private ProductOrderObj mockProductOrderObj;
//
//    @BeforeEach
//    void setUp() {
//        productOrderObj = new ProductOrderObj(1, 1, "sku123", 19.99f, 2, 0);
//    }
//
//    @Test
//    void testAllArgsConstructor() {
//        assertEquals(1, productOrderObj.getProduct_order_id());
//        assertEquals("sku123", productOrderObj.getSku());
//        assertEquals(19.99f, productOrderObj.getSold_price(), 0.01f);
//        assertEquals(2, productOrderObj.getQuantity());
//    }
//
//    @Test
//    void testEntryIdSetter() {
//        productOrderObj.setProduct_order_id(2);
//        assertEquals(2, productOrderObj.getProduct_order_id());
//    }
//
//    @Test
//    void testOrderIdSetter() {
//        productOrderObj.setOrder_id(3);
//        assertEquals(3, productOrderObj.getOrder_id());
//    }
//
//    @Test
//    void testSkuSetter() {
//        productOrderObj.setSku("sku456");
//        assertEquals("sku456", productOrderObj.getSku());
//    }
//
//    @Test
//    void testSoldPriceSetter() {
//        productOrderObj.setSold_price(29.99f);
//        assertEquals(29.99f, productOrderObj.getSold_price(), 0.01f);
//    }
//
//    @Test
//    void testQuantitySetter() {
//        productOrderObj.setQuantity(3);
//        assertEquals(3, productOrderObj.getQuantity());
//    }
//
//    @Test
//    void testEquals() {
//        ProductOrderObj sameObj = new ProductOrderObj(1, 1, "sku123", 19.99f, 2, 0);
//        ProductOrderObj differentObj = new ProductOrderObj(2, 2, "sku456", 29.99f, 3, 0);
//        assertEquals(productOrderObj, productOrderObj);
//        assertNotEquals(productOrderObj, differentObj);
//    }
//
//    @Test
//    void testHashCode() {
//        ProductOrderObj sameObj = new ProductOrderObj(1, 1, "sku123", 19.99f, 2, 0);
//        ProductOrderObj differentObj = new ProductOrderObj(2, 2, "sku456", 29.99f, 3, 0);
//        assertEquals(productOrderObj.hashCode(), productOrderObj.hashCode());
//        assertNotEquals(differentObj.hashCode(), productOrderObj.hashCode());
//    }
//}

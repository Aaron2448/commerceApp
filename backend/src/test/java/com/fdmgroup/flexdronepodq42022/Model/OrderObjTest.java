//package com.fdmgroup.flexdronepodq42022.Model;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@ExtendWith(MockitoExtension.class)
//public class OrderObjTest {
//    @Test
//    public void testNoArgsConstructor() {
//        OrderObj emptyOrder = new OrderObj();
//
//        assertNotNull(emptyOrder);
//        assertEquals(0, emptyOrder.getOrder_id());
//        assertEquals(0, emptyOrder.getCustomer_id());
//        assertEquals("customer_placed", emptyOrder.getStatus());
//        assertEquals(null, emptyOrder.getAddress());
//        assertEquals(null, emptyOrder.getOrder_at());
//        assertEquals(null, emptyOrder.getEmail());
//        assertEquals(null, emptyOrder.getPayment_method());
//    }
//
//    @Test
//    public void testAllArgsConstructor() {
//        
//    	DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");    
//        LocalDateTime now = LocalDateTime.now();
//        String now2 = dtformatter.format(now);
//    	
//    	
//    	
//    	OrderObj order = new OrderObj(1, 2, "customer_placed", "123 Main St", now2, "test@example.com", "credit", null);
//
//        
//        assertNotNull(order);
//        assertEquals(1, order.getOrder_id());
//        assertEquals(2, order.getCustomer_id());
//        assertEquals("customer_placed", order.getStatus());
//        assertEquals("123 Main St", order.getAddress());
//        assertEquals(now, order.getOrder_at());
//        assertEquals("test@example.com", order.getEmail());
//        assertEquals("credit", order.getPayment_method());
//    }
//
//    @Test
//    public void testSettersAndGetters() {
//        
//    	DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");    
//        LocalDateTime now = LocalDateTime.now();
//        String now2 = dtformatter.format(now);
//    	OrderObj order = new OrderObj();
//
//        order.setOrder_id(1);
//        order.setCustomer_id(2);
//        order.setStatus("in_progress");
//        order.setAddress("123 Main St");
//        order.setOrder_at(now2);
//        order.setEmail("test@example.com");
//        order.setPayment_method("credit");
//
//        assertEquals(1, order.getOrder_id());
//        assertEquals(2, order.getCustomer_id());
//        assertEquals("in_progress", order.getStatus());
//        assertEquals("123 Main St", order.getAddress());
//        assertEquals(now, order.getOrder_at());
//        assertEquals("test@example.com", order.getEmail());
//        assertEquals("credit", order.getPayment_method());
//    }
//}

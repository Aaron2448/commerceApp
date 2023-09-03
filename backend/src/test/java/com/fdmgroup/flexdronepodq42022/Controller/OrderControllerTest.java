//package com.fdmgroup.flexdronepodq42022.Controller;
//
//import com.fdmgroup.flexdronepodq42022.Model.OrderObj;
//import com.fdmgroup.flexdronepodq42022.Model.Product;
//import com.fdmgroup.flexdronepodq42022.Model.ProductOrderObj;
//import com.fdmgroup.flexdronepodq42022.Repository.OrderRepository;
//import com.fdmgroup.flexdronepodq42022.Repository.ProductOrderRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//public class OrderControllerTest {
//
//    @Mock
//    private OrderRepository orderRepo;
//
//    @Mock
//    private ProductOrderRepository prodOrderRepo;
//
//    @InjectMocks
//    private OrderController orderController;
//
//    private OrderObj order;
//    private List<Product> productList;
//
//    @BeforeEach
//    void setUp() {
//        order = new OrderObj();
//        productList = new ArrayList<>();
//
//        Product product1 = new Product();
//        product1.setSku("ABC123");
//        product1.setRetailPrice(Float.valueOf(10));
//        product1.setQuantityInCart(2);
//        productList.add(product1);
//
//        Product product2 = new Product();
//        product2.setSku("XYZ456");
//        product2.setRetailPrice(Float.valueOf(20));
//        product2.setQuantityInCart(1);
//        productList.add(product2);
//    }
//
//
//    @Test
//    void testFindAllFromEmail() {
//        String email = "test@example.com";
//        List<OrderObj> orders = new ArrayList<OrderObj>();
//        when(orderRepo.findAllByEmail(email)).thenReturn(orders);
//        assertEquals(orders, orderController.findAllFromEmail(email));
//    }
//
//    @Test
//    void testFindAll() {
//        List<OrderObj> orders = new ArrayList<OrderObj>();
//        when(orderRepo.findAll()).thenReturn(orders);
//        assertEquals(orders, orderController.findAll());
//    }
//
//
//    @Test
//    void testCreateOrderObject() {
//        when(orderRepo.save(any(OrderObj.class))).thenReturn(order);
//        when(orderRepo.getOrderId(isNull(), anyString())).thenReturn(1);
//        when(prodOrderRepo.save(any(ProductOrderObj.class))).thenReturn(new ProductOrderObj());
//
//        String result = orderController.createOrderObject(order, productList);
//
//        verify(orderRepo).save(any(OrderObj.class));
//        verify(orderRepo).getOrderId(isNull(), anyString());
//        verify(prodOrderRepo, times(2)).save(any(ProductOrderObj.class));
//        assertEquals("orders table updated , created one row in product_orders table , created one row in product_orders table", result);
//    }
//}

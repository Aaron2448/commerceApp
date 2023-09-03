package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.DTO.OrderRequestDTO;
import com.fdmgroup.flexdronepodq42022.DTO.ProductDTO;
import com.fdmgroup.flexdronepodq42022.Model.OrderObj;
import com.fdmgroup.flexdronepodq42022.Model.Product;
import com.fdmgroup.flexdronepodq42022.Model.ProductOrderObj;
import com.fdmgroup.flexdronepodq42022.Model.User;
import com.fdmgroup.flexdronepodq42022.Repository.OrderRepository;
import com.fdmgroup.flexdronepodq42022.Repository.ProductOrderRepository;
import com.fdmgroup.flexdronepodq42022.Repository.ProductRepository;
import com.fdmgroup.flexdronepodq42022.Repository.UserRepository;
import com.fdmgroup.flexdronepodq42022.Service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderRepository orderRepo;
    private final ProductOrderRepository prodOrderRepo;
    private final ProductRepository productRepository;
    private final EmailService emailService;
    

    public OrderController(OrderRepository orderRepo, ProductOrderRepository prodOrderRepo, ProductRepository productRepository, EmailService emailService) {

        this.orderRepo = orderRepo;
        this.prodOrderRepo = prodOrderRepo;
        this.productRepository = productRepository;
        this.emailService = emailService;
        
    }

    // R E A D orders from specific user
    @GetMapping("/myOrder")
    public ResponseEntity<List<OrderObj>> findAllFromEmail(@AuthenticationPrincipal User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();


        log.info("Finding all orders for user with email: " + currentUserName);
        List<OrderObj> orders = orderRepo.findAllByEmail(currentUserName);

        log.info("Found orders: " + orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/myOrder/id/{orderId}")
    public ResponseEntity<List<ProductOrderObj>> getAllProductsForOrder(@PathVariable Long orderId) {
        List<ProductOrderObj> products = prodOrderRepo.findAllProductsByOrderId(orderId);
        return ResponseEntity.ok(products);

    }

    // R E A D all orders
    @GetMapping("/getAll")
    public List<OrderObj> findAllOrders_CONT() {

        try {

            log.info("Get all orders: " + orderRepo.findAll());
            return orderRepo.findAll();

        } catch (Exception e) {
            return null;
        }

    }

    // C R E A T E order
    /* Below "createOrder" function.
     * takes an order obj and a list of products. Using the order id that will be automatically generated
     * , it starts populating the productorder table in the database with one or many rows, each row
     * being a single product of the order.
     */
    @PostMapping("/createOrder")
    public String createOrderObject(@RequestBody OrderRequestDTO orderRequestDTO) {

        System.out.println("This is the email given: " + orderRequestDTO.getEmail());
        OrderObj orderObj = new OrderObj();
        orderObj.setCustomer_id(orderRequestDTO.getCustomer_id());
        orderObj.setAddress(orderRequestDTO.getAddress());
        orderObj.setEmail(orderRequestDTO.getEmail());
        orderObj.setPayment_method(orderRequestDTO.getPayment_method());
        orderObj.setName(orderRequestDTO.getName());
        System.out.println("This is the address given: " + orderObj.getAddress());
        System.out.println("This is the order given: " + orderObj);


        List<Product> productList = new ArrayList<>();
        for (ProductDTO productDTO : orderRequestDTO.getProduct()) {
            Product product = productRepository.findBySku(productDTO.getSku());
            if (product != null) {
                product.setQuantity_in_cart(productDTO.getQuantity_in_cart());
                productList.add(product);
            }
        }

        String outcome = "order not received";
        String globalDateTimeVariable = null;

        try {

            DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dateTimeDBformat = dtformatter.format(now);
            globalDateTimeVariable = dateTimeDBformat;
            orderObj.setOrder_at(dateTimeDBformat);
            orderObj.setOrder_id(0);
            orderRepo.save(orderObj);
            log.info("Created order in orders table: " + orderObj);
            outcome = "orders table updated";

        } catch (Exception e) {

            outcome = "orders table not updated";

        }

        Long orderIdGenerated = orderRepo.getOrderId(globalDateTimeVariable);

// orderObj.getEmail(),

        String text = "Thank you for your order!\n\n";
        text += "Order ID: " + orderIdGenerated + "\n";
        text += "Order Date: " + orderObj.getOrder_at() + "\n";
        text += "Shipping Address: " + orderObj.getAddress() + "\n\n";
        text += "Products:\n";

        for (Product product : productList) {

            text += "- " + product.getName() + " (SKU: " + product.getSku() + ")\n";
            text += "  Quantity: " + product.getQuantity_in_cart() + "\n";
            text += "  Price: $" + product.getRetail_price() + "\n\n";

        }

        for (Product product : productList) {
            ProductOrderObj prodOrder = new ProductOrderObj();
            prodOrder.setSku(product.getSku());
            prodOrder.setOrder_id(orderIdGenerated);
            prodOrder.setSold_price(product.getRetail_price());
            prodOrder.setQuantity(product.getQuantity_in_cart());
            prodOrder.setProduct_id(product.getProduct_id());

            try {

                prodOrderRepo.save(prodOrder);
                log.info("Created order in product_orders table: " + prodOrder);

                /**
                 * User email part
                 */
                String to = orderRequestDTO.getEmail();
                log.info("Sending email to user: " + to);
                String subject = "Flex Drone Order";
                emailService.sendSimpleMessage(to, subject, text);
                log.info("email send successfully");
                /**
                 * End User email part
                 */

                outcome += " , created row or rows in product_orders table";

            } catch (Exception e) {

                log.info("Error: did not create order in product_orders table: " + prodOrder);
                outcome += " , error did not create row or rows in product_orders table";

            }

        }

        return outcome;

    }


}

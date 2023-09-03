package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.ProductOrderObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderObj, Long> {
    @Query(nativeQuery = true, value = "SELECT product_order_id, order_id,product_id, quantity, sku, sold_price FROM product_order WHERE order_id = ?1")
    List<ProductOrderObj> findAllProductsByOrderId(Long orderId);
}

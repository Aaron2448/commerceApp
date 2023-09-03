package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.OrderObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderObj, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM `customer_order` WHERE email = ?1")
    List<OrderObj> findAllByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT order_id FROM `customer_order` WHERE order_at = ?1")
    Long getOrderId(String dateTimeDBformat);

    @Query(nativeQuery = true, value = "SELECT * FROM `customer_order` WHERE customer_id = ?1")
    List<OrderObj> findAllByCustId(Long cust_id);

}



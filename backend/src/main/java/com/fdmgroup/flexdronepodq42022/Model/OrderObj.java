package com.fdmgroup.flexdronepodq42022.Model;

import java.time.LocalDateTime;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer_order")
public class OrderObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;
    @Column
    private long customer_id;
    @Column(nullable = false)
    private String status = "placed";
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String order_at;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String payment_method = "card";
    @Column
    private String dispatched_on;
    @Column
    private String name;

    public OrderObj(long order_id, long customer_id, String status, String address, String order_at, String email,
                    String payment_method, String dispatched_on) {
        super();
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.status = status;
        this.address = address;
        this.order_at = order_at;
        this.email = email;
        this.payment_method = payment_method;
        this.dispatched_on = dispatched_on;
    }

    @Override
    public String toString() {
        return "OrderObj [order_id=" + order_id + ", customer_id=" + customer_id + ", status=" + status + ", address="
                + address + ", order_at=" + order_at + ", email=" + email + ", payment_method=" + payment_method
                + ", dispatched_on=" + dispatched_on + "]";
    }


}




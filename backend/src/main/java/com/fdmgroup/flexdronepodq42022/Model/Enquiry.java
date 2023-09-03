package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enquiry_id;
    
    @Column(nullable = false)
    private String email;
 
    @Column(nullable = false)
    private String enquiry_type;

    @Column(nullable = false)
    private String name;
    
    @Column
    private LocalDate create_date;
    
    @Column
    private LocalDate resolve_date;
    
    @Column
    private boolean is_refunded;
    
    @Column
    private boolean is_returned;
    
    @Column
    private String resolution_action;
    
    @Column
    private int allocated_staff_id;
    
    @Column
    private int customer_id;
    
    @Column
    private int order_id;
    
    @Column
    private int resolve_by_id;
    
    @Column
    private String customer_message;
 
    public Enquiry() {
        this.create_date = LocalDate.now();
    }
   
}

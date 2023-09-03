package com.fdmgroup.flexdronepodq42022.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "product_supplier")
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_supplier_id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Supplier supplier;

    private Long lead_time;
    private Float cost_price;
    private Long product_id;

    public ProductSupplier(Product product, Supplier supplier, Long lead_time, Float cost_price) {
        super();
        this.product = product;
        this.supplier = supplier;
        this.lead_time = lead_time;
        this.cost_price = cost_price;
    }

    public ProductSupplier(Supplier supplier, Long lead_time) {
        this.supplier = supplier;
        this.lead_time = lead_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductSupplier that = (ProductSupplier) o;
        return product_supplier_id != null && Objects.equals(product_supplier_id, that.product_supplier_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

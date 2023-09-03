package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category != 'collection'")
    List<Product> findAllPart();

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category = 'collection'")
    List<Product> findAllCollection();

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category = 'base'")
    List<Product> findAllBaseModel();

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category = 'camera'")
    List<Product> findAllCamera();

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category = 'propeller'")
    List<Product> findAllPropeller();

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE category = 'battery'")
    List<Product> findAllBattery();

    Product findBySku(String sku);

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE " +
            "sku LIKE %:keyword% OR " +
            "name LIKE %:keyword% OR " +
            "description LIKE %:keyword% OR " +
            "category LIKE %:keyword%")
    List<Product> searchByKeyword(@Param("keyword") String keyword);

}
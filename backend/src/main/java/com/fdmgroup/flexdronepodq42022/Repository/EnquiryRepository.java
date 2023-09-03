package com.fdmgroup.flexdronepodq42022.Repository;

import com.fdmgroup.flexdronepodq42022.Model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM enquiry")
    List<Enquiry> getAllEnquiries();
    
    @Query(nativeQuery = true, value = "SELECT * FROM enquiry WHERE customer_id = ?1")
    List<Enquiry> getAllEnquiriesByCustomerId(long c_id);

    @Query(nativeQuery = true, value = "SELECT * FROM enquiry WHERE email = ?1")
    List<Enquiry> getAllEnquiriesByEmail(String email);
    
}
package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Exception.ResourceNotFoundException;
import com.fdmgroup.flexdronepodq42022.Model.Enquiry;
import com.fdmgroup.flexdronepodq42022.Repository.EnquiryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/enquiry")
public class EnquiryController {

    private final EnquiryRepository enquiryRepository;

    @Autowired
    public EnquiryController(EnquiryRepository enquiryRepository) {
        
    	this.enquiryRepository = enquiryRepository;
    	
    }
    
    // R E A D of CRUD
    @GetMapping("/getAll")
    public List<Enquiry> getAllEnquiries_CONT() {
        
    	log.info("Getting all enquiries: " + enquiryRepository.getAllEnquiries());
        
    	return enquiryRepository.getAllEnquiries();
        
    }
    
    // R E A D of CRUD
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Enquiry>> getAllEnquiriesByCustomerId_CONT(@PathVariable long id) {
        
    	List<Enquiry> enquiries = enquiryRepository.getAllEnquiriesByCustomerId(id);
        log.info("Getting enquiries by ID: " + enquiries);
        
        return ResponseEntity.ok(enquiries);
        
    }

    // R E A D of CRUD
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Enquiry>> getAllGuestUserEnquiriesByEmail_CONT(@PathVariable String email) {
        
    	List<Enquiry> enquiries = enquiryRepository.getAllEnquiriesByEmail(email);
        log.info("Getting enquiries by ID: " + enquiries);
        
        return ResponseEntity.ok(enquiries);
        
    }
       
    // C R E A T E of CRUD
    @PostMapping("/create")
    public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
        
    	System.out.println(enquiry.toString());
    	
    	log.info("Creating enquiry: " + enquiry);
        enquiryRepository.save(enquiry);
        
        return ResponseEntity.ok(enquiry);
        
    }

    // U P D A T E of CRUD
    @PutMapping("/update/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable long id, @Validated @RequestBody Enquiry enquiry) {
        
    	Enquiry existingEnquiry = enquiryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enquiry not found with id " + id));
        existingEnquiry.setName(enquiry.getName());
        existingEnquiry.setEmail(enquiry.getEmail());
        existingEnquiry.setEnquiry_type(enquiry.getEnquiry_type());
        Enquiry updatedEnquiry = enquiryRepository.save(existingEnquiry);
        log.info("Updated enquiry: " + updatedEnquiry);

        return ResponseEntity.ok(updatedEnquiry);
        
    }

    // D E L E T E of CRUD
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEnquiry(@PathVariable long id) {
        
    	Enquiry enquiry = enquiryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enquiry not found with id " + id));
        log.info("Deleted enquiry: " + enquiry);
        enquiryRepository.delete(enquiry);
        
        return ResponseEntity.ok().build();
        
    }
    
}
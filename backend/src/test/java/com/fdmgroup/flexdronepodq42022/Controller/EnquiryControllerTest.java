//package com.fdmgroup.flexdronepodq42022.Controller;
//
//import com.fdmgroup.flexdronepodq42022.Model.Enquiry;
//import com.fdmgroup.flexdronepodq42022.Repository.EnquiryRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class EnquiryControllerTest {
//
//    @InjectMocks
//    private EnquiryController enquiryController;
//
//    @Mock
//    private EnquiryRepository enquiryRepository;
//
//    @Test
//    public void testGetAllEnquiries() {
//        when(enquiryRepository.findAll()).thenReturn(List.of(new Enquiry()));
//
//        List<Enquiry> enquiries = enquiryController.getAllEnquiries();
//        assertEquals(1, enquiries.size());
//    }
//
//    @Test
//    public void testGetUsersEnquiries() {
//        long id = 1L;
//        Enquiry enquiry1 = new Enquiry();
//        enquiry1.setEnquiry_id(1L);
//        enquiry1.setOrderId(1);
//        enquiry1.setName("John");
//        enquiry1.setEmail("john@example.com");
//        enquiry1.setDescription("Some question");
//
//        Enquiry enquiry2 = new Enquiry();
//        enquiry2.setEnquiry_id(2L);
//        enquiry2.setOrderId(2);
//        enquiry2.setName("Jane");
//        enquiry2.setEmail("jane@example.com");
//        enquiry2.setDescription("Some other question");
//
//        List<Enquiry> enquiries = Arrays.asList(enquiry1, enquiry2);
//
//        when(enquiryRepository.findAllById(id)).thenReturn(enquiries);
//
//        ResponseEntity<List<Enquiry>> response = enquiryController.getUsersEnquiries(id);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(enquiries, response.getBody());
//    }
//
//    @Test
//    public void testCreateEnquiry() {
//        Enquiry enquiry = new Enquiry();
//        when(enquiryRepository.save(enquiry)).thenReturn(enquiry);
//
//        Enquiry createdEnquiry = enquiryController.createEnquiry(enquiry);
//        assertNotNull(createdEnquiry);
//    }
//
//    @Test
//    public void testUpdateEnquiry() {
//        long id = 1L;
//        Enquiry enquiry = new Enquiry();
//        enquiry.setOrderId(1);
//        enquiry.setName("John");
//        enquiry.setEmail("john@example.com");
//        enquiry.setDescription("Test enquiry");
//
//        when(enquiryRepository.findById(id)).thenReturn(Optional.of(new Enquiry()));
//        when(enquiryRepository.save(any(Enquiry.class))).thenReturn(enquiry);
//
//        Enquiry updatedEnquiry = enquiryController.updateEnquiry(id, enquiry);
//        assertNotNull(updatedEnquiry);
//        assertEquals(enquiry.getOrderId(), updatedEnquiry.getOrderId());
//        assertEquals(enquiry.getName(), updatedEnquiry.getName());
//        assertEquals(enquiry.getEmail(), updatedEnquiry.getEmail());
//        assertEquals(enquiry.getDescription(), updatedEnquiry.getDescription());
//    }
//
//    @Test
//    public void testDeleteEnquiry() {
//        long id = 1L;
//        Enquiry enquiry = new Enquiry();
//
//        when(enquiryRepository.findById(id)).thenReturn(Optional.of(enquiry));
//
//        ResponseEntity<?> response = enquiryController.deleteEnquiry(id);
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//}
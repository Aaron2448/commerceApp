//package com.fdmgroup.flexdronepodq42022.Repository;
//
//import com.fdmgroup.flexdronepodq42022.Model.Enquiry;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class EnquiryRepositoryTest {
//
//    @Mock
//    private EnquiryRepository enquiryRepository;
//
//    @BeforeEach
//    public void setUp() {
//        Enquiry enquiry = new Enquiry();
//        enquiry.setName("Test User");
//        enquiry.setEmail("test@test.com");
//        enquiry.setDescription("Test enquiry");
//        enquiry.setEnquiryType("General enquiry");
//        enquiry.setOrderId(1234);
//        when(enquiryRepository.findAllById(1L)).thenReturn(Collections.singletonList(enquiry));
//    }
//
//    @Test
//    public void whenFindAllById_thenReturnListOfEnquiries() {
//        List<Enquiry> foundEnquiries = enquiryRepository.findAllById(1L);
//
//        assertNotNull(foundEnquiries);
//        assertFalse(foundEnquiries.isEmpty());
//        assertEquals(foundEnquiries.size(), 1);
//
//        Enquiry foundEnquiry = foundEnquiries.get(0);
//        assertEquals(foundEnquiry.getName(), "Test User");
//        assertEquals(foundEnquiry.getEmail(), "test@test.com");
//        assertEquals(foundEnquiry.getDescription(), "Test enquiry");
//        assertEquals(foundEnquiry.getEnquiryType(), "General enquiry");
//        assertEquals(foundEnquiry.getOrderId(), 1234);
//    }
//}

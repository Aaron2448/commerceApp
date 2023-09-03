//package com.fdmgroup.flexdronepodq42022.Model;
//
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.junit.Assert.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EnquiryObjTest {
//    private EnquiryObj enquiry;
//    private final long enquiryId = 1L;
//    private final String name = "Enquiry name";
//    private final String email = "Enquiry email";
//    private final String description = "Enquiry description";
//    private final String enquiryType = "General enquiry";
//    private final int orderId = 123;
//
//    @BeforeEach
//    public void setUp() {
//        enquiry = new EnquiryObj(enquiryId, name, email, description, enquiryType, orderId);
//    }
//
//    @Test
//    public void testGetId() {
//        assertEquals(enquiryId, enquiry.getEnquiry_id());
//    }
//
//    @Test
//    public void testSetId() {
//        enquiry.setEnquiry_id(2L);
//
//        assertEquals(2L, enquiry.getEnquiry_id());
//    }
//
//    @Test
//    public void testGetName() {
//        assertEquals(name, enquiry.getName());
//    }
//
//    @Test
//    public void testSetName() {
//        enquiry.setName("New enquiry name");
//
//        assertEquals("New enquiry name", enquiry.getName());
//    }
//
//    @Test
//    public void testGetEmail() {
//        assertEquals(email, enquiry.getEmail());
//    }
//
//    @Test
//    public void testSetEmail() {
//        enquiry.setEmail("New enquiry email");
//
//        assertEquals("New enquiry email", enquiry.getEmail());
//    }
//
//    @Test
//    public void testGetDescription() {
//        assertEquals(description, enquiry.getDescription());
//    }
//
//    @Test
//    public void testSetDescription() {
//        enquiry.setDescription("New enquiry description");
//
//        assertEquals("New enquiry description", enquiry.getDescription());
//    }
//
//    @Test
//    public void testGetEnquiryType() {
//        assertEquals(enquiryType, enquiry.getEnquiryType());
//    }
//
//    @Test
//    public void testSetEnquiryType() {
//        enquiry.setEnquiryType("New enquiry type");
//
//        assertEquals("New enquiry type", enquiry.getEnquiryType());
//    }
//
//    @Test
//    public void testGetOrderId() {
//        assertEquals(orderId, enquiry.getOrderId());
//    }
//
//    @Test
//    public void testSetOrderId() {
//        enquiry.setOrderId(456);
//
//        assertEquals(456, enquiry.getOrderId());
//    }
//
//    @Test
//    public void testEqualsSameObject() {
//        assertEquals(enquiry, enquiry);
//    }
//
//    @Test
//    public void testEqualsDifferentClass() {
//        Object object = new Object();
//
//        assertEquals(false, enquiry.equals(object));
//    }
//
//    @Test
//    public void testEqualsDifferentId() {
//        EnquiryObj otherEnquiry = new EnquiryObj(2L, name, email, description, enquiryType, orderId);
//
//        assertEquals(false, enquiry.equals(otherEnquiry));
//    }
//
//    @Test
//    public void testEqualsSameId() {
//        EnquiryObj otherEnquiry = new EnquiryObj(enquiryId, name, email, description, enquiryType, orderId);
//
//        assertEquals(true, enquiry.equals(otherEnquiry));
//    }
//
//    @Test
//    public void testHashCode() {
//        assertEquals(enquiry.hashCode(), enquiry.hashCode());
//    }
//}

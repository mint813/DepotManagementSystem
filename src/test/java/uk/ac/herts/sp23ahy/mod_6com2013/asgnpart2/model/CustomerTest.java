package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    private Customer customer1;
    private Customer customer2;
    private Parcel parcel;
    
    @BeforeEach
    void setUp() {
        parcel = new Parcel();
        parcel.setParcelID("X123");
        
        customer1 = new Customer("John Smith", parcel);
        customer2 = new Customer("Alice Brown", parcel);
    }
    
    @Test
    void testCustomerComparison() {
        assertTrue(customer2.compareTo(customer1) < 0, 
            "Brown should come before Smith alphabetically");
    }
    
    @Test
    void testCustomerToString() {
        assertEquals("John Smith", customer1.toString(), 
            "toString should return full name");
    }
    
    @Test
    void testCustomerParcelAssociation() {
        assertEquals(parcel, customer1.getParcel(), 
            "Customer should be associated with correct parcel");
    }
} 
package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Customer;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

class WorkerTest {
    private Worker worker;
    private Parcel parcel;
    private Customer customer;
    
    @BeforeEach
    void setUp() {
        worker = new Worker();
        parcel = new Parcel();
        parcel.setParcelID("X123");
        parcel.setDaysInDepot(5);
        parcel.setWeight(10.0);
        parcel.setLength(20.0);
        parcel.setWidth(15.0);
        parcel.setHeight(25.0);
        
        customer = new Customer("John Smith", parcel);
    }
    
    @Test
    void testFeeCalculation() {
        double expectedFee = 5.0 + // base fee
                           (10.0 * 0.5) + // weight fee
                           (20.0 * 15.0 * 25.0 * 0.001) + // volume fee
                           (5.0 * 1.0); // days fee
        
        assertEquals(expectedFee, worker.calculateFee(parcel), 0.01,
            "Fee calculation should match expected value");
    }
    
    @Test
    void testCustomerProcessing() {
        worker.processCustomer(customer);
        
        assertEquals(customer, worker.getCurrentCustomer(),
            "Current customer should be set after processing");
        assertEquals(parcel, worker.getCurrentParcel(),
            "Current parcel should be set after processing");
    }
} 
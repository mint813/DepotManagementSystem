package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueOfCustomersTest {
    private QueueOfCustomers queue;
    private Customer customer;
    private Parcel parcel;

    @BeforeEach
    void setUp() {
        queue = new QueueOfCustomers();
        parcel = new Parcel();
        parcel.setParcelID("X123");
        customer = new Customer("John Smith", parcel);
    }

    @Test
    void testQueueOperations() {
        assertTrue(queue.getQueue().isEmpty(), "Queue should be empty initially");

        queue.addCustomer(customer);
        assertEquals(1, queue.getQueue().size(), "Queue should have one customer");

        Customer removed = queue.removeCustomer();
        assertEquals(customer, removed, "Removed customer should match added customer");
        assertTrue(queue.getQueue().isEmpty(), "Queue should be empty after removal");
    }

    @Test
    void testRemoveFromEmptyQueue() {
        assertNull(queue.removeCustomer(), "Removing from empty queue should return null");
    }
}

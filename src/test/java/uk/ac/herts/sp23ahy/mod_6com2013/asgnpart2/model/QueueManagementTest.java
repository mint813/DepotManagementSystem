package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class QueueManagementTest {
    private QueueOfCustomers queue;
    
    @BeforeEach
    void setUp() {
        queue = new QueueOfCustomers();
    }
    
    @Test
    void testQueueOrder() {
        // 测试按姓氏排序
        Customer c1 = new Customer("John Brown", new Parcel());
        Customer c2 = new Customer("Alice Adams", new Parcel());
        
        queue.addCustomer(c1);
        queue.addCustomer(c2);
        
        assertEquals(c2, queue.removeCustomer(), "Adams should come before Brown");
    }
    
    @Test
    void testQueueOperations() {
        Customer customer = new Customer("Test User", new Parcel());
        queue.addCustomer(customer);
        assertEquals(1, queue.getQueue().size());
        assertNotNull(queue.removeCustomer());
        assertTrue(queue.getQueue().isEmpty());
    }
} 
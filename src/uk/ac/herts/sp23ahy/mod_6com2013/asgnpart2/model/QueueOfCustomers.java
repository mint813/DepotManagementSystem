package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private final Queue<Customer> customerQueue = new LinkedList<>();
    private final Log log = Log.getInstance();

    public void addCustomer(Customer customer) {
        customerQueue.offer(customer);
        log.addEvent("Customer " + customer + " joined the queue");
    }

    public Customer removeCustomer() {
        Customer customer = customerQueue.poll();
        if (customer != null) {
            log.addEvent("Customer " + customer + " removed from queue");
        }
        return customer;
    }

    public Queue<Customer> getQueue() {
        return customerQueue;
    }
} 
package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Customer;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Log;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

public class Worker {
    private final Log log = Log.getInstance();
    private Customer currentCustomer;
    private Parcel currentParcel;

    public double calculateFee(Parcel parcel) {
        // 基础费用
        double baseFee = 5.0;
        
        // 根据重量增加费用
        double weightFee = parcel.getWeight() * 0.5;
        
        // 根据体积增加费用
        double volume = parcel.getLength() * parcel.getWidth() * parcel.getHeight();
        double volumeFee = volume * 0.001;
        
        // 根据存放天数增加费用
        double daysFee = parcel.getDaysInDepot() * 1.0;
        
        return baseFee + weightFee + volumeFee + daysFee;
    }

    public void processCustomer(Customer customer) {
        currentCustomer = customer;
        currentParcel = customer.getParcel();
        double fee = calculateFee(currentParcel);
        
        log.addEvent(String.format("Processing customer %s collecting parcel %s. Fee: £%.2f", 
            customer, currentParcel.getParcelID(), fee));
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public Parcel getCurrentParcel() {
        return currentParcel;
    }
} 
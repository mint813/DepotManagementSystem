package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

class FeeCalculationTest {
    private Worker worker = new Worker();
    
    @Test
    void testBasicFeeCalculation() {
        Parcel parcel = new Parcel();
        parcel.setDaysInDepot(1);
        parcel.setWeight(10.0);
        parcel.setWidth(10.0);
        parcel.setLength(10.0);
        parcel.setHeight(10.0);
        
        double expectedFee = 5.0 + // 基础费用
                           (10.0 * 0.5) + // 重量费用
                           (10.0 * 10.0 * 10.0 * 0.001) + // 体积费用
                           (1.0 * 1.0); // 天数费用
        
        assertEquals(expectedFee, worker.calculateFee(parcel), 0.01);
    }
    
    @Test
    void testZeroValuesFee() {
        Parcel parcel = new Parcel();
        parcel.setDaysInDepot(0);
        parcel.setWeight(0.0);
        parcel.setWidth(0.0);
        parcel.setLength(0.0);
        parcel.setHeight(0.0);
        
        assertEquals(5.0, worker.calculateFee(parcel), 0.01, "Should only charge base fee");
    }
} 
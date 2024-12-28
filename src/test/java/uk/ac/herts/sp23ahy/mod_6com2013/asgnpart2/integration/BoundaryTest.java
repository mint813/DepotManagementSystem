package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.Worker;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

class BoundaryTest {
    
    @Test
    void testFeeCalculationBoundaries() {
        Worker worker = new Worker();
        Parcel parcel = new Parcel();
        
        // 测试最小值
        parcel.setParcelID("MIN001");
        parcel.setDaysInDepot(0);
        parcel.setWeight(0.0);
        parcel.setLength(0.0);
        parcel.setWidth(0.0);
        parcel.setHeight(0.0);
        
        assertEquals(5.0, worker.calculateFee(parcel), 0.01, 
            "Minimum values should result in base fee only");
        
        // 测试极大值
        parcel.setParcelID("MAX001");
        parcel.setDaysInDepot(Integer.MAX_VALUE);
        parcel.setWeight(Double.MAX_VALUE);
        parcel.setLength(100000.0);
        parcel.setWidth(100000.0);
        parcel.setHeight(100000.0);
        
        assertTrue(worker.calculateFee(parcel) > 0, 
            "Fee calculation should handle large values");
    }
} 
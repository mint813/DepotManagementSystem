package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;

class ParcelManagementTest {
    private ParcelManager parcelManager;
    
    @BeforeEach
    void setUp() {
        parcelManager = ParcelManager.getInstance();
    }
    
    @Test
    void testAddParcel() {
        Parcel parcel = new Parcel();
        parcel.setParcelID("TEST003");
        parcel.setDaysInDepot(3);
        parcel.setWeight(15.0);
        parcel.setWidth(20.0);
        parcel.setLength(25.0);
        parcel.setHeight(30.0);
        
        assertTrue(parcelManager.addParcel(parcel));
        assertNotNull(parcelManager.getParcel("TEST003"));
    }
    
    @Test
    void testDeleteParcel() {
        Parcel parcel = parcelManager.getParcel("TEST001");
        assertTrue(parcelManager.deleteParcel(parcel));
        assertNull(parcelManager.getParcel("TEST001"));
    }
} 
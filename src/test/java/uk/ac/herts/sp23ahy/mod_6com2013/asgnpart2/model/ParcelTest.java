package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelTest {
    private Parcel parcel;
    
    @BeforeEach
    void setUp() {
        parcel = new Parcel();
        parcel.setParcelID("X123");
        parcel.setDaysInDepot(5);
        parcel.setWeight(10.0);
        parcel.setLength(20.0);
        parcel.setWidth(15.0);
        parcel.setHeight(25.0);
    }
    
    @Test
    void testParcelEquality() {
        Parcel other = new Parcel();
        other.setParcelID("X123");
        
        assertEquals(parcel, other, "Parcels with same ID should be equal");
        assertEquals(parcel.hashCode(), other.hashCode(), "Hash codes should be equal for equal parcels");
    }
    
    @Test
    void testParcelToString() {
        assertEquals("X123", parcel.toString(), "toString should return parcel ID");
    }
} 
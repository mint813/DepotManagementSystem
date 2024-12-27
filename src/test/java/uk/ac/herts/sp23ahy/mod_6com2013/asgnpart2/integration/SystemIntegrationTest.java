package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.CustomerManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

class SystemIntegrationTest {
    
    @Test
    void testParcelManagementFlow() {
        ParcelManager parcelManager = ParcelManager.getInstance();
        
        // 创建新包裹
        Parcel parcel = new Parcel();
        parcel.setParcelID("TEST001");
        parcel.setDaysInDepot(1);
        parcel.setWeight(10.0);
        parcel.setLength(10.0);
        parcel.setWidth(10.0);
        parcel.setHeight(10.0);
        
        // 测试添加包裹
        assertTrue(parcelManager.addParcel(parcel), "Should successfully add parcel");
        
        // 测试获取包裹
        Parcel retrieved = parcelManager.getParcel("TEST001");
        assertNotNull(retrieved, "Should retrieve added parcel");
        assertEquals(parcel, retrieved, "Retrieved parcel should match added parcel");
        
        // 测试删除包裹
        assertTrue(parcelManager.deleteParcel(parcel), "Should successfully delete parcel");
        assertNull(parcelManager.getParcel("TEST001"), "Deleted parcel should not be found");
    }
    
    @Test
    void testDataPersistence() {
        ParcelManager parcelManager = ParcelManager.getInstance();
        
        // 添加测试数据
        Parcel parcel = new Parcel();
        parcel.setParcelID("TEST002");
        parcel.setDaysInDepot(1);
        parcel.setWeight(10.0);
        parcel.setLength(10.0);
        parcel.setWidth(10.0);
        parcel.setHeight(10.0);
        
        parcelManager.addParcel(parcel);
        
        // 测试保存
        assertTrue(parcelManager.saveParcels(), "Should successfully save parcels");
        
        // 测试数据是否被正确保存
        ParcelManager newInstance = ParcelManager.getInstance();
        Parcel loaded = newInstance.getParcel("TEST002");
        assertNotNull(loaded, "Should load saved parcel");
        assertEquals(parcel, loaded, "Loaded parcel should match saved parcel");
    }
} 
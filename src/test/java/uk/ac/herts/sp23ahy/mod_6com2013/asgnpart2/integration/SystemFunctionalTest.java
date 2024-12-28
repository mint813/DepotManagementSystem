package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Customer;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.QueueOfCustomers;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.Worker;

class SystemFunctionalTest {
    private ParcelManager parcelManager;
    private QueueOfCustomers queue;
    private Worker worker;
    
    @BeforeEach
    void setUp() {
        parcelManager = ParcelManager.getInstance();
        queue = new QueueOfCustomers();
        worker = new Worker();
    }
    
    @Test
    void testCompleteWorkflow() {
        // 1. 创建新包裹
        Parcel parcel = new Parcel();
        parcel.setParcelID("TEST001");
        parcel.setDaysInDepot(5);
        parcel.setWeight(10.0);
        parcel.setLength(20.0);
        parcel.setWidth(15.0);
        parcel.setHeight(25.0);
        
        // 2. 添加包裹到系统
        assertTrue(parcelManager.addParcel(parcel));
        
        // 3. 创建客户并加入队列
        Customer customer = new Customer("John Smith", parcel);
        queue.addCustomer(customer);
        assertFalse(queue.getQueue().isEmpty());
        
        // 4. 处理客户
        Customer processedCustomer = queue.removeCustomer();
        worker.processCustomer(processedCustomer);
        
        // 5. 验证费用计算
        double expectedFee = 5.0 + // 基础费用
                           (10.0 * 0.5) + // 重量费用
                           (20.0 * 15.0 * 25.0 * 0.001) + // 体积费用
                           (5.0 * 1.0); // 天数费用
        
        assertEquals(expectedFee, worker.calculateFee(parcel), 0.01);
        
        // 6. 标记包裹已收集
        assertTrue(parcelManager.deleteParcel(parcel));
        assertNull(parcelManager.getParcel("TEST001"));
    }
} 
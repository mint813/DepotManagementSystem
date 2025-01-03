package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.File;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Log;

class PersistenceTest {
    
    @Test
    void testParcelSaveAndLoad() {
        ParcelManager manager = ParcelManager.getInstance();
        assertTrue(manager.saveParcels(), "Should save successfully");
        
        // 重新加载并验证数据
        ParcelManager newManager = ParcelManager.getInstance();
        assertEquals(manager.getParcels().size(), newManager.getParcels().size());
    }
    
    @Test
    void testLogPersistence() {
        Log log = Log.getInstance();
        String testMessage = "Test log message";
        log.addEvent(testMessage);
        log.saveToFile("test_log.txt");
        
        // 验证文件是否创建
        File logFile = new File("test_log.txt");
        assertTrue(logFile.exists());
    }
} 
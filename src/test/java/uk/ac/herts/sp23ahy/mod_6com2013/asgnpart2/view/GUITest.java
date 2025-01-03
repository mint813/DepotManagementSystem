package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javax.swing.SwingUtilities;

class GUITest {
    
    @Test
    void testFrameCreation() {
        SwingUtilities.invokeLater(() -> {
            try {
                ParcelListFrame frame = new ParcelListFrame();
                assertNotNull(frame);
                assertTrue(frame.isVisible());
            } catch (Exception e) {
                fail("Frame creation failed: " + e.getMessage());
            }
        });
    }
    
    @Test
    void testAddParcelDialog() {
        SwingUtilities.invokeLater(() -> {
            try {
                ParcelListFrame frame = new ParcelListFrame();
                AddParcelDialog dialog = new AddParcelDialog(frame);
                assertNotNull(dialog);
            } catch (Exception e) {
                fail("Dialog creation failed: " + e.getMessage());
            }
        });
    }
} 
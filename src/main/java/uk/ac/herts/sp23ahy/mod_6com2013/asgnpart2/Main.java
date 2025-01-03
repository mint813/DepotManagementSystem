package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.view.ParcelListFrame;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.CustomerManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // 设置Nimbus外观
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
                
                // 初始化管理器
                ParcelManager.getInstance();
                CustomerManager.getInstance();
                
                // 启动主窗口
                new ParcelListFrame();
                
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        });
    }
} 
package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final Log INSTANCE = new Log();
    private final StringBuffer logBuffer = new StringBuffer();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Log() {}

    public static Log getInstance() {
        return INSTANCE;
    }

    public void addEvent(String event) {
        logBuffer.append(LocalDateTime.now().format(formatter))
                .append(" - ")
                .append(event)
                .append("\n");
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(logBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 
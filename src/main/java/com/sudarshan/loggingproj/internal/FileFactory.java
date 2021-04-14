package com.sudarshan.loggingproj.internal;

import com.sudarshan.loggingproj.config.Config;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class FileFactory {
    public static File logFile;
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Config.DATE_PATTERN);
    private static final String USER_DIR = System.getProperty(Config.CUR_DIR);

    public static File getLogFile(LocalDateTime localDateTime) {
        String filename = Config.FILE_NAME_INITIAL+localDateTime.format(dateTimeFormatter)+Config.FILE_EXTENSION;
        if (logFile == null) {
            logFile = new File(filename);
            System.out.println("From Logger : Log File created in "+USER_DIR + "\\"+filename);
        }
        return logFile;
    }
}



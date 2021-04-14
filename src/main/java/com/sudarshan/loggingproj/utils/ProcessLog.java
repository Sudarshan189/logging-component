package com.sudarshan.loggingproj.utils;

import com.sudarshan.loggingproj.internal.FileFactory;
import com.sudarshan.loggingproj.model.Log;
import com.sudarshan.loggingproj.service.impl.LoggerImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ProcessLog {
    // create thread lock fair to make sequential
    public static ReentrantLock lock = new ReentrantLock(true);

    public static void run() {
        lock.lock();
        try {
            Log log = LoggerImpl.logQueue.poll();
            writeToFile(log);
            System.out.println(log.getLogDate() + " "+ log.getSeverityLevel() + " " + log.getLogMessage());
        } finally {
            lock.unlock();
        }
    }

    private static void writeToFile(Log log) {
        File file = FileFactory.getLogFile(log.getLogDate());
        try(FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.append(log.getLogDate() + " "+ log.getSeverityLevel() + " " + log.getLogMessage());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

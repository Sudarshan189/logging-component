package com.sudarshan.loggingproj.service.impl;

import com.sudarshan.loggingproj.model.Log;
import com.sudarshan.loggingproj.model.Severity;
import com.sudarshan.loggingproj.service.Logger;
import com.sudarshan.loggingproj.utils.ProcessLog;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class LoggerImpl implements Logger {

    public static Queue<Log> logQueue;

    public LoggerImpl() {
        logQueue = new LinkedList<>();
    }

    @Override
    public void debug(String logMessage) {
        Log log = new Log(LocalDateTime.now(), Severity.DEBUG, logMessage);
        processLog(log);
    }

    @Override
    public void warning(String logMessage) {
        Log log = new Log(LocalDateTime.now(), Severity.WARNING, logMessage);
        processLog(log);
    }

    @Override
    public void error(String logMessage) {
        Log log = new Log(LocalDateTime.now(), Severity.ERROR, logMessage);
        processLog(log);
    }

    @Override
    public void info(String logMessage) {
        Log log = new Log(LocalDateTime.now(), Severity.INFO, logMessage);
        processLog(log);
    }

    @Override
    public void trace(String logMessage) {
        Log log = new Log(LocalDateTime.now(), Severity.TRACE, logMessage);
        processLog(log);
    }

    private synchronized void processLog(Log log) {
        logQueue.add(log);
        Thread thread = new Thread(ProcessLog::run);
        thread.start();
    }

}

package com.sudarshan.loggingproj.service;

public interface Logger {
    void debug(String logMessage);

    void warning(String logMessage);

    void error(String logMessage);

    void info(String logMessage);

    void trace(String logMessage);
}

package com.sudarshan.loggingproj.internal;

import com.sudarshan.loggingproj.service.Logger;
import com.sudarshan.loggingproj.service.impl.LoggerImpl;

public abstract class LoggerFactory {
    public static Logger logger;

    public static Logger getLogger() {
        if (logger==null) {
            logger = new LoggerImpl();
        }
        return logger;
    }
}

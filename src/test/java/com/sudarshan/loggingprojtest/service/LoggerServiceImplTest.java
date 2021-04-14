package com.sudarshan.loggingprojtest.service;

import com.sudarshan.loggingproj.config.Config;
import com.sudarshan.loggingproj.internal.LoggerFactory;
import com.sudarshan.loggingproj.service.Logger;
import com.sudarshan.loggingproj.service.impl.LoggerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class LoggerServiceImplTest {

    Logger logger = LoggerFactory.getLogger();

    @Before
    public void init() throws InterruptedException {
        logger.debug("Hello World!!");
        // wait for file creation first time
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testDebugLog() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMYYYY");
        File file = new File("assignment.log."+ LocalDateTime.now().format(dateTimeFormatter)+".txt");
        Assert.assertTrue(file.exists());
    }

    @Test(timeout = 1)
    public void testTraceLogwithTimeout() {
        logger.trace("This is trace logger");
    }
}

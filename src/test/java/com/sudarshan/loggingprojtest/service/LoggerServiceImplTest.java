package com.sudarshan.loggingprojtest.service;

import com.sudarshan.loggingproj.internal.LoggerFactory;
import com.sudarshan.loggingproj.service.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class LoggerServiceImplTest {

    Logger logger;

    @Before
    public void init() {
        this.logger = LoggerFactory.getLogger();
    }

    @Test
    public void testDebugLog() throws InterruptedException {
        logger.debug("This is Debug Log");
        TimeUnit.SECONDS.sleep(2);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMYYYY");
        File file = new File("assignment.log."+ LocalDateTime.now().format(dateTimeFormatter)+".txt");
        Assert.assertTrue(file.exists());
    }

    @Test(timeout = 1000)
    public void testTraceLogwithTimeout() {
        logger.trace("This is Trace Log");
    }
}

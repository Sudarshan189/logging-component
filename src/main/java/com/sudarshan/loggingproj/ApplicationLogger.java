package com.sudarshan.loggingproj;

import com.sudarshan.loggingproj.internal.LoggerFactory;
import com.sudarshan.loggingproj.service.Logger;

import java.util.LinkedList;

public class ApplicationLogger {
    public static final  Logger LOGGER = LoggerFactory.getLogger();

    private LinkedList<Integer> linkedList;

    public ApplicationLogger() {
        LOGGER.debug("Creating Linked list");
        linkedList = new LinkedList<>();
    }

    public void push(Integer data) {
        linkedList.add(data);
        LOGGER.info("Adding data "+ data + " to Queue");
    }

    public Integer poll() {
        Integer data = linkedList.poll();
        LOGGER.info("Data retried from Queue "+ data);
        return data;
    }
    /*
    Below is the main method
    We are implementing Queue with Linked list
    We have used info logging while push and pop

    Logs will be saved in Home directory of present user with filename
            assignment.log.ddMMYYYY.txt
     */
    public static void main(String[] args) {
        ApplicationLogger applicationLogger = new ApplicationLogger();
        applicationLogger.push(100);
        applicationLogger.push(1);
        applicationLogger.poll();
        applicationLogger.poll();
        System.out.println("Completed");

    }


}

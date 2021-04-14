package com.sudarshan.loggingproj.model;

import java.time.LocalDateTime;

public class Log {
    private LocalDateTime logDate;
    private Severity severityLevel;
    private String logMessage;

    public Log() {
    }

    public Log(LocalDateTime logDate, Severity severityLevel, String logMessage) {
        this.logDate = logDate;
        this.severityLevel = severityLevel;
        this.logMessage = logMessage;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public Severity getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(Severity severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logDate=" + logDate +
                ", severityLevel=" + severityLevel +
                ", logMessage='" + logMessage + '\'' +
                '}';
    }

}

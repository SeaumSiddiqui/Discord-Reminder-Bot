package org.bot.domain;

import java.time.LocalDateTime;

public class Reminder {
    private String id;
    private String message;
    private LocalDateTime timeStamp;
    private String type;

    public Reminder(String id, String message, LocalDateTime timeStamp, String type) {
        this.id = id;
        this.message = message;
        this.timeStamp = timeStamp;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

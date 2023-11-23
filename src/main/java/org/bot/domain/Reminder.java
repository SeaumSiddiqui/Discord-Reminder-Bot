package org.bot.domain;

import net.dv8tion.jda.api.entities.User;

public class Reminder {
    private User user;
    private String time;
    private String message;

    public Reminder(User user, String time, String message) {
        this.time = time;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

}

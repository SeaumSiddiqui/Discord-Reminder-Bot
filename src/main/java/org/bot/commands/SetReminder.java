package org.bot.commands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bot.domain.Reminder;
import org.bot.scheduler.ReminderManager;

import java.time.LocalDateTime;

public class SetReminder extends ListenerAdapter {
    private final ReminderManager reminderManager;
    public SetReminder(ReminderManager reminderManager) {
        this.reminderManager = reminderManager;

    }

    public void remindMe(String id, String message, LocalDateTime timeStamp, String type) {
        Reminder reminder = new Reminder(id, message, timeStamp, type);
        reminderManager.addReminder(reminder);
    }

    public void remindDaily(String id, String message, LocalDateTime timeStamp, String type) {
        Reminder reminder = new Reminder(id, message, timeStamp, type);
        reminderManager.addReminder(reminder);
    }

    public void remindWeekly(String id, String message, LocalDateTime timeStamp, String type) {
        Reminder reminder = new Reminder(id, message, timeStamp, type);
        reminderManager.addReminder(reminder);
    }

}

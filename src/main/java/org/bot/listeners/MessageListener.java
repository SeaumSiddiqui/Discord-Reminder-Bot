package org.bot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bot.commands.DeleteReminder;
import org.bot.commands.SetReminder;

import java.time.LocalDateTime;

public class MessageListener extends ListenerAdapter {
    private final SetReminder setReminder;
    private final DeleteReminder deletereminder;

    public MessageListener(SetReminder setReminder, DeleteReminder deletereminder) {
        this.setReminder = setReminder;
        this.deletereminder = deletereminder;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ", 2);

        if ("!remindme".equals(command[0]) && command.length > 1) {
            LocalDateTime timeStamp = LocalDateTime.parse(command[1]);

            setReminder.remindMe
                    (event.getAuthor().getId(), "Reminder: " + command[1], timeStamp, "one-time");
        } else if ("!reminddaily".equals(command[0]) && command.length > 1) {
            LocalDateTime timeStamp = LocalDateTime.parse(command[1]);

            setReminder.remindDaily
                    (event.getAuthor().getId(), "Reminder: " + command[1], timeStamp, "daily-reminder");
        } else if ("!remindweekly".equals(command[0]) && command.length > 1) {
            LocalDateTime timeStamp = LocalDateTime.parse(command[1]);

            setReminder.remindWeekly
                    (event.getAuthor().getId(), "Reminder: " + command[1], timeStamp, "weekly-reminder");
        }
    }
}

package org.bot.scheduler;

import net.dv8tion.jda.api.entities.User;
import org.bot.domain.Reminder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommandService {
    public List<Reminder> reminders;
    Timer timer;

    public CommandService() {
        this.reminders = new ArrayList<>();
        this.timer = new Timer();
    }

    public void scheduleOneTimeReminder(Reminder reminder) {
        Date reminderTime = parseReminderTime(reminder.getTime());
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendReminder(reminder);
            }
        };
        timer.schedule(task, reminderTime);
    }

    public void sendReminder(Reminder reminder) {
        User user = reminder.getUser();
        String message = "Reminder: " + reminder.getMessage();
        user.openPrivateChannel().queue(t-> t.sendMessage(message).queue());
    }

    public Date parseReminderTime(String time) {
        time = time.toUpperCase().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            return formatter.parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid reminder time format(e): " + time);
        }
    }
}

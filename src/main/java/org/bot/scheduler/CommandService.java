package org.bot.scheduler;

import net.dv8tion.jda.api.entities.User;
import org.bot.domain.Reminder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CommandService {
    public List<Reminder> reminders;
    private final Logger logger;
    private final ScheduledExecutorService scheduler;

    public CommandService() {
        this.reminders = new ArrayList<>();
        this.logger = LoggerFactory.getLogger(CommandService.class);
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void scheduleOneTimeReminder(Reminder reminder) {
        long delay = parseReminderTime(reminder.getTime());

        scheduler.schedule(()->
                sendReminder(reminder.getUser(), reminder.getMessage()), delay, TimeUnit.MILLISECONDS);
    }

    public void scheduleDailyReminder(Reminder reminder) {
        long delay = parseReminderTime(reminder.getTime());

        scheduler.scheduleAtFixedRate(()->
                sendReminder(reminder.getUser(), reminder.getMessage()), delay, 24, TimeUnit.HOURS);
    }

    private void sendReminder(User user, String message) {
        user.openPrivateChannel()
                .queue(
                        success -> success.sendMessage(message).queue(
                                messageSuccess -> logger.info("Reminder sent successfully to user {}", user.getId()),
                                messageError -> logger.error("Error sending message to user " + user.getId(), messageError)
                        ),
                        channelError -> logger.error("Error opening private channel for user " + user.getId(), channelError)
                );
    }

    private long parseReminderTime(String time) {
        LocalTime reminderTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mma"));
        long currentTime = System.currentTimeMillis();

        long reminder = reminderTime
                .atDate(LocalDate.now())
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        if (reminder < currentTime) {
            reminder += TimeUnit.DAYS.toMillis(1);
            System.out.println("reminder if not today: " + reminder);
        }
        return reminder - currentTime;
    }
}

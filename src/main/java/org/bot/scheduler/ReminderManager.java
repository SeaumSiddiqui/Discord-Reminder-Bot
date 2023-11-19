package org.bot.scheduler;

import org.bot.domain.Reminder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReminderManager {
    private final List<Reminder> reminderList = new ArrayList<>();

    public void addReminder(Reminder reminder) {
        reminderList.add(reminder);
    }

    public List<Reminder> getDueReminders(LocalDateTime currentTime) {
        List<Reminder> dueReminders = new ArrayList<>();

        Iterator<Reminder> iterator = reminderList.iterator();
        while (iterator.hasNext()) {
            Reminder reminder = iterator.next();

            if (reminder.getTimeStamp().isBefore(currentTime)) {
                dueReminders.add(reminder);
                iterator.remove();
            }
        }
        return dueReminders;
    }
}

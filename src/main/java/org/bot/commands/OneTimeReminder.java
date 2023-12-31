package org.bot.commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bot.domain.Reminder;
import org.bot.scheduler.CommandService;
import org.bot.scheduler.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OneTimeReminder implements ICommand {

    @Override
    public String getName() {
        return "remindat";
    }

    @Override
    public String getDescription() {
        return "/remindat 10:45PM meeting";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> optionData = new ArrayList<>();

        optionData.add(new OptionData(OptionType.STRING, "time", "set reminder", true));
        optionData.add(new OptionData(OptionType.STRING, "message", "add a note", true));
        return optionData;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        User user = event.getUser();
        String time = Objects.requireNonNull(event.getOption("time"))
                .getAsString()
                .toUpperCase()
                .replaceAll("\\s", "");
        String message = Objects.requireNonNull(event.getOption("message")).getAsString();

        Reminder reminder = new Reminder(user, time, message);
        CommandService service = new CommandService();

        service.reminders.add(reminder);
        service.scheduleOneTimeReminder(reminder);

        event.reply(
                "Reminder set: " +
                        reminder.getMessage() +
                        " at " +
                        reminder.getTime())
                .queue();
    }
}

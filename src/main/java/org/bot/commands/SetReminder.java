package org.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bot.scheduler.ICommand;

import java.util.ArrayList;
import java.util.List;

public class SetReminder implements ICommand {

    @Override
    public String getName() {
        return "remindme";
    }

    @Override
    public String getDescription() {
        return "One-time reminder";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> optionData = new ArrayList<>();
        optionData.add(new OptionData(OptionType.STRING, "time", "reminder hour", true));
        optionData.add(new OptionData(OptionType.STRING, "message", "reminder note", true));

        return optionData;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        OptionMapping timer = event.getOption("time");
        assert timer != null;
        String option1 = timer.getAsString();

        OptionMapping message = event.getOption("message");
        assert message != null;
        String option2 = message.getAsString();

        event.reply("New Reminder: " + option1 + " " + option2).queue();
    }
}

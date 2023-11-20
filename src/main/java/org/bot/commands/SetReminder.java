package org.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class SetReminder extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("remindme")) return;

        OptionMapping input1 = event.getOption("timer");
        assert input1 != null;
        String option1 = input1.getAsString();

        OptionMapping input2 = event.getOption("message");
        assert input2 != null;
        String option2 = input2.getAsString();


        event.reply(option1 + option2).queue();
    }
}

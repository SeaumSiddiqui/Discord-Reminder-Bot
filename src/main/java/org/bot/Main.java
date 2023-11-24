package org.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bot.commands.DailyReminder;
import org.bot.commands.OneTimeReminder;
import org.bot.scheduler.CommandManager;

public class Main {
    public static void main(String[] args) {
        final String token = "";
        JDA jdaBuilder = JDABuilder.createDefault(token).build();

        CommandManager manager = new CommandManager();
        manager.addCommand(new OneTimeReminder());
        manager.addCommand(new DailyReminder());

        jdaBuilder.addEventListener(manager);
    }
}
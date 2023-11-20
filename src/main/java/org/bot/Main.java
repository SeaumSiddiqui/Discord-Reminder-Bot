package org.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bot.commands.SetReminder;
import org.bot.listeners.MessageListener;
import org.bot.scheduler.ReminderManager;

public class Main {
    public static void main(String[] args) {
        final String token = "";
        JDABuilder jdaBuilder = JDABuilder.createDefault(token);

        ReminderManager manager = new ReminderManager();
        manager.addCommand(new SetReminder());

        JDA jda = jdaBuilder
                .enableIntents(
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new MessageListener(), manager)
                .build();
    }
}
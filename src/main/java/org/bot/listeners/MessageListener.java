package org.bot.listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class MessageListener extends ListenerAdapter {

//    @Override
//    public void onReady(ReadyEvent event) {
//        Guild guild = event.getJDA().getGuildById(588829145211863079L);
//        assert guild != null;
//        guild.upsertCommand("remindme", "one-time reminder")
//                .addOptions(new OptionData(OptionType.STRING, "time", "reminder timer", true),
//                        new OptionData(OptionType.STRING, "message", "reminder note", true))
//                .queue();
//    }
}

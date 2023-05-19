package com.example.discordbotproject;

import com.example.discordbotproject.models.Person;
import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandFirst extends ListenerAdapter {


    private final String URL = "https://discord.com/api/webhooks/1108811425553600593/WVNI2SCM9oORhVU5FaiAOozpNTQkahsetmwOreJDsO7-81W-2AraP7vbdNxoyeGT8Wx7";
    DiscordWebhook discordWebhook = new DiscordWebhook(URL);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {


            String message = event.getMessage().getContentRaw();

            if(message.contains("kacper"))
            {
                try
                {
                    PersonBuilder personBuilder = new PersonBuilder("https://www.ixodus.net/character/show/Toni_Kroos");

                    Person person = personBuilder.buildPerson();


                    event.getTextChannel().sendMessage("Postac o nicku: "+ person.getNick() + "zostala stworzona").queue();
                }
                catch (Exception e)
                {
                    event.getTextChannel().sendMessage("Nie Udalo Sie stworzyc obiektu").queue();
                }

            }
    }

}

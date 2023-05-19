package com.example.discordbotproject;

import com.example.discordbotproject.models.Person;
import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageSender extends ListenerAdapter {


    private final String URL = "https://discord.com/api/webhooks/1108811425553600593/WVNI2SCM9oORhVU5FaiAOozpNTQkahsetmwOreJDsO7-81W-2AraP7vbdNxoyeGT8Wx7";
    DiscordWebhook discordWebhook = new DiscordWebhook(URL);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {


            String message = event.getMessage().getContentRaw();

            if(message.contains("!build"))
            {
                try
                {
                    PersonBuilder personBuilder = new PersonBuilder("https://www.ixodus.net/character/show/Toni_Kroos");

                    Person person = personBuilder.buildPerson();

                    if(person.getNick()!= "" && person.getLevel()>0)
                    {
                        event.getChannel().sendMessage("Postac o nicku: "+ person.getNick() + " zostala stworzona").queue();
                    }


                }
                catch (Exception e)
                {
                    event.getChannel().sendMessage("Obiekt nie zostal stworzony").queue();
                }

            }
    }

}
package com.example.discordbotproject.messengersHandlers;

import com.example.discordbotproject.DiscordWebhook;
import com.example.discordbotproject.models.Person;
import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageSender extends ListenerAdapter {




    private final String URL = "https://discord.com/api/webhooks/1108811425553600593/WVNI2SCM9oORhVU5FaiAOozpNTQkahsetmwOreJDsO7-81W-2AraP7vbdNxoyeGT8Wx7";
    DiscordWebhook discordWebhook = new DiscordWebhook(URL);
    PersonBuilder personBuilder;

    @Autowired
    public MessageSender(PersonBuilder personBuilder){
        this.personBuilder = personBuilder;
    }



    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

                //funkcja ktora lapie kazdy tekst
                System.out.println("zwykly tekst");

//            if(message.contains("!build"))
//            {
//                try
//                {
//
//                    Person person = personBuilder.setUrl(listOfMessage[1]).buildPerson();
//
//                    if(person.getNick() != "" && person.getLevel()>0)
//                    {
//                        event.getChannel().sendMessage("Postac o nicku: "+ person.getNick() + " zostala stworzona uzytkownik wiadomosci: " + event.getAuthor().getName()).queue();
//                    }
//
//
//                }
//                catch (Exception e)
//                {
//                    event.getChannel().sendMessage("Obiekt nie zostal stworzony lub zle wpisales komende, przyklad: !build http//...").queue();
//                }
//
//            }
    }


}

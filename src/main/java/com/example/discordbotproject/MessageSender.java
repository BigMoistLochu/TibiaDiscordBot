package com.example.discordbotproject;

import com.example.discordbotproject.models.Person;
import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.entities.Message;
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


            String message = event.getMessage().getEmbeds().get(0).getFields().get(0).getValue();




            //chce zeby z tibi przyszly mi dane o postac i na podstawie tego chce stworzyc persona


            if(event.isWebhookMessage())
            {

                if(event.getAuthor().isBot())
                {

                    event.getChannel().sendMessage(message).queue();
                }

            }


//                    if(event.isWebhookMessage())
//                    {
//                        event.getChannel().sendMessage("xd").queue();
//                    }

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

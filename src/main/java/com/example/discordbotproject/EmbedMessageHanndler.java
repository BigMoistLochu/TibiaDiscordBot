package com.example.discordbotproject;

import com.example.discordbotproject.models.TibiaCharacter;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmbedMessageHanndler extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.isWebhookMessage())
        {

            MessageEmbed messageEmbed = event.getMessage().getEmbeds().get(0);


            if(event.getAuthor().isBot() || messageEmbed != null)
            {
                String temporaryNick ="";
                Integer temporaryLevel = 0;
                Double temporaryBalance = 0D;

                List<MessageEmbed.Field> fieldList = messageEmbed.getFields();

                if(!fieldList.isEmpty() || fieldList.size()==3)
                {
                    temporaryNick = fieldList.get(0).getValue();
                    temporaryLevel = Integer.parseInt(fieldList.get(1).getValue());
                    temporaryBalance = Double.parseDouble(fieldList.get(2).getValue());


                    if(temporaryNick!="" || temporaryLevel>0 || temporaryBalance>0)
                    {
                        System.out.println(temporaryNick);
                        System.out.println(temporaryBalance);
                        System.out.println(temporaryLevel);
                    }

                }

            }

        }
    }
}

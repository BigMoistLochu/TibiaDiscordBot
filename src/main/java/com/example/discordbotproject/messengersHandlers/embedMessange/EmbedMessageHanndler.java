package com.example.discordbotproject.messengersHandlers.embedMessange;

import com.example.discordbotproject.models.TibiaCharacter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EmbedMessageHanndler extends ListenerAdapter {


    ContainerTibiaCharacter containerTibiaCharacter;

    @Autowired
    public EmbedMessageHanndler(ContainerTibiaCharacter character)
    {
        this.containerTibiaCharacter = character;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.isWebhookMessage())
        {
            MessageEmbed messageEmbed = event.getMessage().getEmbeds().get(0);


            if(event.getAuthor().isBot() && messageEmbed != null)
            {
                String temporaryNick ="";
                Integer temporaryLevel = 0;
                Double temporaryBalance = 0D;
                List<MessageEmbed.Field> fieldList = messageEmbed.getFields();


                if(!fieldList.isEmpty() || fieldList.size()==3)
                {
                    try
                    {
                        temporaryNick = fieldList.get(0).getValue();
                        temporaryLevel = Integer.parseInt(fieldList.get(1).getValue());
                        temporaryBalance = Double.parseDouble(fieldList.get(2).getValue());
                    }
                    catch(NumberFormatException e)
                    {
                        log.info("zle dane blad: " + e);
                    }

                    if(temporaryNick!="" && temporaryLevel>0 && temporaryBalance>0)
                    {
                            System.out.println(temporaryNick);
                            System.out.println(temporaryBalance);
                            System.out.println(temporaryLevel);
                            TibiaCharacter newchar = TibiaCharacter.builder().nick(temporaryNick).balance(temporaryBalance).level(temporaryLevel).build();
                            if(containerTibiaCharacter.checkCharacterIfContain(temporaryNick))
                            {
                                containerTibiaCharacter.addNewCharacter(temporaryNick,newchar);
                            }
                            else
                            {
                                containerTibiaCharacter.getCharacterByNick(temporaryNick).setBalance(temporaryBalance);
                            }
                            System.out.println(containerTibiaCharacter.getListOfChar());
                    }

                }

            }

        }
    }
}

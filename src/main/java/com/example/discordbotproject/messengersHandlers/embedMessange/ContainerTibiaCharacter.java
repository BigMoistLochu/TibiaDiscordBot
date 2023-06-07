package com.example.discordbotproject.messengersHandlers.embedMessange;

import com.example.discordbotproject.models.TibiaCharacter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ContainerTibiaCharacter {

    private Map<String, TibiaCharacter> listOfChar = new HashMap<>();


    public void addNewCharacter(String name,TibiaCharacter tibiaCharacter)
    {
        listOfChar.put(name,tibiaCharacter);
    }

    public boolean checkCharacterIfContain(String name)
    {
        if(!listOfChar.containsKey(name))
        {
            return true;
        }

        return false;
    }

    public TibiaCharacter getCharacterByNick(String name)
    {
        return listOfChar.get(name);
    }

    public Map<String, TibiaCharacter> getListOfChar()
    {
        return listOfChar;
    }





}

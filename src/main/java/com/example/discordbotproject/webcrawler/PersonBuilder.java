package com.example.discordbotproject.webcrawler;

import com.example.discordbotproject.models.Person;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PersonBuilder {

    private Document document;


    public PersonBuilder(String URL) throws IOException {
        document = Jsoup.connect(URL).userAgent("Mozilla/5.0").get();
    }


    public Person buildPerson()
    {
        String temporaryNick = "";
        Integer temporaryLevel = 0;

        if(!document.select(PersonType.find(SelectorInfo.NICK))
                .text().isEmpty())
        {
            temporaryNick = document.select(PersonType.find(SelectorInfo.NICK)).text();
        }


        if(!document.select(PersonType.find(SelectorInfo.LEVEL)).text().isEmpty())
        {
            temporaryLevel = Integer.parseInt(document.select(PersonType.find(SelectorInfo.LEVEL)).text());
        }



        return Person.builder()
                .nick(temporaryNick)
                .level(temporaryLevel)
                .build();
    }













}

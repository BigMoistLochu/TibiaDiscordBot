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
        String temporaryNick;

        if(!document.select(PersonType.find(SelectorInfo.NICK))
                .text().isEmpty())
        {
            System.out.println(document.select(PersonType.find(SelectorInfo.NICK)).text());
        }

        return Person.builder().nick("test").level(10).build();
    }













}

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

        if(!document.select("table.guild-list:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > font:nth-child(1) > strong:nth-child(1)")
                .text().isEmpty())
        {
            System.out.println("tak");
        }

        return Person.builder().nick("test").level(10).build();
    }













}

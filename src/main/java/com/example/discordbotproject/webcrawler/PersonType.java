package com.example.discordbotproject.webcrawler;

public class PersonType {

    private PersonType(){}

    public static String find(SelectorInfo selectorInfo)
    {
        return switch(selectorInfo) {
            case NICK->
                     "table.guild-list:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > font:nth-child(1)";
            case LEVEL ->
                    "table.guild-list:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)";
        };
    }





}

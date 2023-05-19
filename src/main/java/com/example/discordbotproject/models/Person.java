package com.example.discordbotproject.models;

import lombok.*;

import javax.management.ConstructorParameters;

@Getter
@ToString
@AllArgsConstructor
public class Person {

    private String nick;

    private int level;

    @Builder
    private static Person getInstance(String nick, int level)
    {
        return new Person(nick,level);
    }





}

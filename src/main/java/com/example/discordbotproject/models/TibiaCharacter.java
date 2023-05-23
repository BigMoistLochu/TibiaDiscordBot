package com.example.discordbotproject.models;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class TibiaCharacter {

    private String nick;

    private Integer level;

    private Double balance;

    @Builder
    private static TibiaCharacter getInstance(String nick,Integer level,Double balance)
    {
        return new TibiaCharacter(nick,level,balance);
    }
}

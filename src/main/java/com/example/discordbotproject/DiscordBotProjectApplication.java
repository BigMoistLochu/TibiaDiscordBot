package com.example.discordbotproject;

import com.example.discordbotproject.models.Person;
import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@SpringBootApplication
public class DiscordBotProjectApplication implements CommandLineRunner {

    private final String TOKEN = "MTEwODU0MTU3NzQwMTQ3NTExMg.GGdGeK.svToPTv8HgT5rUF-ccxEdEOIy1IPc6S-yc6Ymw";



    public static void main(String[] args) {
        SpringApplication.run(DiscordBotProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        JDA jda = JDABuilder.createDefault(TOKEN)
                .addEventListeners(new CommandFirst())
                .build();



    }

}

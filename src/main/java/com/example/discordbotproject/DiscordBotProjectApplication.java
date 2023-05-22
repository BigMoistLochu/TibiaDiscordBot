package com.example.discordbotproject;

import com.example.discordbotproject.webcrawler.PersonBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static net.dv8tion.jda.api.Permission.MANAGE_WEBHOOKS;

@SpringBootApplication
public class DiscordBotProjectApplication implements CommandLineRunner {

    @Value("${myapp.token.key}")
    private String TOKEN;

    MessageSender messageSender;


    @Autowired
    public DiscordBotProjectApplication(MessageSender messageSender)
    {
        this.messageSender = messageSender;

    }

    public static void main(String[] args) {
        SpringApplication.run(DiscordBotProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        JDA jda = JDABuilder.createDefault(TOKEN)
                .addEventListeners(messageSender)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_WEBHOOKS)
                .build();


    }

}

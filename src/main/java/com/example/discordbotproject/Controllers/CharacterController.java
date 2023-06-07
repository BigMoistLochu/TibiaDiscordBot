package com.example.discordbotproject.Controllers;

import com.example.discordbotproject.messengersHandlers.embedMessange.ContainerTibiaCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {


    ContainerTibiaCharacter containerTibiaCharacter;

    @Autowired
    CharacterController(ContainerTibiaCharacter character)
    {
        this.containerTibiaCharacter = character;
    }


    @GetMapping("/start")
    public String get(Model model)
    {
        model.addAttribute("chars",containerTibiaCharacter.getListOfChar());
        return "main";
    }
}

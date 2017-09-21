package com.discord.soundboard.api;

import com.discord.soundboard.bot.DiscordBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static DiscordBot bot;

    public static void setDiscordBot(DiscordBot _bot){
        bot = _bot;
    }
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the API root !";
    }

    @RequestMapping("/play")
    public String play(@RequestParam(value="song") String song ) {
        bot.playSong(song);
        return "Song : " + song + " played !";
    }

    @RequestMapping("/songs")
    public ArrayList<String> songs(){
        return SongManager.getSongsAsStrings();
    }

    @PostMapping("/songs")
    public void uploadSong(){
    }

}
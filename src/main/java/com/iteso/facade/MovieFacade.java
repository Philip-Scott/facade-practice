package com.iteso.facade;

import com.iteso.facade.interfaces.*;
import com.iteso.facade.interfaces.impl.PS3Game;
import com.iteso.facade.interfaces.impl.SonyBravia;

/**
 * Created by Diego on 27/10/2016.
 */
public class MovieFacade {
    TV tv;
    GameConsole console;
    GameController controller;
    SoundSystem soundSystem;
    Router router;
    Lights lights;
    VideoGame game;

    public MovieFacade(TV tv,GameConsole console, GameController controller, SoundSystem soundSystem, Router router, Lights lights){
        this.tv = tv;
        this.console = console;
        this.controller = controller;
        this.soundSystem = soundSystem;
        this.router = router;
        this.lights = lights;
    }

    public void MovieFacadeON(String FacadeName){
        System.out.println("Starting the system ON, this may take some time");
        System.out.println();
        tv.on();
        tv.toHDMI();
        console.on();
        controller.on();
        game = new PS3Game(FacadeName);
        console.insertGame(game);
        soundSystem.on();
        soundSystem.toOpticalEntry();
        router.on();
        router.checkInternet();
        lights.off();
        game.play();
        System.out.println();
    }
    public void MovieFacadeOFF(){

        System.out.println();
        System.out.println("Turning the movie OFF, this may take some time");
        System.out.println();
        lights.on();
        tv.off();
        controller.off();
        console.off();
        soundSystem.off();
        router.off();


    }
}

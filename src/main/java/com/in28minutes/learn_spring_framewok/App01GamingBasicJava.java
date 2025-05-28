package com.in28minutes.learn_spring_framewok;

import com.in28minutes.learn_spring_framewok.game.GameRunner;
import com.in28minutes.learn_spring_framewok.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var marioGame = new MarioGame();
        var game = new PacmanGame(); //1: Object Creation
        var gameRunner = new GameRunner(game); //2: Object Creation + Wiring of Dependencies
        // Game is a Dependency of GameRunner
        gameRunner.run();
    }
}

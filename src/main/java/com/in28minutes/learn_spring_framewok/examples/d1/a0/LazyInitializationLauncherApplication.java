package com.in28minutes.learn_spring_framewok.examples.d1.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        // Logic
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            System.out.println("Initialization of context is completed");
            context.getBean(ClassB.class).doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }

////        var marioGame = new MarioGame();
//        var game = new PacmanGame(); //1: Object Creation
//        var gameRunner = new GameRunner(game); //2: Object Creation + Wiring of Dependencies
//        // Game is a Dependency of GameRunner
//        gameRunner.run();
    }
}

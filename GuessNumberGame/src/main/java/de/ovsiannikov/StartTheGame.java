package de.ovsiannikov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartTheGame {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Game game = context.getBean("guessNumberGame", Game.class);

        game.play();
    }
}
package com.murrk.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    @Test
    public void testSimpleWinSituation(){
        GuessingGame game = new GuessingGame();

        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);

        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongGuessSituation(){
        GuessingGame game = new GuessingGame();

        String message = game.guess(-5);

        assertEquals("You didnt get it", message);
    }


}

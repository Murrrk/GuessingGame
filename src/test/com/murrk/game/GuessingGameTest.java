package com.murrk.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);

        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongNegativeGuessSituation(){
        String message = game.guess(-5);

        assertEquals("You didnt get it", message);
    }

    @Test
    public void testOneWrongPositiveGuessSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);

        assertEquals("You didnt get it", message);
    }


}

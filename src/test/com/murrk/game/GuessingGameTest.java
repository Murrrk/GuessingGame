package com.murrk.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    public static final int GAME_RETRIES = 50;
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);

        assertEquals("You got it in 1 try", message);
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

    /**
     * The following method tests if our random number generation is working properly (for the numbers between 1 and 10)
     * To track if our generation is working properly, we have an array with 10 elements
     * each one of them is a "0". Each time a number is selected the value of "0" in the array
     * for the selected number is changed to "1". We loop our generation one hundred times and if the
     * sum of the array elements is 10 (we got every number at least once),
     * then our generation is working properly.
     */
    @Test
    //@RepeatedTest(10) additional test if 50 loops is enough to get each number 1 through 10 at least once
    public void testRandomNumberGeneration(){
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 1 1 1 1 1 1 = 10
        int[] randomNumberCount = new int[11];
        for (int counter = 0; counter < GAME_RETRIES; counter++){
            GuessingGame localGame = new GuessingGame();
            int randomNum = localGame.getRandomNumber();
            randomNumberCount[randomNum] = 1;
        }

        int sum = 0;
        for (int counter = 0; counter < 11; counter++){
            sum += randomNumberCount[counter];
        }
        assertEquals(10, sum);
    }


    private void makeThreeWrongGuesses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
    }
    @Test
    public void testFourWrongGuesses(){
        makeThreeWrongGuesses();
        String message = game.guess(-3);
        assertEquals("You didnt get it and youve had four tries. Game over.", message);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect(){
        makeThreeWrongGuesses();
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 4 tries", message);
    }


    @Test
    public void testTwoWrongGuessesAndOneCorrect(){
        game.guess(-3);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 3 tries", message);
    }



}

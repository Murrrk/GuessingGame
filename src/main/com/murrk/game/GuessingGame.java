package com.murrk.game;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(1,11);
    private int counter = 0;

    public String guess(int guessedNumber) {
        counter++;
        if (counter == 4 && guessedNumber != getRandomNumber()){
            return "You didnt get it and youve had four tries. Game over.";
        }
        String tryText = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("You got it in %d %s", counter, tryText);
        return guessedNumber == getRandomNumber() ? winningMsg : "You didnt get it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}

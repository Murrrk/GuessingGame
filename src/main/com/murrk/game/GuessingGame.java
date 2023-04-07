package com.murrk.game;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(1,11);
    public String guess(int guessedNumber) {
        return guessedNumber == getRandomNumber() ? "You got it" : "You didnt get it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}

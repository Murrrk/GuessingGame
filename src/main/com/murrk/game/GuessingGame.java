package com.murrk.game;

public class GuessingGame {
    public String guess(int guessedNumber) {
        return guessedNumber >= 0 ? "You got it" : "You didnt get it";
    }

    public int getRandomNumber() {
        return 0;
    }
}

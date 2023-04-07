package com.murrk.game;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(1,11);
    private int counter = 0;

    public String guess(int guessedNumber) {
        counter++;
        String tryText = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("You got it in %d %s", counter, tryText);
        String response = null;

        if (counter == 4 && guessedNumber != getRandomNumber()){
            response = String.format("You didnt get it and youve had %d %s. Game over.", counter, tryText) ;
        } else if (counter > 4){
            response =  "Sorry you are limited to 4 tries. Your game is over.";
        } else {
            response =  guessedNumber == getRandomNumber() ? winningMsg : "You didnt get it";
        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}

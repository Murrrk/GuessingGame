package com.murrk.game;

import java.util.Random;
import java.util.Scanner;

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
            String tooHighLowText = null;
            if(guessedNumber < getRandomNumber()){
                tooHighLowText = "- youre too low";
            } else if (guessedNumber > getRandomNumber()){
                tooHighLowText = "- youre too high";
            }
            else {
                tooHighLowText = "";
            }
            String loseText = String.format("You didnt get it %s", tooHighLowText).trim();
            response =  guessedNumber == getRandomNumber() ? winningMsg : loseText;
        }

        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        Scanner scan = new Scanner(System.in);
        boolean loopShouldContinue = true;
        do {
            System.out.print("Enter a number: ");
            String input = scan.nextLine();
            if("quit".equals(input)){
                System.out.println("Quitting now...");
                break;
            }

            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);

            if(output.contains("You got it") || output.contains("over")){
                loopShouldContinue = false;
            }
        }while(loopShouldContinue);
    }
}

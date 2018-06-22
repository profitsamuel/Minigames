package org.vashonsd.Games;

import org.vashonsd.Utils.Minigame;
import org.vashonsd.Utils.Utils;

import java.util.Random;

/**
 * Created by andy on 5/2/18.
 */
public class TwentyQuestions extends Minigame {

    private int targetNumber;

    public TwentyQuestions() {
        super("20q", "Guess a number between 0 and 1,000", "quit");
    }

    @Override
    public String start() {
        setUp();
        return("Okay, guess a number between 1 and 500.");
    }

    private void setUp() {
        Random rand = new Random();
        targetNumber = rand.nextInt(499) + 1;
    }

    @Override
    public String handle(String str) {
        int rQuestions=20;
        if(!Utils.IsInteger(str)) {
            return "You must guess a number.";
        }
        int guess = Integer.parseInt(str);
        if(rQuestions==0){
            return "You lose"+quit();

        }
        if(!(guess >= 1 && guess <=500)) {
            return "Your guess must be between 1 and 500.";
        } else if(guess < targetNumber) {
            rQuestions--;
            return "too small: you have "+rQuestions+" guesses remaining.";
        } else if(guess > targetNumber) {
            rQuestions--;
            return "too big: you have "+rQuestions+" guesses remaining.";
        } else {
            setUp();
            return "Congratulations! You guessed it!\nGuess another, or type " + quitWord + " to quit.";
        }
    }

    @Override
    public String quit() {
        return "Goodbye! Thanks for playing!";
    }
}

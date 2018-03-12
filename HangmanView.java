/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.assignment.mvc.hangman;

import java.util.Scanner;

/**
 *
 * @author kiran
 */
public class HangmanView {

    private Scanner s = new Scanner(System.in);
    private static int previousStatus;
    private static int nextStatus=0;
    HangmanController hangmanController = new HangmanController();
    HangmanModel hangmanModel = new HangmanModel();

    public void printLevel(int level,int lenghth) {
        System.out.println("**********LEVEL--" + (level + 1) + "**********");
        System.out.println("Word contains----  "+lenghth+" letters");
    }

    public void input(String replaceWord, int count) {
        String guess;
        System.out.println("        "+replaceWord);

        System.out.println("Guess a letter attempt--- " + (count + 1));
        guess = s.next();

        hangmanController.recieveGuess(guess);

    }

    public void announceSuccess(String word) {
        System.out.println("Congrats!!!\nYou Guessed the word " + word + "  correct");

    }

    public void announceFailure(String word) {
        System.out.println("Your attempts for this word over\n "
                + "better luck for next word By the way word was--" + word);
    }

    public void announceScore(int status, int score) {
        if (status == 1) {
            System.out.println("Your score Now-------" + score + "/10");
        } else if (status == 2) {
            System.out.println("******************************************\n"
                              +"Your Final Score- " + score + "***********\n"
                              +"******************************************");

        }

    }

    public void announceGuessExist() {
        System.out.println("You have guessed it already...Be alert when guessing");
    }

    public void checkGuess(int status) {
        previousStatus=nextStatus;
        nextStatus=status;
       if(status>0 && previousStatus!=nextStatus)
       {
           System.out.println("XXXXXXXXX------>>>wrong guess no: "+status+"<<<-------XXXXXXXXXX");
       }
       
    }
}

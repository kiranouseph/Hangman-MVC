/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.assignment.mvc.hangman;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kiran
 */
public class HangmanModel {

    HangmanController hangmanController = new HangmanController();
    ArrayList<String> wordArray = new ArrayList<>();
    private static String currentWord = new String();
    private String replaceWord = "";
    private int status;
    private static String guessString = "";

    public HangmanModel() {
        wordArray.add("APPLE");
        wordArray.add("ORANGE");
        wordArray.add("GRAPES");
        wordArray.add("FOOTBALL");
        wordArray.add("CRICKET");
        wordArray.add("HOCKEY");
        wordArray.add("COMPUTER");
        wordArray.add("LAPTOP");
        wordArray.add("MOBILE");
        wordArray.add("INNOVATURE");
        wordArray.add("BEACONPLUS");
        

    }

    public String getRandomWord() {
        Collections.shuffle(wordArray);
        currentWord = wordArray.get(0);

        return currentWord;

    }

    public void remove() {
        wordArray.remove(currentWord);
    }

    public void hangman(String guess, String starpattern) {
        guessString += guess;
//        System.out.println("guess array-----" + guessString);
        int checkGuess = 0;
        for (int i = 0; i < guessString.length(); i++) {
            if (guessString.charAt(i) == guess.charAt(0)) {
                checkGuess += 1;
            }
        }
        if (checkGuess > 1) {
            status = 2;
            HangmanController.passName(starpattern, status);
//        System.out.println(replaceWord);

        } else {
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == guess.charAt(0)) {

                    replaceWord += currentWord.charAt(i);

                } else if (starpattern.charAt(i) != '*') {

                    replaceWord += currentWord.charAt(i);

                } else {

                    replaceWord += '*';

                }
                if (starpattern.equals(replaceWord)) {
                    status = 1;
                }

            }

            HangmanController.passName(replaceWord, status);
//        System.out.println(replaceWord);

        }

        replaceWord = "";

    }
    public void resetGuessArray()
    {
        guessString="";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.assignment.mvc.hangman;

/**
 *
 * @author kiran
 */
public class HangmanController {

    private static int count = 0;
    private static String replaceWord;
    private static int status = 0;

    public static void passName(String replaceWordd, int statuss) {
       
        HangmanView hangmanView = new HangmanView();
        replaceWord = replaceWordd;
        if (statuss == 1) {
            status++;

        } else if (statuss == 2) {
            count--;
            hangmanView.announceGuessExist();
        }
    }

    public static void main(String[] args) {
        int score = 0;
        int attempt = 0;

        String word;
        HangmanModel hangmanModel = new HangmanModel();
        HangmanView hangmanView = new HangmanView();

        do {
            count = 0;
            word = hangmanModel.getRandomWord();

            replaceWord = new String(new char[word.length()]).replace("\0", "*");
            hangmanView.printLevel(attempt,word.length());
            while (count < 9 && replaceWord.contains("*")) {
                hangmanView.checkGuess(status);
                hangmanView.input(replaceWord, count);

                count++;
            }

            if (count >= 10) {
                hangmanView.announceFailure(word);
                hangmanModel.remove();

            } else {
                hangmanView.announceSuccess(word);
                score++;
                hangmanView.announceScore(1, score);
                hangmanModel.remove();
            }
            attempt++;
            status = 0;
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            hangmanModel.resetGuessArray();
        } while (attempt < 9);
        hangmanView.announceScore(2, score);
        
    }

    public void recieveGuess(String guess) {
        HangmanModel hangModel = new HangmanModel();
        hangModel.hangman(guess, replaceWord);

    }

}

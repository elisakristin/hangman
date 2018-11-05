package com.example.elisa.hangman;

public class useLogic {

        public static void main(String[] args) {

            HangManLogic play = new HangManLogic();
            play.nulstil();

            play.logStatus();

            play.guessLetter("e");
            play.logStatus();

            play.guessLetter("a");
            play.logStatus();
            System.out.println("" + play.getNrOfWrongLetters());
            System.out.println("" + play.getVisibleLetters());
            if (play.isGameOver()) return;

            play.guessLetter("i");
            play.logStatus();
            if (play.isGameOver()) return;





        }
    }




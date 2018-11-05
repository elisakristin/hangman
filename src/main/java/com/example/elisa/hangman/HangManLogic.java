package com.example.elisa.hangman;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class HangManLogic {
    ArrayList<String> possibleWords = new ArrayList<String>();
    private String theWord;
    private ArrayList<String> usedLetters = new ArrayList<String>();
    private String visibleLetters;
    private int nrOfWrongLetters;
    private boolean latestLetterCorrect;
    private boolean gameWon;
    private boolean gameIsLost;



    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }

    public String getVisibleLetters() {
        return visibleLetters;
    }

    public String getTheWord() {
        return theWord;
    }

    public int getNrOfWrongLetters() {
        return nrOfWrongLetters;
    }

    public boolean erSidsteBogstavKorrekt() {
        return latestLetterCorrect;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean isGameIsLost() {
        return gameIsLost;
    }

    public boolean isGameOver() {
        return gameIsLost || gameWon;
    }

    public HangManLogic() {
        possibleWords.add("dog");
        possibleWords.add("flower");
        possibleWords.add("candle");
        possibleWords.add("christmas");
        possibleWords.add("tea");
        possibleWords.add("bookcase");
        possibleWords.add("alcoholic");
        possibleWords.add("dessertspoon");
        possibleWords.add("availability");
        possibleWords.add("kitten");
        possibleWords.add("chihuahua");
        nulstil();
    }
    public void nulstil() {
        usedLetters.clear();
        nrOfWrongLetters = 0;
        gameWon = false;
        gameIsLost = false;
        theWord = possibleWords.get(new Random().nextInt(possibleWords.size()));
        updateVisibleLetters();
    }

    /*public void updateImage(){
        if (nrOfWrongLetters == 1){
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.a1stwrong);

        } else if (nrOfWrongLetters == 2) {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.second);

        }else if (nrOfWrongLetters == 3){
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.a3rd);

        }else if(nrOfWrongLetters == 4 ){
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.a4th);

        }else if ( nrOfWrongLetters == 5){
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.a5th);

        }else if (nrOfWrongLetters == 6){
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.a6th);
        }
*/


    private void updateVisibleLetters() {
        visibleLetters = "";
        gameWon = true;
        for (int n = 0; n < theWord.length(); n++) {
            String letter = theWord.substring(n, n + 1);
            if (usedLetters.contains(letter)) {
                visibleLetters = visibleLetters + letter;
            } else {
                visibleLetters = visibleLetters + "*";
                gameWon = false;
            }
        }
    }

    public void guessLetter(String letter) {
        if (letter.length() != 1) return;

        if (usedLetters.contains(letter)) return;
        if (gameWon || gameIsLost) return;

        usedLetters.add(letter);

        if (theWord.contains(letter)) {
            latestLetterCorrect = true;
            System.out.println("Correct lettter: " + letter);
        } else {

            latestLetterCorrect = false;
            System.out.println("Wrong letter :( : " + letter);
            nrOfWrongLetters = nrOfWrongLetters + 1;


            if (nrOfWrongLetters >= 6) {
                gameIsLost = true;

            }
        }
        updateVisibleLetters();
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- The Word = " + theWord);
        System.out.println("- Visible letters = " + visibleLetters);
        System.out.println("- Wrong Letters = " + nrOfWrongLetters);
        System.out.println("- Used Letters = " + usedLetters);
        if (gameIsLost) System.out.println("- Game Over");
        if (gameWon) System.out.println("- You win!");
        System.out.println("---------- ");
    }



}

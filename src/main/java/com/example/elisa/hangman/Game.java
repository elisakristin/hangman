package com.example.elisa.hangman;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private Button guess;
    private EditText GuessLetter;
    private ImageView galgi;
    private TextView maintext;

    HangManLogic logic = new HangManLogic ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guess = (Button) findViewById(R.id.guess);
        GuessLetter = (EditText) findViewById(R.id.GuessLetter);

        guess.setOnClickListener(this);

        maintext = (TextView) findViewById(R.id.maintext);



       // ImageView img2 = new ImageView(this);
       // img2.setImageResource(R.drawable.a1stwrong);





    }

    @Override
    public void onClick(View v) {
            String letter = GuessLetter.getText().toString();
            if (letter.length() != 1) {
                GuessLetter.setError("Guess only 1 letter");
                return;
            }
            logic.guessLetter(letter);
            GuessLetter.setText("");
            GuessLetter.setError(null);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                guess.animate().rotationBy(3*360).setInterpolator(new DecelerateInterpolator());

            }
            updatescreen();
        }

    private void updatescreen() {


        maintext.setText(" Guess the word  " + logic.getVisibleLetters());

        maintext.append("\n\nYou have " + logic.getNrOfWrongLetters() + " Incorrect:" + logic.getUsedLetters());


        if (logic.isGameWon()) {
            maintext.append("\nYou won! Congratulations");
        }
        if (logic.isGameIsLost()) {
            maintext.setText("You lost :( the word was: " + logic.getTheWord());
        }

    }



}



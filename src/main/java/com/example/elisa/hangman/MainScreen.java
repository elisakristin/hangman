package com.example.elisa.hangman;

import android.content.Intent;
import android.drm.DrmStore;
import android.drm.DrmStore.Playback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

import android.widget.Button;

public class MainScreen extends AppCompatActivity implements OnClickListener {


    private  Button PlayGame;
    private  Button HighScore;
    private  Button Help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        PlayGame = (Button)findViewById(R.id.PlayGame);
        HighScore = (Button)findViewById(R.id.HighScore);
        Help = (Button)findViewById(R.id.help);

        PlayGame.setOnClickListener(this);
        HighScore.setOnClickListener(this);
        Help.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (v == Help) {

                Intent i = new Intent(this, Help.class);
                startActivity(i);

            } else if (v == HighScore) {

                Intent i = new Intent(this, HighScore.class);
                startActivity(i);

            } else if (v == PlayGame) {

                Intent i = new Intent(this, Game.class);

                startActivity(i);

            }
    }
}

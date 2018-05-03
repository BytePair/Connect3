package com.bytepair.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Team currentTeam;
    private int[] gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetGameState(null);
    }

    public void resetGameState(View view) {

        // reset moves
        gameState = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};

        // reset images
        resetImages();

        // set team randomly
        Random random = new Random();
        currentTeam = Team.values()[random.nextInt(Team.values().length)];
    }

    private void resetImages() {
        ImageView temp;
        temp = (ImageView) findViewById(R.id.square_0_0);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_0_1);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_0_2);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_1_0);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_1_1);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_1_2);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_2_0);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_2_1);
        temp.setImageResource(0);
        temp = (ImageView) findViewById(R.id.square_2_2);
        temp.setImageResource(0);
    }

    public void dropIn(View view) {

        // check if box has already been selected
        int tagNumber = Integer.parseInt(view.getTag().toString());
        if (gameState[tagNumber] != -1) {
            Toast.makeText(this, "Please select an empty square", Toast.LENGTH_SHORT).show();
            return;
        }

        // get view that was clicked on as ImageView
        ImageView box = (ImageView) view;

        // set image resource and drop in from above
        box.setTranslationY(-1200f);
        box.setImageResource(currentTeam.getResourceId());
        box.animate().translationYBy(1200).rotation(1080).setDuration(1000);

        // record the move
        gameState[tagNumber] = currentTeam.getTeamNumber();

        // switch teams
        switchTeams();
    }

    private void switchTeams() {
        currentTeam = Team.nextTeam(currentTeam);
    }
}

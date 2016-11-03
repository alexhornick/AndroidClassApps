/*Alex Hornick
* CSCI 4010 Assignment 5
* This Activity is where the user plays the Hog dice game.
* */

package com.alexhornick.hog;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PlayHog extends AppCompatActivity implements OnClickListener {

    //holds each players Total score.
    private int player1Total = 0;
    private int player2Total = 0;

    //The current users turn. Player 1 starts first
    private boolean player1Turn = true;
    private boolean player2Turn = false;

    //Holds which die were selected by the player.
    private boolean die1Selected = false;
    private boolean die2Selected = false;
    private boolean die3Selected = false;
    private boolean die4Selected = false;
    private boolean die5Selected = false;
    private boolean die6Selected = false;

    //values for each of the six die
    private int die1Value;
    private int die2Value;
    private int die3Value;
    private int die4Value;
    private int die5Value;
    private int die6Value;

    private final int WINNING_SCORE = 200; //score needed to win



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_hog);

        ImageView die1 = (ImageView) findViewById(R.id.die1);
        ImageView die2 = (ImageView) findViewById(R.id.die2);
        ImageView die3 = (ImageView) findViewById(R.id.die3);
        ImageView die4 = (ImageView) findViewById(R.id.die4);
        ImageView die5 = (ImageView) findViewById(R.id.die5);
        ImageView die6 = (ImageView) findViewById(R.id.die6);

        die1.setOnClickListener(this);
        die2.setOnClickListener(this);
        die3.setOnClickListener(this);
        die4.setOnClickListener(this);
        die5.setOnClickListener(this);
        die6.setOnClickListener(this);

        Button roll = (Button) findViewById(R.id.roll);

        //ALTERNATIVE LISTENER REQUIREMENT: (Anonymous inner class)
        roll.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(v.getId() == R.id.roll)
                                        {
                                            roll();
                                        }
                                    }
                                });


        Button newGame = (Button) findViewById(R.id.newGame);
        newGameListener gameListener = new newGameListener();
        newGame.setOnClickListener(gameListener);
    }

    @Override
    public void onClick(View v)
    {
        //Determines which die image was selected, sets its transparency and selects it to be rolled.
        if(v.getId() == R.id.die1)
        {
            ImageView die1 = (ImageView) findViewById(R.id.die1);
            setDiceTransparency(die1);
            selectDieForRoll(1);
        }

        else if(v.getId() == R.id.die2)
        {
            ImageView die2 = (ImageView) findViewById(R.id.die2);
            setDiceTransparency(die2);
            selectDieForRoll(2);
        }

        else if(v.getId() == R.id.die3)
        {
            ImageView die3 = (ImageView) findViewById(R.id.die3);
            setDiceTransparency(die3);
            selectDieForRoll(3);
        }

        else if(v.getId() == R.id.die4)
        {
            ImageView die4 = (ImageView) findViewById(R.id.die4);
            setDiceTransparency(die4);
            selectDieForRoll(4);
        }

        else if(v.getId() == R.id.die5)
        {
            ImageView die5 = (ImageView) findViewById(R.id.die5);
            setDiceTransparency(die5);
            selectDieForRoll(5);
        }

        else if(v.getId() == R.id.die6)
        {
            ImageView die6 = (ImageView) findViewById(R.id.die6);
            setDiceTransparency(die6);
            selectDieForRoll(6);
        }

    }

    //Rolls the selected dice, updates the screen, displays sum rolled and updates total.
    public void roll()
    {
        int drawable = R.drawable.die1;
        int dieSelected = 0; //determine if no dice were selected
        int randomDieNum = 1;
        boolean countSum = true; //if there are no ones, count the sum and add to total.

        if(die1Selected)
        {
            randomDieNum = generateRandomDie(); //gets a die from 1 to 6
            if(randomDieNum == 1) countSum = false; //if it's a one, then the sum won't need to be counted.
            die1Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die1 = (ImageView) findViewById(R.id.die1);
            die1.setImageResource(drawable);
            dieSelected++;
        }

        if(die2Selected)
        {
            randomDieNum = generateRandomDie();
            if(randomDieNum == 1) countSum = false;
            die2Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die2 = (ImageView) findViewById(R.id.die2);
            die2.setImageResource(drawable);
            dieSelected++;
        }

        if(die3Selected)
        {
            randomDieNum = generateRandomDie();
            if(randomDieNum == 1) countSum = false;
            die3Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die3 = (ImageView) findViewById(R.id.die3);
            die3.setImageResource(drawable);
            dieSelected++;
        }

        if(die4Selected)
        {
            randomDieNum = generateRandomDie();
            if(randomDieNum == 1) countSum = false;
            die4Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die4 = (ImageView) findViewById(R.id.die4);
            die4.setImageResource(drawable);
            dieSelected++;
        }

        if(die5Selected)
        {
            randomDieNum = generateRandomDie();
            if(randomDieNum == 1) countSum = false;
            die5Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die5 = (ImageView) findViewById(R.id.die5);
            die5.setImageResource(drawable);
            dieSelected++;
        }

        if(die6Selected)
        {
            randomDieNum = generateRandomDie();
            if(randomDieNum == 1) countSum = false;
            die6Value = randomDieNum;
            drawable = getDieDrawable(randomDieNum);
            ImageView die6 = (ImageView) findViewById(R.id.die6);
            die6.setImageResource(drawable);
            dieSelected++;
        }

        if(countSum && dieSelected > 0)
        {
            if(player1Turn)
            {
                EditText et = (EditText) findViewById(R.id.player1Total);
                int sum = findDiceSum();
                player1Total += sum;
                Toast.makeText(getApplicationContext(),"Player 1 rolled a sum of " + sum, Toast.LENGTH_SHORT).show();
                et.setText(Integer.toString(player1Total));
                if(player1Total >= WINNING_SCORE)
                {
                    endGame("player1");
                }
            }

            else if(player2Turn)
            {
                EditText et = (EditText) findViewById(R.id.player2Total);
                int sum = findDiceSum();
                player2Total += sum;
                Toast.makeText(getApplicationContext(),"Player 2 rolled a sum of " + sum, Toast.LENGTH_SHORT).show();
                et.setText(Integer.toString(player2Total));

                if(player2Total >= WINNING_SCORE)
                {
                    endGame("player2");
                }
            }

        }

        //when countSum is false, but dice were still selected.
        else if(!countSum && dieSelected > 0) {
            Toast.makeText(getApplicationContext(),"A 1 was rolled. Sum was 0", Toast.LENGTH_SHORT).show();
        }

        //Player must select at least one die.
        if(dieSelected == 0)
        {
            Toast.makeText(getApplicationContext(),"Please select at least one die", Toast.LENGTH_SHORT).show();

        }

        //Change to other player's turn.
        else {
            TextView player1Text = (TextView) findViewById(R.id.player1Text);
            TextView player2Text = (TextView) findViewById(R.id.player2Text);
            if (player1Turn) {
                player1Turn = false;
                player2Turn = true;
                player1Text.setBackgroundColor(Color.parseColor("#888888"));
                player2Text.setBackgroundColor(Color.parseColor("#84e184"));
            } else if (player2Turn) {
                player2Turn = false;
                player1Turn = true;
                player2Text.setBackgroundColor(Color.parseColor("#888888"));
                player1Text.setBackgroundColor(Color.parseColor("#84e184"));
            }

        }

        resetDiceTransparency(); //reset dice alpha values.
        resetSelected(); //make all diceSelected = false
    }

    //Called when a score reaches the winning score (200). Will display the winner.
    public void endGame(String winner)
    {
        TextView player1 = (TextView) findViewById(R.id.player1TotalText);
        player1.setText("");
        EditText player1Score = (EditText) findViewById(R.id.player1Total);
        player1Score.setVisibility(View.INVISIBLE);

        TextView player2 = (TextView) findViewById(R.id.player2TotalText);
        player2.setText("");
        EditText player2Score = (EditText) findViewById(R.id.player2Total);
        player2Score.setVisibility(View.INVISIBLE);

        player2.setTextSize(25);
        player2.setTypeface(Typeface.DEFAULT_BOLD);


        if(winner == "player1")
        {
            player2.setText("Player 1 wins!");
        }

        else {
            player2.setText("Player 2 wins!");
        }
    }

    //reset everything
    public void newGame()
    {
        player1Total = 0;
        player2Total = 0;
        player1Turn = true;
        player2Turn = false;

        TextView player1Text = (TextView) findViewById(R.id.player1Text);
        TextView player2Text = (TextView) findViewById(R.id.player2Text);

        player2Text.setBackgroundColor(Color.parseColor("#888888"));
        player1Text.setBackgroundColor(Color.parseColor("#84e184"));

        TextView player1 = (TextView) findViewById(R.id.player1TotalText);
        player1.setText("Player 1 Total");



        TextView player2 = (TextView) findViewById(R.id.player2TotalText);
        player2.setText("Player 2 Total");


        player2.setTextSize(18);
        player2.setTypeface(Typeface.DEFAULT);

        EditText player1Score = (EditText) findViewById(R.id.player1Total);
        player1Score.setText("0");
        player1Score.setVisibility(View.VISIBLE);
        EditText player2Score = (EditText) findViewById(R.id.player2Total);
        player2Score.setText("0");
        player2Score.setVisibility(View.VISIBLE);
    }


    public int findDiceSum()
    {
        int sum = 0;

        if(die1Selected)
        {
            sum += die1Value;
        }

        if(die2Selected)
        {
            sum += die2Value;
        }

        if(die3Selected)
        {
            sum += die3Value;
        }

        if(die4Selected)
        {
            sum += die4Value;
        }

        if(die5Selected)
        {
            sum += die5Value;
        }

        if(die6Selected)
        {
            sum += die6Value;
        }

        return sum;
    }


    public int getDieDrawable(int dieNum)
    {
        int drawable = R.drawable.die1;
        if(dieNum == 1)
            drawable = R.drawable.die1;
        else if(dieNum == 2)
        {
            drawable = R.drawable.die2;
        }

        else if(dieNum == 3)
        {
            drawable = R.drawable.die3;
        }

        else if(dieNum == 4)
        {
            drawable = R.drawable.die4;
        }

        else if(dieNum == 5)
        {
            drawable = R.drawable.die5;
        }

        else if(dieNum == 6)
        {
            drawable = R.drawable.die6;
        }

        return drawable;

    }


    public int generateRandomDie()
    {
        return (int)(6.0 * Math.random()) + 1;
    }


    public void selectDieForRoll(int dieNum)
    {
        if(dieNum == 1)
        {
            if(die1Selected)
                die1Selected = false;
            else
                die1Selected = true;
        }

        else if(dieNum == 2)
        {
            if(die2Selected)
                die2Selected = false;
            else
                die2Selected = true;
        }

        else if(dieNum == 3)
        {
            if(die3Selected)
                die3Selected = false;
            else
                die3Selected = true;
        }

        else if(dieNum == 4)
        {
            if(die4Selected)
                die4Selected = false;
            else
                die4Selected = true;
        }

        else if(dieNum == 5)
        {
            if(die5Selected)
                die5Selected = false;
            else
                die5Selected = true;
        }

        else if(dieNum == 6)
        {
            if(die6Selected)
                die6Selected = false;
            else
                die6Selected = true;
        }
    }


    public void setDiceTransparency(ImageView die)
    {
        float transparency = die.getAlpha();

        if(transparency == 1f)
        {
            die.setAlpha(0.4f);
        }

        else
            die.setAlpha(1f);
    }

    public void resetDiceTransparency()
    {
        float alphaValue = 0.4f;
        ImageView die1 = (ImageView) findViewById(R.id.die1);
        die1.setAlpha(alphaValue);

        ImageView die2 = (ImageView) findViewById(R.id.die2);
        die2.setAlpha(alphaValue);

        ImageView die3 = (ImageView) findViewById(R.id.die3);
        die3.setAlpha(alphaValue);

        ImageView die4 = (ImageView) findViewById(R.id.die4);
        die4.setAlpha(alphaValue);

        ImageView die5 = (ImageView) findViewById(R.id.die5);
        die5.setAlpha(alphaValue);

        ImageView die6 = (ImageView) findViewById(R.id.die6);
        die6.setAlpha(alphaValue);
    }

    public void resetSelected()
    {
        die1Selected = false;
        die2Selected = false;
        die3Selected = false;
        die4Selected = false;
        die5Selected = false;
        die6Selected = false;
    }

    //SECOND ALTERNATIVE LISTENER: INNER CLASS
    class newGameListener implements View.OnClickListener {
        @Override
        public void onClick(View v)
        {
            if(v.getId() == R.id.newGame)
            {
                newGame();
            }
        }
    }
}



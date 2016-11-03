/*Alex Hornick
* CSCI 4010 Assignment 5
* This Activity is the main screen.
* */


package com.alexhornick.hog;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutApp = (Button) findViewById(R.id.about);
        Button moreAbout = (Button) findViewById(R.id.moreAbout);
        Button playHog = (Button) findViewById(R.id.playHog);

        playHog.setOnClickListener(this);
        moreAbout.setOnClickListener(this);
        aboutApp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.about)
        {
            Intent intent = new Intent(getApplicationContext(), AboutApp.class);
            startActivity(intent);
        }

        else if(v.getId() == R.id.moreAbout)
        {
            String urlString = "https://en.wikipedia.org/wiki/Pig_%28dice_game%29";
            Uri uri = Uri.parse(urlString);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }

        else if(v.getId() == R.id.playHog)
        {
            Intent intent = new Intent(getApplicationContext(), PlayHog.class);
            startActivity(intent);
        }
    }
}




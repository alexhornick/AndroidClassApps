/*Alex Hornick
* CSCI 4010 Assignment 7
* This Activity is the Joke WebView screen.
* */

package com.alexhornick.jokecollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View.OnClickListener;


public class JokeWebView extends AppCompatActivity implements OnClickListener {

    private int zoomPercent = 100;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_web_view);

        Intent intent = getIntent();

        String fileName = intent.getStringExtra(MainActivity.JOKE_KEY);

        wv = (WebView) findViewById(R.id.webView);
        wv.loadUrl("file:///android_asset/"+fileName);

        Button zoom = (Button) findViewById(R.id.zoom);
        zoom.setOnClickListener(this);

        Button zoomOut = (Button) findViewById(R.id.zoomOut);
        zoomOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.zoom)
        {
            increaseTextZoom();
        }

        else if(v.getId() == R.id.zoomOut)
        {
            decreaseTextZoom();
        }
    }

    private void increaseTextZoom(){
        WebSettings settings = wv.getSettings();
        zoomPercent +=20;
        settings.setTextZoom(zoomPercent);
    }

    private void decreaseTextZoom(){
        WebSettings settings = wv.getSettings();
        zoomPercent -=20;
        settings.setTextZoom(zoomPercent);
    }
}

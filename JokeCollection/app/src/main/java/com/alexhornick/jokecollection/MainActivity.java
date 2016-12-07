/*Alex Hornick
* CSCI 4010 Assignment 7
* This Activity is the main screen.
* */

package com.alexhornick.jokecollection;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    public static final String JOKE_KEY = "joke";
    private final String JOKE1 = "Orange Joke";
    private final String JOKE2 = "Doctor Joke";
    private final String JOKE3 = "Hard Drive Joke";
    private final String JOKE4 = "Social Media Joke";
    private final String JOKE5 = "Password Joke";

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> jokes = readJokes();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jokes);

        setListAdapter(adapter);


    }

    private ArrayList<String> readJokes() {
        ArrayList<String> jokes = new ArrayList<>();

        jokes.add(JOKE1);
        jokes.add(JOKE2);
        jokes.add(JOKE3);
        jokes.add(JOKE4);
        jokes.add(JOKE5);
        return jokes;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String joke = (String) l.getItemAtPosition(position);
        Intent intent = new Intent(getApplicationContext(), JokeWebView.class);

        String jokeFile;
        if(joke.equals(JOKE1)){
            jokeFile = "joke1.html";
        }
        else if(joke.equals(JOKE2)){
            jokeFile = "joke2.html";
        }
        else if(joke.equals(JOKE3)){
            jokeFile = "joke3.html";
        }
        else if(joke.equals(JOKE4)){
            jokeFile = "joke4.html";
        }
        else if(joke.equals(JOKE5)){
            jokeFile = "joke5.html";
        }
        else {
            jokeFile = "joke1.html";
        }
        intent.putExtra(JOKE_KEY, jokeFile);

        startActivity(intent);
    }

   /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent intent = new Intent(getApplicationContext(), ManageNoteActivity.class);
            intent.putExtra(ACTION_KEY, "Add");
            startActivityForResult(intent, ADD_RESULT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


}

package com.example.andreasp.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    public void clickButton(View view) {
        switch(view.getId()){
            case R.id.menuButton:
                Intent menuIntent = new Intent(MainActivity.this, menu_Activity.class);
                startActivity(menuIntent);
                break;
            case  R.id.ProfileButton:
                Intent hoursIntent = new Intent(MainActivity.this, profile_activity.class);
                startActivity(hoursIntent);
                break;
            case R.id.eventsButton:
                Intent eventsIntent = new Intent(MainActivity.this, main_event_activity.class);
                startActivity(eventsIntent);
                break;
            case R.id.directionButton:
                Intent findUsIntent = new Intent(MainActivity.this, find_us.class);
                startActivity(findUsIntent);
                break;
            case R.id.MusicButton:
                Intent JukeBoxIntent = new Intent(MainActivity.this, music_player.class);
                startActivity(JukeBoxIntent);
                break;
            case R.id.DessertList:
                Intent DessertList = new Intent(MainActivity.this, dessert_list.class);
                startActivity(DessertList);
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

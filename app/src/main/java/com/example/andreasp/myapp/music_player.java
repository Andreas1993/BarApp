package com.example.andreasp.myapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class music_player extends AppCompatActivity implements SensorEventListener {

    MediaPlayer mp;
    SensorManager smanager;
    Sensor accelerometer;
    TextView xAxis,yAxis,zAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        mp = MediaPlayer.create(this, R.raw.arcofthesun1);

        xAxis = (TextView) findViewById(R.id.xAxis);
        yAxis = (TextView) findViewById(R.id.yAxis);
        zAxis = (TextView) findViewById(R.id.zAxis);

        smanager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = smanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume(){
        super.onResume();
        smanager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        smanager.unregisterListener(this);
    }



    public void playMusic (View v){

        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
            else{
            mp.start();
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xAxis.setText(String.format("%f", event.values[0]));
        yAxis.setText(String.format("%f", event.values[1]));
        zAxis.setText(String.format("%f", event.values[2]));

        if (event.values[0] > event.values[1] && event.values[0] > event.values[2]){
            mp.stop();
            mp.release();
            mp = null;
            mp = MediaPlayer.create(music_player.this, R.raw.arcofthesun1);
            mp.start();
        }
        if (event.values[1] > event.values[0] && event.values[1] > event.values[2]){
            mp.stop();
            mp.release();
            mp = null;
            mp = MediaPlayer.create(music_player.this, R.raw.coalminingblues2);
            mp.start();
        }
        if (event.values[2] > event.values[0] && event.values[2] > event.values[1]){
            mp.stop();
            mp.release();
            mp = null;
            mp = MediaPlayer.create(music_player.this, R.raw.yellowmoon3);
            mp.start();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

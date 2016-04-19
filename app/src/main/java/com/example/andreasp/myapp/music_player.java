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
    TextView xAxis,yAxis,zAxis,CurrentSong;
    long lastUpdate;
    int Songs[];
    int SongNumber;
    int SongShift = 1000;
    float xFirst, yFirst, zFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        mp = MediaPlayer.create(this, R.raw.arcofthesun1);

        Songs = new int[]{R.raw.arcofthesun1,R.raw.coalminingblues2,R.raw.yellowmoon3};

        xAxis = (TextView) findViewById(R.id.xAxis);
        yAxis = (TextView) findViewById(R.id.yAxis);
        zAxis = (TextView) findViewById(R.id.zAxis);
        CurrentSong = (TextView) findViewById(R.id.CurrentSong);

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

    public void stopMusicButton (View v){
        mp.stop();
        mp.release();
        mp = null;
    }

    public void stopMusic (){
            mp.stop();
            mp.release();
            mp = null;
    }


    public void playMusic (){
            stopMusic();
            mp = MediaPlayer.create(music_player.this, Songs[SongNumber]);
            mp.start();
        }


    @Override
    public void onSensorChanged(SensorEvent event) {
        xAxis.setText(String.format("%f", event.values[0]));
        yAxis.setText(String.format("%f", event.values[1]));
        zAxis.setText(String.format("%f", event.values[2]));

        long curTime = System.currentTimeMillis();
        // only allow one update every 100ms.
        if ((curTime - lastUpdate) > 100) {
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float Shake = Math.abs(x + y + z - xFirst - yFirst - zFirst)/diffTime * 10000;

            if (Shake > SongShift) {
                if (event.values[0] > event.values[1] && event.values[0] > event.values[2]) {
                    SongNumber = 0;
                    playMusic();

                }
                if (event.values[1] > event.values[0] && event.values[1] > event.values[2]) {
                    SongNumber = 1;
                    playMusic();
                }
                if (event.values[2] > event.values[0] && event.values[2] > event.values[1]) {
                    SongNumber = 2;
                    playMusic();
                }
            }

            xFirst = x;
            yFirst = y;
            zFirst = z;
        }}



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

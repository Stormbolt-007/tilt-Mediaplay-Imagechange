package com.example.asus.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ImageView i1;
    MediaPlayer mp;
    Sensor s;
    SensorManager sm;
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=(ImageView)findViewById(R.id.imageView);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        mp=MediaPlayer.create(this,R.raw.flutesong);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        String s1 = Integer.toString(x1);
        String s2 = Integer.toString(y1);
        String s3 = Integer.toString(z1);
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);


        if(x1!=0){
            mp.start();
            i1.setImageResource(R.drawable.onn);
        }
        else{
            mp.pause();
            i1.setImageResource(R.drawable.off);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

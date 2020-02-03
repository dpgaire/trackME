package com.dpgv1.trackme.Sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

import com.dpgv1.trackme.R;

import java.util.EventListener;

public class GyroscopeSensor extends AppCompatActivity {

    ImageView viewProfile;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_sensor);
        viewProfile=findViewById(R.id.viewProfile);





    }
//    public void ViewPhotoSensor(){
//        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
//        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
//
//    }
}

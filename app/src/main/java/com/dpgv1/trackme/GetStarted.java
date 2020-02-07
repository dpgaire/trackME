package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class GetStarted extends AppCompatActivity  {


Button getStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
               getStarted=findViewById(R.id.btngetStarted);
        wifiConectedDisconnected();
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GetStarted.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

    public void wifiConectedDisconnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo network=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifi.isConnected()){
            Toast.makeText(this, "Wifi Connected", Toast.LENGTH_LONG).show();
        }else if(network.isConnected()){
            Toast.makeText(this, "Internet is not available", Toast.LENGTH_LONG).show();
        }
    }
    }

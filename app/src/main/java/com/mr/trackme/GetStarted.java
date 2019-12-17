package com.mr.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class GetStarted extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    private Button btnGateStarted;
    private Spinner SpUserType;
    private String userType[]={"Select User Type","Trustable","Requestable"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(GetStarted.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);



//        btnGateStarted=findViewById(R.id.gatestarted);
//        Spinner spinner =(Spinner) findViewById(R.id.spUserType);
//        spinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.activity_list_item,userType);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        SpUserType.setAdapter(aa);



    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

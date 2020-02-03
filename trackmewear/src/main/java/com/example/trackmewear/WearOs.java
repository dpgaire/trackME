package com.example.trackmewear;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WearOs extends WearableActivity {

    private TextView mTextView;
    EditText username,password;
    Button login;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_os);

        username=findViewById(R.id.etusernameloginwearos);
        password=findViewById(R.id.etPasswordLoginwearos);
        login=findViewById(R.id.btnLoginwearos);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
    private void Login(){
        String Username,Password;
        Username=username.getText().toString();
        Password=password.getText().toString();

        if(Username.equals("admin") && Password.equals("admin")){
            Toast.makeText(this, "Login sucessful", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(WearOs.this,WearDashboard.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

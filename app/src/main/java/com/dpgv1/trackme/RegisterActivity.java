package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    private TextView backToLogin;
    private EditText firstName, lastName, address, username, password;
    private Button Register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        backToLogin = findViewById(R.id.etBacktoLogin);
        firstName = findViewById(R.id.etfirstname);
        lastName = findViewById(R.id.etlastname);
        address = findViewById(R.id.etaddress);
        Register = findViewById(R.id.btnRegister);
        username = findViewById(R.id.etusernameReg);
        password = findViewById(R.id.etPasswordReg);
        validation();
        GyroscopeSensor();
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void binding() {
        backToLogin = findViewById(R.id.etBacktoLogin);
        firstName = findViewById(R.id.etfirstname);
        lastName = findViewById(R.id.etlastname);
        address = findViewById(R.id.etaddress);
        Register = findViewById(R.id.btnRegister);
        username = findViewById(R.id.etusernameReg);
        password = findViewById(R.id.etPasswordReg);

    }

    public void validation() {
        if (TextUtils.isEmpty(firstName.getText().toString())) {
            firstName.setError("Please enter firstname");
            firstName.requestFocus();

        }
        if (TextUtils.isEmpty(lastName.getText().toString())) {
            lastName.setError("Please enter lastname");
            lastName.requestFocus();

        }
        if (TextUtils.isEmpty(address.getText().toString())) {
            address.setError("Please enter address");
            address.requestFocus();

        }
        if (TextUtils.isEmpty(username.getText().toString())) {
            username.setError("Please enter username");
            username.requestFocus();

        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Please enter password");
            password.requestFocus();

        }
    }


    public void register(){


            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();
            String Address=address.getText().toString();
            String userName = username.getText().toString();
            String Password = password.getText().toString();

            User users = new User(fname, lname,Address,userName, Password);

            UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
            Call<LoginSignUpResponse> signUpCall = usersAPI.registerUser(users);

            signUpCall.enqueue(new Callback<LoginSignUpResponse>() {
                @Override
                public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    public void GyroscopeSensor(){
        SensorManager sensorManager=(SensorManager) getSystemService( Context.SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[2]>0.5f){
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if (event.values[2]<-0.5f){
                    Toast.makeText(RegisterActivity.this, "Right tilt", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    }



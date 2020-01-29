package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
private TextView etRegister;
private EditText Username,password;
private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=findViewById(R.id.etusernamelogin);
        password=findViewById(R.id.etPasswordLogin);
        Login=findViewById(R.id.btnLogin);
        etRegister=findViewById(R.id.ettRegister);
        validation();
        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
//    public void binding(){
//        Username=findViewById(R.id.etusernamelogin);
//        password=findViewById(R.id.etPasswordLogin);
//        Login=findViewById(R.id.btnLogin);
//        etRegister=findViewById(R.id.ettRegister);
//
//    }

    public void validation(){

    }
    public void login(){

    }

}

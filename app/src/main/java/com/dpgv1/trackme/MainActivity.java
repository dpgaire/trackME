package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.BLL.LoginBLL;
import com.dpgv1.trackme.StrickMode.StrickMode;


public class MainActivity extends AppCompatActivity {
private TextView etRegister;
private EditText Username,password;
private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();
        validation();
        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void binding(){
        Username=findViewById(R.id.etusernamelogin);
        password=findViewById(R.id.etPasswordLogin);
        btnLogin=findViewById(R.id.btnLogin);
        etRegister=findViewById(R.id.ettRegister);

    }

    public void validation(){
        if (TextUtils.isEmpty(Username.getText().toString())) {
            Username.setError("Please enter username");
            Username.requestFocus();

        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Please enter password");
            password.requestFocus();

        }
    }
    public void login(){
        String userName = Username.getText().toString();
        String Password = password.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrickMode.StrictMode();
        if (loginBLL.checkUser(userName, Password)) {
            Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_LONG).show();
            Username.requestFocus();
        }


    }

}

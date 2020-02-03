package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.StrickMode.StrickMode;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.UserLogin;
import com.dpgv1.trackme.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        UserLogin userLogin=new UserLogin(userName,Password);
        StrickMode.StrictMode();
        UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
        Call<LoginSignUpResponse> loginCall = usersAPI.loginUser(userLogin);
//        if (loginBLL.checkUser(userName, Password)) {
//            Intent intent=new Intent(MainActivity.this, Example.class);
//            startActivity(intent);
//            finish();

//        } else {
//            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_LONG).show();
//            Username.requestFocus();
//        }
        loginCall.enqueue(new Callback<LoginSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}

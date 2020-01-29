package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity {

  private  TextView backToLogin;
  private EditText firstName,lastName,address,username,password;
  private Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        backToLogin=findViewById(R.id.etBacktoLogin);
        firstName=findViewById(R.id.etfirstname);
        lastName=findViewById(R.id.etlastname);
        address=findViewById(R.id.etaddress);
        Register=findViewById(R.id.btnRegister);
        username=findViewById(R.id.etusernameReg);
        password=findViewById(R.id.etPasswordReg);

        validation();

      backToLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
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
    public void binding(){
        backToLogin=findViewById(R.id.etBacktoLogin);
        firstName=findViewById(R.id.etfirstname);
        lastName=findViewById(R.id.etlastname);
        address=findViewById(R.id.etaddress);
        Register=findViewById(R.id.btnRegister);
        username=findViewById(R.id.etusernameReg);
        password=findViewById(R.id.etPasswordReg);

    }
    public void validation(){
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
//       UserAPI userAPI;
//        userAPI = Url.getInstance().create(UserAPI.class);

    }
}

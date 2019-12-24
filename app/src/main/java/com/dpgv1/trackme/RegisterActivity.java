package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

  private  TextView email,password;
  private Button Register,GoogleSignUp;
  private FirebaseAuth auth;
    private Object AuthResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //get firebase auth get instance.


        TextView tvlogin=findViewById(R.id.txtLogin);
        email=findViewById(R.id.etemail);
        password=findViewById(R.id.etpassword);
        Register=findViewById(R.id.btnRegister);
        //GoogleSignUp=findViewById(R.id.sign_in_button);


        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            final String Email=email.getText().toString().trim();
            final String Password=password.getText().toString().trim();
            auth=FirebaseAuth.getInstance();

            auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Register SUcessfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(intent);



                    }else if(!task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_SHORT).show();

                    }

                }
            });

            }

        });
    }
}

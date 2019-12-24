package com.dpgv1.trackme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.ui.dashboard.DashboardFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private TextView etRegister;
private EditText email,password;
private Button Login;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.etEmailLogin);
        etRegister=findViewById(R.id.txtRegister);
        password=findViewById(R.id.etPasswordLogin);
        Login=findViewById(R.id.btnlogin);
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
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();

                auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this, Dashboard.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });

    }
}

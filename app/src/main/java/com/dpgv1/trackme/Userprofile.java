package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Userprofile extends AppCompatActivity {

   TextView FirstName,LastName,PhoneNumber,Address,Username;
   Button btnUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        FirstName=findViewById(R.id.firstNameu);
        LastName=findViewById(R.id.LastNameU);
        PhoneNumber=findViewById(R.id.phoneNumberU);
        Address=findViewById(R.id.addressU);
        Username=findViewById(R.id.UsernameU);
        btnUpdateProfile=findViewById(R.id.btnUpdateProfile);

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

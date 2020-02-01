package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFriend extends AppCompatActivity {

    EditText FirstName,LastName,PhoneNumber;
    Button btnAddFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        binding();
        validation();
        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addfriend();
            }
        });
    }


    private void binding(){
        FirstName=findViewById(R.id.etfirstnamea);
        LastName=findViewById(R.id.etlastnamea);
        PhoneNumber=findViewById(R.id.etphonenumbera);
        btnAddFriend=findViewById(R.id.btnAddFriend);
    }
    private void validation(){
        if (TextUtils.isEmpty(FirstName.getText().toString())) {
            FirstName.setError("Please enter firstname");
            FirstName.requestFocus();

        }
        if (TextUtils.isEmpty(LastName.getText().toString())) {
            LastName.setError("Please enter lastname");
            LastName.requestFocus();

        }
        if (TextUtils.isEmpty(PhoneNumber.getText().toString())) {
            PhoneNumber.setError("Please enter Phone Number");
            PhoneNumber.requestFocus();

        }
    }
    private void addfriend(){

    }
}

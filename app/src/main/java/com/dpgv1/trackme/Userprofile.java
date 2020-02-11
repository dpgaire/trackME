package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.StrickMode.StrickMode;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.url.Url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Userprofile extends AppCompatActivity {

    CircleImageView profilePicture;
   TextView FirstName,LastName,Address,Username;
   Button btnUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        ViewDetails();
        FirstName=findViewById(R.id.firstNameu);
        LastName=findViewById(R.id.LastNameU);
        Address=findViewById(R.id.addressU);
        profilePicture=findViewById(R.id.imageProfile);
        Username=findViewById(R.id.UsernameU);
        btnUpdateProfile=findViewById(R.id.btnUpdateProfile);

        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowserImage();
            }
        });
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Userprofile.this,UpdateProfile.class);
                startActivity(intent);
            }
        });

    }

    private void BrowserImage() {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }
    private void ViewDetails(){
        UserAPI userAPI= Url.getInstance().create(UserAPI.class);
        Call<User> userCall=userAPI.getUserDetails(Url.token);
        StrickMode.StrictMode();
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Userprofile.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    FirstName.setText(response.body().getFirstName());
                    LastName.setText(response.body().getLastName());
                    Address.setText(response.body().getAddress());
                    Username.setText(response.body().getUsername());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Userprofile.this, "Failed to load profile", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

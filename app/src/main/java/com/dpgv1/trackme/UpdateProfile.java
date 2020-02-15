package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.StrickMode.StrickMode;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.url.Url;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfile extends AppCompatActivity {

    EditText FirstName,LastName,Username, etAddress;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        FirstName=findViewById( R.id.firstNameupdate );
        LastName=findViewById( R.id.lastnameupdate );
        etAddress =findViewById( R.id.addressupdate );
        Username=findViewById( R.id.usernameupdate );
        btnUpdate=findViewById( R.id.btnUpdate );
        ViewDetails();

        btnUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        } );


    }
    private void ViewDetails(){
        UserAPI userAPI= Url.getInstance().create(UserAPI.class);
        Call<User> userCall=userAPI.getUserDetails(Url.token);
        StrickMode.StrictMode();
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(UpdateProfile.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    FirstName.setText(response.body().getFirstName());
                    LastName.setText(response.body().getLastName());
                    etAddress.setText(response.body().getAddress());
                    Username.setText(response.body().getUsername());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(UpdateProfile.this, "Failed to load profile", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateProfile(){
        String fname = FirstName.getText().toString();
        String lname = LastName.getText().toString();
        final String address = etAddress.getText().toString();
        String userName = Username.getText().toString();

        User users = new User(fname, lname,address,userName,"");
        UserAPI userAPI= Url.getInstance().create(UserAPI.class);
        Call<LoginSignUpResponse> userUpdateCall=userAPI.getAlluserDetails(Url.token,users);
        StrickMode.StrictMode();
        userUpdateCall.enqueue( new Callback<LoginSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(UpdateProfile.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText( UpdateProfile.this, "Success", Toast.LENGTH_SHORT ).show();

                }
            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText( UpdateProfile.this, "error", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

}

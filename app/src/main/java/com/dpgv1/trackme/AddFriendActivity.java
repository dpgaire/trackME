package com.dpgv1.trackme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.AddFriendAPI;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.model.CreateChannel;
import com.dpgv1.trackme.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFriendActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    EditText FirstName, LastName, PhoneNumber;
    Button btnAddFriend;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_friend );
        notificationManagerCompat = NotificationManagerCompat.from( this );
        CreateChannel channel = new CreateChannel( this );
        channel.createChannel();
        binding();
        validation();
        btnAddFriend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addfriend();
                DisplayNotification();
            }
        } );
    }


    private void binding() {
        FirstName = findViewById( R.id.etfirstnamea );
        LastName = findViewById( R.id.etlastnamea );
        PhoneNumber = findViewById( R.id.etphonenumbera );
        btnAddFriend = findViewById( R.id.btnAddFriend );
    }

    private void validation() {
        if (TextUtils.isEmpty( FirstName.getText().toString() )) {
            FirstName.setError( "Please enter firstname" );
            FirstName.requestFocus();

        }
        if (TextUtils.isEmpty( LastName.getText().toString() )) {
            LastName.setError( "Please enter lastname" );
            LastName.requestFocus();

        }
        if (TextUtils.isEmpty( PhoneNumber.getText().toString() )) {
            PhoneNumber.setError( "Please enter Phone Number" );
            PhoneNumber.requestFocus();

        }
    }

    private void addfriend() {
        String fname = FirstName.getText().toString();
        String lname = LastName.getText().toString();
        String phonenumber = PhoneNumber.getText().toString();

        AddFriend userfriend = new AddFriend( fname, lname, phonenumber );

        AddFriendAPI addFriendAPI = Url.getInstance().create( AddFriendAPI.class );
        Call<LoginSignUpResponse> addFcall = addFriendAPI.addFriend( userfriend );


        addFcall.enqueue( new Callback<LoginSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText( AddFriendActivity.this, "Code " + response.code(), Toast.LENGTH_LONG ).show();
                    return;
                }
                Toast.makeText( AddFriendActivity.this, "Friend Sucessfully added", Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( AddFriendActivity.this, FriendActivity.class );
                startActivity( intent );
                finish();

            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText( AddFriendActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG ).show();
            }
        } );


    }

    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder( this, CreateChannel.CHANNEL_1 )

                .setSmallIcon( R.drawable.ic_message_black_24dp )
                .setContentTitle( "Friend Added" )
                .setContentText( "You added new Friend" )
                .setCategory( NotificationCompat.CATEGORY_MESSAGE )
                .build();
        notificationManagerCompat.notify( 1, notification );
    }
}

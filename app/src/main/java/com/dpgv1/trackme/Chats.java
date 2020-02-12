package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.adapter.AddFriendAdapter;
import com.dpgv1.trackme.adapter.MessageAdapter;
import com.dpgv1.trackme.api.MessageAPI;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.model.Message;
import com.dpgv1.trackme.url.RunActivity;
import com.dpgv1.trackme.url.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chats extends AppCompatActivity {
    EditText textMessage;
    ImageButton SendButton;
    Toolbar toolbar;
    List<Message> messagelist = new ArrayList<>();
    RecyclerView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getSupportActionBar().hide();
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView( R.layout.activity_chats );
        textMessage = findViewById( R.id.editTextSendMesage );
        messageView = findViewById( R.id.recMessageView );
        messageView.setLayoutManager( new LinearLayoutManager( this ) );
        toolbar = findViewById( R.id.toolbarm );
        SendButton = findViewById( R.id.sendMessageButton );
        seenMessage();
        SendButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        } );
        toolbar.setOnMenuItemClickListener( new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAbout:
                        Intent intent = new Intent( Chats.this, Userprofile.class );
                        startActivity( intent );
                        finish();
                        break;
                }
                return true;
            }
        } );


    }

    private void sendMessage() {
        String tMessage;
        tMessage = textMessage.getText().toString();
        Message msg = new Message( tMessage );

        MessageAPI messageAPI = Url.getInstance().create( MessageAPI.class );
        Call<LoginSignUpResponse> messageCall = messageAPI.sendMessage( Url.token, msg );
        messageCall.enqueue( new Callback<LoginSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText( Chats.this, "Code " + response.code(), Toast.LENGTH_LONG ).show();
                    return;
                }
                Toast.makeText( Chats.this, "Message sent", Toast.LENGTH_LONG ).show();

                MessageAdapter messageAdapter = new MessageAdapter( getApplicationContext(), messagelist );
                messageView.setAdapter( messageAdapter );
                messageView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
                Intent intent = new Intent( Chats.this, Chats.class );
                startActivity( intent );
                finish();
            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText( Chats.this, "Message failed", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    private void seenMessage() {


        MessageAPI messageAPI = Url.getInstance().create( MessageAPI.class );
        Call<List<Message>> listCall = messageAPI.getMessage( Url.token );
        listCall.enqueue( new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText( Chats.this, "Error", Toast.LENGTH_SHORT ).show();
                    return;
                } else {
                    List<Message> messages = response.body();
                    MessageAdapter messageAdapter = new MessageAdapter( Chats.this, messages );
                    messageView.setAdapter( messageAdapter );
                    messageView.setLayoutManager( new LinearLayoutManager( Chats.this ) );
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText( Chats.this, "Message failed", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    private void viewProfile() {
//    Userprofile userprofile=new Userprofile()
    }

}

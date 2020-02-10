package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
    List<Message> messagelist=new ArrayList<>();
RecyclerView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        textMessage=findViewById(R.id.editTextSendMesage);
        messageView=findViewById(R.id.recMessageView);
        toolbar=findViewById(R.id.toolbarm);
        SendButton=findViewById(R.id.sendMessageButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
       toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.navigation_notifications1:
                       Intent intent = new Intent(Chats.this, Userprofile.class);
                       startActivity(intent);
                       finish();
                       break;
               }
               return true;
           }
       });



    }

    private void sendMessage(){
        String btnSend;
        btnSend=textMessage.getText().toString();
        Message message=new Message( btnSend);
        MessageAPI messageAPI= Url.getInstance().create(MessageAPI.class);
        Call<LoginSignUpResponse> messageCall = messageAPI.sendMessage(message);
        messageCall.enqueue(new Callback<LoginSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Chats.this, "Code " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(Chats.this, "Message sent", Toast.LENGTH_LONG).show();

                MessageAdapter messageAdapter =new MessageAdapter(getApplicationContext(),messagelist);
                messageView.setAdapter(messageAdapter);
                messageView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText(Chats.this, "Message failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void viewProfile(){

    }

}

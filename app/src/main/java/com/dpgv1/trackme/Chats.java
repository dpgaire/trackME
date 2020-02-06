package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.MessageAPI;
import com.dpgv1.trackme.model.Message;
import com.dpgv1.trackme.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chats extends AppCompatActivity {
EditText textMessage;
ImageView SendButton;
RecyclerView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        textMessage=findViewById(R.id.editTextSendMesage);
        messageView=findViewById(R.id.recMessageView);
        SendButton=findViewById(R.id.sendMessageButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
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
            }

            @Override
            public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {
                Toast.makeText(Chats.this, "Message failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

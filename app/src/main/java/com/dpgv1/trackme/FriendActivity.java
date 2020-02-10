package com.dpgv1.trackme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.adapter.AddFriendAdapter;
import com.dpgv1.trackme.api.AddFriendAPI;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.url.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendActivity extends AppCompatActivity implements AddFriendAdapter.AddFriendListenner {
    Context context;
TextView FirstName,LastName,PhoneNumber;
RecyclerView recyclerView;
AddFriendAdapter addFriendAdapter;
AddFriendAdapter.AddFriendListenner addFriendListenner;
List<AddFriend> addFriendList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        FirstName=findViewById(R.id.etFnameaddFriend);
        recyclerView=findViewById(R.id.recyclerViewlistfried);
        LastName=findViewById(R.id.etLastnaddFriend);
        PhoneNumber=findViewById(R.id.etPhonenaddFriend);
        context = this;

        AddFriendAPI addFriendAPI= Url.getInstance().create(AddFriendAPI.class);
        Call<List<AddFriend>> addfriendCall=addFriendAPI.getFriend();

        addfriendCall.enqueue(new Callback<List<AddFriend>>() {
            @Override
            public void onResponse(Call<List<AddFriend>> call, Response<List<AddFriend>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(FriendActivity.this, "Code " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                addFriendList=response.body();
                Object addFriendListenener;
                addFriendAdapter=new AddFriendAdapter(context,addFriendList,addFriendListenner);
                recyclerView.setAdapter(addFriendAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<AddFriend>> call, Throwable t) {
                Toast.makeText(FriendActivity.this, "Failed to view friend list", Toast.LENGTH_SHORT).show();
            }
        });

//        FirstName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(FriendActivity.this,Chats.class);
//            }
//        });
    }

    @Override
    public void OnAddFreindClick(int position) {
        Intent intent=new Intent(FriendActivity.this,Chats.class);
        startActivity(intent);
    }
//    private void binding(){
//    FirstName=findViewById(R.id.etFnameaddFriend);
//    recyclerView=findViewById(R.id.recyclerViewlistfried);
//    LastName=findViewById(R.id.etLastnaddFriend);
//    PhoneNumber=findViewById(R.id.etPhonenaddFriend);
//
//
//    }

}

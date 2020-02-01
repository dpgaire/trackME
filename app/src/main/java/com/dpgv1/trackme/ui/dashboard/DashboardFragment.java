package com.dpgv1.trackme.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dpgv1.trackme.R;
import com.dpgv1.trackme.adapter.AddFriendAdapter;
import com.dpgv1.trackme.api.AddFriendAPI;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.url.Url;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {


    RecyclerView recyclerView;
    List<AddFriend> addFriendList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = view.findViewById(R.id.friendlistrecyclerview);
        AddFriendAPI addFriendAPI = Url.getInstance().create(AddFriendAPI.class);
        Call<List<AddFriend>> listCall = addFriendAPI.getFriend();
        listCall.enqueue(new Callback<List<AddFriend>>() {
            @Override
            public void onResponse(Call<List<AddFriend>> call, Response<List<AddFriend>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code Error" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                addFriendList = response.body();
                AddFriendAdapter addFriendAdapter=new AddFriendAdapter(getActivity(),addFriendList);
                recyclerView.setAdapter(addFriendAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<List<AddFriend>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
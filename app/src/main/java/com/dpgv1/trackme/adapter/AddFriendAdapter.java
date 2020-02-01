package com.dpgv1.trackme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dpgv1.trackme.R;
import com.dpgv1.trackme.model.AddFriend;

import java.util.List;

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.AddFriendViewHolder> {

    Context context;
    List<AddFriend> addFriendListList;
    public AddFriendAdapter(Context context, List<AddFriend> addFriendListList) {
        this.context = context;
        this.addFriendListList = addFriendListList;
    }
    @NonNull
    @Override
    public AddFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_add_friend,parent,false);
        return new AddFriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddFriendViewHolder holder, int position) {
        AddFriend addFriend=addFriendListList.get(position);
        holder.Fname.setText(addFriend.getFirstName());
        holder.Lname.setText(addFriend.getLastName());
        holder.pNumber.setText(addFriend.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return addFriendListList.size();
    }

    public class AddFriendViewHolder extends RecyclerView.ViewHolder {

        TextView Fname,Lname,pNumber;

        public AddFriendViewHolder(@NonNull View itemView) {
            super(itemView);
            Fname=itemView.findViewById(R.id.etFnaddFriend);
            Lname=itemView.findViewById(R.id.etLnaddFriend);
            pNumber=itemView.findViewById(R.id.etPnaddFriend);
        }

    }
}

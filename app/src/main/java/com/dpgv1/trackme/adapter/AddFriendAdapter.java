package com.dpgv1.trackme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dpgv1.trackme.AddFriendActivity;
import com.dpgv1.trackme.R;
import com.dpgv1.trackme.model.AddFriend;

import org.w3c.dom.Text;

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
                .inflate(R.layout.friendlist,parent,false);
        return new AddFriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddFriendViewHolder holder, int position) {
        AddFriend aFriend=addFriendListList.get(position);
        holder.Fname.setText(aFriend.getFirstName());
        holder.Lname.setText(aFriend.getLastName());
        holder.pNumber.setText(aFriend.getPhoneNumber());
        holder.invitefrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddFriendActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return addFriendListList.size();

    }

    public class AddFriendViewHolder extends RecyclerView.ViewHolder {

        TextView Fname,Lname,pNumber,invitefrn;

        public AddFriendViewHolder(@NonNull View itemView) {
            super(itemView);
            Fname=itemView.findViewById(R.id.etFnameaddFriend);
            Lname=itemView.findViewById(R.id.etLastnaddFriend);
            pNumber=itemView.findViewById(R.id.etPhonenaddFriend);
            invitefrn=itemView.findViewById(R.id.invitefrn);
        }

    }
}

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
import com.dpgv1.trackme.Chats;
import com.dpgv1.trackme.R;
import com.dpgv1.trackme.model.AddFriend;

import org.w3c.dom.Text;

import java.util.List;

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.AddFriendViewHolder> {


    Context context;
    List<AddFriend> addFriendListList;
    private AddFriendListenner mAddfriendListener;

    public AddFriendAdapter(Context context, List<AddFriend> addFriendListList, AddFriendListenner addFriendListenner) {
        this.context = context;
        this.addFriendListList = addFriendListList;
        this.mAddfriendListener = addFriendListenner;
    }

    @NonNull
    @Override
    public AddFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.friendlist, parent, false );
        return new AddFriendViewHolder( view, mAddfriendListener );
    }

    @Override
    public void onBindViewHolder(@NonNull AddFriendViewHolder holder, int position) {
        AddFriend aFriend = addFriendListList.get( position );
        holder.Fname.setText( aFriend.getFirstName() );
        holder.Lname.setText( aFriend.getLastName() );
        holder.pNumber.setText( aFriend.getPhoneNumber() );
        holder.Fname.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, Chats.class );
                context.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return addFriendListList.size();

    }

    public class AddFriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Fname, Lname, pNumber, invitefrn;
        AddFriendListenner addFriendListenner;

        public AddFriendViewHolder(@NonNull View itemView, AddFriendListenner addFriendListenner) {
            super( itemView );
            Fname = itemView.findViewById( R.id.etFnameaddFriend );
            Lname = itemView.findViewById( R.id.etLastnaddFriend );
            pNumber = itemView.findViewById( R.id.etPhonenaddFriend );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            addFriendListenner.OnAddFreindClick( getAdapterPosition() );
        }


    }

    public interface AddFriendListenner {
        void OnAddFreindClick(int position);
    }
}

package com.dpgv1.trackme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dpgv1.trackme.AddFriendActivity;
import com.dpgv1.trackme.Chats;
import com.dpgv1.trackme.FriendActivity;
import com.dpgv1.trackme.R;
import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.AddFriendAPI;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.url.Url;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final AddFriend aFriend = addFriendListList.get( position );
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

        holder.button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriendAPI api = Url.getInstance().create( AddFriendAPI.class );
                Call<LoginSignUpResponse> call = api.deletefriend( Url.token,aFriend.get_id() );
                call.enqueue( new Callback<LoginSignUpResponse>() {
                    @Override
                    public void onResponse(Call<LoginSignUpResponse> call, Response<LoginSignUpResponse> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText( context, "Error", Toast.LENGTH_SHORT ).show();
                        }else {
                            Toast.makeText( context, "Deleted", Toast.LENGTH_SHORT ).show();
                            Intent intent = new Intent( context, FriendActivity.class );
                            intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                            context.startActivity( intent );
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginSignUpResponse> call, Throwable t) {

                    }
                } );



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
        Button button;

        public AddFriendViewHolder(@NonNull View itemView, AddFriendListenner addFriendListenner) {
            super( itemView );
            Fname = itemView.findViewById( R.id.etFnameaddFriend );
            Lname = itemView.findViewById( R.id.etLastnaddFriend );
            pNumber = itemView.findViewById( R.id.etPhonenaddFriend );
            button = itemView.findViewById( R.id.deletebutton1 );

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

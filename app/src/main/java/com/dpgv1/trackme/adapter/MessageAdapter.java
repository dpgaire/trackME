package com.dpgv1.trackme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dpgv1.trackme.R;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
TextView sendMessage,ReceiveMessage;
    Context context;
    List<Message> messages;

    public MessageAdapter(Context context ,  List<Message> messages1) {
        this.context = context;
        this.messages=messages1;
    }

    @NonNull
    @Override


    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.messagelist,parent,false);
        return new MessageAdapter.MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

        Message message=messages.get(position);
        holder.sendMessage.setText(message.getMessage());
        holder.receiveMessage.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView sendMessage,receiveMessage;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            sendMessage=itemView.findViewById(R.id.tvSendmessage);
            receiveMessage=itemView.findViewById(R.id.tvReceivemessage);
        }


        @Override
        public void onClick(View v) {

        }
    }
}


package com.rahul.meetup.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetup.databinding.ReceiveMessageItemContainerBinding;
import com.example.meetup.databinding.SendMessageItemContainerBinding;
import com.rahul.meetup.models.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<ChatMessage> chatMessages;
    private final Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SEND = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;

    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap receiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_SEND){
            return new SendMessageViewHolder(
                    SendMessageItemContainerBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }
        else{
            return new ReceiveMessageViewHolder(
                    ReceiveMessageItemContainerBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == VIEW_TYPE_SEND){
            ((SendMessageViewHolder) holder).setData(chatMessages.get(position));
        }
        else {
            ((ReceiveMessageViewHolder) holder).setData(chatMessages.get(position), receiverProfileImage);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMessages.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SEND;
        }
        else{
            return VIEW_TYPE_RECEIVED;
        }
    }

    static class SendMessageViewHolder extends RecyclerView.ViewHolder{
        private final SendMessageItemContainerBinding binding;

        SendMessageViewHolder(SendMessageItemContainerBinding sendMessageItemContainerBinding){
            super(sendMessageItemContainerBinding.getRoot());
            binding = sendMessageItemContainerBinding;
        }

        void setData(ChatMessage chatMessage){
            binding.textMessage.setText(chatMessage.message);
            binding.textDataTime.setText(chatMessage.dateTime);
        }
    }

    static class ReceiveMessageViewHolder extends RecyclerView.ViewHolder{
        private final ReceiveMessageItemContainerBinding binding;

        ReceiveMessageViewHolder(ReceiveMessageItemContainerBinding receiveMessageItemContainerBinding){
            super(receiveMessageItemContainerBinding.getRoot());
            binding = receiveMessageItemContainerBinding;
        }

        void setData(ChatMessage chatMessage, Bitmap receiverProfileImage){
            binding.textMessage.setText(chatMessage.message);
            binding.textDateTime.setText(chatMessage.dateTime);
            binding.userProfileImage.setImageBitmap(receiverProfileImage);
        }
    }
}

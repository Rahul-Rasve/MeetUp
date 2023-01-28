package com.rahul.meetup.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetup.databinding.ItemContainerRecentConvoBinding;
import com.rahul.meetup.models.ChatMessage;

import java.util.List;

public class RecentConversationsAdapter extends RecyclerView.Adapter<RecentConversationsAdapter.ConversationViewHolder> {

    private final List<ChatMessage> chatMessageList;

    public RecentConversationsAdapter(List<ChatMessage> chatMessageList) {
        this.chatMessageList = chatMessageList;
    }

    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversationViewHolder(
                ItemContainerRecentConvoBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {
        holder.setData(chatMessageList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessageList.size();
    }

    private Bitmap getConversationImage(String encodedImage){
        byte[] bytes = android.util.Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder{

        ItemContainerRecentConvoBinding binding;

        ConversationViewHolder(ItemContainerRecentConvoBinding itemContainerRecentConvoBinding){
            super(itemContainerRecentConvoBinding.getRoot());
            binding = itemContainerRecentConvoBinding;
        }

        void setData(ChatMessage chatMessageObject){
            binding.profileImage.setImageBitmap(getConversationImage(chatMessageObject.conversationImage));
            binding.nameText.setText(chatMessageObject.conversationName);
            binding.textRecentMessage.setText(chatMessageObject.message);
        }
    }
}

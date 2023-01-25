package com.rahul.meetup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.meetup.databinding.ActivityChatBinding;
import com.rahul.meetup.models.User;
import com.rahul.meetup.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        loadReceiverDetails();
        setListeners();
        setContentView(binding.getRoot());
    }

    private void loadReceiverDetails(){
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.nameText.setText(receiverUser.name);
    }

    private void setListeners(){
        binding.backImage.setOnClickListener(v -> onBackPressed());
    }
}
package com.rahul.meetup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.meetup.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners(){
        binding.loginText.setOnClickListener(v -> onBackPressed());
    }
}
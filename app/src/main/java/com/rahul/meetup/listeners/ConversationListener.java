package com.rahul.meetup.listeners;

import com.rahul.meetup.models.User;

public interface ConversationListener {
    void onConversationClicked(User user);
}

/*package com.hackkings.wannaplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

import java.util.List;
import java.util.ArrayList;

public class Notifications extends AppCompatActivity {

    private List<Channel> channels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Pusher pusher = new Pusher("5c634854fc03379718e5");

        pusher.connect();

        Channel channel = pusher.subscribe("my-channel");
        channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channel, String event, String data) {
                System.out.println("Received event with data: " + data);
            }
        });
    }
-
} */

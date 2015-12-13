package com.hackkings.wannaplay;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

import java.util.ArrayList;
import java.util.List;


public class PusherEvent {
    Pusher pusher = new Pusher('5c634854fc03379718e5');
    pusher.connect();

    Channel channel = pusher.subscribe("my-channel");

    channel.bind("my-event", new SubscriptionEventListener() {
        @Override
        public void onEvent(String channel, String my-event, final String data) {
            System.out.println(data);
        }
    });





}
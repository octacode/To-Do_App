package com.example.kumarshashwat.Any_Do;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReciever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String k=intent.getStringExtra("13");
        Intent i=new Intent(context,MyService.class);
        i.putExtra("13",k);
        context.startService(i);
    }
}

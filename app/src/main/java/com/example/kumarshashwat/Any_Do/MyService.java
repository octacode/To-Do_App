package com.example.kumarshashwat.Any_Do;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.shasha.kumarshashwat.Any_Do.R;

public class MyService extends Service {
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        intent.getStringExtra("13");
        return null;
    }

    public void onCreate(){
        super.onCreate();
        mp=MediaPlayer.create(this, R.raw.alarm);
        Intent i=new Intent(this,AlarmPlaying.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mp.setLooping(true);
        mp.start();
        startActivity(i);

    }

    public void onDestroy(){
        super.onDestroy();
        mp.stop();
        Intent i=new Intent(this,Main13Activity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}

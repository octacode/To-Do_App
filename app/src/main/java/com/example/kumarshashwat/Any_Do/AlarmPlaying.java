package com.example.kumarshashwat.Any_Do;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shasha.kumarshashwat.Any_Do.R;

import java.util.Calendar;

public class AlarmPlaying extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_playing);
        TextView tv=(TextView)findViewById(R.id.textView2);
        Calendar now=Calendar.getInstance();
        int hour=now.get(Calendar.HOUR_OF_DAY);
        if(hour>12) {
            hour = hour - 12;
            int minute = now.get(Calendar.MINUTE);
            assert tv != null;
            tv.setText(hour + ":" + minute+" PM");
        }
        else{
            int minute = now.get(Calendar.MINUTE);
            assert tv != null;
            tv.setText(hour + ":" + minute+" AM");
        }
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        assert image != null;
        image.startAnimation(animation1);
        }

    public void fun(View v) {
        Intent i=new Intent(this, MyService.class);
        stopService(i);
    }
}

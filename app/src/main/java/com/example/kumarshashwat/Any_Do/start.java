package com.example.kumarshashwat.Any_Do;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.shasha.kumarshashwat.Any_Do.R;

public class start extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final String k=getIntent().getExtras().getString("13");
        tv=(TextView)findViewById(R.id.textView3);
        assert tv != null;
        tv.setText(k);
        Animation fade= AnimationUtils.loadAnimation(this,R.anim.fade);
        tv.setAnimation(fade);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(start.this,getstarted.class);
                i.putExtra("13",k);
                startActivity(i);
            }
        },4000);
    }
}


package com.example.kumarshashwat.Any_Do;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shasha.kumarshashwat.Any_Do.R;

import java.util.Random;

public class Animation1 extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH=5569;
    private String[] myString;
    private static final Random rgenerator=new Random();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation1);
        MyPreferences myPreferences;
        boolean isFirstTime=MyPreferences.isFirst(Animation1.this);
        if(isFirstTime) {
        Intent i=new Intent(Animation1.this,Catcher.class);
            startActivity(i);
        }
        else {
            Resources res = getResources();
            myString = res.getStringArray(R.array.myArray);
            String q = myString[rgenerator.nextInt(myString.length)];
            ImageView im = (ImageView) findViewById(R.id.imageView3);
            TextView tv = (TextView) findViewById(R.id.textView10);
            TextView tv1 = (TextView) findViewById(R.id.textView11);
            Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
            Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.fade);
            assert im != null;
            im.setAnimation(anim1);
            assert tv != null;
            tv.setAnimation(anim2);
            assert tv1 != null;
            tv1.setText(q);
            tv1.setAnimation(anim2);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Animation1.this, MainActivity.class);
                    startActivity(i);
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
    }
}

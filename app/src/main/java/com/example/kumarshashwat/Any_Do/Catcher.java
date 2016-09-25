package com.example.kumarshashwat.Any_Do;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import com.shasha.kumarshashwat.Any_Do.R;

public class Catcher extends AppCompatActivity {
    ImageView im;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catcher);
        e1=(EditText)findViewById(R.id.editText);
        im=(ImageView)findViewById(R.id.imageView4);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.rotate1);
        im.setAnimation(anim);
        final TextInputLayout nameWrapper=(TextInputLayout)findViewById(R.id.text_input_layout);
        assert nameWrapper != null;
        nameWrapper.setHint("Your Name");
        nameWrapper.setHintAnimationEnabled(true);

    }
    public void continued(View v){
        if(e1.getText().toString().trim().length()==0)
            e1.setError("Name field can't be left Empty");
        else{
            Intent k=new Intent(this,start.class);
            k.putExtra("13",e1.getText().toString());
            startActivity(k);
        }
    }
}

package com.example.kumarshashwat.Any_Do;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shasha.kumarshashwat.Any_Do.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox c;
    EditText e1;
    Button b;
    Data obj;
    private String[] myString;
    private static final Random rgenerator=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=new Data(this);
        c=(CheckBox)findViewById(R.id.checkBox);
        e1=(EditText)findViewById(R.id.editText);
        b=(Button)findViewById(R.id.button);
        Resources res=getResources();
        myString=res.getStringArray(R.array.array1);
        String q=myString[rgenerator.nextInt(myString.length)];
        e1.setHint(q);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        Toast.makeText(this,"Can't go back",Toast.LENGTH_LONG).show();
        startActivity(i);
    }

    public void submit(View v) {
        if (e1.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Pal! You can't leave the field empty", Toast.LENGTH_LONG).show();
        } else {
            if (c.isChecked()) {
                String k = e1.getText().toString();
                ContentValues cv=new ContentValues();
                cv.put("task",k);
                obj.myInsert(cv);
                Intent i2 = new Intent(this, Main3Activity.class);
                i2.putExtra("13",k);
                startActivity(i2);
            } else {
                String k = e1.getText().toString().trim();
                ContentValues cv=new ContentValues();
                cv.put("task",k);
                obj.myInsert(cv);
                Intent i = new Intent(this, Main13Activity.class);
                startActivity(i);
            }
        }
    }
    public void todo(View v){
        Intent i=new Intent(this,Main13Activity.class);
        startActivity(i);
    }

    public void dev(View v){
    Intent i=new Intent(this,Dev.class);
    startActivity(i);
    }
}

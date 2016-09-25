package com.example.kumarshashwat.Any_Do;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.shasha.kumarshashwat.Any_Do.R;

import java.util.ArrayList;

public class Main13Activity extends AppCompatActivity {

        ListView lv;
        Data obj;
        ImageView im;
        ArrayList<String> al=new ArrayList<String>();
        ArrayList<String> ide=new ArrayList<>();
        SQLiteDatabase db;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main13);
            lv=(ListView)findViewById(R.id.listView);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            assert fab != null;
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(Main13Activity.this,MainActivity.class);
                    startActivity(i);
                }
            });
            obj=new Data(this);
            Cursor c=obj.mySelect();
            while(c.moveToNext()){
                String k=c.getString(0);
                al.add(k);
                String i=c.getString(1);
                ide.add(i);
            }
            final ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,al);
            lv.setAdapter(aa);
            lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    String k=(String)parent.getItemAtPosition(position);
                    db=obj.getWritableDatabase();
                    db.delete(Data.TABLE_TASK,ide.get(position)+"="+Data.KEY_ID,null);
                    Toast.makeText(Main13Activity.this,k+" Removed",Toast.LENGTH_SHORT).show();
                    al.remove(position);
                    aa.notifyDataSetChanged();
                    return false;
                }
            });
        }
    }




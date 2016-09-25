package com.example.kumarshashwat.Any_Do;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.shasha.kumarshashwat.Any_Do.R;

import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    Button b1;
    final static int RQS_1=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String k = getIntent().getExtras().getString("13");
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        b1=(Button)findViewById(R.id.button2);
        Calendar now=Calendar.getInstance();
        datePicker.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),null
        );
        timePicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(now.get(Calendar.MINUTE));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar current=Calendar.getInstance();
                Calendar cal=Calendar.getInstance();
                cal.set(
                datePicker.getYear(),
                datePicker.getMonth(),
                datePicker.getDayOfMonth(),
                timePicker.getCurrentHour(),
                timePicker.getCurrentMinute(),00);
                if(cal.compareTo(current)<=0)
                    Toast.makeText(Main3Activity.this,"Invalid Entry",Toast.LENGTH_LONG).show();
                else{
                    setAlarm(cal);
                }
            }
        });
        /*/e1=(EditText)findViewById(R.id.editText2);
        e2=(TextView)findViewById(R.id.textView12);
        e3=(TextView)findViewById(R.id.textView13);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                final int hours=c.get(Calendar.HOUR_OF_DAY);
                final int minutes=c.get(Calendar.MINUTE);
                TimePickerDialog tm;
                tm=new TimePickerDialog(Main3Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        e1.setText(hourOfDay+":"+minute);
                    }
                },hours,minutes,true);
                tm.setTitle("Select Time");
                tm.show();
            }
        });
    }*/

    /*public void fun(View v2){
        Intent i=new Intent(this, MyReciever.class);
        String k2=e1.getText().toString();
        if(k2.trim().length()==0)
            Toast.makeText(this,"Hey! You can't leave this field empty",Toast.LENGTH_SHORT).show();
        else {
            String k3=e2.getText().toString();
            String k4=e3.getText().toString();
            int p3=Integer.parseInt(k3);
            int p4=Integer.parseInt(k4);
        if(k3.trim().length()==0 || k4.trim().length()==0)
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
            //int p = Integer.parseInt(k2);
            Toast.makeText(this,p3+" hours and "+p4+" minutes",Toast.LENGTH_SHORT).show();
            /*PendingIntent pi = PendingIntent.getBroadcast(this, 101, i, 0);
            AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000*60*60*p3+1000*60*p4, pi);
            Intent i2 = new Intent(this, Main22Activity.class);
            startActivity(i2);

        }*/

    }

    private void setAlarm(Calendar targetcall){
        Toast.makeText(this,"Alarm is set @ "+targetcall.getTime(),Toast.LENGTH_LONG).show();
        Intent i=new Intent(this, MyReciever.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 101, i, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,targetcall.getTimeInMillis(), pi);
        Intent i2 = new Intent(this, Main13Activity.class);
        i2.putExtra("133","Shashwat");
        startActivity(i2);
    }

}
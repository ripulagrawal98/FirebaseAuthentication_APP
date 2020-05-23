package com.nit.login;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class Clock extends Activity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static Clock inst;
    private TextView alarmTextView;

    public static Clock instance()
    {
        return inst;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        inst = this;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);


        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);




        alarmTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Intent i = new Intent(getApplicationContext(),Clock_Next.class);
                i.putExtra("Hour",String.valueOf(hourOfDay));
                i.putExtra("Minute",String.valueOf(minute));
                startActivity(i);

            }



        });

    }





    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }
}
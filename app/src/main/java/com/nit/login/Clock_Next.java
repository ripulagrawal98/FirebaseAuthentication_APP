package com.nit.login;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Clock_Next extends AppCompatActivity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TextView alarmTextView;
    private ToggleButton alarmButton;

//    private static Clock inst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock__next);

        alarmButton = (ToggleButton)findViewById(R.id.alarmToggle2);
        alarmTextView = (TextView)findViewById(R.id.alarmText2);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        String R = getIntent().getStringExtra("Hour");
        String mint = getIntent().getStringExtra("Minute");

        alarmButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(R));

                    calendar.set(Calendar.MINUTE, Integer.parseInt(mint));

                    Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);

                    pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, myIntent, 0);

                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                }

                else
                {
                    alarmManager.cancel(pendingIntent);
                }
            }
        });





    }
}

package com.nit.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class CalenderActivity extends AppCompatActivity {

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView calenderr;
    TextView date_vieww;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderview);

        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calenderr = (CalendarView)findViewById(R.id.calender);
//        date_vieww = (TextView)findViewById(R.id.date_view);
//        Log.d("Error",);
        // Add Listener in calendar
        calenderr.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                startActivity(new Intent(getApplicationContext(),Clock.class));

                                // set this date in TextView for Display
//                                date_vieww.setText(Date);

                            }
                        });
    }
}

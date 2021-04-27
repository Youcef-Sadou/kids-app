package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TaskAdder extends AppCompatActivity {
    TextView tv_hour;
    int tvHour, tvMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adder);

        tv_hour  = findViewById(R.id.tv_hour);

        tv_hour.setOnClickListener((v) -> {
            TimePickerDialog timerPickerDialog = new TimePickerDialog(
                    TaskAdder.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                             tvHour = hourOfDay;
                             tvMinute= minute;
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(0,0,0,tvHour,tvMinute);
                            tv_hour.setText(DateFormat.format("hh:mm aa",calendar));


                        }
                    },12,0,false // these arethe default settings


            );
            timerPickerDialog.updateTime(tvHour,tvMinute);
            timerPickerDialog.show();
        });

    }
}
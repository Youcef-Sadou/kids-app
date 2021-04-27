package com.example.kidsapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TasklistAdder extends AppCompatActivity {
    TextView tvDate;
    DatePickerDialog.OnDateSetListener setListener;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist_adder);

        tvDate = findViewById(R.id.tv_date);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        setListener = (view, year1, month1, dayOfMonth) -> {
            month1 = month1 + 1 ;
              date = day + "/" + month1 + "/" + year1;
              System.out.print(date);
            tvDate.setText(date);


        };
        tvDate.setOnClickListener((v) -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    TasklistAdder.this, (view, year12, month12, day1) -> {
                        month12 = month12 + 1 ;
                        String date = day1 + "/" + month12 + "/" + year12;
                        tvDate.setText(date);
                    },year,month,day);
            //adding a validate button to the adder so that way we can change the date if we made a mistake


            datePickerDialog.show();
            
        });


        ImageButton validate = findViewById(R.id.validateButton);
        validate.setOnClickListener((v) -> {


            // Putting the String to pass back into an Intent and then closing the taskList adder activity
            Intent intent = new Intent();
            date = tvDate.getText().toString();
            intent.putExtra("keyName", date);
            setResult(RESULT_OK, intent);
            this.finish();
        });


    }
}
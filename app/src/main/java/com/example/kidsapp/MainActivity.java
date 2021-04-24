package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add task_list button
        ImageButton AddTasklist_btn = findViewById(R.id.AddTasklistButton);
        AddTasklist_btn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, TasklistAdder.class);
            //startActivity(intent);
            startActivityForResult(intent, 3);
        });




    }

    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");

                // Set text view with string
               /* TextView textView = findViewById(R.id.textView);

                textView.setText(returnString);
                */
                TextView textView = findViewById(R.id.textView);
                textView.setText(returnString);
            }
        }
    }




}   
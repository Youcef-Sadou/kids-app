package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> tasklist_dates  = new ArrayList<String>();
   // LinearLayout layoutList = findViewById(R.id.layout_list);
    int cpt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout layoutList = findViewById(R.id.layout_list);

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


                TextView textView = findViewById(R.id.textView);
                tasklist_dates.add(returnString);
                cpt++;
                textView.setText("");




                final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_tasklist,null,false);
                //this creates a new view


                //this locates the list
                LinearLayout layoutList = findViewById(R.id.layout_list);


                layoutList.addView(tasklistView);



                for(int i = 0; i <(layoutList.getChildCount()) ;i++){
                    TextView tv = (TextView) layoutList.getChildAt(i);

                    tv.setText(tasklist_dates.get(i));

                    // Making it basically a button to the tasks activity
                    tv.setOnClickListener((v) -> {
                        Intent intent = new Intent(this, Task.class);
                        startActivity(intent);
                    });
                }
            }
        }
    }

}   
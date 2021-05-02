package com.example.kidsapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class TaskAdder extends AppCompatActivity {
    TextView tv_hour;
    int tvHour, tvMinute;
    String Task_id = "";// this will be returned to the Task activity
    String Hour;
    String Category = "4";      // the default category is 4 (other) if the person who added a task did not select from the categories
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adder);
        rootNode = FirebaseDatabase.getInstance("https://kids-app-ae14b-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootNode.getReference();
        //connecting to the Firebase database and getting the reference

        DatabaseReference rrr = reference.child("Tasklists");

        tv_hour  = findViewById(R.id.tv_hour);

        tv_hour.setOnClickListener((v) -> {
            TimePickerDialog timerPickerDialog = new TimePickerDialog(
                    TaskAdder.this,
                    (view, hourOfDay, minute) -> {
                        tvHour = hourOfDay;
                        tvMinute= minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,tvHour,tvMinute);
                        Hour = DateFormat.format("hh:mm aa",calendar).toString();
                        tv_hour.setText(DateFormat.format("hh:mm aa",calendar));


                    },12,0,false // these arethe default settings


            );
            timerPickerDialog.updateTime(tvHour,tvMinute);
            timerPickerDialog.show();
        });

        // this code is for the category

        RadioButton school = findViewById(R.id.radioButton);
        RadioButton home = findViewById(R.id.radioButton2);
        RadioButton food = findViewById(R.id.radioButton3);
        RadioButton other = findViewById(R.id.radioButton4);
        Category = "4";
        school.setOnClickListener((v) -> Category = "1");

        home.setOnClickListener((v) -> Category = "2");

        food.setOnClickListener((v) -> Category = "3");

        other.setOnClickListener((v) -> Category = "4");


        //this code is for the task description and the final validate

        ImageButton validate = findViewById(R.id.validateButton2);
        EditText task_description = findViewById(R.id.task_description);
        validate.setOnClickListener((v) -> {
            if(!task_description.getText().toString().isEmpty() && !tv_hour.getText().toString().equals("Select Hour")){           // if the task description or the time is empty we will not add the task (the description and the time is a must)
                Intent intent = new Intent();
                Task_id = Hour + Category + task_description.getText().toString();
                intent.putExtra("keyName2", Task_id);
                Bundle b = getIntent().getExtras();
                ArrayList<String> Tasks = new ArrayList<>();
                Tasks.add(Task_id);
                Task.TasklistToTasks.put(b.getString("TaskListID2"),Tasks);
                //aadded code
                for(TL TaskList : MainActivity.Tasklist_array){
                    if(TaskList.Date.equals(b.getString("TaskListID2"))){
                        T task = new T(Hour,Category,task_description.getText().toString());
                        TaskList.Tasks.add(task);

                    }

                }




                setResult(RESULT_OK, intent);





                rrr.setValue(null);
                rrr.setValue(MainActivity.Tasklist_array);
                //updating the database with the new task

                this.finish();
            }




        });











    }
}
package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Task extends AppCompatActivity {
    static HashMap<String, ArrayList<String>> TasklistToTasks = new HashMap<>();
    ArrayList<String> task_list_tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        int found = 0;
        //for now we will assume it is just 1 task per task list just so we will see if it works or not
        Bundle b = getIntent().getExtras();
        String taskListID = b.getString("TaskListID");      //finding the id to the tasklist

        TL TLL = null;


        for (TL TaskList  :    MainActivity.Tasklist_array){
            if(TaskList.Date.equals(taskListID)){           // we have already added it (if we already added it that means there is atleast 1 task in the task list )
                TLL = TaskList;

                found = 1;
            }
        }

        if (found == 1 && TLL.Tasks.size() != 0) {
            TextView tv2 = findViewById(R.id.textView2);
            tv2.setText(""); // so it won't  bother us
            switch (TLL.Tasks.get(TLL.Tasks.size() -1).Category) {
                case "1": {
                    @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_1, null, false);

                    TextView Hour = tasklistView.findViewById(R.id.task1_hour);
                    Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                    TextView Desc = tasklistView.findViewById(R.id.task1_desc);
                    Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                    LinearLayout layoutList = findViewById(R.id.layout_list222);
                    layoutList.addView(tasklistView);
                    break;
                }
                case "2": {
                    @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_2, null, false);

                    TextView Hour = tasklistView.findViewById(R.id.task2_hour);
                    Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                    TextView Desc = tasklistView.findViewById(R.id.task2_desc);
                    Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                    LinearLayout layoutList = findViewById(R.id.layout_list222);
                    layoutList.addView(tasklistView);
                    break;
                }
                case "3": {
                    @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_3, null, false);

                    TextView Hour = tasklistView.findViewById(R.id.task3_hour);
                    Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                    TextView Desc = tasklistView.findViewById(R.id.task3_desc);
                    Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                    LinearLayout layoutList = findViewById(R.id.layout_list222);
                    layoutList.addView(tasklistView);
                    break;
                }
                case "4": {
                    @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_4, null, false);

                    TextView Hour = tasklistView.findViewById(R.id.task4_hour);
                    Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                    TextView Desc = tasklistView.findViewById(R.id.task4_desc);
                    Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                    LinearLayout layoutList = findViewById(R.id.layout_list222);
                    layoutList.addView(tasklistView);
                    break;
                }


            }


        }




        ImageButton AddTasklist_btn = findViewById(R.id.AddTaskButton);
        AddTasklist_btn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, TaskAdder.class);
            intent.putExtra("TaskListID2",taskListID);  // returns the date of the task list which will serve as the id to the task

            startActivityForResult(intent, 4);
        });


    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4) {
            if (resultCode == RESULT_OK) {



                Bundle b = getIntent().getExtras();
                String taskListID = b.getString("TaskListID");      //finding the id to the tasklist
                int found;
                for (String i : TasklistToTasks.keySet()){
                    if(i.equals(taskListID)){           // we have already added it (if we already added it that means there is atleast 1 task in the task list )
                        task_list_tasks = TasklistToTasks.get(taskListID);

                    }
                }

                TL TLL = null;

                 b = getIntent().getExtras();
                 taskListID = b.getString("TaskListID");      //finding the id to the tasklist
                 found = 0;
                for (TL TaskList  :    MainActivity.Tasklist_array){
                    if(TaskList.Date.equals(taskListID)){           // we have already added it (if we already added it that means there is atleast 1 task in the task list )
                        TLL = TaskList;

                        found = 1;
                    }
                }

                if (found == 1){
                    TextView tv2 = findViewById(R.id.textView2);
                    tv2.setText(""); // so it won't  bother us


                    switch (TLL.Tasks.get(TLL.Tasks.size() -1).Category) {
                        case "1": {
                            @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_1, null, false);

                            TextView Hour = tasklistView.findViewById(R.id.task1_hour);
                            Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                            TextView Desc = tasklistView.findViewById(R.id.task1_desc);
                            Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                            LinearLayout layoutList = findViewById(R.id.layout_list222);
                            layoutList.addView(tasklistView);
                            break;
                        }
                        case "2": {
                            @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_2, null, false);

                            TextView Hour = tasklistView.findViewById(R.id.task2_hour);
                            Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);  

                            TextView Desc = tasklistView.findViewById(R.id.task2_desc);
                            Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                            LinearLayout layoutList = findViewById(R.id.layout_list222);
                            layoutList.addView(tasklistView);
                            break;
                        }
                        case "3": {
                            @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_3, null, false);

                            TextView Hour = tasklistView.findViewById(R.id.task3_hour);
                            Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                            TextView Desc = tasklistView.findViewById(R.id.task3_desc);
                            Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                            LinearLayout layoutList = findViewById(R.id.layout_list222);
                            layoutList.addView(tasklistView);
                            break;
                        }
                        case "4": {
                            @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_4, null, false);

                            TextView Hour = tasklistView.findViewById(R.id.task4_hour);
                            Hour.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Hour);

                            TextView Desc = tasklistView.findViewById(R.id.task4_desc);
                            Desc.setText(TLL.Tasks.get(TLL.Tasks.size() -1).Description);
                            LinearLayout layoutList = findViewById(R.id.layout_list222);
                            layoutList.addView(tasklistView);
                            break;
                        }


                    }


                }



            }
        }

    }


}
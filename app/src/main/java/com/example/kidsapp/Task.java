package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Task extends AppCompatActivity {
    String Hour;
    String Category;
    String Description;
    TL TaskList ;
    static HashMap<String, ArrayList<String>> TasklistToTasks = new HashMap<String, ArrayList<String>>();
    ArrayList<String> task_list_tasks = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        int found = 0;
        //for now we will assume it is just 1 task per task list just so we will see if it works or not
        Bundle b = getIntent().getExtras();
        String taskListID = b.getString("TaskListID");      //finding the id to the tasklist
        for (String i : TasklistToTasks.keySet()){
            if(i.equals(taskListID)){           // we have already added it (if we already added it that means there is atleast 1 task in the task list )
                task_list_tasks = TasklistToTasks.get(taskListID);
                found = 1;
            }
        }

        if (found == 1){
            TextView tv2 = findViewById(R.id.textView2);
            //tv2.setText(task_list_tasks.get(0));//again we will only show the first item (for now)
            tv2.setText(""); // so it won't  bother us

/*
            final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_1,null,false);
            LinearLayout layoutList = findViewById(R.id.layout_list222);

            layoutList.addView(tasklistView);
*/




        }






        //setContentView(R.layout.activity_task);

        ImageButton AddTasklist_btn = findViewById(R.id.AddTaskButton);
        AddTasklist_btn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, TaskAdder.class);
            //startActivity(intent);
            //startActivityForResult(intent, 3);
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
                int found = 0;
                for (String i : TasklistToTasks.keySet()){
                    if(i.equals(taskListID)){           // we have already added it (if we already added it that means there is atleast 1 task in the task list )
                        task_list_tasks = TasklistToTasks.get(taskListID);
                        found = 1;
                    }
                }

                if (found == 1){
                    TextView tv2 = findViewById(R.id.textView2);
                    //tv2.setText(task_list_tasks.get(0));//again we will only show the first item (for now)
                    tv2.setText(""); // so it won't  bother us




                    if(task_list_tasks.get(0).substring(8,9).equals("1")) {
                        final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_1, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task1_hour);
                        Hour.setText(task_list_tasks.get(0).substring(0, 8));

                        TextView Desc = tasklistView.findViewById(R.id.task1_desc);
                        Desc.setText(task_list_tasks.get(0).substring(9));
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                    }else if(task_list_tasks.get(0).substring(8,9).equals("2")) {
                        final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_2, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task2_hour);
                        Hour.setText(task_list_tasks.get(0).substring(0, 8));

                        TextView Desc = tasklistView.findViewById(R.id.task2_desc);
                        Desc.setText(task_list_tasks.get(0).substring(9));
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                    }else if(task_list_tasks.get(0).substring(8,9).equals("3")) {
                        final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_3, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task3_hour);
                        Hour.setText(task_list_tasks.get(0).substring(0, 8));

                        TextView Desc = tasklistView.findViewById(R.id.task3_desc);
                        Desc.setText(task_list_tasks.get(0).substring(9));
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                    }else if(task_list_tasks.get(0).substring(8,9).equals("4")) {
                        final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_4, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task4_hour);
                        Hour.setText(task_list_tasks.get(0).substring(0, 8));

                        TextView Desc = tasklistView.findViewById(R.id.task4_desc);
                        Desc.setText(task_list_tasks.get(0).substring(9));
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                    }









                  /*    LinearLayout SecondLevel = (LinearLayout)FirstLevel.getChildAt(0);
                    TextView Hour = (TextView)SecondLevel.getChildAt(1);
                    Hour.setText("4:20 AM");
*/
                    //layoutList.addView(FirstLevel);


                    /*LinearLayout l2 = (LinearLayout)    ((LinearLayout)tasklistView).getChildAt(0);
                    //LinearLayout l3 = (LinearLayout)    ((LinearLayout)l2).getChildAt(0);
                    TextView Hour = (TextView) (l2).getChildAt(1);
                    Hour.setText("4:20 AM");
                    /**/
                    //Where i put set text, i have to do the other thingy now XD

                }
            }
        }

    }


}
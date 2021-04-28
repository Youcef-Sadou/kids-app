package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
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
            tv2.setText(task_list_tasks.get(0));//again we will only show the first item (for now)

        }












        // here we will cycle through all the task lists until we find a matching id
      //  for(int i = 0; i < MainActivity.Tasklists.size();i++){
        /*
        if(MainActivity.Tasklists.get(0).Date.equals(taskListID) ){
             //we have found our task list
             TaskList = MainActivity.Tasklists.get(0);
             if (!TaskList.Tasks.get(0).Hour.equals("")){
                 TextView tv2 = findViewById(R.id.textView2);
                 tv2.setText(TaskList.Tasks.get(0).Hour + " " + TaskList.Tasks.get(0).Description);

                 // again we will just check the first task to save it
             }



         }*/
        //}




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
                    tv2.setText(task_list_tasks.get(0));//again we will only show the first item (for now)

                }
            }
        }

    }

    protected void onResume() {



        super.onResume();

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
            tv2.setText(task_list_tasks.get(0));//again we will only show the first item (for now)

        }


    }
}
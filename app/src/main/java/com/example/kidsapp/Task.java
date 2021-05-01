package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Task extends AppCompatActivity {
    static HashMap<String, ArrayList<String>> TasklistToTasks = new HashMap<>();
    ArrayList<String> task_list_tasks = new ArrayList<>();

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        rootNode = FirebaseDatabase.getInstance("https://kids-app-ae14b-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootNode.getReference();
        DatabaseReference rrr = reference.child("Tasklists");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        int found = 0;
   //     TextView Desc ;
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

        if (found == 1 && TLL.Tasks.size() > 1) {
            TextView tv2 = findViewById(R.id.textView2);
            tv2.setText(""); // so it won't  bother us

            for (T Task : TLL.Tasks) {
                switch (Task.Category) {
                    case "1": {
                        @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_1, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task1_hour);
                        Hour.setText(Task.Hour);

                        TextView   Desc = tasklistView.findViewById(R.id.task1_desc);
                        Desc.setText(Task.Description);
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                        Desc.setOnLongClickListener((v) -> {

                            for(int i =0;i<MainActivity.Tasklist_array.size();i++){
                                if(MainActivity.Tasklist_array.get(i).getDate().equals(taskListID)){

                                    for(int j=0;j<MainActivity.Tasklist_array.get(i).Tasks.size();j++){
                                        if(MainActivity.Tasklist_array.get(i).Tasks.get(j).getDescription().equals(Desc.getText().toString())){
                                            MainActivity.Tasklist_array.get(i).Tasks.remove(j);
                                            Desc.setText(R.string.removed);
                                            rrr.setValue(MainActivity.Tasklist_array);
                                            this.recreate();

                                        }
                                    }
                                }
                            }

                            return false;

                        });
                        break;
                    }
                    case "2": {
                        @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_2, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task2_hour);
                        Hour.setText(Task.Hour);

                       TextView  Desc = tasklistView.findViewById(R.id.task2_desc);
                        Desc.setText(Task.Description);
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                        Desc.setOnLongClickListener((v) -> {

                            for(int i =0;i<MainActivity.Tasklist_array.size();i++){
                                if(MainActivity.Tasklist_array.get(i).getDate().equals(taskListID)){

                                    for(int j=0;j<MainActivity.Tasklist_array.get(i).Tasks.size();j++){
                                        if(MainActivity.Tasklist_array.get(i).Tasks.get(j).getDescription().equals(Desc.getText().toString())){
                                            MainActivity.Tasklist_array.get(i).Tasks.remove(j);
                                            Desc.setText(R.string.removed);
                                            rrr.setValue(MainActivity.Tasklist_array);
                                            this.recreate();

                                        }
                                    }
                                }
                            }

                            return false;

                        });
                        break;
                    }
                    case "3": {
                        @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_3, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task3_hour);
                        Hour.setText(Task.Hour);

                        TextView   Desc = tasklistView.findViewById(R.id.task3_desc);
                        Desc.setText(Task.Description);
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                        Desc.setOnLongClickListener((v) -> {

                            for(int i =0;i<MainActivity.Tasklist_array.size();i++){
                                if(MainActivity.Tasklist_array.get(i).getDate().equals(taskListID)){

                                    for(int j=0;j<MainActivity.Tasklist_array.get(i).Tasks.size();j++){
                                        if(MainActivity.Tasklist_array.get(i).Tasks.get(j).getDescription().equals(Desc.getText().toString())){
                                            MainActivity.Tasklist_array.get(i).Tasks.remove(j);
                                            Desc.setText(R.string.removed);
                                            rrr.setValue(MainActivity.Tasklist_array);
                                            this.recreate();

                                        }
                                    }
                                }
                            }

                            return false;

                        });
                        break;
                    }
                    case "4": {
                        @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_task_4, null, false);

                        TextView Hour = tasklistView.findViewById(R.id.task4_hour);
                        Hour.setText(Task.Hour);

                        TextView  Desc = tasklistView.findViewById(R.id.task4_desc);
                        Desc.setText(Task.Description);
                        LinearLayout layoutList = findViewById(R.id.layout_list222);
                        layoutList.addView(tasklistView);
                        Desc.setOnLongClickListener((v) -> {

                            for(int i =0;i<MainActivity.Tasklist_array.size();i++){
                                if(MainActivity.Tasklist_array.get(i).getDate().equals(taskListID)){

                                    for(int j=0;j<MainActivity.Tasklist_array.get(i).Tasks.size();j++){
                                        if(MainActivity.Tasklist_array.get(i).Tasks.get(j).getDescription().equals(Desc.getText().toString())){
                                            MainActivity.Tasklist_array.get(i).Tasks.remove(j);
                                            Desc.setText(R.string.removed);
                                            rrr.setValue(MainActivity.Tasklist_array);
                                            this.recreate();

                                        }
                                    }
                                }
                            }

                            return false;

                        });
                        break;
                    }



                }








            }

        }else{
            TextView tv2 = findViewById(R.id.textView2);
            tv2.setText(R.string.yhnt);
        }




        ImageButton AddTasklist_btn = findViewById(R.id.AddTaskButton);
        AddTasklist_btn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, TaskAdder.class);
            intent.putExtra("TaskListID2",taskListID);  // returns the date of the task list which will serve as the id to the task

            startActivityForResult(intent, 4);
        });


        //CODE THAT REMOVES THE THE TASK VIEW






    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        this.recreate();


    }


}

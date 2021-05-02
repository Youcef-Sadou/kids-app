package com.example.kidsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<TL> Tasklists = new ArrayList<>();           // i have to make this static so i can access it from other activites
    static ArrayList<TL> Tasklist_array =  new ArrayList<>();
    static int cpt = 0;
    ValueEventListener valueEventListener;
    static int Done = 0 ;
    int i = 0;
    FirebaseDatabase rootNode;
   DatabaseReference reference;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    Activity random = this;

        rootNode = FirebaseDatabase.getInstance("https://kids-app-ae14b-default-rtdb.europe-west1.firebasedatabase.app/");
      reference = rootNode.getReference();
      DatabaseReference rrr = reference.child("Tasklists");
        //connecting to the Firebase database and getting the reference

        valueEventListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MainActivity.Tasklist_array.clear();
                for (DataSnapshot child : snapshot.getChildren()) {

                    TL tl = child.getValue(TL.class);
                    MainActivity.Tasklist_array.add(tl);

                }
                if(Done ==0) {
                    random.recreate();
                    MainActivity.Done = 1;
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        rrr.keepSynced(true);
        //syncing the database
        rrr.addValueEventListener(valueEventListener);


        setContentView(R.layout.activity_main);



        if(Tasklist_array.size() != 0){

            TextView textView = findViewById(R.id.textView);
            textView.setText("");
            for (TL tasklist : Tasklist_array){
                @SuppressLint("InflateParams") final View tasklistView = getLayoutInflater().inflate(R.layout.row_add_tasklist, null, false);
                //this creates a new view


                //this locates the list
                LinearLayout layoutList = findViewById(R.id.layout_list);


                layoutList.addView(tasklistView);
                TextView tv = (TextView) layoutList.getChildAt(i);
                i++;
                tv.setText(tasklist.Date);
                String current_date = tasklist.Date;
                // Making it basically a button to the tasks activity
                tv.setOnClickListener((v) -> {
                    Intent intent = new Intent(this, Task.class);
                    intent.putExtra("TaskListID",current_date);  // returns the date of the task list which will serve as the id to the task

                    startActivity(intent);
                });
                tv.setOnLongClickListener((v) -> {

                          for(int i =0;i<Tasklist_array.size();i++){
                                if(Tasklist_array.get(i).getDate().equals(tv.getText().toString())){

                                    Tasklist_array.remove(i);
                                    tv.setText("removed");

                                    rrr.setValue(MainActivity.Tasklist_array);
                                    //updating the database with the deletion of the tasklist
                                    this.recreate();

                                }
                            }

                            return false;

                   });

                cpt++;

            }
        }else{
            TextView textView = findViewById(R.id.textView);
            textView.setText(R.string.tlaie);
        }





        //add task_list button
        ImageButton AddTasklist_btn = findViewById(R.id.AddTaskButton);
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

        this.recreate();
        //we restart the activity


    }


}
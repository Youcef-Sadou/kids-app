package com.example.kidsapp;

import java.util.ArrayList;

public class TL {
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ArrayList<T> getTasks() {
        return Tasks;
    }

    public void setTasks(ArrayList<T> tasks) {
        Tasks = tasks;
    }

    String Date;
    ArrayList<T>  Tasks;





    TL(String Date,ArrayList<T> Tasks){
        this.Date = Date;
        this.Tasks = Tasks;
    }
    TL(){

    }
}

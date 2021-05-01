package com.example.kidsapp;

public class T {
    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    String Hour;
    String Category;
    String Description;

    T(String Hour,String Category,String Description){
        this.Hour  = Hour;
        this.Category = Category;
        this.Description = Description;
    }
    T(){

    }

}

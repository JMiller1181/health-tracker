package models;

import java.util.Date;

public class Food {
    private String name;
    private int calories;
    private String date;
    public Food(String name, int calories, String date){
        this.name = name;
        this.calories = calories;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

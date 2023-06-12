package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<Food> foodList;
    private List<Exercise> exerciseList;
    private List<Sleep> sleepList;

    public User(String userName) {
        this.userName = userName;
        this.foodList = new ArrayList<>();
        this.exerciseList = new ArrayList<>();
        this.sleepList = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void addFood(Food food){
        foodList.add(food);
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void addExercise(Exercise exercise){
        exerciseList.add(exercise);
    }

    public List<Sleep> getSleepList() {
        return sleepList;
    }

    public void setSleepList(List<Sleep> sleepList) {
        this.sleepList = sleepList;
    }

    public void addSleep(Sleep sleep){
        sleepList.add(sleep);
    }
    public String toString(){
        String user = userName;
        for(Food food: foodList){
            user += ", " + food.getName();
        }
        for(Exercise exercise: exerciseList){
            user += ", " + exercise.getName();
        }
        for(Sleep sleep: sleepList){
            user += ", " + sleep.stringDuration();
        }
        return user;
    }
}

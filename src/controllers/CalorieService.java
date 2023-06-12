package controllers;

import models.Exercise;
import models.Food;
import models.User;

import java.util.List;

public class CalorieService {
    private User user;

    public CalorieService(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int calculateCalIn(String date) {
        List<Food> foods = user.getFoodList();
        int calIn = 0;
        for(Food food: foods){
            if (food.getDate().equals(date)){
                calIn += food.getCalories();
            }
        }
        return calIn;
    }

    public int calculateCalOut(String date) {
        List<Exercise> exercises = user.getExerciseList();
        int calOut = 0;
        for(Exercise exercise: exercises){
            if(exercise.getDate().equals(date)){
                calOut += exercise.getCaloriesBurned();
            }
        }
        return calOut;
    }

    public void printCalorieTracker(String date){
        if(calculateCalIn(date) > calculateCalOut(date)){
            System.out.println("On " + date + " you consumed " +
                    (calculateCalIn(date) - calculateCalOut(date)) + " more calories than you burned.");
        } else if (calculateCalOut(date) > calculateCalIn(date)) {
            System.out.println("On " + date + " you burned " +
                    (calculateCalOut(date) - calculateCalIn(date)) + " more calories than you consumed.");
        } else {
            System.out.println("Calories consumed is equal to calories burned.");
        }
    }
}

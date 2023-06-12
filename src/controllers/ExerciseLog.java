package controllers;

import models.Exercise;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLog {
    private User user;

    public ExerciseLog(User user){
        this.user = user;
    }

    public void printDailyReport(String date){
        List<Exercise> exercises = user.getExerciseList();
        List<String> dailyList = new ArrayList<>();
        int totalCaloriesBurned = 0;
        int totalExercise = 0;
        for (Exercise exercise: exercises){
            if(exercise.getDate().equals(date)){
                totalExercise += exercise.getDuration();
                totalCaloriesBurned += exercise.getCaloriesBurned();
                if(!dailyList.contains(exercise.getName())){
                    dailyList.add(exercise.getName());
                }
            }
        }
        System.out.println("On " + date + " you exercised for a total of " + totalExercise + " minutes and burned a total of "
        + totalCaloriesBurned + " calories.");
        String listOfExercises = "On " + date  + "the list of exercises you completed were:\n";
        for(String name: dailyList){
            listOfExercises += name + "\n";
        }
    }
}

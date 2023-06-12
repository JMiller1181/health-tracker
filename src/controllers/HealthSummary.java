package controllers;

import models.User;

import java.util.Scanner;

public class HealthSummary {

    public HealthSummary(){

    }
    public void printSummary(String date, CalorieService calorieService,
                             ExerciseLog exerciseLog, SleepService sleepService){
        System.out.println("Caloric intake summary");
        calorieService.printCalorieTracker(date);
        System.out.println("Exercise summary");
        exerciseLog.printDailyReport(date);
        System.out.println("Sleep summary");
        sleepService.printDailySleep(date);
    }
}

package controllers;

import models.User;

import java.util.Scanner;

public class HealthSummary {

    public HealthSummary(){

    }
    public void printSummary(User user){
        Scanner scanner = new Scanner(System.in);
        CalorieService calorieService = new CalorieService(user);
        ExerciseLog exerciseLog = new ExerciseLog(user);
        SleepService sleepService = new SleepService(user);

        System.out.println("""
        What day would you like a summary for?
        Please enter in dd/MM/yy format""");
        String date = scanner.nextLine();
        System.out.println("Caloric intake summary");
        calorieService.printCalorieTracker(date);
        System.out.println("Exercise summary");
        exerciseLog.printDailyReport(date);
        System.out.println("Sleep summary");
        sleepService.printDailySleep(date);
    }
}

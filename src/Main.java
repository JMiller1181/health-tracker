import controllers.*;
import models.Exercise;
import models.Food;
import models.Sleep;
import models.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        userService.loadFoodData();
        userService.loadExerciseData();
        userService.loadSleepData();
        //User Login or Create new User
        System.out.println("Welcome! What is your username?");
        String login = scanner.nextLine();
        if(userService.findUser(login) == null){
            System.out.println("First time user! Nice to meet you " + login);
            User user = new User(login);
            userService.addUser(user);
        } else {
            System.out.println("Welcome back, " + login);
        }
        User user = userService.findUser(login);
        //Add or view data and create services
        CalorieService calorieService = new CalorieService(user);
        ExerciseLog exerciseLog = new ExerciseLog(user);
        SleepService sleepService = new SleepService(user);
        HealthSummary healthSummary = new HealthSummary();
        while(true) {
            System.out.println("""
                    What would you like to do?
                    1) Add Data
                    2) View Data
                    3) Exit""");
            int dataOption = scanner.nextInt();
            scanner.nextLine();
            if(dataOption == 1) {
                System.out.println("""
                        What data would you like to add?
                        1) Food data
                        2) Exercise data
                        3) Sleep data
                        4) Exit""");
                int addOption = scanner.nextInt();
                scanner.nextLine();
                switch (addOption) {
                    case 1 -> {
                        System.out.println("What is the name of the food?");
                        String foodName = scanner.nextLine();
                        System.out.println("How many calories is the food?");
                        int foodCalories = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("When did you eat the food?");
                        String foodDate = scanner.nextLine();
                        Food newFood = new Food(foodName, foodCalories, foodDate);
                        user.addFood(newFood);
                    }
                    case 2 -> {
                        System.out.println("What exercise did you do?");
                        String exerciseName = scanner.nextLine();
                        System.out.println("How long did you exercise?");
                        int exerciseDuration = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("How many calories were burned?");
                        int exerciseCalories = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("When did you do the exercise?");
                        String exerciseDate = scanner.nextLine();
                        Exercise newExercise = new Exercise(exerciseName, exerciseDuration, exerciseCalories, exerciseDate);
                        user.addExercise(newExercise);
                    }
                    case 3 -> {
                        System.out.println("What day did you get to sleep? (Use dd/MM/yy format)");
                        String sleepStartDate = scanner.nextLine();
                        System.out.println("When did you get to sleep? (Use HH:mm 24hr format)");
                        String sleepStart = scanner.nextLine();
                        System.out.println("What day did you wake up?");
                        String sleepEndDate = scanner.nextLine();
                        System.out.println("When did you wake up?");
                        String sleepEnd = scanner.nextLine();
                        Sleep newSleep = new Sleep(sleepStartDate, sleepStart, sleepEndDate, sleepEnd);
                        user.addSleep(newSleep);
                    }
                    default -> {
                    }
                }
            } else if (dataOption == 2) {
                System.out.println("""
                        What data would you like to view?
                        1) Caloric intake data
                        2) Exercise log
                        3) Sleep log
                        4) Health Summary
                        5) Sleep Average
                        6) Exit""");
                int viewOption = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What date would you like to view data for? (Use dd/MM/yy format)");
                String viewDate = scanner.nextLine();
                switch (viewOption){
                    case 1:
                        calorieService.printCalorieTracker(viewDate);
                        break;
                    case 2:
                        exerciseLog.printDailyReport(viewDate);
                        break;
                    case 3:
                        sleepService.printDailySleep(viewDate);
                        break;
                    case 4:
                        healthSummary.printSummary(viewDate, calorieService, exerciseLog, sleepService);
                        break;
                    case 5:
                        System.out.println("What is the end date of the sleep average period? (Use dd/MM/yy format)");
                        String averageDate = scanner.nextLine();
                        sleepService.printAverage(viewDate, averageDate);
                        break;
                    default:
                        break;
                }
            } else{
                System.out.println("Goodbye!");
                break;
            }
        }
        userService.saveExerciseData();
        userService.saveFoodData();
        userService.saveSleepData();
    }
}

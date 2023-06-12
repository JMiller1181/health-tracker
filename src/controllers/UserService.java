package controllers;
import models.Exercise;
import models.Food;
import models.Sleep;
import models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import  java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users;

    public UserService(){
        this.users = new ArrayList<>();
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User findUser(String userName){
        for (User user: users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }
    public void saveFoodData() {
        try {
            // Write the users and their health data to a file(s)
            FileWriter writer = new FileWriter("food-data.txt");
            for (User user : users) {
                for (Food food : user.getFoodList()) {
                    writer.write(user.getUserName() + "," + food.getName() + "," + food.getCalories() + "," + food.getDate() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFoodData() {
        // Read the users and their health data from a file(s)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("food-data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                User user = findUser(username);
                if (user == null) {
                    user = new User(username);
                    addUser(user);
                }
                Food food = new Food(parts[1], Integer.parseInt(parts[2]), parts[3]);
                user.addFood(food);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveExerciseData() {
        try {
            // Write the users and their health data to a file(s)
            FileWriter writer = new FileWriter("exercise-data.txt");
            for (User user : users) {
                for (Exercise exercise : user.getExerciseList()) {
                    writer.write(user.getUserName() + "," + exercise.getName() + "," + exercise.getDuration()
                            + "," + exercise.getCaloriesBurned() + "," + exercise.getDate() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadExerciseData() {
        // Read the users and their health data from a file(s)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("exercise-data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                User user = findUser(username);
                if (user == null) {
                    user = new User(username);
                    addUser(user);
                }
                Exercise exercise = new Exercise(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                user.addExercise(exercise);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSleepData() {
        try {
            // Write the users and their health data to a file(s)
            FileWriter writer = new FileWriter("sleep-data.txt");
            for (User user : users) {
                for (Sleep sleep : user.getSleepList()) {
                    writer.write(user.getUserName() + "," + sleep.getStartDate() + "," + sleep.getStart()
                            + "," + sleep.getEndDate() + "," + sleep.getEnd() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSleepData() {
        // Read the users and their health data from a file(s)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sleep-data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                User user = findUser(username);
                if (user == null) {
                    user = new User(username);
                    addUser(user);
                }
                Sleep sleep = new Sleep(parts[1], parts[2], parts[3], parts[4]);
                user.addSleep(sleep);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String toString(){
        String userList = "";
        for (User user: users){
            userList += "\n"+user;
        }
        return userList;
    }
}

package controllers;

import models.Sleep;
import models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SleepService {
    private User user;

    public SleepService(User user){
        this.user = user;
    }

    public int calculateTimePeriod(String date1, String date2){
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
            Date firstDate = format.parse(date1);
            Date secondDate = format.parse(date2);
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e){
            e.printStackTrace();
            System.out.println("There was an error with the date you input, please try again later.");
            return 1;
        }
    }

    public void printDailySleep(String date){
        List<Sleep> sleeps = user.getSleepList();
        for (Sleep sleep: sleeps){
            if(sleep.getStartDate().equals(date)){
                System.out.println(sleep.stringDuration());
            }
        }
    }
    public void printAverage(String date1, String date2){
        List<Sleep> sleeps = user.getSleepList();
        int totalMinutes = 0;
        for(Sleep sleep: sleeps){
            totalMinutes += sleep.calculateMinutes();
            totalMinutes += (sleep.calculateHours() * 60);
        }
        int average = calculateTimePeriod(date1, date2);
        int averageSleep = totalMinutes/average;
        int averageMinutes = averageSleep % 60;
        int averageHours = (averageSleep - averageMinutes)/60;
        System.out.println("From " + date1+ " to " + date2 + " you slept a total of " + totalMinutes
                + " minutes, averaging " + averageHours + " hours and " + averageMinutes + " minutes a night.");
    }
}

import controllers.UserService;
import models.Exercise;
import models.Food;
import models.Sleep;
import models.User;

public class Main {
    public static void main(String[] args){
        UserService userService = new UserService();
        userService.loadFoodData();
        userService.loadExerciseData();
        userService.loadSleepData();
        System.out.println(userService);
        userService.saveExerciseData();
        userService.saveFoodData();
        userService.saveSleepData();
    }
}

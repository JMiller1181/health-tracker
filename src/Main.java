import controllers.UserService;
import models.Exercise;
import models.Food;
import models.User;

public class Main {
    public static void main(String[] args){
        UserService userService = new UserService();
        userService.loadFoodData();
        userService.loadExerciseData();
        User user = new User("Steve");
        User user1 = new User("Jacob");
        Exercise exercise = new Exercise("Running", 30, 20, "06/12/23");
        user.addExercise(exercise);
        user1.addExercise(exercise);
        userService.addUser(user);
        userService.addUser(user1);
        System.out.println(userService);
        userService.saveExerciseData();
        userService.saveFoodData();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> categoriesAndDishes = new HashMap<>();

    void addDish(String dishType, String dishName) {
        for (ArrayList<String> values : categoriesAndDishes.values()) {
            for (String value : values) {
                if (value.equals(dishName)) {
                    System.out.println("Такое блюдо уже есть в меню");
                    return;
                }
            }
        }
        if (categoriesAndDishes.containsKey(dishType)) {
            ArrayList<String> existedCategoryDish = categoriesAndDishes.get(dishType);
            existedCategoryDish.add(dishName);
        } else {
            ArrayList<String> newCategoryDish = new ArrayList<>();
            newCategoryDish.add(dishName);
            categoriesAndDishes.put(dishType, newCategoryDish);
        }
        System.out.println("Блюдо успешно добавлено!");
    }

    ArrayList<String> generateRandomCombo(ArrayList<String> categories) {

        ArrayList<String> combo = new ArrayList<>();
        Random random = new Random();

        for (String category : categories) {
            int randomDishNumber = random.nextInt(categoriesAndDishes.get(category).size());
            String dish = categoriesAndDishes.get(category).get(randomDishNumber);
            combo.add(dish);
        }
        return combo;
    }

    boolean existCategory(String item) {
        boolean flag = false;
        for (String s : categoriesAndDishes.keySet()) {
            if (s.equals(item)) {
                flag = true;
            }
        }
        return flag;
    }
}

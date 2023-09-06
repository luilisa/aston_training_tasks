package Lesson5.task1;

public class FoodBowl {
    private int foodAmount;

    public void putFood(int foodAmount) {
        if (foodAmount < 0) {
            System.out.println("Положить можно только положительное количество корма!");
        }
        else {
            this.foodAmount = foodAmount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

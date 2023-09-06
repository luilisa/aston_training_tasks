package Lesson5.task1;

public class Cat extends Animal{

    public static int catCount;
    public boolean full;

    public Cat(String name) {
        super(name);
        this.full = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Слишком далеко для " + this.name);
        }
        else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(this.name + " не умеет плавать!");
    }

    public void eat(FoodBowl bowl, int foodAmount) {
        if (bowl.getFoodAmount() >= foodAmount) {
            this.full = true;
            bowl.putFood(bowl.getFoodAmount() - foodAmount);
            System.out.println(this.name + " покушал " + foodAmount + " еды. В миске осталось: " + bowl.getFoodAmount());
        }
        else {
            System.out.println("В миске не хватает еды для " + this.name);
        }
    }
}

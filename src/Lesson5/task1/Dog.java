package Lesson5.task1;

public class Dog extends Animal{

    public static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Слишком далеко для " + this.name);
        }
        else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(this.name + " не умеет плавать так далеко!");
        }
        else {
            super.swim(distance);
        }
    }
}

package Lesson5.task1;

public class Animal {

    public String name;
    public static int animalCount;


    public Animal(String name) {
        this.name = name;
        animalCount++;
    }


    public void run(int distance) {
        System.out.println(this.name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(this.name + " проплыл " + distance + " м.");
    }

}

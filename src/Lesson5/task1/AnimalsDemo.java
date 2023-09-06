package Lesson5.task1;

public class AnimalsDemo {

    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        Dog sharik = new Dog("Шарик");
        bobik.run(100);
        bobik.swim(20);
        sharik.run(600);
        sharik.swim(10);
        System.out.println(Dog.dogCount + " - количество собак");

        Cat persik = new Cat("Персик");
        persik.run(100);
        Cat kuzya = new Cat("Кузя");
        kuzya.swim(10);
        Cat murka = new Cat("Мурка");
        murka.run(300);
        System.out.println(Cat.catCount + " - количество котов");
        System.out.println(Animal.animalCount + " - количество животных");

        Cat[] cats = new Cat[3];
        cats[0] = persik;
        cats[1] = kuzya;
        cats[2] = murka;
        FoodBowl bowl = new FoodBowl();
        bowl.putFood(20);
        for (Cat cat: cats) {
            cat.eat(bowl, 10);
            System.out.println(cat.full);
        }
    }
}

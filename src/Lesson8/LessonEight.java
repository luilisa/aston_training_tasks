package Lesson8;

import java.util.*;

public class LessonEight {

    public static int numberOfDuplicates(String word, ArrayList<String> names) {
        int c = 0;
        for (String name: names) {
            if (name.equals(word)) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Map<String, Integer> uniqueNames = new HashMap<>();
        names.add("Alina");
        names.add("Alena");
        names.add("Anton");
        names.add("Elena");
        names.add("Anton");
        names.add("Andrei");
        names.add("Alina");
        names.add("Alina");
        names.add("Luiza");
        names.add("Daria");
        names.add("Kristina");
        names.add("Alina");
        names.add("Alena");
        names.add("Anton");
        names.add("Elena");
        names.add("Anton");
        names.add("Andrei");
        names.add("Alina");
        for (String name: names) {
            int c = numberOfDuplicates(name, names);
            uniqueNames.put(name, c);
        }

        System.out.println(names);
        System.out.println(uniqueNames);
    }

}

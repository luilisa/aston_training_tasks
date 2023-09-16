package Lesson8;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, String> phonebook = new HashMap<>();

    public void add(String secondName, String phoneNumber) {
        phonebook.put(phoneNumber, secondName);
    }

    public void get(String secondName) {
        System.out.println(secondName + "'s phone numbers:");
        for (Map.Entry<String, String> element: phonebook.entrySet()) {
            if (secondName.equals(element.getValue())) {
                System.out.print(element.getKey() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook1 = new Phonebook();
        phonebook1.add("Petrov", "89111111111");
        phonebook1.add("Petrov", "89222222222");
        phonebook1.add("Petrov", "89333333333");
        phonebook1.add("Ivanov", "89444444444");
        phonebook1.add("Ivanov", "89555555555");
        phonebook1.get("Petrov");
        phonebook1.get("Ivanov");
    }
}

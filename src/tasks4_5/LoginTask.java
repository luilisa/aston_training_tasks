package tasks4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoginTask {
    public static void main(String[] args) throws IOException {
        ArrayList<String> logins = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Начните вводить логины: ");

        String s = "init";

        while (true) {
            if (!s.isEmpty()) {
                 s = bufferedReader.readLine();
                logins.add(s);
            }
            else {
                break;
            }
        }

        System.out.println("Логины, начинающиеся на 'f': ");
        logins.stream().filter(login -> login.startsWith("f")).forEach(System.out::println);
    }
}

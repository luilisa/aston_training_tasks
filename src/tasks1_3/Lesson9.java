package tasks1_3;

import java.util.*;
import java.util.stream.IntStream;

public class Lesson9 {

    public static void main(String[] args) {
        //1 задание
        int[] nums = new Random().ints(10, 0, 10).toArray();
        System.out.println(Arrays.toString(nums));
        long count = IntStream.of(nums).filter(w -> w % 2 == 0).count();
        System.out.println(count);

        //2 задание
        List<String> strings = Arrays.asList("Highload", "High", "Load", "Highload");
        long count1 = strings.stream().filter(s -> Objects.equals(s, "High")).count();
        System.out.println(count1);
        String firstElement = strings.stream().findFirst().orElse("0");
        System.out.println("Первый элемент: " + firstElement);
        String lastElement = strings.stream().reduce((first, second) -> second)
                .orElse("0");
        System.out.println("Последний элемент: " + lastElement);

        //3 задание
        List<String> fs = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        Object[] fsArray = fs.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1)))).toArray();

        System.out.println(Arrays.toString(fsArray));
    }

}

package pl.strefakursow.springadvanced.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasAndStreams {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("New thread is running"));
        thread.start();
        System.out.println(thread);

        List<Integer> numbers = Arrays.asList(21, 5, 43, 29, 80, 69, 47, 72);

        int result = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                result += i * 2;
            }
        }
        System.out.println(result);

        System.out.println("Second way " +
                numbers.stream()
                        .filter(i -> i % 2 == 0).
                        mapToInt(i -> i * 2)
                        .sum());

        System.out.println(numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element));

        System.out.println(numbers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList()));

    }

}

package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        gen1();

        gen2();

        gen3();

        gen4();

        demo();
    }

    public static void demo() {
        Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).forEach(System.out::println);

        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter((x) -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("sum: " + sum);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int integer = list.stream().max(Comparator.comparingInt(x -> x)).get();
        System.out.println("max: " + integer);
    }

    public static void gen4() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    public static void gen3() {

        Stream<Integer> stream = Stream.generate(() -> 1);
        stream.limit(10).forEach(System.out::println);

    }

    public static void gen2() {
        List<String> list = Arrays.asList("2", "19", "0");
        list.stream().forEach(System.out::println);
    }

    public static void gen1() {
        String[] strings = {"d", "a", "b"};
        Stream<String> stream = Stream.of(strings);
        stream.forEach(System.out::println);
    }
}

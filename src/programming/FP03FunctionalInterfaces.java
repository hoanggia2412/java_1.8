package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, String> squareFunction2 = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return " value is "+ integer;
            }
        };
        Consumer<Integer> consumer = System.out::println;
        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String integer) {
                System.out.println(integer);
            }
        };
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
       int sum = numbers.stream()
                .reduce(0,binaryOperator);
        System.out.println(sum);
    }
}

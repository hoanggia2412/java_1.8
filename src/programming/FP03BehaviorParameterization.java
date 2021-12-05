package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
//        filterAndPrint(numbers, x -> x % 2 == 0);
//        filterAndPrint(numbers, x -> x %2 != 0); // in số lẻ
//        filterAndPrint(numbers, x -> x %3 == 0); // in số chia hết cho 3

        List squareList = collectSquareNumbersToList(numbers, x-> x*x);
        List cubesList = collectSquareNumbersToList(numbers, x-> x*x*x);
        List doubledList = collectSquareNumbersToList(numbers, x->x*2);
        System.out.println(squareList);
    }
    public static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
    public static List<Integer> collectSquareNumbersToList(List<Integer> numbers, Function<Integer,Integer> function){
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}

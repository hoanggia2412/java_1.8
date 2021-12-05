package programming;

import java.util.Arrays;
import java.util.List;

public class FP02Operation {
    public static void main(String[] args) {
       List numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)

        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    public static int addListFunctional(List<Integer> numbers){
      return numbers.stream()
                .reduce(0,Integer::sum);
    }
    public static int squareEveryNumberAndFindSum(List<Integer> numbers){
        return numbers.stream()
                .map(number -> number * number)
                .reduce(0,(a,b)->a+b);
    }
    public static int cubesEveryNumberAndFindSum(List<Integer> numbers){
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0,Integer::sum);
    }
    public static int findSumOfOddNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0,Integer::sum);
    }
}

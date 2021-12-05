package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP02Functional {
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
        System.out.println(findSumOfOddNumbers(list));
        IntStream.iterate(2, x->x+2).limit(5).peek(System.out::println);

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

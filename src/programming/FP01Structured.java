package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printEvenNumbersInListStructured(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15)); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
    }

    public static void  printAllNumbersInListStructured(List<Integer> numbers){
        for (Integer number: numbers) {
            System.out.println(number);
        }
    }
    public static void  printEvenNumbersInListStructured(List<Integer> numbers){
        for (Integer number: numbers) {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}

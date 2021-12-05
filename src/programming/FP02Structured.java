package programming;

import java.util.Arrays;
import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {
       List list = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
        System.out.println(addListStructured(list));
    }

    public static int addListStructured(List<Integer> numbers){
        int sum = 0;
        for (Integer number : numbers){
             sum += number;
        }
        return sum;
    }
}

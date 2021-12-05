package programming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfacesSummary {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0; // Predicate inputs a parameter then returns boolean

        Function<Integer,Integer> squareFunction = x -> x * x; // Function<T,R> inputs one T parameter then returns one R
        Function<Integer,String> stringFunction = x -> "string value = " + x;

        Consumer<Integer> printConsumer = x -> System.out.println(x); //Consumer inputs a parameter then does void method

        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y; //BinaryOperator inputs 2 parameters then returns one value
       // System.out.println(sumBinaryOperator.apply(2,3));

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(1000); //No input -> return something
//        System.out.println(randomSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> x*3; //UnaryOperation inputs a parameter then returns a value
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate =  (number, string) -> number > 10 && string.length() >5;
        System.out.println(biPredicate.test(20,"BiPredicate"));

        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + " " + str2);
        biConsumer.accept("Spring","Boot");

        IntConsumer intConsumer = x -> System.out.println(x);
        intConsumer.accept(10);
    }
}

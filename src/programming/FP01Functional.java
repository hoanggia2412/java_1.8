package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {
    public static void main(String[] args) {
        // printAllNumbersInListFunctional(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15)); //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
        List numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List doubledNumbers = doubleList(numbers);
        System.out.println(doubledNumbers);
        List courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        printCourseHasAtLeast4Letters(list);
//        sortedListWithComparator(courses);
    }

    public static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().forEach(System.out::print);
    }

    public static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream() //Convert to stream
//                .filter(FP01Functional::isEven) //Filter -Only Allow Even Numbers
                .filter(number -> number % 2 == 0) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    public static void printOddNumberInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    public static void printCourseContainingSpecifyWord(List<String> courses, String word) {
        courses.stream()
                .filter(course -> course.contains(word))
                .forEach(System.out::println);
    }

    public static void printCourseHasAtLeast4Letters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    public static void printNumberOfCharactersEachCourse(List<String> courses) {
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    public static void printSquareOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    public static int cubes(int number) {
        return number * number * number;
    }

    public static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number) //This here
                .forEach(System.out::println);
    }

    public static void sortedListWithComparator(List<String> courses) {
        courses.stream()
                .sorted(Comparator.comparingInt(s -> s.length()))
                .forEach(System.out::println);
    }

    public static List<Integer> doubleList(List<Integer> numbers){
        return numbers.stream().map(number -> number *number).collect(Collectors.toList());
    }

    public static  List<Integer> buildAListWithEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    public static  List<Integer> buildAListWithLengthsOfCourses(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }
}


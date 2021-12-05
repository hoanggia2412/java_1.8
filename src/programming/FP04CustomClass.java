package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":"+ noOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {

    //Higher order Function
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutoffReviewScore){
            return course ->  course.getReviewScore() > cutoffReviewScore;
    }
    public static void main(String[] args) {
       List<Course> courses = Arrays.asList(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000));

//        List<String> name = courses.stream().map(course -> course.getName()).collect(Collectors.toList());
//        List chars = name.stream().map(each -> each.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
//        chars.stream().forEach(System.out::println);

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreThan80Predicate = createPredicateWithCutOffReviewScore(80);
        Predicate<Course> nameContainSpring = course -> course.getName().contains("Spring");



        System.out.println(courses.stream()
                .allMatch(reviewScoreThan80Predicate));
        System.out.println(courses.stream()
                .anyMatch(nameContainSpring));

        //sorted by Comparator
        Comparator<Course> comparatorByNumberOfStudent = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream()
                .sorted(comparatorByNumberOfStudent).collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore).reversed()).collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore).reversed())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore).reversed()).skip(3).collect(Collectors.toList()));
        System.out.println("========================");
        Comparator<Course> reviewScore = Comparator.comparingInt(value -> value.getReviewScore());
        System.out.println(courses.stream()
                .max(reviewScore).get());

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() <90)
                .min(Comparator.comparingInt(course-> course.getReviewScore()))
                .orElse(courses.get(courses.size()-1)));

        System.out.println("Filter courses < 95 then return the first element: " + courses.stream()
                .filter(course -> course.getReviewScore() <95)
                .findFirst().get());

        System.out.println("Sum of elements have reviewScore > 95: " + courses.stream()
                .filter(course -> course.getReviewScore() >95)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        System.out.println("Group by category: " + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println("Group by category then counting: " + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.counting())));

        System.out.println("Group by category then max by: " + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println("Group by category: " + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));


    }
}

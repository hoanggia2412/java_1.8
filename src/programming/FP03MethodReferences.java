package programming;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

public class FP03MethodReferences {

    public static String toUpperCase(String str){
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
//                .map(str -> str.toUpperCase())
                .map(FP03MethodReferences::toUpperCase)
                .forEach(System.out::println );
       UnaryOperator<String> unaryOperator = String::new;
        System.out.println(unaryOperator.apply("Spring Security"));

    }

}

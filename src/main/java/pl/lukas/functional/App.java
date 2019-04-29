package pl.lukas.functional;

import com.sun.javafx.binding.IntegerConstant;
import pl.lukas.functional.domain.Index;
import pl.lukas.functional.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20; // take object, return boolean
        Consumer<String> print = System.out::println; // take object, return nothing


        Double sumOfRandomDoubles = Stream
                .generate(Math::random)
                .limit(10)
                .reduce(0.0, Double::sum);

        List<Integer> collect = createDataStream()
                .map(Student::getAge)
                .collect(Collectors.toList());

        String allAges = createDataStream()
                .map(Student::getAge)
                .map(age -> age.toString())
                .collect(Collectors.joining(", "));

        System.out.println(allAges);

        Map<Integer, List<Student>> studentsByAge = createDataStream().collect(groupingBy(Student::getAge));

        studentsByAge.forEach(new BiConsumer<Integer, List<Student>>() {
            @Override
            public void accept(Integer integer, List<Student> students) {
                System.out.println(integer);
                students.stream().map(Student::getName).forEach(System.out::println);
            }
        });
    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Pawel", 23, "69874");
        Student john = new Student("John", 21, "74568");
        Student mark = new Student("Mark", 21, "73562");
        Student billy = new Student("Billy A.", 19, "78956");
        Student billy2 = new Student("Billy D.", 28, "55752");
        return Stream.of(pawel, john, billy, billy2, mark);
    }
}
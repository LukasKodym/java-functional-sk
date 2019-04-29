package pl.lukas.functional;

import pl.lukas.functional.domain.Student;

import java.util.Comparator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

//        createDataStream().limit(3).map(Student::getIndexNumber).forEach(System.out::println);
//        createDataStream().skip(3).map(Student::getIndexNumber).forEach(System.out::println);
//        createDataStream().distinct().map(Student::getName).forEach(System.out::println); // pass only unique values
//        createDataStream().sorted().map(Student::getName).forEach(System.out::println);
        createDataStream().sorted(Comparator.comparingInt(Student::getAge))
                .map(Student::getName)
                .forEach(System.out::println);

        long count = createDataStream().sorted(Comparator.comparingInt(Student::getAge))
                .map(Student::getName)
                .count();
        System.out.println(count);

    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Pawel", 23, "69874");
        Student john = new Student("John", 21, "74568");
        Student billy = new Student("Billy A.", 19, "78956");
        Student billy2 = new Student("Billy D.", 28, "78956");
        Student mark = new Student("Mark", 21, "73562");
        Student martha = new Student("Martha", 25, "73562");
        return Stream.of(pawel, john, billy, billy2, mark, martha);
    }
}
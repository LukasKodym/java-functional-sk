package pl.lukas.functional;

import pl.lukas.functional.domain.Index;
import pl.lukas.functional.domain.Student;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20; // take object, return boolean
        Consumer<String> print = System.out::println; // take object, return nothing

        createDataStream()
                .filter(over20)
                .map(Student::getName)
                .filter(name -> name.startsWith("Billy"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        createDataStream()
                .map(Student::getIndex)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Index::getIndexNumber)
                .forEach(System.out::println);
    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Pawel", 23, "69874");
        Student john = new Student("John", 21, "74568");
        Student billy = new Student("Billy A.", 19, "78956");
        Student billy2 = new Student("Billy D.", 28, "55752");
        return Stream.of(pawel, john, billy, billy2);
    }
}
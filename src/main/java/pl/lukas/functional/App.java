package pl.lukas.functional;

import pl.lukas.functional.domain.Student;
import java.util.function.*;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20; // take object, return boolean
        Consumer<String> print = System.out::println; // take object, return nothing
//        Supplier<List<Student>> supplyPredefinedStudents = App::createData; // take nothing, return object
        Function<Student, String> getStudentName = Student::getName; // take object first type, return object another type

//        createDataStream().filter(over20).map(getStudentName).forEach(print);

        createDataStream().filter(s -> s.getName().equals("Billy")).filter(over20).forEach(System.out::println);


    }

    private static Stream<Student> createDataStream() {
        Student pawel = (new Student("Pawel", 23, "69874"));
        Student john = (new Student("John", 21, "74568"));
        Student billy = (new Student("Billy", 19, "78956"));
        Student billy2 = (new Student("Billy", 28, "55752"));
        return Stream.of(pawel, john, billy);
    }
}
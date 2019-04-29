package pl.lukas.functional;

import pl.lukas.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20; // take object, return boolean
        Consumer<String> print = System.out::println; // take object, return nothing
        Supplier<List<Student>> supplyPredefinedStudents = App::createData; // take nothing, return object
        Function<Student, String> getStudentName = Student::getName; // take object first type, return object another type

        BiFunction<Student,String, Student> changeIndex = Student::changeIndexNumber;


//        consumeStudents(filterStudents(supplyPredefinedStudents, over20), getStudentName, print);

        List<Student> students = supplyPredefinedStudents.get();
        students.stream().filter(over20).map(getStudentName).forEach(print);


    }

    private static void consumeStudents(List<Student> students,
                                        Function<Student, String> function,
                                        Consumer<String> consumer) {
        for (Student s : students) {
            consumer.accept(function.apply(s));
        }
    }

    private static List<Student> filterStudents(Supplier<List<Student>> supplier, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        List<Student> students = supplier.get();
        for (Student s : students) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }


    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Pawel", 23, "69874"));
        Student john = (new Student("John", 21, "74568"));
        Student billy = (new Student("Billy", 19, "78956"));
        return Stream.of(pawel, john, billy);
    }
}
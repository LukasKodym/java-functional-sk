package pl.lukas.functional;

import pl.lukas.functional.domain.Index;
import pl.lukas.functional.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20; // take object, return boolean
        Consumer<String> print = System.out::println; // take object, return nothing
        Supplier<List<Student>> supplyPredefinedStudents = App::createData; // take nothing, return object
        Function<Student, String> getStudentName = Student::getName; // take object first type, return object another type

        BiFunction<Student,String, Student> changeIndex = Student::changeIndexNumber;


        consumeStudents(filterStudents(supplyPredefinedStudents, over20), getStudentName, print);

        Student student = supplyPredefinedStudents.get().get(0);

        Optional<Index> index = student.getIndex();

        if (index.isPresent()) {
            System.out.println(index.get().getIndexNumber());
        }


        index.ifPresent(i -> System.out.println(i.getIndexNumber()));

        index.filter(i -> i.getIndexNumber().equals("12345"));

        index.map(i -> i.getIndexNumber())
                .filter(indexNumber -> indexNumber.equals("12345"))
                .ifPresent(indexNumber -> System.out.println(indexNumber));
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

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Pawel", 23, "69874"));
        result.add(new Student("John", 21, "74568"));
        result.add(new Student("Billy", 19, "78956"));
        return result;
    }
}
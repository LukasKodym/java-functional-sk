package pl.lukas.functional;

import pl.lukas.functional.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {

        Predicate<Student> over20 = student -> student.getAge() >= 20;
        Consumer<Student> printStudentName = student -> System.out.println(student.getName());
        Supplier<List<Student>> supplyPredefinedStudents = () -> createData();
        Function<Student,String> function = new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return null;
            }
        };

        consumeStudents(filterStudents(supplyPredefinedStudents, over20), printStudentName);
    }

    private static void consumeStudents(List<Student> students, Consumer<Student> consumer) {
        for (Student s : students) {
            consumer.accept(s);
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
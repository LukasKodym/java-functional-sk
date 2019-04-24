package pl.lukas.functional;

import pl.lukas.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        List<Student> students = createData();

        Predicate<Student> isBilly = student -> student.getName().equals("Billy");
        Predicate<Student> over20 = student -> student.getAge() >= 20;

        filterStudents(students, isBilly);
        filterStudents(students, over20);

    }

    private static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
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
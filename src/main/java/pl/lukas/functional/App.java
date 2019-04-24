package pl.lukas.functional;

import pl.lukas.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        List<Student> students = createData();


        getBillies(students);
        getOver20(students);

    }

    private static List<Student> getOver20(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getAge() >= 20) {
                result.add(s);
            }
        }
        return result;
    }

    private static List<Student> getBillies(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equals("Billy")) {
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
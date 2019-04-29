package pl.lukas.functional;

import pl.lukas.functional.domain.Student;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        IntStream intStream = createDataStream().map(Student::getAge).mapToInt(Integer::intValue);

        intStream.sorted().forEach(System.out::println);
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
package pl.lukas.functional.domain;

import lombok.Getter;

import java.util.Optional;

@Getter
final public class Student {

    private String name;
    private int age;
    private Index index;

    public Student(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.index = new Index(indexNumber);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<Index> getIndex() {
        return Optional.ofNullable(this.index);
    }

    public String getStudentInformation() {
        return this.name + " " + this.age;
    }

    public Student changeIndexNumber(String newIndexNumber) {
        return new Student(this.name, this.age, newIndexNumber);
    }
}
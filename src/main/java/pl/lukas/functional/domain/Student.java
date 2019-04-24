package pl.lukas.functional.domain;

import lombok.Getter;

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
}
package pl.lukas.functional.domain;

import lombok.Getter;

@Getter
final public class Index {

    private String name;

    public Index(String name) {
        this.name = name;
    }
}
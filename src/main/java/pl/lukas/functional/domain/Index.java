package pl.lukas.functional.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
final public class Index {

    private String indexNumber;

    public Index(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getIndexNumber() {

        return this.indexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return Objects.equals(indexNumber, index.indexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexNumber);
    }
}
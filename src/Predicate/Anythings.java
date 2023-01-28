package Predicate;

import java.util.Objects;

public class Anythings {
    private String title;
    private  int number;

    public Anythings(String title, int number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public Anythings setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anythings)) return false;
        Anythings anythings = (Anythings) o;
        return getNumber() == anythings.getNumber() && getTitle().equals(anythings.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getNumber());
    }

    @Override
    public String toString() {
        return "Объект: " + "название *" + title + "*, случайный номер: " + number;
    }
}

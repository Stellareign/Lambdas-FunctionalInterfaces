package Consumer;

import java.util.Objects;

public class Person {
    private String fio;
    private  int age;

    public Person(String fio, int age) {
        this.fio = fio;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public int getNumber() {
        return age;
    }

    public Person setFio(String fio) {
        this.fio = fio;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && getFio().equals(person.getFio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFio(), age);
    }

    @Override
    public String toString() {
        return "Объект: " + "название *" + fio + "*, случайный номер: " + age;
    }
}

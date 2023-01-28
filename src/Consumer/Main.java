package Consumer;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Иванов И.И.", 45);
        Person person2 = new Person("Петров П.П.", 33);
        Person person3 = new Person("Семёнов С.С.", 16);
        Person person4 = new Person("Кузнецов К.К.", 98);
        Person person5 = new Person("Михайлов М.М.", 21);
        Person person6 = new Person("Огнев О.О.", 55);
        List<Person> personList = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5, person6)); // добавление по-новому

        for (Person person : personList) {
            System.out.println(person);
        }
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Привет, меня зовут " + person.getFio());
            }
        };
        consumer.accept(person1);
        Consumer<Person> consumer1 = person -> System.out.println("Привет, меня зовут " + person.getFio());
        consumer1.accept(person2);
    }
}




package Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Anythings anything1 = new Anythings("кое-что", -4);
        Anythings anything2 = new Anythings("что-то", 33);
        Anythings anything3 = new Anythings("нечто", 6);
        Anythings anything4 = new Anythings("что-нибудь", -113);
        Anythings anything5 = new Anythings("что же", -84);
        Anythings anything6 = new Anythings("это же", 135);
        List<Anythings> anythingsList = new ArrayList<>(Arrays.asList(anything1, anything2, anything3, anything4, anything5, anything6)); // добавление по-новому

        for (Anythings anything : anythingsList) {
            System.out.println(anything);
        }

        Predicate<Anythings> predicate = new Predicate<Anythings>() { //вызываем предикат
            @Override
            public boolean test(Anythings anythings) {
                return anythings.getNumber() > 0; // условие предиката
            }
        };
        for (Anythings anything : anythingsList)
            System.out.println(predicate.test(anything)); // выводим предикат в консоль


        System.out.println("--------------------------------------------");
        Predicate<Anythings> predicate1 = anythings -> anythings.getNumber() < 0;
        for (Anythings anything : anythingsList) {
            System.out.println(predicate.test(anything));
        }
    }
}





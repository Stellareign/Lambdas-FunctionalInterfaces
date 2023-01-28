


package Function_Supplier;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Задание 4
        Double one = 125.969;
        Function<Double, Long> changeDouble = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) { // one меняется в методе на aDouble
                return Math.round(aDouble); // округляем и возвр. новое значение
            }
        };
        System.out.println(changeDouble.apply(one)); //выводим результат метода в консоль

        Function<Double, Long> changeDouble1 = number -> Math.round(number); // лямбда, number - внутриметодная переменная
        System.out.println(changeDouble1.apply(236.963));

        Supplier<Integer> rndInt = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random rnd1 = new Random(); // генератор случайных чисел
                return rnd1.nextInt(100); // nextInt - считает от 0, bound  - верхняя граница
            }
        };
        System.out.println(rndInt.get());

        Supplier<Integer> integerSupplier = () -> {
            Random rnd1 = new Random();
            return rnd1.nextInt(100); // можно без ограничения использовать
        };
        System.out.println((integerSupplier.get()));
    }
}

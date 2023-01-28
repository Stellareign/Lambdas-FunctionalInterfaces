package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        int minNumber = -50; // нижняя граница
        int maxNumber = 50; // верхняя граница
        Random randomNumbers = new Random(); // генератор случайных чисел (можно использовать SecureRandom)
        List<Integer> allRndNumbers = new ArrayList<>(); // создаём наш список случайных чисел
        for (int i = 1; i <= 25; i++) { // задаём "длину листа"
            allRndNumbers.add(randomNumbers.nextInt((maxNumber - minNumber) + 1) + minNumber); // добавляем случ.числа в список длиной 25 ячеек в диапозоне от -50 до 50
        }
        System.out.println(allRndNumbers); // выводим в консоль готовый список, обязательно вне цикла

        for (Integer ignored : allRndNumbers) {
            Predicate<Integer> condition = integer -> integer > 0; // создаём предикат

            Function<Integer, String> isTrue = o -> "Положительное число " + o; // делаем преобразование для вывода числа с пояснением
            Function<Integer, String> isFalse = o -> "Отрицательное число " + o;
            Function<Integer, String> seeList = ternaryOperator(condition, isTrue, isFalse);
            System.out.println(seeList.apply(ignored));//
        }
    }
}







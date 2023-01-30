package Streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        int minNumber = -50; // нижняя граница
        int maxNumber = 50; // верхняя граница
        Random randomNumbers = new Random(); // генератор случайных чисел (можно использовать SecureRandom)
        List<Integer> allRndNumbers = new ArrayList<>(); // используем наш список случайных чисел из задания 5
        for (int i = 1; i <= 100; i++) {
            allRndNumbers.add(randomNumbers.nextInt((maxNumber - minNumber) + 1) + minNumber); // добавляем случ.числа в список в диапозоне от -50 до 50
        }
        System.out.println(allRndNumbers);
        System.out.println("******** Лист из стрима: *********");

        Stream<Integer> rndNumbersStream = allRndNumbers.stream();

        minMaxOfStream(rndNumbersStream, Integer::compareTo, (minNum, maxNum) -> System.out.println("Минимальное число: " + minNum + "\n" +
                "Максимальное число: " + maxNum)); // применяем созданный метод к списку
        System.out.println("******** Подсчёт чётных чисел в листе: *********");
        evenAndOddNumbers((List<Integer>) allRndNumbers);

    }

    // пишем вне метода main (!)
    public static <T> void minMaxOfStream( // создаём метод с заданными в ДЗ элементами на входе
                                           Stream<? extends T> stream,
                                           Comparator<? super T> order,
                                           BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> listStream;
        listStream = stream// создаём стрим из листа
                .limit(10) // ограничиваем 10-ю значениями
                .sorted() // сортируем от меньшего к большему
                .collect(Collectors.toList()); // упаковываем стрим в лист
        T minNum = null;
        T maxNum = null;
        if (listStream.size() != 0) {
            minNum = listStream.get(0); // забираем после сортировки минимальное первое значение
            maxNum = listStream.get(listStream.size() - 1); // забираем после сортировки максимальное последнее значение
        }
        minMaxConsumer.accept(minNum, maxNum);
        System.out.println(listStream); // выводим стрим-лист в консоль для проверки (т.к. у нас случайные значения в листе)
    }

    public static void evenAndOddNumbers(List<Integer> list) {
        System.out.println(list.stream() // записываем внутри sout стрим с операциями для вывода на печать, как иначе - не придумалось
                .filter(i -> i % 2 == 0)
                .count());

    }
}












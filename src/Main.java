import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }
    public static void task1() { System.out.println("Задача 1");
    Predicate<Integer> positiveNumber = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer > 0;
        }
    };
    List<Integer> integerList = new ArrayList<>();
    integerList.add(-1);
    integerList.add(2);
    integerList.add(-3);
        System.out.println("Анонимный класс");
        for(Integer list: integerList) {
            if(list > 0) {
                System.out.println("Значение Predicate: " + positiveNumber.test(list) + " для числа " + list);
            } else {
                System.out.println("Значение Predicate: " + positiveNumber.test(list) + " для числа " + list);
            }
        }
    Predicate<Integer> positiveNumberLambda = x -> x > 0;
        System.out.println("Лямбда-выражение");
        for(Integer list: integerList) {
            if(list > 0) {
                System.out.println("Значение Predicate: " + positiveNumberLambda.test(list) + " для числа " + list);
            } else {
                System.out.println("Значение Predicate: " + positiveNumberLambda.test(list) + " для числа " + list);
            }
        }
    }
    public static void task2() { System.out.println("\nЗадача 2");
        Consumer<String> entryName = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println("Добрый день, " + s + "! реализовано через анонимный класс");
            }
        };
        entryName.accept("Иван");
        Consumer<String> entryNameLambda = s -> System.out.println("Добрый день, " + s + "! реализовано через лямбда-выражение");
        entryNameLambda.accept("Мария");
    }
    public static void task3() {
        System.out.println("\nЗадача 3");
        Double doubleNumber = 7.0 / 3.0;
        System.out.println("Значение типа Double до округления " + doubleNumber);
        Function<Double, Long> doubleToLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return (Long) Math.round(aDouble);
            }
        };
        System.out.println("Реализовано через анонимный класс");
        System.out.println("Значение типа Integer после округления и приведения типа: " + doubleToLong.apply(doubleNumber));
        Function<Double, Long> doubleIntegerFunction = d -> (Long) Math.round(d);
        System.out.println("Реализовано через лямбда-выражение");
        System.out.println("Значение типа Integer после округления и приведения типа: " + doubleIntegerFunction.apply(doubleNumber));
    }
    public static void task4() {
        System.out.println("\nЗадача 4");
        Random integerRandom = new Random();
        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return integerRandom.nextInt(100) + 1;
            }
        };
        System.out.println("Supplier реализован через анонимный класс");
        for(int i = 0; i < 5; i++) {
            System.out.println("Случайное число: " + integerSupplier.get());
        }
        System.out.println("Supplier реализован через лямбда-функцию");
        Supplier<Integer> integerSupplierLambda = () -> integerRandom.nextInt(100) + 1;
        for(int i = 0; i < 5; i++) {
            System.out.println("Случайное число: " + integerSupplierLambda.get());
        }
    }
    public static void task5() {
        System.out.println("\nЗадача 5");
        System.out.println("Комбинирование нескольких функций в одну сложную функцию");
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println("Длина строки: " + safeStringLength.apply("test"));
        System.out.println("Длина строки: " + safeStringLength.apply(""));
    }
    public static <T,U> Function<T,U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t)? ifTrue.apply(t): ifFalse.apply(t);
    }
}
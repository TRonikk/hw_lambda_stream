import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        // Ошибка возникает из-за того, что мы пытаемся поделить на ноль
        // Код не содержит проверки на нулевое значение делителя

        // Способ решения: добавить проверку на ноль и обработку исключения
        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);
        try {
            int c = calculator.devide.apply(a, b);
            calculator.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();

        // Задание 2
        OnTaskDoneListener listener = System.out::println;

        Worker worker = new Worker(listener);
        worker.start();

        System.out.println();

        // Задание 3
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> positiveIntList = new ArrayList<>();
        List<Integer> evenAndPositiveIntList = new ArrayList<>();
        for (Integer i : intList) {
            if (i > 0) {
                positiveIntList.add(i);
            }
        }

        for (Integer i : positiveIntList) {
            if (i % 2 == 0) {
                evenAndPositiveIntList.add(i);
            }
        }

        Collections.sort(evenAndPositiveIntList);

        System.out.println("Without Stream API:");
        System.out.println(evenAndPositiveIntList);

        System.out.println("With Stream API:");
        StreamMain.start();
        System.out.println();

        // Задание 4
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long countofChild = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Count of child: " + countofChild);

        List<String> listOfConscripts = persons.stream().filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .toList();


    }
}
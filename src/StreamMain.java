import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;


public class StreamMain {

    public static void start() {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

//        List<Integer> result = intList.stream()
//                .filter(x -> x > 0)
//                .filter(x -> x % 2 == 0)
//                .sorted(Comparator.naturalOrder())
//                .collect(Collectors.toList());
//
//        System.out.println(result);

        Stream<Integer> stream = intList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder());

        stream.forEach(System.out::println);
    }
}
package net.fill;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.BiConsumer;

public class MinMaxFinder {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = list.stream().min(order).orElse(null);
            T max = list.stream().max(order).orElse(null);

            minMaxConsumer.accept(min, max);
        }
    }

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 34, 534, 2, 232);
        Comparator<Integer> comparator = Integer::compare;

        findMinMax(stream, comparator, (min, max) -> {
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        });
    }

}

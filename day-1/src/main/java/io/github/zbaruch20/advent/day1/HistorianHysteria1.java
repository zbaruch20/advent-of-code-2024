package io.github.zbaruch20.advent.day1;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import io.github.zbaruch20.advent.common.PuzzleInputReader;
import io.github.zbaruch20.advent.common.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

public class HistorianHysteria1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistorianHysteria1.class);

    private HistorianHysteria1() {}

    public static void main(String[] args) {
        LOGGER.info("Total distance: {}", totalDistance("day1_input.txt"));
    }

    public static int totalDistance(String resource) {
        var distances = distanceLists(PuzzleInputReader.readLines(resource));
        return totalDistance(distances.getT1(), distances.getT2());
    }

    private static Tuple2<List<Integer>, List<Integer>> distanceLists(List<String> lines) {
        List<Integer> list1 = Lists.newArrayListWithCapacity(lines.size());
        List<Integer> list2 = Lists.newArrayListWithCapacity(lines.size());

        lines.forEach(l -> {
            String[] split = l.split("\\s+");
            list1.add(Integer.parseInt(split[0]));
            list2.add(Integer.parseInt(split[1]));
        });

        return new Tuple2<>(list1, list2);
    }

    private static int totalDistance(Collection<Integer> c1, Collection<Integer> c2) {
        return Streams.zip(c1.stream().sorted(), c2.stream().sorted(), Tuple2::new)
                .mapToInt(t -> Math.abs(t.getT1() - t.getT2()))
                .sum();
    }
}

package io.github.zbaruch20.advent.day1;

import com.google.common.collect.Streams;
import io.github.zbaruch20.advent.common.PuzzleInputReader;
import io.github.zbaruch20.advent.common.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class HistorianHysteria1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistorianHysteria1.class);

    private HistorianHysteria1() {}

    public static void main(String[] args) {
        LOGGER.info("Total distance: {}", totalDistance(HistorianHysteriaCommon.DAY_1_INPUT_RESOURCE));
    }

    public static int totalDistance(String resource) {
        var distances = HistorianHysteriaCommon.distanceLists(PuzzleInputReader.readLines(resource));
        return totalDistance(distances.getT1(), distances.getT2());
    }

    private static int totalDistance(Collection<Integer> c1, Collection<Integer> c2) {
        return Streams.zip(c1.stream().sorted(), c2.stream().sorted(), Tuple2::new)
                .mapToInt(t -> Math.abs(t.getT1() - t.getT2()))
                .sum();
    }
}

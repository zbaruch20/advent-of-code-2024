package io.github.zbaruch20.advent.day1;

import com.google.common.collect.Maps;
import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class HistorianHysteria2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistorianHysteria2.class);

    private HistorianHysteria2() {}

    public static void main(String[] args) {
        LOGGER.info("Similarity score: {}", similarityScore(HistorianHysteriaCommon.DAY_1_INPUT_RESOURCE));
    }

    public static int similarityScore(String resource) {
        var distances = HistorianHysteriaCommon.distanceLists(PuzzleInputReader.readLines(resource));
        var counts = getCounts(distances.getT2());
        return distances.getT1()
                .stream()
                .mapToInt(x -> x * counts.getOrDefault(x, 0))
                .sum();
    }

    private static <T extends Comparable<? super T>> Map<T, Integer> getCounts(Collection<T> list) {
        Map<T, Integer> counts = Maps.newTreeMap(Comparator.<T>naturalOrder());
        list.forEach(x -> counts.put(x, counts.getOrDefault(x, 0) + 1));
        return counts;
    }
}

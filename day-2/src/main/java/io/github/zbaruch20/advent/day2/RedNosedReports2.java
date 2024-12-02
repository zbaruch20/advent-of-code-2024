package io.github.zbaruch20.advent.day2;

import com.google.common.collect.Lists;
import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RedNosedReports2 {
    private RedNosedReports2() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RedNosedReports2.class);

    public static void main(String[] args) {
        LOGGER.info("Number of safe reports using the Problem Dampener: {}", numSafeReportsWithDampener(RedNosedReportsCommon.DAY_2_INPUT_RESOURCE));
    }

    public static long numSafeReportsWithDampener(String resource) {
        return PuzzleInputReader.readLines(resource)
                .stream()
                .map(RedNosedReportsCommon::getLevels)
                .map(RedNosedReports2::slices)
                .filter(slices -> slices.anyMatch(RedNosedReportsCommon::isSafe))
                .count();
    }

    private static <T> Stream<List<T>> slices(List<T> list) {
        return IntStream.range(0, list.size()).mapToObj(i -> {
            List<T> slice = Lists.newArrayList(list.subList(0, i)); // wrapper constructor to make it mutable
            slice.addAll(list.subList(i + 1, list.size()));
            return slice;
        });
    }
}

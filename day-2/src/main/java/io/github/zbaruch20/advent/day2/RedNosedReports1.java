package io.github.zbaruch20.advent.day2;

import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedNosedReports1 {
    private RedNosedReports1() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(RedNosedReports1.class);

    public static void main(String[] args) {
        LOGGER.info("Number of safe reports: {}", numSafeReports(RedNosedReportsCommon.DAY_2_INPUT_RESOURCE));
    }

    public static long numSafeReports(String resource) {
        return PuzzleInputReader.readLines(resource)
                .stream()
                .filter(RedNosedReportsCommon::isSafe)
                .count();
    }
}

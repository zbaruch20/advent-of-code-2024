package io.github.zbaruch20.advent.day2;

import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RedNosedReports1 {
    private RedNosedReports1() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(RedNosedReports1.class);
    public static final int MIN_DISTANCE = 1;
    public static final int MAX_DISTANCE = 3;

    public static void main(String[] args) {
        LOGGER.info("Number of safe reports: {}", numSafeReports(RedNosedReportsCommon.DAY_2_INPUT_RESOURCE));
    }

    public static long numSafeReports(String resource) {
        return PuzzleInputReader.readLines(resource)
                .stream()
                .filter(RedNosedReports1::isSafe)
                .count();
    }

    private static boolean isSafe(String report) {
        List<Integer> levels = RedNosedReportsCommon.getLevels(report);

        // initial checks to see if we're increasing or decreasing
        if (levels.size() < 2) return false;
        if (levels.get(0).equals(levels.get(1))) return false; // equal consecutive levels is unsafe
        boolean isIncreasing = levels.get(1) > levels.get(0);

        for (int i = 0; i < levels.size() - 1; i++) {
            int curr = levels.get(i);
            int next = levels.get(i + 1);
            if (next > curr != isIncreasing) {
                // if increasing/decreasing doesn't match initial, report is unsafe
                return false;
            }

            int diff = Math.abs(next - curr);
            if (diff < MIN_DISTANCE || diff > MAX_DISTANCE) {
                // if diff is out of acceptable range, report is unsafe
                return false;
            }
        }

        return true;
    }
}

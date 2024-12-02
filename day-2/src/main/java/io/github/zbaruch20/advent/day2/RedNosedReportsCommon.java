package io.github.zbaruch20.advent.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RedNosedReportsCommon {
    private RedNosedReportsCommon() {}

    public static final String DAY_2_INPUT_RESOURCE = "day2_input.txt";
    public static final String DAY_2_TEST_RESOURCE = "day2_test.txt";

    public static final int MIN_DISTANCE = 1;
    public static final int MAX_DISTANCE = 3;

    static boolean isSafe(String report) {
        List<Integer> levels = getLevels(report);

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

    static List<Integer> getLevels(String report) {
        return Arrays.stream(report.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

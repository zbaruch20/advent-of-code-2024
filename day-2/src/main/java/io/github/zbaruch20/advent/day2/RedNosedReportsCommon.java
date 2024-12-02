package io.github.zbaruch20.advent.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RedNosedReportsCommon {
    private RedNosedReportsCommon() {}

    public static final String DAY_2_INPUT_RESOURCE = "day2_input.txt";
    public static final String DAY_2_TEST_RESOURCE = "day2_test.txt";

    static List<Integer> getLevels(String report) {
        return Arrays.stream(report.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

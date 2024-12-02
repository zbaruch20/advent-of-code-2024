package io.github.zbaruch20.advent.day1;

import com.google.common.collect.Lists;
import io.github.zbaruch20.advent.common.Tuple2;

import java.util.List;

public class HistorianHysteriaCommon {
    private HistorianHysteriaCommon() {}

    public static final String DAY_1_INPUT_RESOURCE = "day1_input.txt";
    public static final String DAY_1_TEST_RESOURCE = "day1_test.txt";

    static Tuple2<List<Integer>, List<Integer>> distanceLists(List<String> lines) {
        List<Integer> list1 = Lists.newArrayListWithCapacity(lines.size());
        List<Integer> list2 = Lists.newArrayListWithCapacity(lines.size());

        lines.forEach(l -> {
            String[] split = l.split("\\s+");
            list1.add(Integer.parseInt(split[0]));
            list2.add(Integer.parseInt(split[1]));
        });

        return new Tuple2<>(list1, list2);
    }
}

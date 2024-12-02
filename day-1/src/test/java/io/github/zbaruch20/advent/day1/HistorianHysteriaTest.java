package io.github.zbaruch20.advent.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HistorianHysteriaTest {
    @Test
    public void puzzle1() {
        int distance = HistorianHysteria1.totalDistance(HistorianHysteriaCommon.DAY_1_TEST_RESOURCE);
        Assertions.assertEquals(11, distance);
    }

    @Test
    public void puzzle2() {
        int similarity = HistorianHysteria2.similarityScore(HistorianHysteriaCommon.DAY_1_TEST_RESOURCE);
        Assertions.assertEquals(31, similarity);
    }
}

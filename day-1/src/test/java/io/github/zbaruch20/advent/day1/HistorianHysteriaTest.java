package io.github.zbaruch20.advent.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HistorianHysteriaTest {
    @Test
    public void puzzle1() {
        Assertions.assertEquals(11, HistorianHysteria1.totalDistance("day1_test.txt"));
    }
}

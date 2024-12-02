package io.github.zbaruch20.advent.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RedNosedReportsTest {
    @Test
    public void numSafeReports() {
        long numSafeReports = RedNosedReports1.numSafeReports(RedNosedReportsCommon.DAY_2_TEST_RESOURCE);
        Assertions.assertEquals(2, numSafeReports);
    }

    @Test
    public void numSafeReportsWithDampener() {
        long numSafeReports = RedNosedReports2.numSafeReportsWithDampener(RedNosedReportsCommon.DAY_2_TEST_RESOURCE);
        Assertions.assertEquals(4, numSafeReports);
    }
}

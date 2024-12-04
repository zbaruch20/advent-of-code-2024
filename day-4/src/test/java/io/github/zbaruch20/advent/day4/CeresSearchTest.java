package io.github.zbaruch20.advent.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CeresSearchTest {
    @Test
    public void xmasWordSearch() {
        int xmasCount = CeresSearch.xmasWordSearch(CeresSearch.DAY_4_TEST_RESOURCE);
        Assertions.assertEquals(18, xmasCount);
    }

    @Test
    public void crossMasWordSearch() {
        int crossMasCount = CeresSearch.crossMasWordSearch(CeresSearch.DAY_4_TEST_RESOURCE);
        Assertions.assertEquals(9, crossMasCount);
    }
}

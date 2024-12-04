package io.github.zbaruch20.advent.day4;

import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CeresSearch {
    private static final Logger LOGGER = LoggerFactory.getLogger(CeresSearch.class);

    public static final String DAY_4_INPUT_RESOURCE = "day4_input.txt";
    public static final String DAY_4_TEST_RESOURCE = "day4_test.txt";

    public static void main(String[] args) {
        LOGGER.info("XMAS word search count: {}", xmasWordSearch(DAY_4_INPUT_RESOURCE));
        LOGGER.info("X-MAS word search count: {}", crossMasWordSearch(DAY_4_INPUT_RESOURCE));
    }

    public static int xmasWordSearch(String resource) {
        int xmasCount = 0;
        List<String> lines = PuzzleInputReader.readLines(resource);
        final int LineWidth = lines.get(0).length();
        final int NorthLimit = 3;
        final int SouthLimit = lines.size() - 4;
        final int WestLimit = 3;
        final int EastLimit = LineWidth - 4;

        for (int i = 0; i < lines.size(); i++) {
            boolean northPossible = i >= NorthLimit;
            boolean southPossible = i <= SouthLimit;

            for (int j = 0; j < LineWidth; j++) {
                boolean eastPossible = j <= EastLimit;
                boolean westPossible = j >= WestLimit;

                if (charAt(lines, i, j) == 'X') {
                    // North
                    if (northPossible && charAt(lines, i - 1, j) == 'M' && charAt(lines, i - 2, j) == 'A'
                            && charAt(lines, i - 3, j) == 'S') xmasCount++;
                    // South
                    if (southPossible && charAt(lines, i + 1, j) == 'M' && charAt(lines, i + 2, j) == 'A'
                            && charAt(lines, i + 3, j) == 'S') xmasCount++;
                    // East
                    if (eastPossible && charAt(lines, i, j + 1) == 'M' && charAt(lines, i, j + 2) == 'A'
                            && charAt(lines, i, j + 3) == 'S') xmasCount++;
                    // West
                    if (westPossible && charAt(lines, i, j - 1) == 'M' && charAt(lines, i, j - 2) == 'A'
                            && charAt(lines, i, j - 3) == 'S') xmasCount++;
                    // Northeast
                    if (northPossible && eastPossible && charAt(lines, i - 1, j + 1) == 'M'
                            && charAt(lines, i - 2, j + 2) == 'A' && charAt(lines, i - 3, j + 3) == 'S') xmasCount++;
                    // Southeast
                    if (southPossible && eastPossible && charAt(lines, i + 1, j + 1) == 'M'
                            && charAt(lines, i + 2, j + 2) == 'A' && charAt(lines, i + 3, j + 3) == 'S') xmasCount++;
                    // Northwest
                    if (northPossible && westPossible && charAt(lines, i - 1, j - 1) == 'M'
                            && charAt(lines, i - 2, j - 2) == 'A' && charAt(lines, i - 3, j - 3) == 'S') xmasCount++;
                    // Southwest
                    if (southPossible && westPossible && charAt(lines, i + 1, j - 1) == 'M'
                            && charAt(lines, i + 2, j - 2) == 'A' && charAt(lines, i + 3, j - 3) == 'S') xmasCount++;
                }
            }
        }

        return xmasCount;
    }

    public static int crossMasWordSearch(String resource) {
        int crossMasCount = 0;
        List<String> lines = PuzzleInputReader.readLines(resource);
        final int LineWidth = lines.get(0).length();

        // don't need to check edges
        for (int i = 1; i < lines.size() - 1; i++) {
            for (int j = 1; j < LineWidth - 1; j++) {
                // start from central 'A' and branch out
                if (charAt(lines, i, j) == 'A') {
                    boolean southeastNortheast = charAt(lines, i - 1, j - 1) == 'M' && charAt(lines, i - 1, j + 1) == 'S'
                            && charAt(lines, i + 1, j - 1) == 'M' && charAt(lines, i + 1, j + 1) == 'S';
                    boolean southwestNorthwest = charAt(lines, i - 1, j - 1) == 'S' && charAt(lines, i - 1, j + 1) == 'M'
                            && charAt(lines, i + 1, j - 1) == 'S' && charAt(lines, i + 1, j + 1) == 'M';
                    boolean southeastSouthwest = charAt(lines, i - 1, j - 1) == 'M' && charAt(lines, i - 1, j + 1) == 'M'
                            && charAt(lines, i + 1, j - 1) == 'S' && charAt(lines, i + 1, j + 1) == 'S';
                    boolean northeastNorthwest = charAt(lines, i - 1, j - 1) == 'S' && charAt(lines, i - 1, j + 1) == 'S'
                            && charAt(lines, i + 1, j - 1) == 'M' && charAt(lines, i + 1, j + 1) == 'M';
                    if (southeastNortheast || southwestNorthwest || southeastSouthwest || northeastNorthwest) crossMasCount++;
                }
            }
        }

        return crossMasCount;
    }

    private static char charAt(List<String> lines, int i, int j) {
        return lines.get(i).charAt(j);
    }
}

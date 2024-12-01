package io.github.zbaruch20.advent.common;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PuzzleInputReaderTest {
    @Test
    public void testReadLines() {
        List<String> expectedLines = Lists.newArrayList("hello", "world", "go bucks", "advent of code", "6.25");
        String resource = "test_resource.txt";
        Assertions.assertEquals(expectedLines, PuzzleInputReader.readLines(resource));
    }

    @Test
    public void invalidResource() {
        String resource = "foobar";
        Assertions.assertThrows(RuntimeException.class, () -> PuzzleInputReader.readLines(resource));
    }
}

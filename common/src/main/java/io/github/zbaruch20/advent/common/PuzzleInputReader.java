package io.github.zbaruch20.advent.common;

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class PuzzleInputReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PuzzleInputReader.class);

    private PuzzleInputReader() {}

    public static List<String> readLines(String resource) {
        try {
            URL input = Resources.getResource(resource);
            return Resources.readLines(input, Charset.defaultCharset());
        } catch (Exception e) {
            LOGGER.error("Failed to read lines from input resource {}", resource, e);
            throw new RuntimeException(e);
        }
    }
}

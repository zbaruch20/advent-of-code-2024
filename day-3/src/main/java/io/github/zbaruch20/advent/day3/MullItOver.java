package io.github.zbaruch20.advent.day3;

import io.github.zbaruch20.advent.common.PuzzleInputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class MullItOver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MullItOver.class);

    public static final String DAY_3_INPUT_RESOURCE = "day3_input.txt";
    public static final Pattern MUL_REGEX = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    public static final Pattern MUL_WITH_CONDITIONAL_REGEX = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");

    public static void main(String[] args) {
        String instructions = String.join("", PuzzleInputReader.readLines(DAY_3_INPUT_RESOURCE));

        LOGGER.info("Uncorrupted multiplication: {}", multiplyUncorrupted(instructions));
        LOGGER.info("Uncorrupted multiplication with conditionals: {}", multiplyUncorruptedWithConditional(instructions));
    }

    public static int multiplyUncorrupted(String instructions) {
        return MUL_REGEX.matcher(instructions)
                .results()
                .mapToInt(mul -> Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)))
                .sum();
    }

    public static int multiplyUncorruptedWithConditional(String instructions) {
        AtomicBoolean enabled = new AtomicBoolean(true);
        return MUL_WITH_CONDITIONAL_REGEX.matcher(instructions)
                .results()
                .mapToInt(inst -> {
                    int result = 0;

                    if ("do()".equals(inst.group())) {
                        enabled.set(true);
                    } else if ("don't()".equals(inst.group())) {
                        enabled.set(false);
                    } else if (enabled.get()) {
                        result = Integer.parseInt(inst.group(1)) * Integer.parseInt(inst.group(2));
                    }

                    return result;
                })
                .sum();
    }
}

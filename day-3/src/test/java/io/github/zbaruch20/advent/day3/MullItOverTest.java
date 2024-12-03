package io.github.zbaruch20.advent.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MullItOverTest {

    @Test
    public void multiplyUncorrupted() {
        String instructions = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        Assertions.assertEquals(161, MullItOver.multiplyUncorrupted(instructions));
    }

    @Test
    public void multiplyUncorruptedWithCondition() {
        String instructions = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        Assertions.assertEquals(48, MullItOver.multiplyUncorruptedWithConditional(instructions));
    }
}

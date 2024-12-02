package io.github.zbaruch20.advent.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tuple3<T1, T2, T3> {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
}

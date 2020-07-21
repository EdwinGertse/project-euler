package com.tegres.project.euler.common;

import java.util.stream.IntStream;

public final class NumberUtils {

    private NumberUtils() {}

    /**
     * Determines if given number is a prime number
     *
     * @param number    Any given number
     * @return          true if a prime number
     */
    public static boolean isPrimeNumber(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
}

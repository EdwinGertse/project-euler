package com.tegres.project.euler.challenge6;

import com.tegres.project.euler.common.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Edwin Gertse
 */
public class SumSquareDifference {

    /**
     * Calculate the difference between sum of square and square of sum
     * @param maxNumber     Parsed number
     * @return              Difference between sum of square and square of sum
     */
    public static Double calculateDifference(Integer maxNumber) {
        Preconditions.notNull(maxNumber, () -> "Parameter <maxNumber> should not be null");

        return squareOfSum(maxNumber) - sumOfSquares(maxNumber);
    }

    /**
     * Calculate the sum of all the squares
     *
     * @param maxNumber     Parsed number
     * @return              sum of squares
     */
    private static Double sumOfSquares(Integer maxNumber) {
        Preconditions.notNull(maxNumber, () -> "Parameter <maxNumber> should not be null");

        List<Double> multiples = new ArrayList<>();
        for (int i = 1; i <= maxNumber; i++) {
            multiples.add(Math.pow(i, 2));
        }
        return multiples.stream().mapToDouble(Double::intValue).sum();
    }

    /**
     * Calculates the square of the sum
     *
     * @param maxNumber     Parsed number
     * @return              Square of sum
     */
    private static Double squareOfSum(Integer maxNumber) {
        Preconditions.notNull(maxNumber, () -> "Parameter <maxNumber> should not be null");

        return Math.pow(IntStream.rangeClosed(1, maxNumber).sum(), 2);
    }
}

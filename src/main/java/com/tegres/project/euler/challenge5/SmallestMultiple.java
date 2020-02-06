package com.tegres.project.euler.challenge5;

import com.tegres.project.euler.common.Preconditions;

/**
 * Smallest multiple
 *
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author Edwin Gertse
 */
public class SmallestMultiple {

    /**
     * This method determines the smallest multiple between the given parsed min and max number
     *
     * @param min   Minimum number
     * @param max   Maximum number
     * @return      The smallest multiple
     */
    public Integer smallestMultiple(Integer min, Integer max) {
        Preconditions.notNull(min, () -> "Parameter <min> should not be null");
        Preconditions.notNull(max, () -> "Parameter <max> should not be null");

        int count = 1;
        while (true) {
            if (isDivisible(count, min, max))
                return count;

            count++;
        }
    }

    /**
     * This method determines if parsed number is divisible by all number from Min to Max
     *
     * @param divisibleNumber   Number to be divided by
     * @param min               Minimum number
     * @param max               Maximum number
     * @return                  True if divisible by all number from Min to Max
     */
    private boolean isDivisible(Integer divisibleNumber, Integer min, Integer max) {
        Preconditions.notNull(divisibleNumber, () -> "Parameter <divisibleNumber> should not be null");
        Preconditions.notNull(min, () -> "Parameter <min> should not be null");
        Preconditions.notNull(max, () -> "Parameter <max> should not be null");

        for (int x = min; x <= max; x++) {
            if(Math.floorMod(divisibleNumber, x) != 0)
                return false;
        }
        return true;
    }
}

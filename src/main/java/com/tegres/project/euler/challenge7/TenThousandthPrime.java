package com.tegres.project.euler.challenge7;

/**
 * 10001st prime
 * <p>
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 *
 * @author Edwin Gertse
 */
public class TenThousandthPrime {

    /**
     * Determines if given number is a prime number
     *
     * @param number    Any given number
     * @return          true if a prime number
     */
    public boolean isPrimeNumber(Integer number) {
        if (number <= 1) return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determine the prime number in the given position
     *
     * @param primePosition     Prime position
     * @return                  Prime number
     */
    public Integer determinePrimeNumberSimple(Integer primePosition) {
        Integer resultCount = 0, primeCount = 0;
        while (true) {
            if (isPrimeNumber(resultCount)) {
                primeCount++;
                if (primeCount.equals(primePosition)) break;
            }
            resultCount++;
        }
        return resultCount;
    }
}

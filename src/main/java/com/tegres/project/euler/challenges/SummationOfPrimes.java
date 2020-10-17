package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.NumberUtils;
import com.tegres.project.euler.common.Preconditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * @author Edwin Gertse
 */
public class SummationOfPrimes {

    /**
     * Retrieve list of prime numbers up to number passed as parameter
     *
     * @param start     Start Number
     * @param end       End Number
     * @return          List of Prime numbers
     */
    public List<Integer> getListOfPrimeNumbers(int start, int end) {
        Preconditions.notNull(start, () -> "Parameter <start> should not be null");
        Preconditions.notNull(end, () -> "Parameter <end> should not be null");

        return IntStream.range(start, end)
                .map(i -> start + (end - 1 - i))
                .filter(NumberUtils::isPrimeNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Calculates the sum of numbers
     *
     * @param primeNumbers  List of Prime Numbers
     * @return              Sum list of numbers
     */
    public Integer sumOfPrimeNumber(List<Integer> primeNumbers) {
        return primeNumbers.stream().mapToInt(i -> i).sum();
    }

}

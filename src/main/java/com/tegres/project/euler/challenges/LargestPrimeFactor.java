package com.tegres.project.euler.challenges;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Largest prime factor
 *
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author Edwin Gertse
 */
public class LargestPrimeFactor {

    /**
     * Retrieve largest number in a collection
     * @param numbers   collection of numbers
     * @return          largest number in collection
     */
    public Long largestNumber(Collection<Long> numbers) {
        return numbers.stream()
                .mapToLong(prime -> prime)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * This method determines the largest prime number from the given number
     * @param number    Any given number
     * @return          Largest prime number
     */
    public Long retrieveLargestPrimeFactorSimple(Long number) {
        List<Long> primeNumbers = new ArrayList<>();
        for(int i = 2; i < number; i++) {
            while(number % i == 0) {
                number = number / i;
            }
        }
        if(number > 2) primeNumbers.add(number);

        return largestNumber(primeNumbers);
    }

}

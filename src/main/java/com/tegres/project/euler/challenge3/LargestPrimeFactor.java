package com.tegres.project.euler.challenge3;

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
    public Integer largestNumber(Collection<Integer> numbers) {
        return numbers.stream()
                .mapToInt(prime -> prime)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Determines if given number is a prime number
     *
     * @param number    Any given number
     * @return          true if a prime number
     */
    public boolean isPrimeNumber(Integer number) {
        for(int i = 2; i <= number / 2; ++i) {
            if(number % i == 0)
                return true;
        }
        return false;
    }

    /**
     * This method determines the largest prime number from the given number
     * @param number    Any given number
     * @return          Largest prime number
     */
    public Integer retrieveLargestPrimeFactorSimple(Integer number) {
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            if (isPrimeNumber(i))
                primeNumbers.add(i);
        }
        //TODO: Determine what prime numbers makes up given number
        return largestNumber(primeNumbers);
    }

}

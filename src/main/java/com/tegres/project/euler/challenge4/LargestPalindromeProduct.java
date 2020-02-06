package com.tegres.project.euler.challenge4;

import com.tegres.project.euler.common.Preconditions;

import java.util.Optional;

/**
 * Largest palindrome product
 *
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author Edwin Gertse
 */
public class LargestPalindromeProduct {

    private static final int TEN = 10;

    /**
     * This method executes the <code>calculateLargestPalindromeProduct</code> method.
     *
     * @param minNumber    Lowest 3 digit number
     * @param maxNumber     Largest 3 digit number
     * @return              {@link PalindromeProduct}
     */
    public PalindromeProduct execute(Integer minNumber, Integer maxNumber) {
        Preconditions.notNull(minNumber, () -> "Parameter <minNumber> should not be null");
        Preconditions.notNull(maxNumber, () -> "Parameter <maxNumber> should not be null");

        Optional<PalindromeProduct> product;
        while (true) {
            product = calculateLargestPalindromeProduct(minNumber, maxNumber);
            if(product.isPresent())
                break;
            maxNumber--;
        }
        return product.get();
    }

    /**
     * This method calculates the largest palindrome product
     * from the product of two 3-digit numbers
     *
     * @param minNumber     Lowest 3 digit number
     * @param maxNumber     Largest 3 digit number
     * @return              {@link Optional<PalindromeProduct>}
     */
    private Optional<PalindromeProduct> calculateLargestPalindromeProduct(Integer minNumber, Integer maxNumber) {
        Preconditions.notNull(minNumber, () -> "Parameter <minNumber> should not be null");
        Preconditions.notNull(maxNumber, () -> "Parameter <maxNumber> should not be null");

        for (int i = maxNumber; i >= minNumber; i--) {
            int palindromeNumber = maxNumber * i;
            if (isPalindrome(palindromeNumber)) {
                return Optional.of(new PalindromeProduct(palindromeNumber, maxNumber, i));
            }
        }
        return Optional.empty();
    }

    /**
     * Determines whether or not parsed number is a palindrome number
     *
     * @param originalNumber    parse number
     * @return                  True if number is a palindrome
     */
    private boolean isPalindrome(Integer originalNumber) {
        Preconditions.notNull(originalNumber, () -> "Parameter <originalNumber> should not be null");

        int number = originalNumber;
        int remainder, reverseNumber = 0;
        while (number != 0) {
            remainder = number % TEN;
            reverseNumber = reverseNumber * TEN + remainder;
            number /= TEN;
        }
        return originalNumber == reverseNumber;
    }
}

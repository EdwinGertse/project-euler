package com.tegres.project.euler.challenge1;

import com.tegres.project.euler.common.Multiples;

import java.util.ArrayList;
import java.util.List;

/**
 * Multiples of 3 and 5
 *
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author Edwin Gertse
 */
public class MultiplesOf3And5 {

    private Integer isMultipleOf(Integer number) {
        if (Multiples.MULITPLES_OF_THREE.test(number)) return number;
        else if (Multiples.MULITPLES_OF_FIVE.test(number)) return number;
        else return null;
    }

    public Integer sumOfMultiples(Integer maxNumber) {
        List<Integer> multiples = new ArrayList<>();
        for(int i = 0; i < maxNumber; i++) {
            if (isMultipleOf(i) != null) multiples.add(i);
        }
        return multiples.stream().mapToInt(Integer::intValue).sum();
    }
}

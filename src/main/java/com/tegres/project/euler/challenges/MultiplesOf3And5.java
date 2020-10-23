package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.MultiplesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private Optional<Integer> isMultipleOf(Integer number) {
        if (MultiplesEnum.MULITPLES_OF_THREE.test(number)) return Optional.of(number);
        else if (MultiplesEnum.MULITPLES_OF_FIVE.test(number)) return Optional.of(number);
        else return Optional.empty();
    }

    public Integer sumOfMultiples(Integer maxNumber) {
        List<Integer> multiples = new ArrayList<>();
        for(int i = 0; i < maxNumber; i++) {
            if (isMultipleOf(i).isPresent()) multiples.add(i);
        }
        return multiples.stream().mapToInt(Integer::intValue).sum();
    }
}

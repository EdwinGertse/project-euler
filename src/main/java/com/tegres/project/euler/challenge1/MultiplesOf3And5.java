package com.tegres.project.euler.challenge1;

import com.tegres.project.euler.common.Multiples;

import java.util.ArrayList;
import java.util.List;

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

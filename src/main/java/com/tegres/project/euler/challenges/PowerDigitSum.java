package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.Preconditions;
import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 *
 * @author Edwin Gertse
 */
public class PowerDigitSum {

    public Integer execute(Integer value, Integer powerDigit) {
        Preconditions.notNull(value, "Value cannot be null");
        Preconditions.notNull(powerDigit, "Power digit cannot be null");

        BigInteger digit = this.calculatePowerDigit(value, powerDigit);
        return this.sumOfPowerDigit(digit);
    }

    private Integer sumOfPowerDigit(BigInteger powerDigit) {
        return String.valueOf(powerDigit).chars().sum();
    }

    private BigInteger calculatePowerDigit(Integer value, Integer powerDigit) {
        return BigInteger.valueOf(value)
                .pow(powerDigit)
                .add(BigInteger.ONE);
    }
}

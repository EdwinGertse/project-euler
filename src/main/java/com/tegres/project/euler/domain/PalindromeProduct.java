package com.tegres.project.euler.domain;

import java.util.Objects;

public class PalindromeProduct {

    private Integer palindromeNumber;
    private Integer firstDigit;
    private Integer secondDigit;

    public PalindromeProduct(Integer palindromeNumber, Integer firstDigit, Integer secondDigit) {
        this.palindromeNumber = palindromeNumber;
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
    }

    public Integer getPalindromeNumber() {
        return palindromeNumber;
    }

    public Integer getFirstDigit() {
        return firstDigit;
    }

    public Integer getSecondDigit() {
        return secondDigit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PalindromeProduct)) return false;
        PalindromeProduct that = (PalindromeProduct) o;
        return Objects.equals(getPalindromeNumber(), that.getPalindromeNumber()) &&
                Objects.equals(getFirstDigit(), that.getFirstDigit()) &&
                Objects.equals(getSecondDigit(), that.getSecondDigit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPalindromeNumber(), getFirstDigit(), getSecondDigit());
    }

    @Override
    public String toString() {
        return "PalindromeProduct{" +
                "palindromeNumber=" + palindromeNumber +
                ", firstDigit=" + firstDigit +
                ", secondDigit=" + secondDigit +
                '}';
    }
}

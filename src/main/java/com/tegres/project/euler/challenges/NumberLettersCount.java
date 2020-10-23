package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.Preconditions;
import com.tegres.project.euler.domain.NumberLetterRequest;
import com.tegres.project.euler.validation.RuleNumberToLetters;

import java.util.logging.Logger;

public class NumberLettersCount {

    private final static Logger LOGGER = Logger.getLogger(NumberLettersCount.class.getName());

    public Integer execute(int start, int end) {
        String letters = retrieveLetters(start, end);
        Preconditions.notNull(letters, "Letters cannot be null");
        LOGGER.info(letters);
        return calculateLettersCount(letters);
    }

    private String retrieveLetters(int start, int end) {
        return new RuleNumberToLetters().evaluate(new NumberLetterRequest(start, end));
    }

    private Integer calculateLettersCount(String letters) {
        return letters.replaceAll("[^a-zA-Z]", "").trim().length();
    }P
}

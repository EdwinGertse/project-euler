package com.tegres.project.euler.validation;

import com.tegres.project.euler.domain.NumberLetterRequest;

public class RuleNumberToLetters implements Rule<String, NumberLetterRequest> {

    private static final String[] tensLetters = {
            "", " ten", " twenty", " thirty", " forty",
            " fifty", " sixty", " seventy", " eighty", " ninety"
    };

    private static final String[] numberLetters = {
            "", " one", " two", " three", " four", " five",
            " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen"
    };

    @Override
    public String evaluate(NumberLetterRequest input) {
        StringBuilder result = new StringBuilder();
        for(int i = input.getStart(); i <= input.getEnd(); i++) {
            result.append(buildLetters(i)).append(",");
        }
        return result.toString();
    }

    private String buildLetters(Integer number) {
        if (number == 1000) return "one thousand";

        String tmp;

        /**
         * Get numbers from lowest to highest
         */
        if (number % 100 < 20) {
            tmp = numberLetters[number % 100];
            number /= 100;
        } else {
            tmp = numberLetters[number % 10];
            number /= 10;

            tmp = tensLetters[number % 10] + tmp;
            number /= 10;
        }

        if (number == 0) return tmp;
        String result = numberLetters[number] + " hundred";
        if (tmp.length() > 1) result += " and " + tmp.trim();
        return result;
    }
}

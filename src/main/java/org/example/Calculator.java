package org.example;

import java.util.Arrays;

public class Calculator {

    private static final String VALID_PATTERN_FOR_TWO_NUMBERS = "^(\\d+|\\d+(,\\d+))$";
    private static final String VALID_PATTERN_FOR_N_NUMBERS = "^(\\d+)?(,\\d+)*$";

    /**
     * The method can take up to two numbers, separated by commas, and will return their sum.
     * And also handle an unknown amount of numbers
     */
    public int add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int result = 0;

        if (numbers.matches(VALID_PATTERN_FOR_TWO_NUMBERS) ||
                numbers.matches(VALID_PATTERN_FOR_N_NUMBERS)) {
            result = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
        } else {
            throw new InvalidInputException("Invalid input");
        }

        return result;
    }

    public static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}

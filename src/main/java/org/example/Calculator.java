package org.example;

import java.util.Arrays;

public class Calculator {

    private static final String VALID_PATTERN = "^(\\d+|\\d+(,\\d+))$";

    /**
     * The method can take up to two numbers, separated by commas, and will return their sum.
     */
    public int add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int result = 0;

        if (numbers.matches(VALID_PATTERN)) {
            int[] arr = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
            result = arr.length == 2 ? arr[0] + arr[1] : arr[0];
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

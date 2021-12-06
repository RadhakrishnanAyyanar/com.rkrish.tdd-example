package org.example;

import java.util.Arrays;

public class Calculator {

    private static final String VALID_PATTERN_FOR_TWO_NUMBERS = "^(\\d+|\\d+(,\\d+))$";
    private static final String VALID_PATTERN_FOR_N_NUMBERS = "^(\\d+)+?(,\\d+)*$";
    private static final String INPUT_STARTS_WITH_DELIMITER = "^[^a-zA-Z\\d\\s]$";
    private static final String NEW_LINE_CHARACTER = "\n";

    public static void main(String[] args) {
        System.out.println(";".matches(INPUT_STARTS_WITH_DELIMITER));
    }

    /**
     * The method can take up to two numbers, separated by commas, and will return their sum.
     * And also handle an unknown amount of numbers
     * handle new lines between numbers (instead of commas).
     */
    public int add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int result = 0;
        String delimiter = "";

        if (String.valueOf(numbers.charAt(0)).matches(INPUT_STARTS_WITH_DELIMITER) &&
                numbers.indexOf(NEW_LINE_CHARACTER) == 1) {
            delimiter = String.valueOf(numbers.charAt(0));
            numbers = numbers.substring(2).replaceAll(delimiter, ",");

        }

        if (numbers.contains(NEW_LINE_CHARACTER)) {
            numbers = numbers.replaceAll(NEW_LINE_CHARACTER, ",");
        }

        if (!numbers.isEmpty() && numbers.matches(VALID_PATTERN_FOR_TWO_NUMBERS) ||
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

package designpattern.behavioral.strategy.validator;

import jakarta.xml.bind.ValidationException;

// 길이 유효성 검사 전략
public class LengthValidationStrategy implements ValidationStrategy<String> {
    private int minLength;
    private int maxLength;

    public LengthValidationStrategy(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public void validate(String input) throws ValidationException {
        if (input == null || input.length() < minLength || input.length() > maxLength) {
            throw new ValidationException("Input length must be between " + minLength + " and " + maxLength + " characters");
        }
    }
}

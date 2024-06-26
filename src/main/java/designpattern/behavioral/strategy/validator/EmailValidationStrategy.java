package designpattern.behavioral.strategy.validator;

import java.util.regex.Pattern;

// 이메일 유효성 검사 전략
public class EmailValidationStrategy implements ValidationStrategy<String>{
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    @Override
    public void validate(String input) throws Exception {
        if (input == null || !EMAIL_PATTERN.matcher(input).matches()) {
            throw new Exception("Invalid email format");
        }
    }
}

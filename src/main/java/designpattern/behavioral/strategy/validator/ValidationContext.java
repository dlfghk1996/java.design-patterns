package designpattern.behavioral.strategy.validator;

import jakarta.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class ValidationContext<T> {
    private List<ValidationStrategy<T>> strategies;

    public ValidationContext() {
        this.strategies = new ArrayList<>();
    }

    public void addValidationStrategy(ValidationStrategy<T> strategy) {
        strategies.add(strategy);
    }

    public void validate(T input) throws ValidationException {
        for (ValidationStrategy<T> strategy : strategies) {
            strategy.validate(input);
        }
    }
}

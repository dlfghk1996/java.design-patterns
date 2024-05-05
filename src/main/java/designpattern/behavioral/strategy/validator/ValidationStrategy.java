package designpattern.behavioral.strategy.validator;

import jakarta.xml.bind.ValidationException;

public interface ValidationStrategy<T>  {
    void validate(T input) throws ValidationException;
}

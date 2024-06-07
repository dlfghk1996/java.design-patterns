package designpattern.behavioral.strategy.validator;



public interface ValidationStrategy<T>  {
    void validate(T input) throws Exception;
}

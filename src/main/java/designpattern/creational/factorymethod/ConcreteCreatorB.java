package designpattern.creational.factorymethod;

public class ConcreteCreatorB extends Creator{

    @Override
    protected Product createProduct() {
        return new ConcreteProductB();
    }
}

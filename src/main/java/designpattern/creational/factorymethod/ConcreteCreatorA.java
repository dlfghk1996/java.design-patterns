package designpattern.creational.factorymethod;


public class ConcreteCreatorA extends Creator {

    @Override
    protected Product createProduct() {
        return new ConcreteProductA();
    }
}

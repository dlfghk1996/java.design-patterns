package designpattern.behavioral.observer.basic;

public class ConcreteObserverB implements Observer{

    @Override
    public void update(String eventTxt) {
        System.out.println("[ ConcreteObserverB ] received price update: " + eventTxt);
    }
}

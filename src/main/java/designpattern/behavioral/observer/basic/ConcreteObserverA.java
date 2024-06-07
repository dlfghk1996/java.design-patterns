package designpattern.behavioral.observer.basic;

public class ConcreteObserverA implements Observer{

    @Override
    public void update(String eventTxt) {
        System.out.println("[ ConcreteObserverA ] received price update: " + eventTxt);
    }
}

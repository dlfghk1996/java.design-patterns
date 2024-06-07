package designpattern.behavioral.observer.basic;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
// 옵저버를 관리하며, 상태 변화를 옵저버에게 알린다.
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String eventTxt;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(eventTxt);
        }
    }

    public void setEvent(String text) {
        this.eventTxt = text;
        notifyObservers();
    }
}

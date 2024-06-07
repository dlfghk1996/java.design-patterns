package designpattern.behavioral.observer.chat;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // 메시지 수신
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

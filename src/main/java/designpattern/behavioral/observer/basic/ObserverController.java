package designpattern.behavioral.observer.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/observer")
public class ObserverController {

    private final Subject subject;

    @GetMapping("")
    public void test() {

        ConcreteObserverA concreteObserverA = new ConcreteObserverA();
        ConcreteObserverB concreteObserverB = new ConcreteObserverB();

        subject.registerObserver(concreteObserverA);
        subject.registerObserver(concreteObserverB);

        subject.setEvent("Event AAAAA");
        subject.setEvent("Event BBBBB");

        // Remove an observer
        subject.removeObserver(concreteObserverA);

        subject.setEvent("Event CCCCC");
    }
}

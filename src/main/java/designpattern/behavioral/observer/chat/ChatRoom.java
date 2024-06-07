package designpattern.behavioral.observer.chat;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChatRoom {

    // PublishSubject: Observable의 일종으로, 새로운 아이템을 옵저버들에게 발행한다.
    private PublishSubject<String> messageSubject = PublishSubject.create(); // 메시지 발행 역할

    private Map<User, Disposable> userSubscriptions = new HashMap<>();


    // 옵저버 등록
    public void addObserver(User user, Consumer<String> observer) {
        // 새로운 옵저버를 messageSubject에 등록하여 새로운 메시지가 도착할 때마다 이 옵저버에게 전달되도록 한다.
        Disposable disposable = messageSubject.subscribe(observer);
        userSubscriptions.put(user, disposable);
    }

    // 옵저버 제거
    public void removeObserver(User user) {
        // 해당 옵저버의 Disposable 객체를 찾음
        Disposable disposable = userSubscriptions.get(user);

        // Disposable 객체가 null이 아니면 구독을 해제
        if (disposable != null) {
            disposable.dispose();
            userSubscriptions.remove(user);
        }
    }

    // 메시지 전송
    public void sendMessage(String message) {
        // onNext: messageSubject에 새로운 메시지를 발행
        messageSubject.onNext(message);
    }
}

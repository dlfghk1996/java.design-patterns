package designpattern.behavioral.observer.chat;


import io.reactivex.rxjava3.functions.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  RxJava를 사용하여 옵저버 디자인 패턴을 적용한 채팅 프로그램
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    @GetMapping("")
    public void chat(){
        // 채팅방 생성
        ChatRoom chatRoom = new ChatRoom();

        // 사용자 생성
        User user1 = new User("User1");
        User user2 = new User("User2");


        // 사용자를 채팅방에 등록
        // 인자값 = Consumer<String> messageConsumer = message -> user1.receiveMessage(message);
        chatRoom.addObserver(user1, message -> user1.receiveMessage(message));
        chatRoom.addObserver(user2, message -> user2.receiveMessage(message));

        // 메시지 전송
        chatRoom.sendMessage("Hello, everyone!");
        chatRoom.sendMessage("How are you?");

        // 사용자가 채팅방을 나감
        chatRoom.removeObserver(user1);

        // 사용자가 채팅방을 나간 후 메시지 전송
        chatRoom.sendMessage("User1 has left the room.");
    }

}

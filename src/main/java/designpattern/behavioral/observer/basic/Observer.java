package designpattern.behavioral.observer.basic;


public interface Observer {
    // 관찰된 객체의 상태가 변경될 때마다 update 메서드가 호출된다.
    void update(String eventTxt);
}

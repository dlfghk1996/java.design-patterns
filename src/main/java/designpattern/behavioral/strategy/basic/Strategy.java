package designpattern.behavioral.strategy.basic;

// 전략 인터페이스: 공통적인 작업을 선언
public interface Strategy {
    // context class가 호출하는 메서드
    int execute(int a, int b);
}

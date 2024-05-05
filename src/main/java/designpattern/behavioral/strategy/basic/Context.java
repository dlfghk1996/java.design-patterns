package designpattern.behavioral.strategy.basic;


import org.springframework.stereotype.Component;

// context: 전략 객체를 사용하는 클래스
@Component
public class Context {
    // 전략 객체에 대한 참조
    private Strategy strategy;

    // 전략 객체의 값을 설정하기 위한 setter 메서드 정의
    public void setStrategy(Strategy strategy) {
        // 이 메서드를 통해 클라이언트가 원하는 전략을 설정한다.
        this.strategy = strategy;
    }

    // 전략 객체에 실행 위임하는 메서드
    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}


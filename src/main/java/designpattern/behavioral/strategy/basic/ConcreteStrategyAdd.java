package designpattern.behavioral.strategy.basic;

// 구체적인 전략: 더하기
public class ConcreteStrategyAdd implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

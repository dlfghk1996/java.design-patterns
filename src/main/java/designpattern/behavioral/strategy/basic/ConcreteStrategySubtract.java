package designpattern.behavioral.strategy.basic;

// 구체적인 전략: 빼기
public class ConcreteStrategySubtract implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

package designpattern.behavioral.strategy.basic;

// 구체적인 전략: 곱하기
public class ConcreteStrategyMultiply implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

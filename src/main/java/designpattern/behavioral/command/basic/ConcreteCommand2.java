package designpattern.behavioral.command.basic;

// ConcreteCommand Implementation
//  리시버 객체의 정보 + 행동이 들어 있는 객체
public class ConcreteCommand2 implements Command {
    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean execute() {
        receiver.turnOff();
        return false;
    }
}

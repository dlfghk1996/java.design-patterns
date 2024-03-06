package designpattern.behavioral.command.basic;

public class ConcreteCommand1 implements Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean execute() {
        receiver.turnOn();
        return false;
    }
}

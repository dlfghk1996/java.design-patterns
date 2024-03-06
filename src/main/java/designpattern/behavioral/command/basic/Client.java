package designpattern.behavioral.command.basic;



//  Client
public class Client {

    public void test(){
        Receiver receiver = new Receiver();  // 수신자
        Command c1=new ConcreteCommand2(receiver);
        Command c2=new ConcreteCommand1(receiver);

        Invoker remote = new Invoker(); // 호출자
        remote.setCommand(c1);
        remote.pressButton(); // invoking command

        remote.setCommand(c2);
        remote.pressButton();
    }

}

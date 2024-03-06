package designpattern.behavioral.command.basic;


// Invoker Class
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }


    public void pressButton(){
    // execute() — 해당 호출로 커멘드 객체에 있는 일련의 과정들이 수행 된다. (자바에서는 run 이라는 용어로 많이 사용된다.)
        command.execute();
    }

    // Invoker 에서는 명령을 스택에 쌓고, undo를 실행할 때마다 pop하여 순서대로 실행 취소를 할 수 있다.
    // 그 외에도 매크로 기록, 작업 단위 취소, 히스토리 기록 등을 응용해 구현할 수 있다.
}

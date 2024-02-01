package designpattern.structural.proxy.dynamic;

public class RealSubject implements SubjectService {
    @Override
    public String call() {
        System.out.println("B 호출");
        return "b";
    }

    @Override
    public void print() {

    }

    @Override
    public void run() {

    }
}

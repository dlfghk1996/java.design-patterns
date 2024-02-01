package designpattern.structural.proxy.dynamic;

public class RealSubjectProxy implements SubjectService {
    SubjectService subject;

    RealSubjectProxy(SubjectService subject) {
        this.subject = subject;
    }

    @Override
    public String call() {
        System.out.println("TimeProxy 실행");
        long startTime = System.nanoTime();

        String result = subject.call();

        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        System.out.println("TimeProxy 종료 resultTime = " + resultTime);

        return result;
    }

    @Override
    public void print() {

    }

    @Override
    public void run() {

    }
}

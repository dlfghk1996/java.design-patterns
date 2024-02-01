package designpattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class MyProxyHandler implements InvocationHandler {
    private final Object target;
    MyProxyHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("TimeProxy 실행");
        long startTime = System.nanoTime();

        // 파라미터로 전달받은 메서드를 invoke로 실행
        Object result = method.invoke(target, args);

        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        System.out.println("TimeProxy 종료 resultTime = " + resultTime);

        return result;
    }
}

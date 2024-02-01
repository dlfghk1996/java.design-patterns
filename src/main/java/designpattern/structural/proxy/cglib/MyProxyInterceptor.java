package designpattern.structural.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyProxyInterceptor implements MethodInterceptor {

    private final Object target;

    MyProxyInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(
        Object o,
        Method method,
        Object[] args,
        MethodProxy methodProxy
    ) throws Throwable {

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

package designpattern.structural.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * CGLIB
 * : 인터페이스가 아닌 클래스 기반으로 바이트코드를 조작하여 프록시를 생성하는 방식
 * : 구체 클래스를 상속 받아서 프록시를 생성한다.
 * */
public class CglibController {
    public void cglibBasic() {

        // 1. Enhancer를 사용해서 프록시 등록
        Enhancer enhancer = new Enhancer();
        // 2. 상속한 구체 클래스 지정
        enhancer.setSuperclass(RealSubject.class);
        // 3. 프록시 핸들러 할당
        enhancer.setCallback(new MyProxyInterceptor(new RealSubject()));

        // 4. 프록시 생성
        RealSubject proxy = (RealSubject) enhancer.create();

        // 5. 프록시 호출
        proxy.call();
    }

    // 2. 람다_Version
    public void cglibBasicByLambda() {

        RealSubject proxy = (RealSubject) Enhancer.create(RealSubject.class,
            (MethodInterceptor) (o, method, args, methodProxy) -> {

                RealSubject target = new RealSubject();
                System.out.println("TimeProxy 실행");
                long startTime = System.nanoTime();

                // 파라미터로 전달받은 메서드를 invoke로 실행
                Object result = method.invoke(target, args);
                long endTime = System.nanoTime();
                long resultTime = endTime - startTime;

                System.out.println("TimeProxy 종료 resultTime = " + resultTime);
                return result;
            });

        proxy.call();
    }
}

package designpattern.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Java 다이나믹 프록시 예제
 * 런타임 시점에 프록시 클래스를 만들어주는 방식
 * */
public class DynamicProxyController {

    // 기본 proxyHandler 와 다이나믹 프록시
    public void basicDynamicProxy(){
        // 일반 프록시 패턴 => 필요에 따라 프록시 class 가 n개씩 증가한다.
        SubjectService proxyB1 = new RealSubjectProxy(new RealSubject());
        proxyB1.call();

        // 다이나믹 프록시
        /**
         * newProxyInstance() : 동적으로 프록시 객체를 생성
         * ClassLoader : 프록시 클래스를 만들 클래스로더
         * Class : 프록시 클래스가 구현할 인터페이스 목록(배열)
         * InvocationHandler : 메서드가 호출되었을때 실행될 핸들러
         */
        SubjectService proxyB2 = (SubjectService) Proxy.newProxyInstance(
            SubjectService.class.getClassLoader(),
            new Class[]{SubjectService.class},
            new MyProxyHandler(new RealSubject())
        );
        proxyB2.call();
    }



    // 다이나믹 프록시 람다
    public void basicDynamicProxyByLambda(){


        // 프록시 핸들러
        SubjectService proxyB = (SubjectService) Proxy.newProxyInstance(
            SubjectService.class.getClassLoader(), // 대상 객체의 인터페이스의 클래스로더
            new Class[]{SubjectService.class}, // 대상 객체의 인터페이스
            (proxy, method, args) -> {
                Object target = new RealSubject();

                /*메서드가 여러개인 타겟을 프록시화 할경우
                 대상 객체의 모든 메서드를 호출할때마다 프록시 핸들러가 실행되기 때문에 메서드 명을 확인하여 분기처리한다.*/
                if(method.getName().equals("call")) {
                    System.out.println("----call 메서드 호출----");

                    // 파라미터로 전달받은 메서드를 invoke로 실행
                    Object result = method.invoke(target, args);
                }
                Object result = method.invoke(target, args);

                return result;
            }
        );
        proxyB.call();
        proxyB.print();
        proxyB.run();

    }
}

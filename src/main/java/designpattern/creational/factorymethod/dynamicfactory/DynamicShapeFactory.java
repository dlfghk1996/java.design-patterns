package designpattern.creational.factorymethod.dynamicfactory;

import designpattern.creational.factorymethod.ConcreteProductA;
import designpattern.creational.factorymethod.ConcreteProductB;
import designpattern.creational.factorymethod.Product;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DynamicShapeFactory {

    // Class 클래스 객체와 이를 구분하는 이니셜 문자열을 저장하는 HashMap 컬렉션
    private static final Map<String, Class<? extends Product>> registeredTypes = new HashMap<>();

    // 팩토리 객체가 생성됨에 동시에 미리 등록
    static {
        registeredTypes.put("productA", ConcreteProductA.class);
        registeredTypes.put("productB", ConcreteProductB.class);
    }

    // 나중에 등록할때 사용하는 메서드
    public static void registerType(String type, Class<? extends Product> cls) {
        registeredTypes.put(type, cls);
    }

    public static Product create(String type) {
        Product product = null;

        try {
            product = getProduct(type);
            product.setting();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return product;
    }

    // 다이나믹 팩토리 메서드
    private static Product getProduct(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1. 원하는 제품명의 Class 클래스 객체를 가져옴
        Class<?> cls = registeredTypes.get(type);

        // 2. 제품 객체의 생성자를 가져옴
        Constructor<?> shapeconstructor = cls.getDeclaredConstructor();

        // 3. Reflection API를 통해 인스턴스화를 하고 업캐스팅 하여 반환
        return (Product) shapeconstructor.newInstance();
    }
}

package designpattern.creational.factorymethod;

import designpattern.creational.factorymethod.dynamicfactory.DynamicShapeFactory;
import org.springframework.web.bind.annotation.RestController;
import designpattern.creational.factorymethod.enumfactorymethod.EnumFactory;

@RestController
public class FactoryMethodController {

    public void test(){
        Creator creator;

        if(true){
            creator = new ConcreteCreatorA();
        }else{
            creator = new ConcreteCreatorB();
        }

        creator.createOperation();
    }

    // 다이나믹 팩토리 메서드
    public void dynamic() {

        // 다이나믹 팩토리 클래스에 미리 등록된 제품 객체를 가져옴
        Product productA = DynamicShapeFactory.create("productA");
        Product productB = DynamicShapeFactory.create("productB");


        // 다이나믹 팩토리 클래스에 동적으로 제품 객체를 등록
       // DynamicShapeFactory.registerType("productC", ConcreteProductC.class);
       // Product productC = DynamicShapeFactory.create("productC");
    }

    public void enums() {
        Product productA = EnumFactory.PRODUCTA.createOperation();
        Product productB = EnumFactory.PRODUCTB.createOperation();
    }
}

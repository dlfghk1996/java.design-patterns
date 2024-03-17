package designpattern.creational.factorymethod.enumfactorymethod;

import designpattern.creational.factorymethod.ConcreteProductA;
import designpattern.creational.factorymethod.ConcreteProductB;
import designpattern.creational.factorymethod.Product;

// enum 상수내에서 추상메서드 구현
public enum EnumFactory {
    PRODUCTA {
        public Product createProduct() {
            return new ConcreteProductA();
        }
    },
    PRODUCTB {
        public Product createProduct() {
            return new ConcreteProductB();
        }
    };

    public Product createOperation() {
        Product product = createProduct();
        product.setting();
        return product;
    }

    // 팩토리 메서드
    abstract protected Product createProduct();
}

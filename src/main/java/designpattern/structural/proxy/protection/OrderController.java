package designpattern.structural.proxy.protection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

/* 보호 프록시 예제
* : 주문을 이행할 수 있는 경우에만 주체클래스에 요청을 위임한다.
 */
@RequiredArgsConstructor
public class OrderController {

    public void addOrder() {
        OrderService orderService = new ProxyFulfillment(new Storage());
        Order order = new Order();
        order.setBuyNo(1);
        orderService.addOrder(order);
    }
}

package designpattern.structural.proxy.protection;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Proxy Pattern : Proxy
 * 주문이 가능한지 확인하는 작업이 이뤄진다.
 * 주문을 이행할 수 있는 경우에만 주체클래스에 요청을 위임한다.
 */
@Service
@RequiredArgsConstructor
public class ProxyFulfillment implements OrderService {
    private final Storage storage; // 물류 창고

    @Override
    public void addOrder(Order order) {
        // 재고가 있으면 주문을 진행한다.
        if (storage.currentInventory(order.getItem(), order.getBuyNo()) != 0) {
            storage.addOrder(order);
        }
    }
}

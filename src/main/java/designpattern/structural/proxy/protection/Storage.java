package designpattern.structural.proxy.protection;



import java.util.Map;
import org.springframework.stereotype.Service;

// Proxy Pattern : RealSubject
@Service
public class Storage implements OrderService {
    private Map<String, Integer> stock = Map.of("인형", 1, "과자", 2);

    @Override
    public void addOrder(Order order) {
        // 수량 변경
        String item = order.getItem();
        this.stock.replace(item, stock.get(item) - 1);

        /* 포장, 배송 등 기타 작업들이 추가적으로 이루어질 수 있음 */
        //processOne(); // 포장
        //processTwo(); // 배송
    }


    public int currentInventory(String item, int buyNO) {
        return this.stock.getOrDefault(stock.get(item), 0);
    }
}

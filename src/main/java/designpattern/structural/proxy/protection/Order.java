package designpattern.structural.proxy.protection;

import java.util.Calendar;
import java.util.List;
import lombok.Data;

@Data
public class Order {

    // 주문 개수
    private String item;
    int buyNo;

    @Data
    public static class Item {

        // 최대 상품 품목수 (Stock Keeping Unit)
        private int sku;
    }
}

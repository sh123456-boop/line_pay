package line.pay.cafe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //이러면 fetch = FetchType.LAZY랑 @JoinColumn 필요하지 않나
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) //마찬가지로 fetch = FetchType.LAZY랑 @JoinColumn 필요하지 않나
    @JoinColumn(name = "order_id") //연관관계 메서드를 설정하니까 fetch와 @joincolumn이 생김. 정확한 이유가 뭐지
    private Order order;

    private int count;

    private BigDecimal orderPrice;

    public OrderItem() {
    }

    public OrderItem(Long id, Item item, Order order, int count, BigDecimal orderPrice) {
        this.id = id;
        this.item = item;
        this.order = order;
        this.count = count;
        this.orderPrice = orderPrice;
    }



    // 연관관계 편의 메서드
    public static OrderItem create(Item item, int count, BigDecimal price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setOrderPrice(price);
        return orderItem;
    }




}

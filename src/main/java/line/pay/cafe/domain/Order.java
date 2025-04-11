package line.pay.cafe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")  //mysql 정책과 겹침?
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        orphanRemoval = true : 고아 객체(연관관계가 끊어진 자식)” 을 자동으로 삭제해주는 역할
        ex) order.getOrderItems().remove(orderItem); : 이렇게 리스트에서 제거하면 자바 컬렉션에만 빠지고 DB에는 여전히 살아있지만
                                                       orphanRemoval = true 로 설정하면 DB에서도 사라짐.

     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Pay> payments = new ArrayList<>();

    private BigDecimal totalPrice;

    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;


    public BigDecimal getTotalPrice(List<OrderItem> orderItems) {
        BigDecimal sum = BigDecimal.ZERO;

        for (OrderItem orderItem : orderItems) {
            sum = sum.add(orderItem.getOrderPrice());
        }

        return sum;
    }

    public Order(Long id, List<OrderItem> orderItems, List<Pay> payments, BigDecimal totalPrice, LocalDateTime orderDate, Merchant merchant) {
        this.id = id;
        this.orderItems = orderItems;
        this.payments = payments;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.merchant = merchant;
    }

    //연관관계 편의 메서드
    // ✅ 연관관계 메서드 1 - Merchant
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
        if (!merchant.getOrders().contains(this)) {
            merchant.getOrders().add(this);
        }
    }

    // ✅ 연관관계 메서드 2 - OrderItem
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    // ✅ 연관관계 메서드 3 - Pay
    public void addPay(Pay pay) {
        payments.add(pay);
        pay.setOrder(this);
    }


}

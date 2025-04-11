package line.pay.cafe.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String businessNumber;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    /*
        cascade = CascadeType.ALL : 연관된 엔티티도 자동으로 저장됨.
        주의 : 반드시 order.setMerchant(merchant) 로 양방향 관계 세팅 해줘야 함
     */
    private List<Order> orders = new ArrayList<>();

    protected Merchant() {
    }

    public Merchant(Long id, String name, String businessNumber, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.businessNumber = businessNumber;
        this.createdAt = createdAt;
    }
}

package line.pay.cafe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter //Annotation으로 편하게 getter 이용
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //무슨 전략이지?
    private Long id;

    private String name;

    // BigDecimal은 뭐야
    private BigDecimal price;

    //jpa이용시 기본 생성자 필요?
    protected Item() {
    }

    //이건 왜 만든거지
    public Item(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}

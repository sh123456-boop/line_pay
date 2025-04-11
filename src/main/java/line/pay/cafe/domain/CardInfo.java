package line.pay.cafe.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class CardInfo {
    private String cardNumberEncrypted;
    private String cardExpiration;
    private String cardIssuer;

    protected CardInfo() {
    }

    public CardInfo(String cardNumberEncrypted, String cardExpiration, String cardIssuer) {
        this.cardNumberEncrypted = cardNumberEncrypted;
        this.cardExpiration = cardExpiration;
        this.cardIssuer = cardIssuer;
    }
}

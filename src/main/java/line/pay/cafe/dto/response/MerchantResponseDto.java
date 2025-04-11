package line.pay.cafe.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MerchantResponseDto {
    private String name;
    private String businessNumber;
    private LocalDateTime createdAt;

    public static MerchantResponseDto fromEntity(line.pay.cafe.domain.Merchant merchant) {
        return MerchantResponseDto.builder()
                .name(merchant.getName())
                .businessNumber(merchant.getBusinessNumber())
                .createdAt(merchant.getCreatedAt())
                .build();
    }
}
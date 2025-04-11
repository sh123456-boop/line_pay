package line.pay.cafe.repository;

import line.pay.cafe.domain.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {
    List<Pay> findByOrderId(Long orderId);
}

package br.com.entregas.repository;

import br.com.entregas.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByOrderNumber(Long orderNumber);
}

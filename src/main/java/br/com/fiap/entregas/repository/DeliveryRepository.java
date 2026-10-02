package br.com.fiap.entregas.repository;

import br.com.fiap.entregas.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByOrderNumber(Long orderNumber);
}

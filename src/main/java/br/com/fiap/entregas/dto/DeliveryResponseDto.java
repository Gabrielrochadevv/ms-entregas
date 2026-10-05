package br.com.fiap.entregas.dto;

import br.com.fiap.entregas.domain.Delivery;
import br.com.fiap.entregas.domain.DeliveryStatus;

import java.time.LocalDate;

public record DeliveryResponseDto(
        Long deliveryNumber,
        Long orderNumber,
        String deliveryPersonName,
        DeliveryStatus deliveryStatus,
        LocalDate deliveryDate
) {
    public DeliveryResponseDto(Delivery delivery) {
        this(
                delivery.getDeliveryNumber(),
                delivery.getOrderNumber(),
                delivery.getDeliveryPersonName(),
                delivery.getDeliveryStatus(),
                delivery.getDeliveryDate()
        );
    }
}

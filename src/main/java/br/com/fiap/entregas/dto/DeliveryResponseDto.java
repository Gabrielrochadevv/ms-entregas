package br.com.fiap.entregas.dto;

import br.com.fiap.entregas.model.Delivery;
import br.com.fiap.entregas.model.DeliveryStatus;

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

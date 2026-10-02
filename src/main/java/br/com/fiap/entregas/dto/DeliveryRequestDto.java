package br.com.fiap.entregas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequestDto {
    private String deliveryPersonName;
    private Long orderNumber;
}

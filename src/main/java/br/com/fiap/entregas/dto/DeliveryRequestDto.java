package br.com.fiap.entregas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequestDto {
    @NotBlank
    private String deliveryPersonName;
    @NotNull
    private Long orderNumber;
}

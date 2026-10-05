package br.com.fiap.entregas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_delivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_number")
    private Long deliveryNumber;

    @Positive
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "delivery_person_name")
    private String deliveryPersonName;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

}

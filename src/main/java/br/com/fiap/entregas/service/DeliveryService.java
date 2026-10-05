package br.com.fiap.entregas.service;

import br.com.fiap.entregas.dto.DeliveryRequestDto;
import br.com.fiap.entregas.dto.DeliveryResponseDto;
import br.com.fiap.entregas.exception.DeliveryNotFoundException;
import br.com.fiap.entregas.domain.Delivery;
import br.com.fiap.entregas.domain.DeliveryStatus;
import br.com.fiap.entregas.repository.DeliveryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public void putInDelivery(Long orderNumber) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findByOrderNumber(orderNumber);

        if (deliveryOptional.isEmpty()) {
            throw new DeliveryNotFoundException("Entrega não encontrada!");
        }
        Delivery delivery = deliveryOptional.get();
        delivery.setDeliveryStatus(DeliveryStatus.IN_TRANSIT);
        deliveryRepository.save(delivery);
    }

    public DeliveryResponseDto create(DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(deliveryRequestDto, delivery);

        delivery.setDeliveryStatus(DeliveryStatus.IN_SEPARATION);
        delivery.setDeliveryDate(LocalDate.now());
        Delivery deliveryCreated = deliveryRepository.save(delivery);

        return new DeliveryResponseDto(deliveryCreated);
    }

    public DeliveryResponseDto searchByNumber(Long deliveryNumber) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryNumber);

        if (optionalDelivery.isPresent()) {
            return new DeliveryResponseDto(optionalDelivery.get());
        } else {
            throw new DeliveryNotFoundException("Entrega não encontrada!");
        }
    }

    public List<DeliveryResponseDto> listAllDelivery() {
        return deliveryRepository
                .findAll()
                .stream()
                .map(DeliveryResponseDto::new)
                .toList();
    }

    public void delete(Long deliveryNumber) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryNumber);

        if (optionalDelivery.isPresent()) {
            deliveryRepository.delete(optionalDelivery.get());
        } else {
            throw new RuntimeException("Entrega não encontrada!");
        }
    }

    public DeliveryResponseDto update(DeliveryRequestDto deliveryRequestDto, Long deliveryNumber) {
        Delivery delivery = deliveryRepository.findByOrderNumber(deliveryNumber)
                .orElseThrow(() -> new DeliveryNotFoundException("Entrega não encontrada."));

        delivery.setDeliveryPersonName(deliveryRequestDto.getDeliveryPersonName());
        delivery.setOrderNumber(deliveryRequestDto.getOrderNumber());
        Delivery updatedDelivery = deliveryRepository.save(delivery);
        return new DeliveryResponseDto(updatedDelivery);
    }
}














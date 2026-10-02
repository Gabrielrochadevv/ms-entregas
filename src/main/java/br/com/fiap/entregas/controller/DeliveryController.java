package br.com.fiap.entregas.controller;

import br.com.fiap.entregas.dto.DeliveryRequestDto;
import br.com.fiap.entregas.dto.DeliveryResponseDto;
import br.com.fiap.entregas.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @PutMapping("/{orderNumber}/transport")
    public void putInTransport(@PathVariable Long orderNumber) {
        service.putInDelivery(orderNumber);
    }

    @PostMapping
    public DeliveryResponseDto create(@RequestBody @Valid DeliveryRequestDto deliveryRequestDto) {
        return service.create(deliveryRequestDto);
    }

    @GetMapping("{deliveryNumber}")
    public ResponseEntity<DeliveryResponseDto> searchByNumber(@PathVariable Long deliveryNumber) {
        return ResponseEntity.ok(service.searchByNumber(deliveryNumber));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryResponseDto>> listAllDelivery() {
        return ResponseEntity.ok(service.listAllDelivery());
    }

    @DeleteMapping("{deliveryNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long deliveryNumber) {
        service.delete(deliveryNumber);
    }

    @PutMapping("{deliveryNumber}")
    public DeliveryResponseDto update(@RequestBody DeliveryRequestDto deliveryRequestDto, @PathVariable Long deliveryNumber) {
        return service.update(deliveryRequestDto, deliveryNumber);
    }

}

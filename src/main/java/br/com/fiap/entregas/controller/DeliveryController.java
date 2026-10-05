package br.com.fiap.entregas.controller;

import br.com.fiap.entregas.dto.DeliveryRequestDto;
import br.com.fiap.entregas.dto.DeliveryResponseDto;
import br.com.fiap.entregas.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping
    @Operation(summary = "Cria as entregas")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery created successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Invalid delivery information.")
    })
    public DeliveryResponseDto create(@RequestBody @Valid DeliveryRequestDto deliveryRequestDto) {
        return service.create(deliveryRequestDto);
    }

    @PutMapping("{deliveryNumber}")
    @Operation(
            summary = "Atualiza a entrega",
            description = "Atualiza os dados de uma entrega existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery successfully updated"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid delivery details"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Delivery not found")
    })
    public DeliveryResponseDto update(@RequestBody DeliveryRequestDto deliveryRequestDto, @PathVariable Long deliveryNumber) {
        return service.update(deliveryRequestDto, deliveryNumber);
    }

    @DeleteMapping("{deliveryNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Exclui entrega",
            description = "Remove a entrega existente pelo número de entrega."
    )
    public void delete(@PathVariable Long deliveryNumber) {
        service.delete(deliveryNumber);
    }

    @GetMapping("{deliveryNumber}")
    @Operation(
            summary = "Busca entrega pelo número",
            description = "Retorna os dados da entrega pelo número."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery found"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Delivery not found")
    })
    public ResponseEntity<DeliveryResponseDto> searchByNumber(@PathVariable Long deliveryNumber) {
        return ResponseEntity.ok(service.searchByNumber(deliveryNumber));
    }

    @GetMapping
    @Operation(
            summary = "Lista todas as entregas",
            description = "Retorna todos as entregas cadastradas"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Deliveries successfully returned."
    )
    public ResponseEntity<List<DeliveryResponseDto>> listAllDelivery() {
        return ResponseEntity.ok(service.listAllDelivery());
    }

    @Operation(
            summary = "Atualiza o status de transporte da entrega",
            description = "Atualiza o status da entrega para indicar que foi encaminhado para transporte"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Transportation status updated successfully."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Delivery not found"
            )
    })
    @PutMapping("/{orderNumber}/transport")
    public void putInTransport(@PathVariable Long orderNumber) {
        service.putInDelivery(orderNumber);
    }


}

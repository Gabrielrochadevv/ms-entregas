package br.com.fiap.entregas.exception;

public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException(String mensagem) {
        super(mensagem);
    }
}

package br.com.entregas.exception;

public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException(String mensagem) {
        super(mensagem);
    }
}

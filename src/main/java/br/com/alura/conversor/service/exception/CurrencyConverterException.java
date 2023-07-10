package br.com.alura.conversor.service.exception;

public class CurrencyConverterException extends RuntimeException {
    
    public CurrencyConverterException(String msg) {
        super(msg);
    }
}
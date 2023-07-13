package br.com.alura.conversor.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Recebe os dados retornados da API de moedas.
 * 
 * @author edielson-assis
 */
@Data
public class CurrencyData {

    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    
    @JsonProperty("create_date")
    private String createDate;
}
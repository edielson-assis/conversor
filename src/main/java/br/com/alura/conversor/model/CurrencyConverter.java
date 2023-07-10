package br.com.alura.conversor.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.alura.conversor.model.entities.CurrencyData;
import lombok.Data;

/**
 * Classe utilizada para serializar e converter as moedas.
 * 
 * @author edielson-assis
 */
@Data
public class CurrencyConverter {

    @JsonProperty("USDBRL")
    private CurrencyData usdBrl;

    @JsonProperty("BRLUSD")
    private CurrencyData brlUsd;

    @JsonProperty("EURBRL")
    private CurrencyData eurBrl;

    @JsonProperty("BRLEUR")
    private CurrencyData brlEur;

    @JsonProperty("GBPBRL")
    private CurrencyData gbpBrl;

    @JsonProperty("BRLGBP")
    private CurrencyData brlGbp;

    @JsonProperty("ARSBRL")
    private CurrencyData arsBrl;

    @JsonProperty("BRLARS")
    private CurrencyData brlArs;

    @JsonProperty("CLPBRL")
    private CurrencyData clpBrl;

    @JsonProperty("BRLCLP")
    private CurrencyData brlClp;

    /** 
     * Imprime a moeda convertida com base na taxa de câmbio. Recebe como parametro o valor atual da moeda e a quantidade que deve ser convertida.
     * 
     * @param obj
     * @param amount
     */
    public void printCurrency(CurrencyConverter obj, BigDecimal amount) {
        CurrencyData rate = rate(obj);
        if (rate != null) {
            String currency = rate.getCode();
            String symbol = getCurrencySymbol(currency);
            Double exchangeRate = exchangeRate(amount);
            System.out.println(currency.concat(" ").concat(symbol).concat(" ") + exchangeRate);
        }
    }

    /** 
     * Retorna os dados recebidos da API
     * 
     * @return CurrencyData
     */
    public CurrencyData getRate() {
        return rate(this);
    }
    
    private Double exchangeRate(BigDecimal amount) {
        return amount.multiply(new BigDecimal(getRate().getBid())).doubleValue();
    }  

    private CurrencyData rate(CurrencyConverter currency) {
        Map<String, Function<CurrencyConverter, CurrencyData>> rateMap = new HashMap<>();
        rateMap.put("USDBRL", CurrencyConverter::getUsdBrl);
        rateMap.put("BRLUSD", CurrencyConverter::getBrlUsd);
        rateMap.put("EURBRL", CurrencyConverter::getEurBrl);
        rateMap.put("BRLEUR", CurrencyConverter::getBrlEur);
        rateMap.put("GBPBRL", CurrencyConverter::getGbpBrl);
        rateMap.put("BRLGBP", CurrencyConverter::getBrlGbp);
        rateMap.put("ARSBRL", CurrencyConverter::getArsBrl);
        rateMap.put("BRLARS", CurrencyConverter::getBrlArs);
        rateMap.put("CLPBRL", CurrencyConverter::getClpBrl);
        rateMap.put("BRLCLP", CurrencyConverter::getBrlClp);

        for (Function<CurrencyConverter, CurrencyData> getter : rateMap.values()) {
            CurrencyData rate = getter.apply(currency);
            if (rate != null) {
                return rate;
            }
        }
        return null; 
    }
    
    private String getCurrencySymbol(String currency) {
        Map<String, String> symbolMap = new HashMap<>();
        symbolMap.put("USD", "$");
        symbolMap.put("BRL", "R$");
        symbolMap.put("EUR", "€");
        symbolMap.put("GBP", "£");
        symbolMap.put("ARS", "$");
        symbolMap.put("CLP", "$");
    
        return symbolMap.getOrDefault(currency, "");
    }    
}
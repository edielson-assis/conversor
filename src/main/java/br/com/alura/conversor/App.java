package br.com.alura.conversor;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.alura.conversor.model.CurrencyConverter;
import br.com.alura.conversor.service.AwesomeAPIService;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String rate = sc.nextLine();
        Double quantity = sc.nextDouble();

        CurrencyConverter response = AwesomeAPIService.getCurrencyConverter(rate);
        response.printCurrency(response, BigDecimal.valueOf(quantity));    

        sc.close();
    }
}
package br.com.alura.conversor.model.gui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.alura.conversor.model.CurrencyConverter;
import br.com.alura.conversor.service.AwesomeAPIService;

/**
 * Gera os componentes gráficos do conversor de moeda.
 * 
 * @author edielson-assis
 */
public class Currency {

    /** 
     * De acordo com a moeda selecionada, ele passa, como parâmetro, os valores para a API de moedas.
     */
    public static void currencyRate() {

        String quantity = JOptionPane.showInputDialog(null, "Insira um valor:");

        while (quantity != null && (!isValidQuantity(quantity))) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
            quantity = JOptionPane.showInputDialog(null, "Insira um valor:");
        }
        
        if (quantity != null) {
            Map<String, String> currencyMap = new HashMap<>();

            currencyMap.put("De Dólares a Reais", "USD-BRL");
            currencyMap.put("De Reais a Dólares", "BRL-USD");
            currencyMap.put("De Euros a Reais", "EUR-BRL");
            currencyMap.put("De Reais a Euros", "BRL-EUR");
            currencyMap.put("De Libras Esterlinas a Reais", "GBP-BRL");
            currencyMap.put("De Reais a Libras Esterlinas", "BRL-GBP");
            currencyMap.put("De Peso Argentino a Reais", "ARS-BRL");
            currencyMap.put("De Reais a Peso Argentino", "BRL-ARS");
            currencyMap.put("De Peso Chileno a Reais", "CLP-BRL");
            currencyMap.put("De Reais a Peso Chileno", "BRL-CLP");

            JComboBox<String> comboBox = new JComboBox<>(currencyMap.keySet().toArray(new String[0]));
            JOptionPane.showMessageDialog(null, comboBox, "Moedas", JOptionPane.QUESTION_MESSAGE);

            String selectedKey = (String) comboBox.getSelectedItem();
            String selectedValue = currencyMap.get(selectedKey);

            CurrencyConverter response = AwesomeAPIService.getCurrencyConverter(selectedValue);
            response.printCurrency(response, new BigDecimal(quantity));
        }
    }
 
    /** 
     * Realiza a validação de input. Utiliza uma espressão regular para verificar se o valor na caixa de input é um valor numérico. 
     * Através do método <b>isBlank()</b>, da classe String, verifica se é um valor vazio.
     * Retorna true se numérico e false se vazio ou não numérico.
     * 
     * @param quantity
     * @return boolean
     */
    private static boolean isValidQuantity(String quantity) {
        return quantity.matches("[-+]?\\d+(\\.\\d+)?") && !quantity.isBlank();
    }
}
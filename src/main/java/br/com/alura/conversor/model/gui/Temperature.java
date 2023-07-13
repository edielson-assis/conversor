package br.com.alura.conversor.model.gui;

import javax.swing.JOptionPane;

import br.com.alura.conversor.model.entities.TemperatureData;

/**
 * Gera os componentes gráficos do conversor de temperatura.
 * 
 * @author edielson-assis
 */
public class Temperature {

    /** 
     * De acordo com a escala selecionada, ele passa, como parâmetro, os valores para a classe <b>TemperatureData</b> e chama o método selecionado.
     */
    public static void currencyTemperature() {

        String[] temperaturies = { 
            "De Celsius pra Fahrenheit", 
            "De Fahrenheit para Celsius", 
            "De Fahrenheit para Kelvin", 
            "De Kelvin para Fahrenheit", 
            "De Celsius para Kelvin", 
            "De Kelvin para Celsius" 
        };
        String choice = (String) JOptionPane.showInputDialog(null, "Escolha uma escala",
                    "Menu", JOptionPane.PLAIN_MESSAGE, null, temperaturies, temperaturies[0]);

        if (choice != null) {
            String temperature = JOptionPane.showInputDialog(null, "Insira a temperatura:");

            if (temperature != null) {
                while (!isValidTemperature(temperature)) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
                    temperature = JOptionPane.showInputDialog(null, "Insira a temperatura:");
                }

                TemperatureData temperatureData = new TemperatureData();

                switch (choice) {
                    case "De Celsius pra Fahrenheit":
                        temperatureData.celsiusToFahrenheit(temperature);
                        break;
                    case "De Fahrenheit para Celsius":
                        temperatureData.fahrenheitToCelsius(temperature);
                        break;
                    case "De Fahrenheit para Kelvin":
                        temperatureData.fahrenheitToKelvin(temperature);
                        break;
                    case "De Kelvin para Fahrenheit":
                        temperatureData.kelvinToFahrenheit(temperature);
                        break;
                    case "De Celsius para Kelvin":
                        temperatureData.celsiusToKelvin(temperature);
                        break;
                    case "De Kelvin para Celsius":
                        temperatureData.kelvinToCelsius(temperature);
                        break;
                    default:
                }
            }
        }
    }

    
    /** 
     * Realiza a validação de input. Utiliza uma espressão regular para verificar se o valor na caixa de input é um valor numérico. 
     * Através do método <b>isBlank()</b>, da classe String, verifica se é um valor vazio.
     * Retorna true se numérico e false se vazio ou não numérico.
     * 
     * @param temperature
     * @return boolean
     */
    private static boolean isValidTemperature(String temperature) {
        return temperature.matches("[-+]?\\d+(\\.\\d+)?") && !temperature.isBlank();
    }
}
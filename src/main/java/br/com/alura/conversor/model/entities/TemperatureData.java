package br.com.alura.conversor.model.entities;

import javax.swing.JOptionPane;

/**
 * Realiza a conversão das temperaturas.
 * 
 * @author edielson-assis
 */
public class TemperatureData {
    
    private Double celsius;
    private Double fahrenheit;
    private Double kelvin;

    public void fahrenheitToCelsius(String temperature) {
        celsius = 5.0 / 9.0 * (Double.valueOf(temperature) - 32.0);
        JOptionPane.showMessageDialog(null, "Temperatura em Celsius: " + String.format("%.2f", celsius));
    }

    public void celsiusToFahrenheit(String temperature) {
        fahrenheit = 9.0 * Double.valueOf(temperature) / 5.0 + 32.0;
        JOptionPane.showMessageDialog(null, "Temperatura em Fahrenheit: " + String.format("%.2f", fahrenheit));
    }

    public void celsiusToKelvin(String temperature) {
        kelvin = Double.valueOf(temperature) + 273.15;
        JOptionPane.showMessageDialog(null, "Temperatura em Kelvin: " + String.format("%.2f", kelvin));
    }

    public void fahrenheitToKelvin(String temperature) {
        kelvin = ((Double.valueOf(temperature) - 32.0) * 5.0 / 9.0) + 273.15;
        JOptionPane.showMessageDialog(null, "Temperatura em Kelvin: " + String.format("%.2f", kelvin));
    }

    public void kelvinToCelsius(String temperature) {
        celsius = Double.parseDouble(temperature) - 273.15;
        JOptionPane.showMessageDialog(null, "Temperatura em Celsius: " + String.format("%.2f", celsius));
    }
    
    public void kelvinToFahrenheit(String temperature) {
        fahrenheit = (Double.parseDouble(temperature) - 273.15) * 9 / 5 + 32;
        JOptionPane.showMessageDialog(null, "Temperatura em Fahrenheit: " + String.format("%.2f", fahrenheit));
    }
}
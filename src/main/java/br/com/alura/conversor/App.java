package br.com.alura.conversor;

import javax.swing.JOptionPane;

import br.com.alura.conversor.model.gui.Currency;
import br.com.alura.conversor.model.gui.Temperature;

public class App {
    public static void main(String[] args) {

        boolean next = true;

        do {
            String[] converter = { "Conversor de Moeda", "Conversor de Temperatura" };
            String choice = (String) JOptionPane.showInputDialog(null, "Escolha uma opção",
                    "Menu", JOptionPane.PLAIN_MESSAGE, null, converter, converter[0]);

            if (choice != null) {
                if (choice.equals("Conversor de Moeda")) {
                    Currency.currencyRate();
                } else {
                    Temperature.currencyTemperature();
                }
            } 

            Integer reposonse = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "", JOptionPane.YES_NO_CANCEL_OPTION);
            if (reposonse.equals(JOptionPane.NO_OPTION)) {
                next = false;
                JOptionPane.showMessageDialog(null, "Programa finalizado");
            } else if (reposonse.equals(JOptionPane.CANCEL_OPTION)) {
                next = false;
                JOptionPane.showMessageDialog(null, "Programa concluido");
            } 
            else if (reposonse.equals(JOptionPane.CLOSED_OPTION)) {
                System.exit(0);
            }
        } while (next);
    }
}
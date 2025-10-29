package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame {

    // Atributos (componentes de la interfaz)
    private JTextField campo1, campo2;
    private JButton btnSumar, btnRestar, btnMultiplicar, btnDividir;
    private JLabel resultado;

    // Constructor
    public CalculadoraGUI() {
        setTitle("Calculadora Scrum - TecMilenio");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    // Método para inicializar y posicionar componentes
    private void operar(char operador) {
    try {
        // Leer los valores de los campos de texto
        double num1 = Double.parseDouble(campo1.getText());
        double num2 = Double.parseDouble(campo2.getText());
        double resultadoFinal;

        // Ejecutar la operación según el operador recibido
        switch (operador) {
            case '+':
                resultadoFinal = num1 + num2;
                resultado.setText("Resultado: " + resultadoFinal);
                break;
            case '-':
                resultadoFinal = num1 - num2;
                resultado.setText("Resultado: " + resultadoFinal);
                break;
            case '*':
                resultadoFinal = num1 * num2;
                resultado.setText("Resultado: " + resultadoFinal);
                break;
            case '/':
                if (num2 == 0) {
                    resultado.setText("Error: No se puede dividir entre cero");
                } else {
                    resultadoFinal = num1 / num2;
                    resultado.setText("Resultado: " + resultadoFinal);
                }
                break;
            default:
                resultado.setText("Operación inválida");
        }
    } catch (NumberFormatException e) {
        // Si el usuario ingresó texto no numérico
        resultado.setText("Error: Ingrese números válidos");
    }
}

    // Método main
    public static void main(String[] args) {
        CalculadoraGUI app = new CalculadoraGUI();
        app.setVisible(true);
    }
    private void inicializarComponentes() {
    // Campos de entrada
    campo1 = new JTextField();
    campo1.setBounds(50, 30, 120, 30);
    add(campo1);

    campo2 = new JTextField();
    campo2.setBounds(200, 30, 120, 30);
    add(campo2);

    // Botones de operación
    btnSumar = new JButton("+");
    btnSumar.setBounds(50, 80, 60, 30);
    add(btnSumar);

    btnRestar = new JButton("-");
    btnRestar.setBounds(120, 80, 60, 30);
    add(btnRestar);

    btnMultiplicar = new JButton("*");
    btnMultiplicar.setBounds(190, 80, 60, 30);
    add(btnMultiplicar);

    btnDividir = new JButton("/");
    btnDividir.setBounds(260, 80, 60, 30);
    add(btnDividir);

    // Etiqueta de resultado
    resultado = new JLabel("Resultado:");
    resultado.setBounds(50, 130, 300, 30);
    add(resultado);

    // Eventos para los botones
    btnSumar.addActionListener(e -> operar('+'));
    btnRestar.addActionListener(e -> operar('-'));
    btnMultiplicar.addActionListener(e -> operar('*'));
    btnDividir.addActionListener(e -> operar('/'));
}

}

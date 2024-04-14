package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualKeyboard1 extends JFrame {

    private JTextField textField;
    private PedidoAreaSujaGUI pedido;

    public VirtualKeyboard1(PedidoAreaSujaGUI pedido) {
        this.pedido = pedido;
        setTitle("WindCare Keyboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Visor
        textField = new JTextField();
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(300, 80)); // Tamanho do visor aumentado
        textField.setFont(new Font("Arial", Font.PLAIN, 42)); // Fonte maior para o visor
        mainPanel.add(textField, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5)); // Espaçamento mínimo entre os botões

        // Botões
        String[] buttonLabels = {
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                ",", "0", "Enviar"
        };

        JButton[] buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].setPreferredSize(new Dimension(80, 80)); // Botões quadrados
            buttonPanel.add(buttons[i]);
        }

        // Adicionar ação aos botões
        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.equals("Enviar")) {
                        enviarValor();
                    } else {
                        textField.setText(textField.getText() + command);
                    }
                }
            });
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
    }

    private void enviarValor() {
        String valorDigitado = textField.getText();
        JOptionPane.showMessageDialog(this, "Valor digitado: " + valorDigitado);
        textField.setText("");
        pedido.definePeso(valorDigitado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VirtualKeyboard1(null).setVisible(true);
            }
        });
    }
}
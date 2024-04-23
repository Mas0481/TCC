package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class VirtualKeyboard1 extends JFrame {

    private JTextField textField;
    private PedidoAreaSujaGUI pedido;
    private String valor = "";

    public VirtualKeyboard1(PedidoAreaSujaGUI pedido) {
        this.pedido = pedido;
        setTitle("WindCare Keyboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(this);
        setUndecorated(true);
        
        Point point = new Point(800, 300);
	setLocation(point);
        //setAlwaysOnTop(true);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Visor
        textField = new JTextField();
        
        // Criando o título da borda com fonte personalizada
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Digite o peso total");
        titledBorder.setTitleFont(new Font("Arial", Font.PLAIN, 18)); // Altere o tamanho da fonte aqui

        // Definindo o título da borda para o textField
        textField.setBorder(titledBorder);

        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(300, 80)); // Tamanho do visor aumentado
        textField.setFont(new Font("Arial", Font.PLAIN, 42)); // Fonte maior para o visor
        mainPanel.add(textField, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3)); // Espaçamento mínimo entre os botões

        // Botões
        String[] buttonLabels = {
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                "/", "0", ".",
                "", "OK", ""
        };

        JButton[] buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].setPreferredSize(new Dimension(80, 80)); // Botões quadrados
            buttonPanel.add(buttons[i]);
        }
        buttons[14].setVisible(false);
        buttons[12].setVisible(false);

        // Adicionar ação aos botões
        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.equals("OK")) {
                        enviarValor();
                        dispose();
                    } else {
                        valor = valor + command;
                        textField.setText(valor);
                        //enviarValor();
                    }
                }
            });
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
    }

    private void enviarValor() {
        String valorDigitado = valor;
        //JOptionPane.showMessageDialog(this, "Valor digitado: " + valorDigitado);
        //textField.setText("");
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

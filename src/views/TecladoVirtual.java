package views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.PedidoAreaSujaGUI;


        
public class TecladoVirtual extends JFrame implements ActionListener {
    private JTextField textField;
    private PedidoAreaSujaGUI pedido;

    public TecladoVirtual(PedidoAreaSujaGUI pedido) {
        
        this.pedido = pedido;
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Campo de texto
        textField = new JTextField(20);
        mainPanel.add(textField, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3)); // 0 linhas, 2 colunas
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adicionando os botões de 0 a 9
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Adicionando as teclas especiais
        JButton commaButton = new JButton(",");
        commaButton.addActionListener(this);
        buttonPanel.add(commaButton);

        JButton slashButton = new JButton("/");
        slashButton.addActionListener(this);
        buttonPanel.add(slashButton);

        // Adicionando o botão Enter maior
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        enterButton.setPreferredSize(new Dimension(900, 50));
        buttonPanel.add(enterButton);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Enter".equals(command)) {
            // Lógica para "Enter" (pode ser modificada conforme necessário)
            JOptionPane.showMessageDialog(this, "Texto digitado: " + textField.getText());
            textField.setText("");
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TecladoVirtual(null).setVisible(true);
            }
        });
    }
}

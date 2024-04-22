package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoLavanderiaGUI extends JFrame {

    private JPanel panelPedidos;
    private List<JButton> botoesPedidos;
    private int contadorPedidos;

    public PedidoLavanderiaGUI() {
        super("Pedidos da Lavanderia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Painel para os pedidos
        panelPedidos = new JPanel();
        panelPedidos.setLayout(new GridLayout(2, 4, 10, 10)); // 2 linhas, 4 colunas, espaçamento entre os componentes
        panelPedidos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Borda vazia para margens
        add(panelPedidos, BorderLayout.CENTER);

        // Lista de botões de pedidos
        botoesPedidos = new ArrayList<>();
        contadorPedidos = 1;
        
        //cria o primeiro botão
           JButton NovoPedido = new JButton("NovoPedido");
            NovoPedido.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte e o tamanho do texto
            NovoPedido.setVisible(true); // Inicialmente invisível
            botoesPedidos.add(NovoPedido);
            panelPedidos.add(NovoPedido);

        // Cria os botões iniciais como invisíveis
        for (int i = 1; i < 8; i++) {
            JButton botaoPedido = new JButton("Pedido " + (i + 1));
            botaoPedido.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte e o tamanho do texto
            botaoPedido.setVisible(false); // Inicialmente invisível
            botoesPedidos.add(botaoPedido);
            panelPedidos.add(botaoPedido);
        }

        // Simula a chegada de pedidos
        Thread threadPedidos = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); // Espera 3 segundos para simular a chegada de um novo pedido
                    adicionarNovoPedido();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPedidos.start();
    }

    private void adicionarNovoPedido() {
        // Verifica se todos os botões de pedidos já foram usados
        if (contadorPedidos >= botoesPedidos.size()) {
            JOptionPane.showMessageDialog(this, "Limite de pedidos atingido!");
            return;
        }

        // Torna o próximo botão de pedido visível
        botoesPedidos.get(contadorPedidos).setVisible(true);
        contadorPedidos++;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PedidoLavanderiaGUI gui = new PedidoLavanderiaGUI();
            gui.setVisible(true);
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.PedidoDAO;
import config.Configuracao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import modelo.Cliente;
import modelo.Pedido;

/**
 *
 * @author Marcio Almeida
 */
public class InicioAreaSujaGUI extends javax.swing.JFrame {

    private JPanel panelPedidos;
    private List<JButton> botoesPedidos;
    private int contadorPedidos;
    
    //instancia e objeto pedidoDAO  e recupera a lista de pedidos
    PedidoDAO pedidos = new PedidoDAO();
    ArrayList<Pedido> cad_pedidos = pedidos.list();

    public InicioAreaSujaGUI() {
        initComponents();
        
        //seta o usuario atual
        usuario.setText(Configuracao.getUsuario());
        
        // Lista de botões de pedidos
        botoesPedidos = new ArrayList<>();
        contadorPedidos = 0;

        //instancia e objeto pedidoDAO  e recupera a lista de pedidos
        PedidoDAO pedidos = new PedidoDAO();
        ArrayList<Pedido> cad_pedidos = pedidos.list();

        //cria o primeiro botão
        JButton novoPedido = new JButton("Novo Pedido");
        novoPedido.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte e o tamanho do texto
        novoPedido.setVisible(true); // Inicialmente invisível
        botoesPedidos.add(novoPedido);
        jPanel1.add(novoPedido);
        
        

        novoPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PedidoAreaSujaGUI().setVisible(true); 
            }
        });

        // Cria os botões iniciais como invisíveis
        for (int i = 1; i < 8; i++) {
            JButton botaoPedido = new JButton();
            botaoPedido.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte e o tamanho do texto
            botaoPedido.setVisible(false); // Inicialmente invisível
            botoesPedidos.add(botaoPedido);
            botaoPedido.setLayout(new FlowLayout(FlowLayout.CENTER)); // Define um layout de grade para organizar os rótulos
            
            JLabel pedido = new JLabel("Pedido");
            botaoPedido.add(pedido, BorderLayout.CENTER);
            
            JLabel cliente = new JLabel("Cliente");
            botaoPedido.add(cliente, BorderLayout.CENTER);
            
            JLabel entrega = new JLabel("Entrega");
            botaoPedido.add(entrega, BorderLayout.CENTER);
            
            JLabel quantidade = new JLabel("Quantidade");
            botaoPedido.add(quantidade, BorderLayout.CENTER);
            
            JButton botaoLavagem = new JButton();  
            JLabel rotulo_lavagem = new JLabel("Lavagem");
            botaoLavagem.add(rotulo_lavagem, BorderLayout.CENTER);
            JProgressBar lavagem = new JProgressBar();
            botaoLavagem.add(lavagem, BorderLayout.CENTER);
            botaoPedido.add(botaoLavagem, BorderLayout.CENTER);
            lavagem.setForeground(new java.awt.Color(255, 0, 0));
    
            JButton botaoCentrifugacao = new JButton();
            JLabel rotulo_centrifugacao = new JLabel("Centrifugação");
            botaoCentrifugacao.add(rotulo_centrifugacao, BorderLayout.CENTER);
            JProgressBar centrifugacao = new JProgressBar();
            botaoCentrifugacao.add(centrifugacao, BorderLayout.CENTER);
            botaoPedido.add(botaoCentrifugacao, BorderLayout.CENTER);            
            
            JButton botaoSecagem = new JButton();
            JLabel rotulo_secagem = new JLabel("Secagem");
            botaoSecagem.add(rotulo_secagem, BorderLayout.CENTER);
            JProgressBar secagem = new JProgressBar();
            secagem.setValue(i*23/2);
            botaoSecagem.add(secagem, BorderLayout.CENTER);
            botaoPedido.add(botaoSecagem, BorderLayout.CENTER);            
            
            JButton botaoDobra_Embala = new JButton();
            JLabel rotulo_botaoDobra_Embala = new JLabel("Finalização");
            botaoDobra_Embala.add(rotulo_botaoDobra_Embala, BorderLayout.CENTER);
            JProgressBar dobra_Embala = new JProgressBar();
            dobra_Embala.setValue(i*23/2);
            botaoDobra_Embala.add(dobra_Embala, BorderLayout.CENTER);
            botaoPedido.add(botaoDobra_Embala, BorderLayout.CENTER);      
           
            jPanel1.add(botaoPedido);
            
            if(cad_pedidos.size() > i-1){
                pedido.setText("Numero do pedido: " + cad_pedidos.get(i-1).getCodPedido());
                cliente.setText("Numero do pedido: " + cad_pedidos.get(i-1).getCodCliente());
                quantidade.setText("Quantidade: " + String.valueOf(cad_pedidos.get(i-1).getQtd_produto()));
                entrega.setText("Data Entrega: " + String.valueOf(cad_pedidos.get(i-1).getEntrega()));
                botaoPedido.setVisible(true);
            }
        }
        
        //adicionarPedidoNoBotao();
    }

    private void adicionarPedidoNoBotao() {

        //cria o modelo do combobox e adiciona a primeira linha
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Selecione o Cliente");

        // Adicione os itens do ArrayList ao modelo do ComboBox
        for (Pedido cads : cad_pedidos) {
            botoesPedidos.get(contadorPedidos + 1).setText("");
        }

        
        // Verifica se todos os botões de pedidos já foram usados
        if (contadorPedidos >= botoesPedidos.size()) {
            System.out.println("Tentando setar o valor");
            jLabel1.setText("Há mais pedidos na fila de espera");
            jLabel1.setVisible(true);
            return;
        }

        // Torna o próximo botão de pedido visível
        botoesPedidos.get(contadorPedidos).setVisible(true);
        contadorPedidos++;
    }

    private void adicionarNovoPedido() {
        // Verifica se todos os botões de pedidos já foram usados
        if (contadorPedidos >= botoesPedidos.size()) {
            System.out.println("Tentando setar o valor");
            jLabel1.setText("Há mais pedidos na fila de espera");
            jLabel1.setVisible(true);
            return;
        }

        // Torna o próximo botão de pedido visível
        botoesPedidos.get(contadorPedidos).setVisible(true);
        contadorPedidos++;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 780));
        setResizable(false);
        setSize(new java.awt.Dimension(940, 860));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SERVIÇOS - ÁREA SUJA");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 870, 36);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("SAIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(320, 640, 240, 60);

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 15, 15));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 80, 880, 540);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 520, 880, 0);

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/user.png"))); // NOI18N
        usuario.setText("MAS0481");
        getContentPane().add(usuario);
        usuario.setBounds(790, 30, 100, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAreaSujaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}

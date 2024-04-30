/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.PedidoDAO;
import config.Configuracao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import modelo.Pedido;

/**
 *
 * @author Marcio Almeida
 */
public class InicioAreaSujaGUI extends javax.swing.JFrame {

    //instancia e objeto pedidoDAO  e recupera a lista de pedidos
    PedidoDAO pedidos = new PedidoDAO();
    ArrayList<Pedido> cad_pedidos = pedidos.list();

    public InicioAreaSujaGUI() {
        initComponents();
        btPedido1.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte e o tamanho do texto
        btPedido1.setText("NOVO PEDIDO");
        btPedido1.setVisible(true); // Inicialmente invisível  

        Thread threadPedidos = new Thread(new Runnable() {
            @Override
            public void run() {

                // Array de botões
                JButton[] botoes = {btPedido1, btPedido2, btPedido3, btPedido4, btPedido5, btPedido6, btPedido7, btPedido8};

                while (true) {

                    ArrayList<Pedido> cad_pedidos = pedidos.list();

                    // Verificar se o índice é válido na lista de valores
                    for (int i = 0; i < botoes.length - 1; i++) {

                        botoes[i + 1].removeAll();

                        jPanel1.setDoubleBuffered(true);

                        if (i < cad_pedidos.size()) {

                            botoes[i + 1].setLayout(new FlowLayout(FlowLayout.CENTER)); // Define um layout de grade para organizar os rótulos

                            JLabel pedido = new JLabel("");
                            botoes[i + 1].add(pedido, BorderLayout.CENTER);
                            pedido.setText("Número do Pedido: " + cad_pedidos.get(i).getCodPedido());
                            System.out.println("Número do Pedido: " + cad_pedidos.get(i).getCodPedido());

                            JLabel cliente = new JLabel("");
                            botoes[i + 1].add(cliente, BorderLayout.CENTER);
                            cliente.setText("Codigo do Cliente: " + cad_pedidos.get(i).getCodCliente());

                            JLabel entrega = new JLabel("Data da Entrega: " + cad_pedidos.get(i).getEntrega());
                            botoes[i + 1].add(entrega, BorderLayout.CENTER);
                            entrega.setText("Data da Entrega: " + cad_pedidos.get(i).getEntrega());

                            JLabel quantidade = new JLabel();
                            botoes[i + 1].add(quantidade, BorderLayout.CENTER);
                            quantidade.setText("Quantidade do Pedido: " + cad_pedidos.get(i).getQtd_produto());

                            JButton botaoLavagem = new JButton();
                            JLabel rotulo_lavagem = new JLabel("Lavagem");
                            botaoLavagem.add(rotulo_lavagem, BorderLayout.CENTER);
                            JProgressBar lavagem = new JProgressBar();
                            botaoLavagem.add(lavagem, BorderLayout.CENTER);
                            botoes[i + 1].add(botaoLavagem, BorderLayout.CENTER);
                            lavagem.setForeground(new java.awt.Color(255, 0, 0));

                            JButton botaoCentrifugacao = new JButton();
                            JLabel rotulo_centrifugacao = new JLabel("Centrifugação");
                            botaoCentrifugacao.add(rotulo_centrifugacao, BorderLayout.CENTER);
                            JProgressBar centrifugacao = new JProgressBar();
                            botaoCentrifugacao.add(centrifugacao, BorderLayout.CENTER);
                            botoes[i + 1].add(botaoCentrifugacao, BorderLayout.CENTER);

                            JButton botaoSecagem = new JButton();
                            JLabel rotulo_secagem = new JLabel("Secagem");
                            botaoSecagem.add(rotulo_secagem, BorderLayout.CENTER);
                            JProgressBar secagem = new JProgressBar();
                            secagem.setValue(i * 23 / 2);
                            botaoSecagem.add(secagem, BorderLayout.CENTER);
                            botoes[i + 1].add(botaoSecagem, BorderLayout.CENTER);

                            JButton botaoDobra_Embala = new JButton();
                            JLabel rotulo_botaoDobra_Embala = new JLabel("Finalização");
                            botaoDobra_Embala.add(rotulo_botaoDobra_Embala, BorderLayout.CENTER);
                            JProgressBar dobra_Embala = new JProgressBar();
                            dobra_Embala.setValue(i * 23 / 2);
                            botaoDobra_Embala.add(dobra_Embala, BorderLayout.CENTER);
                            botoes[i + 1].add(botaoDobra_Embala, BorderLayout.CENTER);

                            jPanel1.getComponent(i + 1).setVisible(true);

                        } else {
                            // Se não houver valor correspondente na lista, limpar o texto do botão
                            botoes[i + 1].setText("");
                            jPanel1.getComponent(i + 1).setVisible(false);
                        }
                    }

                    try {
                        Thread.sleep(Configuracao.getAtualizacao());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InicioAreaSujaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        threadPedidos.start();

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
        usuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btPedido1 = new javax.swing.JButton();
        btPedido2 = new javax.swing.JButton();
        btPedido3 = new javax.swing.JButton();
        btPedido4 = new javax.swing.JButton();
        btPedido5 = new javax.swing.JButton();
        btPedido6 = new javax.swing.JButton();
        btPedido7 = new javax.swing.JButton();
        btPedido8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(925, 750));
        setPreferredSize(new java.awt.Dimension(925, 750));
        setSize(new java.awt.Dimension(925, 750));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SERVIÇOS - ÁREA SUJA");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 870, 36);

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/user.png"))); // NOI18N
        usuario.setText("MAS0481");
        getContentPane().add(usuario);
        usuario.setBounds(790, 30, 100, 16);

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 10, 10));

        btPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedido1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPedido1);
        jPanel1.add(btPedido2);
        jPanel1.add(btPedido3);
        jPanel1.add(btPedido4);
        jPanel1.add(btPedido5);
        jPanel1.add(btPedido6);
        jPanel1.add(btPedido7);
        jPanel1.add(btPedido8);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 70, 870, 520);

        jButton9.setText("SAIR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(320, 620, 210, 60);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedido1ActionPerformed
        new PedidoAreaSujaGUI().setVisible(true);
    }//GEN-LAST:event_btPedido1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAreaSujaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPedido1;
    private javax.swing.JButton btPedido2;
    private javax.swing.JButton btPedido3;
    private javax.swing.JButton btPedido4;
    private javax.swing.JButton btPedido5;
    private javax.swing.JButton btPedido6;
    private javax.swing.JButton btPedido7;
    private javax.swing.JButton btPedido8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.PedidoDAO;
import config.Configuracao;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Cliente;
import modelo.Pedido;
import util.ManipuladorPedidos;

/**
 *
 * @author Marcio Almeida
 */
public class ConfiguracoesGUI extends javax.swing.JFrame {

    PedidoDAO p = new PedidoDAO();
    ArrayList<Pedido> cad_pedidos = p.list();

    public ConfiguracoesGUI() {
        initComponents();
        //seta o usuario atual
        usuario.setText(Configuracao.getUsuario());

        ArrayList<Pedido> cad_pedidos = p.list();
        //cria o modelo do combobox e adiciona a primeira linha
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("");

        // Adicione os itens do ArrayList ao modelo do ComboBox
        for (Pedido cads : cad_pedidos) {
            model.addElement("" + cads.getCodPedido());
        }

        // Defina o modelo atualizado no ComboBox
        cbQtdExcluir.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTempo = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbQtdPedidos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cbQtdExcluir = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(560, 420));
        setSize(new java.awt.Dimension(560, 420));
        getContentPane().setLayout(null);

        jLabel1.setText("Tempo atualização tela de pedidos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 135, 182, 16);

        jLabel2.setText("Gerar pedidos automaticamente");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 178, 176, 16);

        tfTempo.setText("3000");
        getContentPane().add(tfTempo);
        tfTempo.setBounds(230, 130, 58, 22);

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/user.png"))); // NOI18N
        usuario.setText("MAS0481");
        getContentPane().add(usuario);
        usuario.setBounds(410, 30, 100, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONFIGURAÇÕES");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 500, 36);

        cbQtdPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cbQtdPedidos);
        cbQtdPedidos.setBounds(228, 175, 60, 22);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(294, 130, 50, 23);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(294, 175, 50, 23);

        jLabel3.setText("Imagem da tela inicial");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 218, 116, 16);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(228, 218, 199, 22);

        jButton3.setText("OK");
        getContentPane().add(jButton3);
        jButton3.setBounds(433, 218, 50, 23);

        jButton4.setText("SAIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(110, 310, 317, 35);

        jLabel4.setText("Excluir Pedidos");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 260, 170, 16);

        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(310, 260, 50, 23);

        cbQtdExcluir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbQtdExcluir);
        cbQtdExcluir.setBounds(230, 260, 72, 22);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Configuracao.setAtualizacao(tfTempo.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object selectedItem = cbQtdPedidos.getSelectedItem();
        int valor = 0;
        if (selectedItem != null) {
            String selectedString = selectedItem.toString();
            try {
                // Tente converter a String para um int
                valor = Integer.parseInt(selectedString);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter para int: " + e.getMessage());
            }
        }

        Configuracao.setQtd_pedidos_gerados(valor);
        ManipuladorPedidos gerar = new ManipuladorPedidos();
        gerar.GerarPedidos();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Object selectedItem = cbQtdExcluir.getSelectedItem();
        int valor = 0;
        if (selectedItem != null) {
            String selectedString = selectedItem.toString();
            try {
                // Tente converter a String para um int
                valor = Integer.parseInt(selectedString);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter para int: " + e.getMessage());
            }
        }

        p.excluir(valor);
        
  cbQtdExcluir.removeAllItems();
  
        ArrayList<Pedido> cad_pedidos1 = p.list();
         //cria o modelo do combobox e adiciona a primeira linha
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>();
        model1.addElement("");

        // Adicione os itens do ArrayList ao modelo do ComboBox
        for (Pedido cads : cad_pedidos1) {
            model1.addElement("" + cads.getCodPedido());
        }
        
             // Defina o modelo atualizado no ComboBox
        cbQtdExcluir.setModel(model1);
        cbQtdExcluir.repaint();
        
       
        

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfiguracoesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiguracoesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbQtdExcluir;
    private javax.swing.JComboBox<String> cbQtdPedidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField tfTempo;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

/**
 *
 * @author Marcio Almeida
 */
public class PedidoAreaSujaGUI extends javax.swing.JFrame {

    /**
     * Creates new form PedidoAreaSujaGUI
     */
    public PedidoAreaSujaGUI() {
        initComponents();
    }
    
    public void definePeso(String peso)
    {
        tfPeso.setText(peso);
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
        tfCodCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tfEndereco1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfEndereco2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(940, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(940, 660));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INGRESSO DE PEDIDO");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 890, 36);

        tfCodCli.setEditable(false);
        getContentPane().add(tfCodCli);
        tfCodCli.setBounds(100, 80, 100, 30);

        jLabel4.setText("Cod Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 90, 80, 16);

        jLabel22.setText("Nome");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(230, 90, 60, 16);

        tfNome.setEditable(false);
        getContentPane().add(tfNome);
        tfNome.setBounds(280, 80, 500, 30);

        tfEndereco.setEditable(false);
        getContentPane().add(tfEndereco);
        tfEndereco.setBounds(100, 120, 440, 30);

        jLabel23.setText("Endereço");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(20, 120, 70, 16);

        tfTelefone.setEditable(false);
        getContentPane().add(tfTelefone);
        tfTelefone.setBounds(640, 120, 140, 30);

        jLabel20.setText("Telefone");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(570, 130, 60, 16);

        jLabel1.setText("n Serviço");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("N Serviço"));
        jLabel1.setMaximumSize(new java.awt.Dimension(58, 34));
        jLabel1.setMinimumSize(new java.awt.Dimension(58, 34));
        jLabel1.setPreferredSize(new java.awt.Dimension(58, 34));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(800, 70, 110, 90);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DATA COLETA");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(140, 170, 210, 16);
        getContentPane().add(tfEndereco1);
        tfEndereco1.setBounds(130, 210, 220, 60);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("DATA ENTREGA");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(590, 170, 210, 16);

        tfEndereco2.setEditable(false);
        getContentPane().add(tfEndereco2);
        tfEndereco2.setBounds(580, 210, 220, 60);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PESO");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(130, 310, 210, 16);

        tfPeso.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        tfPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfPesoMouseClicked(evt);
            }
        });
        tfPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesoActionPerformed(evt);
            }
        });
        getContentPane().add(tfPeso);
        tfPeso.setBounds(120, 340, 230, 80);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(520, 360, 40, 40);

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcional"));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 330, 400, 180);

        jTextField2.setText("jTextField1");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(520, 360, 40, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPesoMouseClicked
        new VirtualKeyboard1(this).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesoMouseClicked

    private void tfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesoActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoAreaSujaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoAreaSujaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField tfCodCli;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEndereco1;
    private javax.swing.JTextField tfEndereco2;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}

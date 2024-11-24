/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import config.Configuracao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Pedido;

public class PedidoGUI extends javax.swing.JFrame {

    private final Cliente c;
    
        ArrayList<Pedido> lista = new ArrayList();
        double valor;
        double qtd;
        long codCli;
        Date data;
                
        ClienteDAO cliente = new ClienteDAO();
        PedidoDAO pedido = new PedidoDAO();
        ArrayList<Cliente> cad = cliente.list();

     public PedidoGUI(Cliente c) {
        this.c = c;
        
        //seta o usuario atual
//        usuario.setText(Configuracao.getUsuario());
         
        initComponents();
         tfPago.setVisible(false);
         Pedido pedido = new Pedido();
         tfCodCli.setText(String.valueOf(c.getCodCliente()));
         tfNome.setText( c.getNome());
         tfTelefone.setText(String.valueOf(c.getTelefone()));
         tfEndereco.setText(c.getEndereco() + ", " + c.getNumero() + " - " + c.getBairro() + " - " + c.getCidade() );
         tbProdutos.setValueAt(1, 0, 0);
         tbProdutos.setValueAt("Basico", 0, 1);
         tbProdutos.setValueAt(10.00, 0, 2);
         tbProdutos.setValueAt("un", 0, 3);
         
         
              // Captura e formata a data atual
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tfDataColeta.setText(dataAtual.format(formatter));
        tfDataEntrega.setText(LocalDate.now().plusDays(2).format(formatter));
         
         
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel20 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        btAdicionar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTotalG = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfCodCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btPago = new javax.swing.JRadioButton();
        btAPagar = new javax.swing.JRadioButton();
        tfPago = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        tfDataColeta = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        tfDataEntrega = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");
        setMinimumSize(new java.awt.Dimension(940, 660));
        setSize(new java.awt.Dimension(940, 660));
        getContentPane().setLayout(null);

        jLabel20.setText("Telefone");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(700, 130, 60, 16);

        tfNome.setEditable(false);
        getContentPane().add(tfNome);
        tfNome.setBounds(280, 80, 630, 30);

        tfTelefone.setEditable(false);
        getContentPane().add(tfTelefone);
        tfTelefone.setBounds(770, 120, 140, 30);

        tfEndereco.setEditable(false);
        getContentPane().add(tfEndereco);
        tfEndereco.setBounds(100, 120, 570, 30);

        jLabel22.setText("Nome");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(230, 90, 60, 16);

        jLabel23.setText("Endereço");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(20, 120, 70, 16);

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "COD", "Serviço", "Valor", "Unidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 380, 330);

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Cod", "Quantidade", "Total"
            }
        ));
        jScrollPane2.setViewportView(tbPedido);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 170, 370, 330);

        btAdicionar.setText("Adicionar >>");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btAdicionar);
        btAdicionar.setBounds(420, 270, 100, 40);

        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btFinalizar);
        btFinalizar.setBounds(420, 320, 100, 40);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar);
        btCancelar.setBounds(420, 370, 100, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 220, 100, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PEDIDO");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 190, 100, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NÚMERO DO");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 170, 100, 20);

        tfTotalG.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tfTotalG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(tfTotalG);
        tfTotalG.setBounds(420, 450, 100, 70);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TOTAL");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 420, 100, 20);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setText("Total do Pedido");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(640, 520, 110, 16);

        tfTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(tfTotal);
        tfTotal.setBounds(750, 510, 160, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INGRESSO DE PEDIDO");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 890, 36);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 10, 10);

        jLabel4.setText("Cod Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 90, 80, 16);

        tfCodCli.setEditable(false);
        getContentPane().add(tfCodCli);
        tfCodCli.setBounds(100, 80, 100, 30);

        jLabel7.setText("Pagamento");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(640, 550, 80, 16);

        btPago.setText("Pago");
        btPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btPago);
        btPago.setBounds(730, 550, 70, 21);

        btAPagar.setText("À Pagar");
        btAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btAPagar);
        btAPagar.setBounds(730, 580, 80, 21);
        getContentPane().add(tfPago);
        tfPago.setBounds(810, 550, 100, 22);

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/user.png"))); // NOI18N
        usuario.setText("MAS0481");
        getContentPane().add(usuario);
        usuario.setBounds(790, 30, 100, 16);

        tfDataColeta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfDataColeta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(tfDataColeta);
        tfDataColeta.setBounds(130, 510, 160, 30);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setText("Data do pedido");
        getContentPane().add(jLabel52);
        jLabel52.setBounds(20, 520, 110, 16);

        tfDataEntrega.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfDataEntrega.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(tfDataEntrega);
        tfDataEntrega.setBounds(130, 550, 160, 30);

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setText("Data de Entrega");
        getContentPane().add(jLabel53);
        jLabel53.setBounds(20, 560, 110, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        
        // Obtém o modelo de seleção de linha da JTable
        ListSelectionModel selectionModel = tbProdutos.getSelectionModel();

        // Adiciona um MouseListener para tratar o evento de clique    
                
                Pedido pedido = new Pedido();
                
                int rowIndex = tbProdutos.rowAtPoint(evt.getPoint());
                // Verifica se o clique foi em uma linha válida
                if (rowIndex >= 0) {
                    // Define a linha clicada como a linha selecionada
                    selectionModel.setSelectionInterval(rowIndex, rowIndex);
                    pedido.setCodCliente(c.getCodCliente());
                    float qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a Quantidade"));
                    pedido.setQtd_produto(qtd);
                    pedido.setValor_produtos(qtd*10);  
                    lista.add(pedido);
               }        
            evt.consume();       
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        valor=0;
            for (int i = 0; i < lista.size(); i++) {
                DefaultTableModel model = (DefaultTableModel) tbPedido.getModel();
                Object[] rowData = {""};
                model.addRow(rowData);
                tbPedido.setValueAt(lista.get(i).getCodPedido(), i, 0);
                tbPedido.setValueAt(lista.get(i).getQtd_produto(), i, 1);
                tbPedido.setValueAt(lista.get(i).getValor_produtos(), i, 2);
                valor = valor + lista.get(i).getValor_produtos();
                tfTotal.setText(String.valueOf( valor));
                qtd = qtd + lista.get(i).getQtd_produto();
            }
        
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
       Pedido p = new Pedido();
       p.setCodCliente((int)c.getCodCliente());
       p.setValor_produtos(valor);
       p.setQtd_produto(qtd);
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            p.setDataEntrega(formato.parse(tfDataEntrega.getText()));
            p.setDataColeta(formato.parse(tfDataColeta.getText()));
            
        } catch (ParseException ex) {
            Logger.getLogger(PedidoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(data!=null){
            p.setData_pagamento(data);
            p.setPagamento(1);
       }else{
           p.setPagamento(0);
       }
        
       pedido.inserir(p);
      JOptionPane.showMessageDialog(null, "Pedido Ingressado com Sucesso", "Pedido", JOptionPane.INFORMATION_MESSAGE);
       this.dispose();
       new PedidosGUI().setVisible(true);  
       
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagoActionPerformed
         if(btPago.isSelected()){
            tfPago.setVisible(true);
            LocalDate hoje = LocalDate.now();
            tfPago.setText(String.valueOf(hoje));
            data = java.sql.Date.valueOf(hoje);
            btAPagar.setSelected(false);
        }
    }//GEN-LAST:event_btPagoActionPerformed

    private void btAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAPagarActionPerformed
        if(btAPagar.isSelected()){
            tfPago.setVisible(false);
            btPago.setSelected(false);
        }
    }//GEN-LAST:event_btAPagarActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(Cliente cliente) {
                       
                new PedidoGUI(cliente).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btAPagar;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JRadioButton btPago;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPedido;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfCodCli;
    private javax.swing.JTextField tfDataColeta;
    private javax.swing.JTextField tfDataEntrega;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPago;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JLabel tfTotalG;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}

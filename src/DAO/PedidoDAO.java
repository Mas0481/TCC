package DAO;

import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pedido;

public class PedidoDAO implements OperacoesDAO {

    ArrayList<Pedido> cadastro = new ArrayList<>();

    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	salva no final da tabela cliente*/
    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Pedido p = (Pedido) obj;
            new Thread(() -> {
                try {
                    Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps;
                    ps = conn.prepareStatement("INSERT INTO pedidos (Qtd_produto, Valor_produtos, fk_codCliente, pagamento, data_pagamento, entrega) VALUES (?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);

                    ps.setFloat(1, p.getQtd_produto());
                    ps.setFloat(2, p.getValor_produtos());
                    ps.setInt(3, p.getCodCliente());
                    ps.setInt(4, p.getPagamento());
                    ps.setDate(5, (Date) p.getData_pagamento());
                    ps.setDate(6, (Date) p.getEntrega());

                    int rowcount = ps.executeUpdate();

                    conn = ConexaoMySQL.getConexaoMySQL();

                    PreparedStatement ps1 = conn.prepareStatement("INSERT INTO pedido_cliente (fk_codPedido, fk_codCliente) VALUES (?,?)");
                    ps1.setInt(1, rowcount);
                    ps1.setInt(2, p.getCodCliente());

                    ps1.executeUpdate();

                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();

            return true;
        }
        return false;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o Ativo como false e grava na mesma posição da tabela cliente*/
    @Override
    public boolean excluir(Object obj) {
        if (obj != null) {
            int cod = (int) obj;
            new Thread(() -> {
                try {
                    Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps = conn.prepareStatement("DELETE from pedidos WHERE codPedido=?");

                    ps.setInt(1, cod);

                    ps.executeUpdate();

                    conn.close();

                } catch (SQLException ex) {
                    System.out.println("Erro: Não consegui excluir o Pedido");
                    System.out.println(ex);
                }
            }).start();

            return true;
        }
        return false;
    }

    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    @Override
    public Object pesquisar(Object obj) {
        if (obj != null) {
            int cod = (int) obj;
            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedidos WHERE codPedido=?");

                ps.setInt(1, cod);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    Pedido c = new Pedido();

                    c.setCodPedido(rs.getInt(1));
                    c.setQtd_produto(rs.getFloat(2));
                    c.setValor_produtos(rs.getInt(3));
                    c.setEntrega(rs.getDate(4));
                    c.setPagamento(rs.getInt(5));
                    c.setData_pagamento(rs.getDate(6));

                    return c;
                }

                conn.close();

            } catch (SQLException ex) {
                System.out.println("Erro: Não consegui conectar o no BD");
                System.out.println(ex);
            }
        }
        return null;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o objeto todo na mesma posição da tabela*/
    @Override
    public boolean editar(Object obj) {
        if (obj != null) {
            Pedido p = (Pedido) obj;
            new Thread(() -> {
                try {
                    Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps = conn.prepareStatement("UPDATE pedidos SET Qtd_produto=?, Valor_produtos=?, Pagamento=?, Data_pagamento=? WHERE codPedido=?");

                    ps.setInt(1, p.getCodPedido());
                    ps.setFloat(2, p.getQtd_produto());
                    ps.setFloat(3, p.getValor_produtos());
                    ps.setDate(4, (Date) p.getEntrega());
                    ps.setInt(5, p.getPagamento());
                    ps.setDate(6, (Date) p.getData_pagamento());

                    ps.executeUpdate();

                    conn.close();

                } catch (SQLException ex) {
                    System.out.println("Erro: Não consegui alterar o pedido");
                    System.out.println(ex);
                }
            }).start();
            
            return true;
        }
        return false;
    }

    /*esse metodo lista todas as posições do ArrayList*/
    public ArrayList<Pedido> list() {
        ArrayList<Pedido> minhaLista = new ArrayList<Pedido>();
        try {
            Connection conn = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT p.codPedido,p.fk_codCliente,p.qtd_produto,p.valor_produtos,p.entrega, p.pagamento, p.data_pagamento from pedidos as p inner join clientes as c ON p.fk_codCliente=c.codCliente inner join pessoas as s on c.fk_Cpf=s.cpf;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido c = new Pedido();

                c.setCodPedido(rs.getInt(1));
                c.setCodCliente(rs.getInt(2));
                c.setQtd_produto(rs.getFloat(3));
                c.setValor_produtos(rs.getInt(4));
                c.setEntrega(rs.getDate(5));
                c.setPagamento(rs.getInt(6));
                c.setData_pagamento(rs.getDate(7));
                minhaLista.add(c);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.println("Erro: Não consegui listar os pedidos");
            System.out.println(ex);
        }

        return minhaLista;
    }

    // esse metodo retorna o cadastro
    public ArrayList<Pedido> getCadastro() {
        return cadastro;
    }

}

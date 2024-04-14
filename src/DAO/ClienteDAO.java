
package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ModelPessoa;
import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mk
 */
public class ClienteDAO implements OperacoesDAO {

    ArrayList<Cliente> cadastro = new ArrayList<>();
       
        /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	salva no final da tabela cliente*/
    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente p = (Cliente) obj;
            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps;
                ps = conn.prepareStatement("INSERT INTO pessoas (cpf, rg, endereco, numero, estado, telefone, ativo, obs, bairro, cidade, apto, cep, nome) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setLong(1, p.getCpf());
                ps.setLong(2, p.getRg());
                ps.setString(3, p.getEndereco());
                ps.setInt(4,  p.getNumero());
                ps.setString (5, p.getEstado());
                ps.setLong(6, p.getTelefone());
                ps.setBoolean(7,  p.isAtivo());
                ps.setString(8, p.getObs());
                ps.setString(9, p.getBairro());
                ps.setString(10, p.getCidade());
                ps.setInt(11, p.getApto());
                ps.setLong(12, p.getCep());
                ps.setString(13, p.getNome());
                
                ps.executeUpdate(); 
                
                conn = ConexaoMySQL.getConexaoMySQL();
                    
                PreparedStatement ps1 = conn.prepareStatement("INSERT INTO clientes (fk_Cpf, qntPedidos, divida, credito) VALUES (?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);

                ps1.setDouble(1, p.getCpf());
                ps1.setDouble(2, p.getQntPedidos());
                ps1.setDouble(3, p.getDivida());
                ps1.setDouble(4, p.getCredito());
                
                int rowcount = ps1.executeUpdate(); 
                
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
        if (obj !=null){
           Cliente cNovo = (Cliente) obj;
           
           
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pessoas SET ativo='1', obs=? WHERE cpf=?");
                                                                    
                ps.setString(1,cNovo.getObs());
                ps.setLong(2, cNovo.getCpf());
                                 
                int rowCount = ps.executeUpdate();        
                     
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui excluir o cliente");
                System.out.println(ex);
           } 
        }
        return false;
    }

    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    @Override
     public Object pesquisar(Object obj) {
        if (obj !=null){
            int cod = (int) obj;         
             try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT c.codCliente, p.cpf, p.nome, p.rg, p.endereco, p.numero, p.estado, p.telefone, p.ativo, p.obs, p.bairro, p.cidade, p.apto, p.cep FROM clientes c inner join pessoas p ON c.fk_Cpf=p.cpf where c.codCliente=?;");
                 
                ps.setInt(1, cod);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    
                    long cpf = rs.getLong(2);
                    String nome = rs.getString(3);
                    
                    Cliente c  = new Cliente(nome, cpf);  
                    c.setCodCliente(rs.getInt(1));
                    c.setRg(rs.getLong(4));
                    c.setEndereco(rs.getString(5));
                    c.setNumero(rs.getInt(6));
                    c.setEstado(rs.getString(7));
                    c.setTelefone(rs.getLong(8));
                    c.setAtivo(rs.getBoolean(9));
                    c.setObs(rs.getString(10));
                    c.setBairro(rs.getString(11));
                    c.setCidade(rs.getString(12));
                    c.setApto(rs.getInt(13));
                    c.setCep(rs.getInt(14));
                   
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
	seta o objeto todo na mesma posição do ArrayList*/
    @Override
    public boolean editar(Object obj) {     
        if (obj !=null){
           Cliente cNovo = (Cliente) obj;           
            System.out.println("cpf " + cNovo.getCpf());
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pessoas SET rg=?, nome=?, endereco=?, numero=?, estado=?, telefone=?, ativo=?, obs=?, bairro=?, cidade=?, apto=?, cep=? WHERE cpf=?");
                ps.setLong(1, cNovo.getRg());
                ps.setString(2, cNovo.getNome());
                ps.setString(3, cNovo.getEndereco());
                ps.setInt(4, cNovo.getNumero());
                ps.setString(5, cNovo.getEstado());
                ps.setLong(6,cNovo.getTelefone());
                ps.setBoolean(7, cNovo.isAtivo());
                ps.setString(8, cNovo.getObs());
                ps.setString(9,cNovo.getBairro());
                ps.setString(10, cNovo.getCidade());
                ps.setInt(11, cNovo.getApto());
                ps.setLong(12, cNovo.getCep());
                ps.setLong(13, cNovo.getCpf());
                                 
                int rowCount = ps.executeUpdate();        
                     
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui alterar o cliente");
                System.out.println(ex);
           }
        }
        return false;
    }
      
   /*esse metodo lista todas as posições da tabela clientes*/  
    public ArrayList<Cliente> list(){

        ArrayList <Cliente> minhaLista = new ArrayList<Cliente>();

            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes JOIN pessoas ON clientes.fk_Cpf = pessoas.cpf ORDER BY clientes.codCliente ASC;");             
                ResultSet rs = ps.executeQuery();
                    while(rs.next()){                         
                        long cpf = rs.getLong(2);
                        String nome = rs.getString(8);
                        Cliente c  = new Cliente(nome, cpf);
                        c.setCodCliente(rs.getInt(1));
                        c.setQntPedidos(rs.getInt(3));
                        c.setDivida(rs.getDouble(4));
                        c.setCredito(rs.getDouble(5));
                        c.setRg(rs.getLong(7));
                        c.setEndereco(rs.getString(9));
                        c.setNumero(rs.getInt(10));
                        c.setEstado(rs.getString(11));
                        c.setTelefone(rs.getLong(12));
                        c.setAtivo(rs.getBoolean(13));
                        c.setObs(rs.getString(14));
                        c.setBairro(rs.getString(15));
                        c.setCidade(rs.getString(16));
                        c.setApto(rs.getInt(17));
                        c.setCep(rs.getInt(18));         
                        minhaLista.add(c);
                    }         
                    
                conn.close();
                
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui listar os clientes");
                System.out.println(ex);
           } 
            
         return minhaLista; 
    }

    // esse metodo retorna o cadastro
    public ArrayList<Cliente> getCadastro() {
        return cadastro;
    }
    
    

}

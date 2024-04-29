package util;

import DAO.PedidoDAO;
import config.Configuracao;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import modelo.Pedido;

public class GerarPedidos {

    public boolean GerarPedidos() {
        // Lista para armazenar os pedidos gerados
        PedidoDAO p = new PedidoDAO();
        int quant = Configuracao.getQtd_pedidos_gerados();
        
        System.out.println("Entrou no gerador de pedidos, serão gerados " + quant + " pedidos.");

        // Gerar pedidos automaticamente
        for (int i = 0; (i + 1) <= quant; i++) {
            // Suponha que você tenha um método para gerar um código de cliente aleatório
            int codCliente = gerarCodigoCliente();

            // Suponha que você tenha um método para gerar uma quantidade aleatória
            int quantidade = gerarQuantidade();

            float valor = quantidade * 10;

            LocalDate hoje = LocalDate.now();
            Date dataEntrega = java.sql.Date.valueOf(hoje);

            // Criar um novo pedido e adicioná-lo à lista de pedidos
            Pedido pedido = new Pedido();
            pedido.setCodCliente(codCliente);
            pedido.setCodPedido(codCliente);
            pedido.setData_pagamento(null);
            pedido.setPagamento(1);
            pedido.setQtd_produto(quantidade);
            pedido.setValor_produtos(valor);
            pedido.setEntrega(dataEntrega);
           
            p.inserir(pedido);
        }
        return true;
    }

    // gerador de cadigo de cliente
    private static int gerarCodigoCliente() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4) + 1;
        return numeroAleatorio;
    }

    // gerador de quantidade
    private static int gerarQuantidade() {
        return (int) (Math.random() * 11);
    }
}

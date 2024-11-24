/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.Objects;

public class Pedido {
    private int codPedido;
    private int codCliente;
    private double qtd_produto;
    private double valor_produtos;
    private Date dataEntrega;
    private Date dataColeta;
    private int pagamento;
    private Date data_pagamento;
    
    
     public Pedido() {
    }
     
     
    public Pedido(double qtd_produto, double valor_produtos) {
        this.qtd_produto = qtd_produto;
        this.valor_produtos = valor_produtos;
    }

    public Pedido(double qtd_produto, double valor_produtos, Date entrega, int pagamento, Date data_pagamento) {
        this.qtd_produto = qtd_produto;
        this.valor_produtos = valor_produtos;
        this.dataEntrega = entrega;
        this.pagamento = pagamento;
        this.data_pagamento = data_pagamento;
    }
       
    
    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    
    
    public double getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(double qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    public double getValor_produtos() {
        return valor_produtos;
    }

    public void setValor_produtos(double valor_produtos) {
        this.valor_produtos = valor_produtos;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date entrega) {
        this.dataEntrega = entrega;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
        public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codPedido;
        hash = 37 * hash + this.codCliente;
       // hash = 37 * hash + Float.floatToIntBits(this.qtd_produto);
        //hash = 37 * hash + Float.floatToIntBits(this.valor_produtos);
        hash = 37 * hash + Objects.hashCode(this.dataEntrega);
        hash = 37 * hash + this.pagamento;
        hash = 37 * hash + Objects.hashCode(this.data_pagamento);
        return hash;
    }

//    @Override
   /* public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.codPedido != other.codPedido) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
       // if (Float.floatToIntBits(this.qtd_produto) != Float.floatToIntBits(other.qtd_produto)) {
            return false;
      //  }
      //  if (Float.floatToIntBits(this.valor_produtos) != Float.floatToIntBits(other.valor_produtos)) {
      //      return false;
       // }
        if (this.pagamento != other.pagamento) {
            return false;
        }
        if (!Objects.equals(this.dataEntrega, other.dataEntrega)) {
            return false;
        }
        return Objects.equals(this.data_pagamento, other.data_pagamento);
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", codCliente=" + codCliente + ", qtd_produto=" + qtd_produto + ", valor_produtos=" + valor_produtos + ", entrega=" + dataEntrega + ", pagamento=" + pagamento + ", data_pagamento=" + data_pagamento + '}';
    }*/



    
}


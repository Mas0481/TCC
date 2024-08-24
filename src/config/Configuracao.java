package config;

public class Configuracao {

    private static String usuario;
    private static int atualizacao = 3000;
    private static int qtd_pedidos_gerados;
    private static int qtd_clientes_gerados;

    public static int getQtd_clientes_gerados() {
        return qtd_clientes_gerados;
    }

    public static void setQtd_clientes_gerados(int qtd_clientes_gerados) {
        Configuracao.qtd_clientes_gerados = qtd_clientes_gerados;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    public static int getAtualizacao() {
        return atualizacao;
    }

    public static void setAtualizacao(String aAtualizacao) {
        atualizacao = atualizacao;
    }

    public static int getQtd_pedidos_gerados() {
        return qtd_pedidos_gerados;
    }

    public static void setQtd_pedidos_gerados(int aQtd_pedidos_gerados) {
        qtd_pedidos_gerados = aQtd_pedidos_gerados;
    }

}

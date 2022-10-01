package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPoolConexoes {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConexao();
            System.out.println("conexão numero: "+ i);
        }
    }
}

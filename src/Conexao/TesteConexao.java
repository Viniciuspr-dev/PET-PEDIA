package Conexao;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        Connection conexao = Conexao.conectar();

        if (conexao != null) {

            System.out.println("Teste concluído com sucesso!");

        } else {

            System.out.println("Falha na conexão.");

        }

    }

}
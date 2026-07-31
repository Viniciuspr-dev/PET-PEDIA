package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/pet_pedia";

    // Altere se o seu usuário não for root
    private static final String USUARIO = "root";

    // Coloque sua senha entre as aspas
    private static final String SENHA = "vini1313.0309";

    public static Connection conectar() {

        try {

            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("Conexão realizada com sucesso!");

            return conexao;

        } catch (SQLException e) {

            System.out.println("Erro ao conectar com o banco!");

            e.printStackTrace();

            return null;
        }

    }

}
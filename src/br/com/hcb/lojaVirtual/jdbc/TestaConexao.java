package br.com.hcb.lojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        
        Statement statement = connection.createStatement();
        boolean resultado = statement.execute("select * from produto");
        System.out.println("É possível retornar resultado dessa consulta: "+ resultado);
        
        System.out.println("Resultado:");
        ResultSet resultSet = statement.getResultSet();        
        
        while(resultSet.next()){
            System.out.println("Produto: " + resultSet.getString("descricao") + ", preco: " + resultSet.getDouble("preco"));
        }      
        
        resultSet.close();
        statement.close();
        
        connection.close();
    }
}

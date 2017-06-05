package br.com.hcb.lojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        
        Statement statement = connection.createStatement();
        boolean resultado = statement.execute("insert into produto (descricao, preco) values ('teclado',150.33)", Statement.RETURN_GENERATED_KEYS);
        
        System.out.println("Executou com sucesso: " + resultado);
        
        ResultSet keys = statement.getGeneratedKeys();
        
        while(keys.next()){
            int id = keys.getInt(1);
            System.out.println("Gerou o id: "+ id);
        }
                
        statement.close();        
        connection.close();
    }
}

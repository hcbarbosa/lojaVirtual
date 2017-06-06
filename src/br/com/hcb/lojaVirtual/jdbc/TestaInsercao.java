package br.com.hcb.lojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        
        String sql = "insert into produto (descricao, preco) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, "note' i5");
        statement.setDouble(2, 1999.99);
        
        boolean resultado = statement.execute();
        
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

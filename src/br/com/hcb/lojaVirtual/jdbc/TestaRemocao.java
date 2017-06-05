package br.com.hcb.lojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        
        Statement statement = connection.createStatement();
        statement.execute("delete from produto where id = " + 4);
        
        int linhasRemovidas = statement.getUpdateCount();
        System.out.println("Nº linhas removidas: " + linhasRemovidas);        
         
        statement.close();        
        connection.close();
    }
}

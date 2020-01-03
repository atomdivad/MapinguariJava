package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
    
    public static Connection getConnection(){

        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/mapinguari","root","");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
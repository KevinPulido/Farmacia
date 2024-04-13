
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private String database_name= "farmacia_database";
    private String user="root";
    private String password="Developer10";
    private String Url="jdbc:mysql://localhost:3306/"+ database_name;
    
    Connection conn = null;
    public Connection getConnection() throws SQLException{
        try{
            //Obtener valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexion
            conn = DriverManager.getConnection(Url,user,password);
        }catch(ClassNotFoundException e){
            System.err.println("Ha ocurrido un ClassNotFoundException" + e.getMessage());
        }catch(SQLException e){
            System.err.println("Ha ocurrido un SQLException"+ e.getMessage());
        }
        return conn;
    }
}

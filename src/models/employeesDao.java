
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class employeesDao {
    // instanciar la conexion
    ConnectionMySQL cn= new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst; // Sirve para las consultas
    ResultSet rs; // Sirve para datos de la consulta para operar
    
    //variables para enviar datos entre interfaces
    public static int id_user=0;
    public static String full_name_user="";
    public static String username_user="";
    public static String address_user="";
    public static String rol_user="";
    public static String email_user="";
    public static String telephone_user="";
    
    //Método de login
    public employees loginQuery(String user,String password){
        String query = "SELECT * FROM employees "
                + "WHERE username= ? AND password = ? " ;
        employees emp =new employees();
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            //enviar los parametros
            pst.setString(1, user);
            pst.setString(2,password);
            rs = pst.executeQuery();
            
            if(rs.next()){
                emp.setId(rs.getInt("id"));
                id_user = emp.getId();
                emp.setFull_name(rs.getString("full_name"));
                 full_name_user=emp.getFull_name();
                emp.setUsername(rs.getString("username"));
                username_user= emp.getUsername();
                emp.setAddress(rs.getString("address"));
                address_user= emp.getAddress();
                emp.getTelephone(rs.getString("telephone"));
                telephone_user=emp.getTelephone();
                emp.setRol(rs.getString("rol"));
                rol_user=emp.getRol();
                emp.
    email_user
    telephone_user
                
            }
        }catch(Exception e){
            
        }
    }
}

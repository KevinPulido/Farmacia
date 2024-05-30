package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.ConnectionMySQL;
import models.employees;

public class employeesDao {

    // instanciar la conexion
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst; // Sirve para las consultas
    ResultSet rs; // Sirve para datos de la consulta para operar

    //variables para enviar datos entre interfaces
    public static int id_user = 0;
    public static String full_name_user = "";
    public static String username_user = "";
    public static String address_user = "";
    public static String rol_user = "";
    public static String email_user = "";
    public static String telephone_user = "";

    //Método de login
    public employees loginQuery(String user, String password) {
        String query = "SELECT * FROM employees "
                + "WHERE username= ? AND password = ? ";
        employees emp = new employees();

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            //enviar los parametros
            pst.setString(1, user);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                emp.setId(rs.getInt("id"));
                id_user = emp.getId();

                emp.setFull_name(rs.getString("full_name"));
                full_name_user = emp.getFull_name();

                emp.setUsername(rs.getString("username"));
                username_user = emp.getUsername();

                emp.setAddress(rs.getString("address"));
                address_user = emp.getAddress();

                emp.setTelephone(rs.getString("telephone"));
                telephone_user = emp.getTelephone();

                emp.setEmail(rs.getString("email"));
                email_user = emp.getEmail();

                emp.setRol(rs.getString("rol"));
                rol_user = emp.getRol();

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de empleado" + e);
        }
        return emp;
    }

    //registrar empleado
    public boolean registerEmployeeQuery(employees employee) {
        String query="INSERT INTO employees(id, full_name,username,address,telephone,email,password,rol,created,update)"
               +"VALUES(?,?,?,?,?,?,?,?,?,?)";
        Timestamp datetime=new Timestamp(new Date().getTime());
        
        try{
            conn=cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getFull_name());
            pst.setString(3,employee.getUsername());
            pst.setString(4, employee.getAddress());
            pst.setString(5, employee.getTelephone());
            pst.setString(6, employee.getEmail());
            pst.setString(7,employee.getPassword());
            pst.setString(8,employee.getRol());
            pst.setTimestamp(9,datetime);
            pst.setTimestamp(10, datetime);
            pst.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al registrar al empleado"+e);
            return false;
        }
        
    }
    
    //listar empleados
    public List listEmployeesQuery(String value){
        List<employees> list_employees = new ArrayList();
        String query="SELECT * FROM employees ORDER BY rol ASC";
        String query_search_employee="SELECT * FROM employees WHERE id LIKE '%"+ value +"%'";
        
        try{
            conn=cn.getConnection();
            if(value.equalsIgnoreCase("")){
                pst = conn.prepareStatement(query);
                rs=pst.executeQuery();
            }else{
                pst=conn.prepareStatement(query_search_employee);
                rs=pst.executeQuery();
            }
            
            //recorrer los registros
            while(rs.next()){
                employees employee= new employees();
                employee.setId(rs.getInt("id"));
                employee.setFull_name(rs.getString("full_name"));
                employee.setUsername(rs.getString("username"));
                employee.setAddress(rs.getString("address"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setEmail(rs.getString("email"));
                employee.setRol(rs.getString("rol"));
                list_employees.add(employee);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return list_employees;
    }
    
    //Modificar empleado
    public boolean updateEmployeeQuery(employees employee) {
        String query="UPDATE employees SET full_name=?,username=?,address=?,telephone=?,email=?,rol=?,update=?"
                +"WHERE id=?";
        Timestamp datetime=new Timestamp(new Date().getTime());
        
        try{
            conn=cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.setString(1, employee.getFull_name());
            pst.setString(2,employee.getUsername());
            pst.setString(3, employee.getAddress());
            pst.setString(4, employee.getTelephone());
            pst.setString(5, employee.getEmail());
            pst.setString(6,employee.getRol());
            pst.setTimestamp(7, datetime);
            pst.setInt(8, employee.getId());
            pst.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al modificar los datos del empleado"+e);
            return false;
        }
        
    }
    
    //Eliminar empleado
    public boolean deleteEmployeeQuery(int id){
        String query = "DELETE FROM employees WHERE id = "+id;
        
        try{
            conn= cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No puedes eliminar el empleado que tenga relación con otra tabla");
            return false;
        }
    }
    
    //cambiar la contraseña
    public boolean updateEmployeePassword(employees employee){
        String query="UPDATE employees SET password=? WHERE username='"+username_user+"'";
        
        try{
            conn= cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.setString(1, employee.getPassword());
            pst.executeUpdate();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al modificar la contraseña "+ e);
            return false;
        }
    }
    
}

package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SuppliersDao {

    //instanciar conexión
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar proveedor
    public boolean registerSupplierQuery(Suppliers supplier) {
        String query = "INSERT INTO supppliers(name,description,telephone,address,email,city,created,updated)+"
                + "VALUES(?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getDescription());
            pst.setString(3, supplier.getTelephone());
            pst.setString(4, supplier.getAddress());
            pst.setString(5, supplier.getEmail());
            pst.setString(6, supplier.getCity());
            pst.setTimestamp(7, datetime);
            pst.setTimestamp(8, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el nuevo proveedor" + e);
            return false;
        }

    }

    //Listar proveedores
    public List listSupplierQuery(String value) {
        List<Suppliers> list_suppliers = new ArrayList();
        String query = "SELECT * FROM suppliers";
        String query_search_supplier = "SELECT * FROM suppliers WHERE id LIKE '%" + value + "%'";

        try {
            conn = cn.getConnection();
            if (value.equalsIgnoreCase("")) {
                pst = conn.prepareStatement(query);
                pst.executeQuery();
            } else {
                pst = conn.prepareStatement(query_search_supplier);
                rs = pst.executeQuery();

            }
            while (rs.next()) {
                Suppliers supplier = new Suppliers();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setDescription(rs.getString("description"));
                supplier.setTelephone(rs.getString("telephone"));
                supplier.setAddress(rs.getString("address"));
                supplier.setEmail(rs.getString("email"));
                supplier.setCity(rs.getString("city"));
                list_suppliers.add(supplier);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los proveedores " + e);
        }
        return list_suppliers;
    }

    //Modificar proveedor
    public boolean updateSupplierQuery(Suppliers supplier) {
        String query = "UPDATE suppliers SET name=?,description=?,telephone=?,address=?,email=?,city=?,updated=?"
                + "WHERE id=?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        int id = supplier.getId();
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getDescription());
            pst.setString(3, supplier.getTelephone());
            pst.setString(4, supplier.getAddress());
            pst.setString(5, supplier.getEmail());
            pst.setString(6, supplier.getCity());
            pst.setTimestamp(7, datetime);
            pst.setInt(8, supplier.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el proveedor " + id + e);
            return false;
        }
    }

    //eliminar proveedor
    public boolean deleteSupplierQuery(int id) {
        String query = "DELETE FROM supplier WHERE id = " + id;

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor con id = " + id + "tiene relación en otra tabla");
            return false;
        }
    }

}

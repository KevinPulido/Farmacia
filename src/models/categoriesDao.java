package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class categoriesDao {

    //Instanciar conexion
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //crear nueva categoria
    public boolean registerCategoryQuery(Categories category) {
        String query = "INSERT INTO categories(name,created,updated)"
                + "VALUES(?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.setTimestamp(2, datetime);
            pst.setTimestamp(3, datetime);
            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al registar catergoria" + e);
            return false;
        }

    }

    //listar categorias
    public List listCategoryQuery(String value) {
        List<Categories> list_categories = new ArrayList();
        String query = "SELECT * FROM categories";
        String query_search_categories = "SELECT * FROM categories WHERE id LIKE '%" + value + "%'";

        try {
            conn = cn.getConnection();
            if (value.equalsIgnoreCase("")) {
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                pst = conn.prepareStatement(query_search_categories);
                rs = pst.executeQuery();
            }
            while (rs.next()) {
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list_categories.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_categories;
    }

    //modificar categoria
    public boolean updateCategoryQuery(Categories category) {
        String query = "UPDATE categories SET name=?,created=?,updated=?";

        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.setTimestamp(2, datetime);
            pst.setTimestamp(3, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoria" + e);
            return false;
        }
    }

    //eliminar categoria
    public boolean deleteCategoryQuery(int id) {
        String query = "DELETE FROM categories WHERE id=" + id;

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor con id = " + id + "tiene relación en otra tabla" + e);
            return false;
        }
    }
}

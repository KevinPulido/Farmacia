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

public class productsDao {

    //instanciar conexion
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //registrar productos
    public boolean registerProductQuery(Products product) {
        String query = "INSERTO INTO products(id,code,name,description,unit_price,product_quantify,created,updated,category_id)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, product.getId());
            pst.setInt(2, product.getCode());
            pst.setString(3, product.getName());
            pst.setString(4, product.getDescription());
            pst.setDouble(5, product.getUnit_price());
            pst.setInt(6, product.getProduct_quantify());
            pst.setTimestamp(7, datetime);
            pst.setTimestamp(8, datetime);
            pst.setInt(9, product.getCategory_id());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto" + e);
            return false;
        }
    }

    //listar productos
    public List listProductQuery(String value) {
        List<Products> list_product = new ArrayList();

        String query = "select pro.*, ca.name AS category_name from products pro, categories ca WHERE pro.category_id=ca.id";
        String query_search_product = "select pro.*, ca.name AS category_name from products pro INNER JOIN categories ca +"
                + "ON pro.category_id=ca.id WHERE pro.name LIKE '%" + value + "%'";

        try {
            if (value.equalsIgnoreCase("")) {
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                conn = cn.getConnection();
                pst = conn.prepareStatement(query_search_product);
                rs = pst.executeQuery();
            }
            //Se recorren los datos
            while (rs.next()) {
                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setCode(rs.getInt("code"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUnit_price(rs.getDouble("unit_price"));
                product.setProduct_quantify(rs.getInt("product_quantify"));
                product.setCategory_name(rs.getString("category_name"));
                list_product.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_product;
    }

    //modificar producto
    public boolean updateProductQuery(Products product) {
        String query = "UPDATE products SET code=?,name=?,description=?,unit_price=?,product_quantify=?,updated=?+"
                + "WHERE id=?";

        Timestamp datetime = new Timestamp(new Date().getTime());

        try {
            conn= cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.setInt(1, product.getCode());
            pst.setString(2, product.getName());
            pst.setString(3, product.getDescription());
            pst.setDouble(4, product.getUnit_price());
            pst.setInt(5, product.getProduct_quantify());
            pst.setTimestamp(6, datetime);
            pst.setInt(7, product.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al modificar el producto"+ e);
             return true;
        }
    }
    
    //elminar producto
    public boolean deleteProductQuery(int id){
        String query="DELETE FROM products WHERE id="+id;
        
        try{
            conn= cn.getConnection();
            pst=conn.prepareStatement(query);
            pst.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor con id = " + id + "tiene relación en otra tabla");
            return false;
        }
    }
    
}


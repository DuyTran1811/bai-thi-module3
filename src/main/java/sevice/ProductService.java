package sevice;

import mode.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final String query = "SELECT p.id, p.name, p.price, p.quantity, p.color, c.name, p.category_id FROM category c\n" +
            "JOIN product p ON p.category_id = c.id\n" +
            "WHERE p.name LIKE  ?";

    @Override
    public List<Product> getAll() {
        String query = "CALL getAll()";
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnector.getConnection();
             CallableStatement call = con.prepareCall(query)) {
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                byte id = rs.getByte(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                byte quantity = rs.getByte(4);
                String color = rs.getString(5);
                String category = rs.getString(6);
                byte category_id = rs.getByte(7);
                list.add(new Product(id, name, price, quantity, color, category, category_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insert(Product product) {
        String query = "INSERT INTO product (`name`,`price`,`quantity`,`color`,`category_id`)VALUES (?,?,?,?,?)";
        boolean rowUpdate = false;
        try (Connection con = DBConnector.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setByte(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setByte(5, product.getCategory_id());
            rowUpdate = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean update(Product product) {
        String query = "CALL edit(?,?,?,?,?,?)";
        boolean rowUpdate = false;
        try (Connection con = DBConnector.getConnection();
             CallableStatement call = con.prepareCall(query)) {
            call.setString(1, product.getName());
            call.setFloat(2, product.getPrice());
            call.setByte(3, product.getQuantity());
            call.setString(4, product.getColor());
            call.setByte(5, product.getCategory_id());
            call.setInt(6, product.getId());
            rowUpdate = call.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM product WHERE (id = ?);";
        boolean rowDelete = false;
        try (Connection con = DBConnector.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public Product getById(byte id) {
        String query = "CALL getid(?)";
        Product product = null;
        try (Connection con = DBConnector.getConnection();
             CallableStatement call = con.prepareCall(query)) {
            call.setByte(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                byte ID = rs.getByte("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                byte quantity = rs.getByte("quantity");
                String color = rs.getString("color");
                byte categoryid = rs.getByte("category_id");
                product = new Product(ID, name, price, quantity, color, categoryid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list1 = new ArrayList<>();
        try (Connection con = DBConnector.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                byte id1 = rs.getByte(1);
                String name1 = rs.getString(2);
                float price1 = rs.getFloat(3);
                byte quantity1 = rs.getByte(4);
                String color1 = rs.getString(5);
                String category1 = rs.getString(6);
                byte categoryid1 = rs.getByte(7);
                list1.add(new Product(id1,name1,price1,quantity1,color1,category1,categoryid1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list1;
    }

}

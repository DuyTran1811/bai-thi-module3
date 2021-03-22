package sevice;

import mode.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    @Override
    public List<Category> getAll() {
        String query = "SELECT * FROM category";
        List<Category> list = new ArrayList<>();
        try (Connection con = DBConnector.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                byte id = rs.getByte(1);
                String name = rs.getString(2);
                list.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insert(Category category) {
        boolean rowInsert = false;
        String query = "INSERT INTO category (`name`) VALUES (?)";
        try (Connection con = DBConnector.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, category.getName());
            rowInsert = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category getById(byte id) {
        return null;
    }

    @Override
    public List<Category> search(String name) {
        return null;
    }

}

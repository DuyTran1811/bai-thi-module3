package sevice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String Url = "jdbc:mysql://localhost:3306/bt";
    private static final String UserName = "root";
    private static final String UserPassword = "duytran12";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,UserName,UserPassword);
            System.out.println("Kết Nối Thành Công");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Kết Nối Không Thành Công");
        }
        return con;
    }
}

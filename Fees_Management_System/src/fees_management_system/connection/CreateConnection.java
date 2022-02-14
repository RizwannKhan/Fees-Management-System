package fees_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/fees_management_system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connected...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }
        return con;
    }

//    public static void main(String[] args) {
//        getConnection();
//    }

}

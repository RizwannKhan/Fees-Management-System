package fees_management_system.connection;

import fees_management_system.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserDao {

    private static Connection con;

    public static boolean createUser(User user) {
        boolean status = false;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = format.format(user.getDob());
        System.out.println("D O B : " + date);

        try {
            con = CreateConnection.getConnection();
            System.out.println("Connected to DB successful...");
            String query = "insert into signup(firstname, lastname, username, password, dob, contact) values(?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, date);
            stmt.setString(6, user.getContact());
            System.out.println("Query : " + stmt);
            stmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }
        return status;
    }

    public static User userVarification(String username, String password) {
        User user = null;
        try {
            con = CreateConnection.getConnection();
            System.out.println("Connected to DB successful...");
            String query = "select * from signup where username='" + username + "' and password='" + password + "'";

            Statement stmt = con.createStatement();
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                Date dob = rs.getDate(5);
                String contact = rs.getString(6);
                user = new User(id, fname, lname, username, password, dob, contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }
        return user;
    }

}

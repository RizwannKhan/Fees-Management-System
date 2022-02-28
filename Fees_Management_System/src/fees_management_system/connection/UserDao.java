package fees_management_system.connection;

import fees_management_system.entity.User;
import fees_management_system.helper.PasswordEncoder;
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

    public static User userVarification(String username, String password) throws Exception {
        User user = null;
        String encryptPassword = PasswordEncoder.encrypt(password);
        try {
            con = CreateConnection.getConnection();
            System.out.println("Connected to DB successful...");
            String query = "select * from signup where username='" + username + "' and password='" + encryptPassword + "'";

            Statement stmt = con.createStatement();
            System.out.println("Query : " + query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String dob = rs.getString("dob");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
                String contact = rs.getString(7);
                //String encryptPass = rs.getString("password");
                //encryptPass = PasswordEncoder.decrypt(encryptPassword);
                user = new User(id, fname, lname, username, password, date, contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }
        return user;
    }

}

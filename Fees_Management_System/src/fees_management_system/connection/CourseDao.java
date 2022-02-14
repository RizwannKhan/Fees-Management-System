package fees_management_system.connection;

import fees_management_system.entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rijwank
 */
public class CourseDao {

    public static List<Course> getCourses() {
        List<Course> course = new ArrayList<>();
        Connection con = null;

        try {
            con = CreateConnection.getConnection();
            String query = "select * from course";
            Statement stmt = con.createStatement();
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String cname = rs.getString(2);
                String cost = rs.getString(3);
                course.add(new Course(id, cname, cost));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }

        return course;
    }

    public static String courseCost(String course) {
        String cost = null;
        Connection con = null;
        try {
            con = CreateConnection.getConnection();
            String query = "select cost from course where cName=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, course);
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                cost = rs.getString("cost");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message : " + e.getMessage());
        }
        return cost;
    }

}

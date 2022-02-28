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

    private static PreparedStatement stmt;
    private static Connection con = null;

    public static boolean addCourse(Course course) {
        boolean add = false;
        try {
            con = CreateConnection.getConnection();
            String query = "insert into course(cName, cost) values(?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, course.getcName());
            stmt.setString(2, course.getCost());
            System.out.println("Query : " + stmt);
            stmt.executeUpdate();
            add = true;
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return add;
    }

    public static List<Course> getCourses() {
        List<Course> course = new ArrayList<>();
        try {
            con = CreateConnection.getConnection();
            String query = "select * from course";
            Statement stmt = con.createStatement();
            System.out.println("Query : " + query);
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

    public static boolean updateCourse(Course course) {
        boolean status = false;
        try {
            con = CreateConnection.getConnection();
            String q = "update course set cName=?, cost=? where id=?";
            stmt = con.prepareStatement(q);
            stmt.setString(1, course.getcName());
            stmt.setString(2, course.getCost());
            stmt.setInt(3, course.getId());
            System.out.println("Query : " + stmt);
            stmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return status;
    }

    public static boolean deleteCourse(int id) {
        boolean status = false;
        try {
            con = CreateConnection.getConnection();
            String q = "delete from course where id=?";
            stmt = con.prepareStatement(q);
            stmt.setInt(1, id);
            System.out.println("Query : " + stmt);
            stmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return status;
    }

}

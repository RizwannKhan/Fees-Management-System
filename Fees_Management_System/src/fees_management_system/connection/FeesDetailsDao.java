package fees_management_system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fees_management_system.entity.FeesDetails;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Rijwank
 */
public class FeesDetailsDao {

    public static int getReceiptNo() {
        Connection con = null;
        Integer receipt_no = 0;
        try {
            con = CreateConnection.getConnection();
            String q = "select max(receipt_no) from fees_details";
            PreparedStatement stmt = con.prepareStatement(q);
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                receipt_no = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return receipt_no + 1;
    }

    public static boolean insertFeesDetails(FeesDetails details) {
        boolean status = false;
        Connection con = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = format.format(details.getDate());

        try {
            con = CreateConnection.getConnection();
            String q = "insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(q);
            stmt.setInt(1, details.getReceiptNo());
            stmt.setString(2, details.getStudentName());
            stmt.setString(3, details.getRollNo());
            stmt.setString(4, details.getPaymentMode());
            stmt.setString(5, details.getChequeNo());
            stmt.setString(6, details.getBankName());
            stmt.setString(7, details.getDdNo());
            stmt.setString(8, details.getCourseName());
            stmt.setString(9, details.getGstin());
            stmt.setFloat(10, details.getTotalAmount());
            stmt.setString(11, date);
            stmt.setFloat(12, details.getAmount());
            stmt.setFloat(13, details.getCgst());
            stmt.setFloat(14, details.getSgst());
            stmt.setString(15, details.getTotalInWords());
            stmt.setString(16, details.getRemark());
            stmt.setInt(17, details.getYear1());
            stmt.setInt(18, details.getYear2());
            System.out.println("Query : " + stmt);

            int rowCount = stmt.executeUpdate();

            if (rowCount == 1) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }

    public static boolean updateFeesDetails(FeesDetails details) {
        boolean status = false;
        Connection con = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = format.format(details.getDate());

        try {
            con = CreateConnection.getConnection();
            String q = "update fees_details SET student_name=?, roll_no=?, payment_mode=?,"
                    + "cheque_no=?, bank_name=?, dd_no=?, course_name=?, gstin=?, total_amount=?, date=?,"
                    + "amount=?, cgst=?, sgst=?, total_in_words=?, remark=?, year1=?, year2=? where receipt_no=?";
            PreparedStatement stmt = con.prepareStatement(q);

            stmt.setString(1, details.getStudentName());
            stmt.setString(2, details.getRollNo());
            stmt.setString(3, details.getPaymentMode());
            stmt.setString(4, details.getChequeNo());
            stmt.setString(5, details.getBankName());
            stmt.setString(6, details.getDdNo());
            stmt.setString(7, details.getCourseName());
            stmt.setString(8, details.getGstin());
            stmt.setFloat(9, details.getTotalAmount());
            stmt.setString(10, date);
            stmt.setFloat(11, details.getAmount());
            stmt.setFloat(12, details.getCgst());
            stmt.setFloat(13, details.getSgst());
            stmt.setString(14, details.getTotalInWords());
            stmt.setString(15, details.getRemark());
            stmt.setInt(16, details.getYear1());
            stmt.setInt(17, details.getYear2());
            stmt.setInt(18, details.getReceiptNo());
            System.out.println("Query : " + stmt);

            int rowCount = stmt.executeUpdate();

            if (rowCount == 1) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }

    public static List<FeesDetails> getFeeDetails() {
        List<FeesDetails> details = new ArrayList<>();
        Connection con = null;
        try {
            con = CreateConnection.getConnection();
            String sql = "select * from fees_details";
            PreparedStatement stmt = con.prepareStatement(sql);
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int receipt = rs.getInt("receipt_no");
                String name = rs.getString("student_name");
                String rollNo = rs.getString("roll_no");
                String paymentMode = rs.getString("payment_mode");
                String course = rs.getString("course_name");
                Float totalAmount = rs.getFloat("total_amount");
                String remark = rs.getString("remark");
                details.add(new FeesDetails(receipt, rollNo, name, course, paymentMode, totalAmount, remark));
            }
        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return details;
    }

    public static List<FeesDetails> getFeeDetailsInRange(String courseName, String fromDate, String toDate) {
        List<FeesDetails> details = new ArrayList<>();
        Connection con = null;
        Float amount = 0F;
        try {
            con = CreateConnection.getConnection();
            String sql = "select * from fees_details where date between ? and ? and course_name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fromDate);
            stmt.setString(2, toDate);
            stmt.setString(3, courseName);
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int receiptNo = rs.getInt("receipt_no");
                String name = rs.getString("student_name");
                String rollNo = rs.getString("roll_no");
                String paymentMode = rs.getString("payment_mode");
                String course = rs.getString("course_name");
                Float totalAmount = rs.getFloat("total_amount");
                String remark = rs.getString("remark");
                //amount += totalAmount;
                details.add(new FeesDetails(receiptNo, rollNo, name, course, paymentMode, totalAmount, remark));
            }
        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return details;
    }

}

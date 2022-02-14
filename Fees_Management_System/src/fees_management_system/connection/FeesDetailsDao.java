package fees_management_system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fees_management_system.entity.FeesDetails;
import java.text.SimpleDateFormat;
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
            e.printStackTrace();
        }
        return status;
    }

}

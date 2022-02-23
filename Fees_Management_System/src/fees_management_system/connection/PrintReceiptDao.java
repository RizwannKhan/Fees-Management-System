package fees_management_system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import fees_management_system.entity.FeesDetails;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Rijwank
 */
public class PrintReceiptDao {

    private static Connection con = null;
    private static PreparedStatement stmt;

    public static FeesDetails getRecords() {
        FeesDetails record = null;
        try {
            con = CreateConnection.getConnection();
            String sql = "select * from fees_details order by receipt_no desc limit 1";
            stmt = con.prepareStatement(sql);
            System.out.println("Query : " + stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int receipt = rs.getInt(1);
                String name = rs.getString(2);
                String rollNo = rs.getString(3);
                String paymentMode = rs.getString(4);
                String cheque = rs.getString(5);
                String bank = rs.getString(6);
                String dd = rs.getString(7);
                String course = rs.getString(8);
                String gst = rs.getString("gstin");
                Float total = rs.getFloat("total_amount");
                String date = rs.getString("date");
                Date dt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date);
                Float amount = rs.getFloat("amount");
                Float cgst = rs.getFloat("cgst");
                Float sgst = rs.getFloat("sgst");
                String totalWords = rs.getString("total_in_words");
                String remark = rs.getString("remark");
                int yearFrom = rs.getInt("year1");
                int yearTo = rs.getInt("year2");
                record = new FeesDetails(receipt, paymentMode, dt, name, rollNo, cheque, bank, dd, course, gst, amount, total, cgst, sgst, totalWords, remark, yearFrom, yearTo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

}

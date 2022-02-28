package fees_management_system.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Rijwank
 */
public class TableToExcelConvert {

    public static boolean exportToExcel(TreeMap<String, Object[]> map, String path, JTable tbl_feeDetail) {
        boolean st = false;
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet();
        Set<String> id = map.keySet();
        XSSFRow row;
        Row rowCol = sheet.createRow(0);
        for (int i = 0; i < tbl_feeDetail.getColumnCount(); i++) {
            Cell cell = rowCol.createCell(i);
            cell.setCellValue(tbl_feeDetail.getColumnName(i));
        }
        int rowId = 0;
        for (String key : id) {
            row = sheet.createRow(rowId + 1);
            Object[] value = map.get(key);
            int cellId = 0;
            for (Object v : value) {
                XSSFCell cell = row.createCell(cellId);
                cell.setCellValue(v.toString());
                cellId++;
            }
            rowId++;
        }

        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            workBook.write(fos);
            st = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

}

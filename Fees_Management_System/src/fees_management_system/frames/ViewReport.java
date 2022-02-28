package fees_management_system.frames;

import fees_management_system.connection.CourseDao;
import fees_management_system.connection.FeesDetailsDao;
import fees_management_system.entity.Course;
import fees_management_system.entity.FeesDetails;
import fees_management_system.helper.TableToExcelConvert;
import fees_management_system.helper.NumberToWordsConverter;
import java.awt.Color;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * @author Rijwank
 */
public class ViewReport extends javax.swing.JFrame {

    DefaultTableModel model;
    TableToExcelConvert dateLabelFormatter;
    Float totalAmount = 0.0F, amount = 0F;
    String courseName, amountInWords;
    String[] colName = {"Receipt No", "Student Name", "Roll No", "Course", "Amount", "Remark"};

    public ViewReport() {
        initComponents();
        courseComboBox();
    }

    public void courseComboBox() {
        List<Course> course = CourseDao.getCourses();
        List<Course> sortedList = course.stream()
                .sorted(Comparator.comparing(fees_management_system.entity.Course::getcName))
                .collect(Collectors.toList());

        for (fees_management_system.entity.Course c : sortedList) {
            combo_course.addItem(c.getcName());
        }
    }

    public void setRecordsToTable() {
        String cName = combo_course.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fromDate = dateFormat.format(date_from.getDate());
        String toDate = dateFormat.format(date_to.getDate());

        List<FeesDetails> details = FeesDetailsDao.getFeeDetailsInRange(cName, fromDate, toDate);
        for (FeesDetails amt : details) {
            totalAmount += amt.getTotalAmount();
        }

        Object[][] data = new Object[details.size()][6];

        int i = 0;
        for (FeesDetails detail : details) {
            data[i][0] = detail.getReceiptNo();
            data[i][1] = detail.getStudentName();
            data[i][2] = detail.getRollNo();
            data[i][3] = detail.getCourseName();
            data[i][4] = detail.getTotalAmount();
            data[i][5] = detail.getRemark();
            i++;
            courseName = detail.getCourseName();
            //amount += detail.getTotalAmount();

        }
        //totalAmount = totalAmount + amount;
        amountInWords = NumberToWordsConverter.convert(totalAmount.intValue());
        lbl_course.setText(courseName);
        lbl_totalAmount.setText(totalAmount.toString());
        lbl_totalInWords.setText(amountInWords + " Rupees Only");

        //model.setRowCount(data.length + 1);
        model = new DefaultTableModel(data, colName);
        tbl_feesDetails.setModel(model);
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_feesDetails.getModel();
        model.setRowCount(1);
    }

    public void exportToExcel() {
        TreeMap<String, Object[]> map = new TreeMap<>();
        model = (DefaultTableModel) tbl_feesDetails.getModel();
        map.put("0", new Object[]{model.getColumnName(0), model.getColumnName(1),
            model.getColumnName(2), model.getColumnName(3),
            model.getColumnName(4), model.getColumnName(5)});

        for (int i = 0; i < model.getRowCount(); i++) {
            map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),
                model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3),
                model.getValueAt(i, 4), model.getValueAt(i, 5)});
        }

        String path = tf_filePath.getText();
        boolean status = TableToExcelConvert.exportToExcel(map, path, tbl_feesDetails);
        if (status) {
            JOptionPane.showMessageDialog(this, "File exported successfully at " + path);
        } else {
            JOptionPane.showMessageDialog(this, "File export failed");
        }

        /*for (Map.Entry<String, Object[]> entry : map.entrySet()) {
            String key = entry.getKey();
            Object[] value = entry.getValue();
            System.out.println(Arrays.toString(value));
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_search = new javax.swing.JPanel();
        btn_search = new javax.swing.JLabel();
        pnl_home = new javax.swing.JPanel();
        btn_home = new javax.swing.JLabel();
        pnl_edit_course = new javax.swing.JPanel();
        btn_editCourse = new javax.swing.JLabel();
        pnl_courses = new javax.swing.JPanel();
        btn_courses = new javax.swing.JLabel();
        pnl_viewAllRecords = new javax.swing.JPanel();
        btn_viewAllRecords = new javax.swing.JLabel();
        pnl_back = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        date_to = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date_from = new com.toedter.calendar.JDateChooser();
        btn_browse = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        tf_filePath = new javax.swing.JTextField();
        btn_exportToExcel = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_feesDetails = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_totalInWords = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_totalAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees Management System - View Report");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_search.setBackground(new java.awt.Color(0, 153, 153));
        pnl_search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(204, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/search2.png"))); // NOI18N
        btn_search.setText("SEARCH RECORD");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
        });
        pnl_search.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 70));

        jPanel1.add(pnl_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 250, 70));

        pnl_home.setBackground(new java.awt.Color(0, 153, 153));
        pnl_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(204, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/home.png"))); // NOI18N
        btn_home.setText("   HOME");
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        pnl_home.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 50));

        jPanel1.add(pnl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 70));

        pnl_edit_course.setBackground(new java.awt.Color(0, 153, 153));
        pnl_edit_course.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_edit_course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_editCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_editCourse.setForeground(new java.awt.Color(204, 255, 255));
        btn_editCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/edit2.png"))); // NOI18N
        btn_editCourse.setText(" EDIT COURSE");
        btn_editCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editCourseMouseExited(evt);
            }
        });
        pnl_edit_course.add(btn_editCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 50));

        jPanel1.add(pnl_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 70));

        pnl_courses.setBackground(new java.awt.Color(0, 153, 153));
        pnl_courses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_courses.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_courses.setForeground(new java.awt.Color(204, 255, 255));
        btn_courses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/list.png"))); // NOI18N
        btn_courses.setText("COURSES");
        btn_courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_coursesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_coursesMouseExited(evt);
            }
        });
        pnl_courses.add(btn_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 50));

        jPanel1.add(pnl_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 250, 70));

        pnl_viewAllRecords.setBackground(new java.awt.Color(0, 153, 153));
        pnl_viewAllRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_viewAllRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_viewAllRecords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_viewAllRecords.setForeground(new java.awt.Color(204, 255, 255));
        btn_viewAllRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/view all record.png"))); // NOI18N
        btn_viewAllRecords.setText("VIEW RECORDS");
        btn_viewAllRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewAllRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewAllRecordsMouseExited(evt);
            }
        });
        pnl_viewAllRecords.add(btn_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        jPanel1.add(pnl_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 250, 70));

        pnl_back.setBackground(new java.awt.Color(0, 153, 153));
        pnl_back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(204, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/left-arrow.png"))); // NOI18N
        btn_back.setText("BACK");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });
        pnl_back.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 50));

        jPanel1.add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 250, 70));

        pnl_logout.setBackground(new java.awt.Color(0, 153, 153));
        pnl_logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(204, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/logout.png"))); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        pnl_logout.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        jPanel1.add(pnl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 250, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/list_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Report");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 110, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 180, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 660));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("To");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 20, 20));

        combo_course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel2.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Select Course :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 20));

        date_to.setDateFormatString("dd-MM-yyyy");
        date_to.setNextFocusableComponent(btn_submit);
        jPanel2.add(date_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Select Date :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("From");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 40, 20));

        date_from.setDateFormatString("dd-MM-yyyy");
        date_from.setNextFocusableComponent(date_to);
        date_from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_fromPropertyChange(evt);
            }
        });
        jPanel2.add(date_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, -1));

        btn_browse.setBackground(new java.awt.Color(0, 153, 153));
        btn_browse.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_browse.setForeground(new java.awt.Color(204, 255, 255));
        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });
        jPanel2.add(btn_browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 90, -1));

        btn_submit.setBackground(new java.awt.Color(0, 153, 153));
        btn_submit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(204, 255, 255));
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        tf_filePath.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel2.add(tf_filePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 220, 30));

        btn_exportToExcel.setBackground(new java.awt.Color(0, 153, 153));
        btn_exportToExcel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_exportToExcel.setForeground(new java.awt.Color(204, 255, 255));
        btn_exportToExcel.setText("Export to Excel");
        btn_exportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportToExcelActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exportToExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 140, -1));

        btn_print.setBackground(new java.awt.Color(0, 153, 153));
        btn_print.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_print.setForeground(new java.awt.Color(204, 255, 255));
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 80, -1));

        tbl_feesDetails.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbl_feesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No", "Student Name", "Roll No", "Course", "Amount", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_feesDetails);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 950, -1));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Total Amount In Words : ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lbl_totalInWords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(lbl_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 420, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Total Amount Collected : ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Course Selected : ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        lbl_totalAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(lbl_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 460, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 990, 660));

        setSize(new java.awt.Dimension(1296, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchMouseExited

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_editCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCourseMouseClicked
        EditCourse edit = new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_editCourseMouseClicked

    private void btn_editCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCourseMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_edit_course.setBackground(clr);
    }//GEN-LAST:event_btn_editCourseMouseEntered

    private void btn_editCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCourseMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_edit_course.setBackground(clr);
    }//GEN-LAST:event_btn_editCourseMouseExited

    private void btn_coursesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_coursesMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_courses.setBackground(clr);
    }//GEN-LAST:event_btn_coursesMouseEntered

    private void btn_coursesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_coursesMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_courses.setBackground(clr);
    }//GEN-LAST:event_btn_coursesMouseExited

    private void btn_viewAllRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewAllRecordsMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_viewAllRecords.setBackground(clr);
    }//GEN-LAST:event_btn_viewAllRecordsMouseEntered

    private void btn_viewAllRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewAllRecordsMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_viewAllRecords.setBackground(clr);
    }//GEN-LAST:event_btn_viewAllRecordsMouseExited

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_back.setBackground(clr);
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_back.setBackground(clr);
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        try {
            File f = file.getSelectedFile();
            String path = f.getAbsolutePath();
            path = path + "_" + date + ".xlsx";
            tf_filePath.setText(path);
        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_exportToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportToExcelActionPerformed
        exportToExcel();
    }//GEN-LAST:event_btn_exportToExcelActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fromDate = dateFormat.format(date_from.getDate());
        String toDate = dateFormat.format(date_to.getDate());

        MessageFormat header = new MessageFormat("Report From " + fromDate + " To " + toDate);
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {
            tbl_feesDetails.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            System.err.println("Error " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        String course = combo_course.getSelectedItem().toString();
    }//GEN-LAST:event_combo_courseActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        clearTable();
        totalAmount = 0.0F;
        amountInWords = "";
        lbl_totalAmount.setText("");
        lbl_totalInWords.setText("");
        setRecordsToTable();
    }//GEN-LAST:event_btn_submitActionPerformed

    private void date_fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_fromPropertyChange

    }//GEN-LAST:event_date_fromPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JButton btn_browse;
    private javax.swing.JLabel btn_courses;
    private javax.swing.JLabel btn_editCourse;
    private javax.swing.JButton btn_exportToExcel;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel btn_search;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel btn_viewAllRecords;
    private javax.swing.JComboBox<String> combo_course;
    private com.toedter.calendar.JDateChooser date_from;
    private com.toedter.calendar.JDateChooser date_to;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_totalAmount;
    private javax.swing.JLabel lbl_totalInWords;
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_courses;
    private javax.swing.JPanel pnl_edit_course;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_viewAllRecords;
    private javax.swing.JTable tbl_feesDetails;
    private javax.swing.JTextField tf_filePath;
    // End of variables declaration//GEN-END:variables
}

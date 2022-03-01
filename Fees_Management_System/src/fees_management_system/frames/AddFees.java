package fees_management_system.frames;

import fees_management_system.connection.CourseDao;
import fees_management_system.connection.FeesDetailsDao;
import fees_management_system.entity.Course;
import fees_management_system.entity.FeesDetails;
import fees_management_system.helper.NumberToWordsConverter;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Rijwank
 */
public class AddFees extends javax.swing.JFrame {

    Float amount, cgst, sgst;
    float totalAmount;
    Integer receipt_no;

    public AddFees() {
        initComponents();
        displayCashFirst();
        courseComboBox();

        receipt_no = FeesDetailsDao.getReceiptNo();
        tf_recieptNo.setText(receipt_no.toString());

        tf_date.setDate(new Date());
    }

    public void displayCashFirst() {
        lbl_ddNo.setVisible(false);
        lbl_checkNo.setVisible(false);
        lbl_bank.setVisible(false);

        tf_ddNo.setVisible(false);
        tf_checkNo.setVisible(false);
        tf_bank.setVisible(false);
    }

    public boolean validation() {
        if (tf_date.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select date");
            return false;
        }
        if (combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("Cheque")) {
            if (tf_checkNo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter cheque no");
                return false;
            }
            if (tf_bank.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        if (combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("DD")) {
            if (tf_ddNo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter DD no");
                return false;
            }
            if (tf_bank.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        if (combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("Card")) {
            if (tf_bank.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        if (tf_receiveFrom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter reciever's name");
            return false;
        }
        if (tf_amount.getText().equals("") | tf_amount.getText().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Please enter valid amount");
            return false;
        }
        return true;
    }

    public void courseComboBox() {
        List<Course> course = CourseDao.getCourses();
        List<Course> sortedList = course.stream().sorted(Comparator.comparing(Course::getcName)).collect(Collectors.toList());

        for (Course c : sortedList) {
            combo_courses.addItem(c.getcName());
        }
    }

    public boolean insertData() {
        boolean status = false;
        int receiptNo = Integer.parseInt(tf_recieptNo.getText());
        String sName = tf_receiveFrom.getText();
        String rollNo = tf_rollNo.getText();
        String paymentMode = combo_paymentMode.getSelectedItem().toString();
        String chequeNo = tf_checkNo.getText();
        String bankName = tf_bank.getText();
        String ddNo = tf_ddNo.getText();
        String course = combo_courses.getSelectedItem().toString();
        String gst = lbl_gstNo.getText();
        float total = Float.parseFloat(tf_totalAmount.getText());
        float amount = Float.parseFloat(tf_amount.getText());
        Date date = tf_date.getDate();
        float cgst = Float.parseFloat(tf_cgst.getText());
        float sgst = Float.parseFloat(tf_sgst.getText());
        String totalInWords = tf_totalInWords.getText();
        String remark = ta_remark.getText();
        int year1 = Integer.parseInt(tf_yearFrom.getText());
        int year2 = Integer.parseInt(tf_yearTo.getText());

        FeesDetails details = new FeesDetails(receiptNo, paymentMode, date, sName, rollNo, chequeNo, bankName, ddNo, course, gst, amount, total, cgst, sgst, totalInWords, remark, year1, year2);
        status = FeesDetailsDao.insertFeesDetails(details);

        return status;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("fees_management_system?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        //courseQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Course c");
        //courseList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : courseQuery.getResultList();
        pnl_sidebar = new javax.swing.JPanel();
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
        pnl_parent = new javax.swing.JPanel();
        lbl_checkNo = new javax.swing.JLabel();
        tf_ddNo = new javax.swing.JTextField();
        lbl_gstNo = new javax.swing.JLabel();
        tf_date = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        lbl_ddNo = new javax.swing.JLabel();
        lbl_paymentMode = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_gst = new javax.swing.JLabel();
        tf_recieptNo = new javax.swing.JTextField();
        tf_checkNo = new javax.swing.JTextField();
        lbl_bank = new javax.swing.JLabel();
        pnl_child = new javax.swing.JPanel();
        lbl_rollNo = new javax.swing.JLabel();
        lbl_yearTo = new javax.swing.JLabel();
        lbl_paymentYear = new javax.swing.JLabel();
        tf_yearTo = new javax.swing.JTextField();
        lbl_receiveFrom = new javax.swing.JLabel();
        tf_totalInWords = new javax.swing.JTextField();
        combo_courses = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_remark = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_yearFrom = new javax.swing.JTextField();
        tf_head = new javax.swing.JTextField();
        tf_amount = new javax.swing.JTextField();
        tf_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        tf_sgst = new javax.swing.JTextField();
        tf_totalAmount = new javax.swing.JTextField();
        lbl_course = new javax.swing.JLabel();
        lbl_signature = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_remark = new javax.swing.JTextArea();
        lbl_totalAmount = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btn_print = new javax.swing.JButton();
        lbl_totalInWords = new javax.swing.JLabel();
        lbl_cgst = new javax.swing.JLabel();
        lbl_sgst = new javax.swing.JLabel();
        tf_receiveFrom = new javax.swing.JTextField();
        tf_rollNo = new javax.swing.JTextField();
        combo_paymentMode = new javax.swing.JComboBox<>();
        tf_bank = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees Management System - Add Fees");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_sidebar.setBackground(new java.awt.Color(0, 102, 102));
        pnl_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_search.setBackground(new java.awt.Color(0, 153, 153));
        pnl_search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(204, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/search2.png"))); // NOI18N
        btn_search.setText("SEARCH RECORD");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
        });
        pnl_search.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 70));

        pnl_sidebar.add(pnl_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 70));

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

        pnl_sidebar.add(pnl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 70));

        pnl_edit_course.setBackground(new java.awt.Color(0, 153, 153));
        pnl_edit_course.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_edit_course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_editCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_editCourse.setForeground(new java.awt.Color(204, 255, 255));
        btn_editCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/edit2.png"))); // NOI18N
        btn_editCourse.setText(" EDIT COURSE");
        btn_editCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editCourseMouseExited(evt);
            }
        });
        pnl_edit_course.add(btn_editCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 50));

        pnl_sidebar.add(pnl_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, 70));

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

        pnl_sidebar.add(pnl_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, 70));

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

        pnl_sidebar.add(pnl_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 250, 70));

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

        pnl_sidebar.add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 250, 70));

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

        pnl_sidebar.add(pnl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 250, 70));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 660));

        pnl_parent.setBackground(new java.awt.Color(0, 153, 153));
        pnl_parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_checkNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_checkNo.setText("Cheque No:");
        pnl_parent.add(lbl_checkNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));

        tf_ddNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ddNoActionPerformed(evt);
            }
        });
        pnl_parent.add(tf_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 170, -1));

        lbl_gstNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gstNo.setText("22HVSJG55A");
        pnl_parent.add(lbl_gstNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        tf_date.setDateFormatString("dd/MM/yyyy");
        pnl_parent.add(tf_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Receipt no:  JPR - ");
        pnl_parent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lbl_ddNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_ddNo.setText("DD No:");
        pnl_parent.add(lbl_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_paymentMode.setText("Mode of Payment:");
        pnl_parent.add(lbl_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_date.setText("Date : ");
        pnl_parent.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        lbl_gst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gst.setText("GSTIN : ");
        pnl_parent.add(lbl_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        tf_recieptNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_recieptNoActionPerformed(evt);
            }
        });
        pnl_parent.add(tf_recieptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 90, -1));

        tf_checkNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_checkNoActionPerformed(evt);
            }
        });
        pnl_parent.add(tf_checkNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, -1));

        lbl_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_bank.setText("Bank Name:");
        pnl_parent.add(lbl_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        pnl_child.setBackground(new java.awt.Color(0, 153, 153));
        pnl_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_rollNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rollNo.setText("Roll No :");
        pnl_child.add(lbl_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 60, -1));

        lbl_yearTo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_yearTo.setText("to");
        pnl_child.add(lbl_yearTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        lbl_paymentYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_paymentYear.setText("Payment for the Year :");
        pnl_child.add(lbl_paymentYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        tf_yearTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_yearToActionPerformed(evt);
            }
        });
        pnl_child.add(tf_yearTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        lbl_receiveFrom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_receiveFrom.setText("Recieved From :");
        pnl_child.add(lbl_receiveFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tf_totalInWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_totalInWordsActionPerformed(evt);
            }
        });
        pnl_child.add(tf_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 350, -1));

        combo_courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_coursesActionPerformed(evt);
            }
        });
        pnl_child.add(combo_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Amount ");
        pnl_child.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));
        pnl_child.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 820, 30));
        pnl_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 820, 30));

        lbl_remark.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_remark.setText("Remark :");
        pnl_child.add(lbl_remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Sr No:");
        pnl_child.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Head");
        pnl_child.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        tf_yearFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_yearFromActionPerformed(evt);
            }
        });
        pnl_child.add(tf_yearFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 90, -1));

        tf_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_headActionPerformed(evt);
            }
        });
        pnl_child.add(tf_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 360, -1));

        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });
        pnl_child.add(tf_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 190, -1));

        tf_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cgstActionPerformed(evt);
            }
        });
        pnl_child.add(tf_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 190, -1));
        pnl_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 240, 20));

        tf_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sgstActionPerformed(evt);
            }
        });
        pnl_child.add(tf_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 190, -1));

        tf_totalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_totalAmountActionPerformed(evt);
            }
        });
        pnl_child.add(tf_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 190, -1));

        lbl_course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_course.setText("Course :");
        pnl_child.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lbl_signature.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_signature.setText("Reciever's Signature");
        pnl_child.add(lbl_signature, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        ta_remark.setColumns(20);
        ta_remark.setRows(5);
        jScrollPane1.setViewportView(ta_remark);

        pnl_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 350, 70));

        lbl_totalAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_totalAmount.setText("Total Amount : ");
        pnl_child.add(lbl_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));
        pnl_child.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 280, 10));

        btn_print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pnl_child.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 90, -1));

        lbl_totalInWords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_totalInWords.setText("Total in words :");
        pnl_child.add(lbl_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lbl_cgst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_cgst.setText("CGST 9% : ");
        pnl_child.add(lbl_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        lbl_sgst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_sgst.setText("SGST 9% : ");
        pnl_child.add(lbl_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        tf_receiveFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receiveFromActionPerformed(evt);
            }
        });
        pnl_child.add(tf_receiveFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, -1));

        tf_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rollNoActionPerformed(evt);
            }
        });
        pnl_child.add(tf_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 150, -1));

        pnl_parent.add(pnl_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 860, 550));

        combo_paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Card", "Cash" }));
        combo_paymentMode.setSelectedIndex(3);
        combo_paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentModeActionPerformed(evt);
            }
        });
        pnl_parent.add(combo_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 110, -1));

        tf_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bankActionPerformed(evt);
            }
        });
        pnl_parent.add(tf_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 190, -1));

        getContentPane().add(pnl_parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 860, 660));

        setSize(new java.awt.Dimension(1179, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchMouseExited

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

    private void tf_ddNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ddNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ddNoActionPerformed

    private void tf_recieptNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_recieptNoActionPerformed
        tf_recieptNo.setText(receipt_no.toString());
    }//GEN-LAST:event_tf_recieptNoActionPerformed

    private void tf_receiveFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receiveFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_receiveFromActionPerformed

    private void tf_checkNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_checkNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_checkNoActionPerformed

    private void combo_coursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_coursesActionPerformed
        String course = combo_courses.getSelectedItem().toString();
        tf_head.setText(course);

        String cost = CourseDao.courseCost(course);
        tf_amount.setText(cost);

        amount = Float.parseFloat(tf_amount.getText());

        cgst = (amount * 0.09f);
        tf_cgst.setText(cgst.toString());

        sgst = (amount * 0.09f);
        tf_sgst.setText(sgst.toString());

        totalAmount = amount + cgst + sgst;
        tf_totalAmount.setText(Float.toString(totalAmount));

        String totalInWords = NumberToWordsConverter.convert((int) totalAmount);
        tf_totalInWords.setText(totalInWords + " Only");
    }//GEN-LAST:event_combo_coursesActionPerformed

    private void tf_yearToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_yearToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_yearToActionPerformed

    private void tf_totalInWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_totalInWordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_totalInWordsActionPerformed

    private void combo_paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentModeActionPerformed
        if (combo_paymentMode.getSelectedIndex() == 0) {
            lbl_ddNo.setVisible(true);
            lbl_checkNo.setVisible(false);
            tf_ddNo.setVisible(true);
            tf_checkNo.setVisible(false);
            lbl_bank.setVisible(true);
            tf_bank.setVisible(true);
        }
        if (combo_paymentMode.getSelectedIndex() == 1) {
            lbl_ddNo.setVisible(false);
            lbl_checkNo.setVisible(true);
            tf_ddNo.setVisible(false);
            tf_checkNo.setVisible(true);
            lbl_bank.setVisible(true);
            tf_bank.setVisible(true);
        }
        if (combo_paymentMode.getSelectedIndex() == 2) {
            lbl_ddNo.setVisible(false);
            lbl_checkNo.setVisible(false);
            tf_ddNo.setVisible(false);
            tf_checkNo.setVisible(false);
            lbl_bank.setVisible(true);
            tf_bank.setVisible(true);
        }
        if (combo_paymentMode.getSelectedIndex() == 3) {
            lbl_ddNo.setVisible(false);
            lbl_checkNo.setVisible(false);
            tf_ddNo.setVisible(false);
            tf_checkNo.setVisible(false);
            lbl_bank.setVisible(false);
            tf_bank.setVisible(false);
        }

    }//GEN-LAST:event_combo_paymentModeActionPerformed

    private void tf_yearFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_yearFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_yearFromActionPerformed

    private void tf_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_headActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_headActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        amount = Float.parseFloat(tf_amount.getText());

        cgst = (amount * 0.09f);
        tf_cgst.setText(cgst.toString());

        sgst = (amount * 0.09f);
        tf_sgst.setText(sgst.toString());

        totalAmount = amount + cgst + sgst;
        tf_totalAmount.setText(Float.toString(totalAmount));

        String totalInWords = NumberToWordsConverter.convert((int) totalAmount);
        tf_totalInWords.setText(totalInWords + " Only");
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cgstActionPerformed

    private void tf_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_sgstActionPerformed

    private void tf_totalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_totalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_totalAmountActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if (validation()) {
            //database code...
            if (insertData()) {
                JOptionPane.showMessageDialog(this, "Details are inserted successfuly");
                PrintReceipt receipt = new PrintReceipt();
                receipt.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong, please try again");
            }
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void tf_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bankActionPerformed

    private void tf_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rollNoActionPerformed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_courses;
    private javax.swing.JLabel btn_editCourse;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_viewAllRecords;
    private javax.swing.JComboBox<String> combo_courses;
    private javax.swing.JComboBox<String> combo_paymentMode;
    //private java.util.List<fees_management_system.helper.Course> courseList;
    //private javax.persistence.Query courseQuery;
    //private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bank;
    private javax.swing.JLabel lbl_cgst;
    private javax.swing.JLabel lbl_checkNo;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_ddNo;
    private javax.swing.JLabel lbl_gst;
    private javax.swing.JLabel lbl_gstNo;
    private javax.swing.JLabel lbl_paymentMode;
    private javax.swing.JLabel lbl_paymentYear;
    private javax.swing.JLabel lbl_receiveFrom;
    private javax.swing.JLabel lbl_remark;
    private javax.swing.JLabel lbl_rollNo;
    private javax.swing.JLabel lbl_sgst;
    private javax.swing.JLabel lbl_signature;
    private javax.swing.JLabel lbl_totalAmount;
    private javax.swing.JLabel lbl_totalInWords;
    private javax.swing.JLabel lbl_yearTo;
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_child;
    private javax.swing.JPanel pnl_courses;
    private javax.swing.JPanel pnl_edit_course;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_parent;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JPanel pnl_viewAllRecords;
    private javax.swing.JTextArea ta_remark;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_bank;
    private javax.swing.JTextField tf_cgst;
    private javax.swing.JTextField tf_checkNo;
    private com.toedter.calendar.JDateChooser tf_date;
    private javax.swing.JTextField tf_ddNo;
    private javax.swing.JTextField tf_head;
    private javax.swing.JTextField tf_receiveFrom;
    private javax.swing.JTextField tf_recieptNo;
    private javax.swing.JTextField tf_rollNo;
    private javax.swing.JTextField tf_sgst;
    private javax.swing.JTextField tf_totalAmount;
    private javax.swing.JTextField tf_totalInWords;
    private javax.swing.JTextField tf_yearFrom;
    private javax.swing.JTextField tf_yearTo;
    // End of variables declaration//GEN-END:variables
}

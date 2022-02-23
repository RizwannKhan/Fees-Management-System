package fees_management_system.frames;

import fees_management_system.connection.PrintReceiptDao;
import fees_management_system.entity.FeesDetails;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Rijwank
 */
public class PrintReceipt extends javax.swing.JFrame {

    public PrintReceipt() {
        initComponents();
        getRecord();
//        Container c = getContentPane();
//        c.setBackground(new Color(0, 153, 153));
    }

    public void getRecord() {
        FeesDetails record = PrintReceiptDao.getRecords();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = format.format(record.getDate());

        String paymentMode = record.getPaymentMode();

        tf_receiptNo.setText(Integer.toString(record.getReceiptNo()));
        tf_date.setText(date);
        tf_paymentMode.setText(record.getPaymentMode());
        tf_receivedFrom.setText(record.getStudentName());

        if (paymentMode.equalsIgnoreCase("cash")) {
            tf_chequeDDNo.setText("");
            tf_chequeDD.setText("");
            tf_bankName.setText("");
        } else if (paymentMode.equalsIgnoreCase("dd")) {
            tf_chequeDDNo.setText("DD No.:");
            tf_chequeDD.setText(record.getDdNo());
            tf_bankName.setText(record.getBankName());
        } else if (paymentMode.equalsIgnoreCase("cheque")) {
            tf_chequeDDNo.setText("Cheque No.:");
            tf_chequeDD.setText(record.getChequeNo());
            tf_bankName.setText(record.getBankName());
        } else if (paymentMode.equalsIgnoreCase("card")) {
            tf_chequeDDNo.setText("");
            tf_chequeDD.setText("");
            tf_bankName.setText(record.getBankName());
        }
        tf_gst.setText(record.getGstin());
        tf_amount.setText(Float.toString(record.getAmount()));
        tf_cgst.setText(Float.toString(record.getCgst()));
        tf_sgst.setText(Float.toString(record.getSgst()));
        tf_totalAmount.setText(Float.toString(record.getTotalAmount()));
        tf_totalInWords.setText(record.getTotalInWords());
        tf_yearFrom.setText(Integer.toString(record.getYear1()));
        tf_yearTo.setText(Integer.toString(record.getYear2()));
        tf_head.setText(record.getCourseName());
        ta_remarks.setText(record.getRemark());
        tf_rollNo.setText(record.getRollNo());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        pnl_edit = new javax.swing.JPanel();
        btn_edit = new javax.swing.JLabel();
        pnl_print = new javax.swing.JPanel();
        btn_print = new javax.swing.JLabel();
        pnl_back = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        pnl_printPage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tf_receiptNo = new javax.swing.JLabel();
        tf_paymentMode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_chequeDD = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_date = new javax.swing.JLabel();
        tf_bankName = new javax.swing.JLabel();
        tf_receivedFrom = new javax.swing.JLabel();
        tf_amount = new javax.swing.JLabel();
        tf_yearFrom = new javax.swing.JLabel();
        tf_yearTo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tf_rollNo = new javax.swing.JLabel();
        tf_chequeDDNo = new javax.swing.JLabel();
        tf_gst = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        tf_head = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tf_totalAmount = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cgst = new javax.swing.JLabel();
        tf_sgst = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tf_cgst = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        sgst1 = new javax.swing.JLabel();
        tf_totalInWords = new javax.swing.JLabel();
        total2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        total4 = new javax.swing.JLabel();
        total5 = new javax.swing.JLabel();
        total6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_remarks = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        pnl_sidebar.add(pnl_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 250, 70));

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

        pnl_sidebar.add(pnl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 70));

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

        pnl_sidebar.add(pnl_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 70));

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

        pnl_sidebar.add(pnl_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 70));

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

        pnl_sidebar.add(pnl_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 250, 70));

        pnl_edit.setBackground(new java.awt.Color(0, 153, 153));
        pnl_edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_edit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(204, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/edit2.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
        });
        pnl_edit.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 60));

        pnl_sidebar.add(pnl_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 250, 70));

        pnl_print.setBackground(new java.awt.Color(0, 153, 153));
        pnl_print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_print.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_print.setForeground(new java.awt.Color(204, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/printer-.png"))); // NOI18N
        btn_print.setText("  PRINT");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_printMouseExited(evt);
            }
        });
        pnl_print.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 60));

        pnl_sidebar.add(pnl_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 250, 70));

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

        pnl_sidebar.add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 250, 70));

        pnl_logout.setBackground(new java.awt.Color(0, 153, 153));
        pnl_logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(204, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/logout.png"))); // NOI18N
        btn_logout.setText(" LOGOUT");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        pnl_logout.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        pnl_sidebar.add(pnl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 250, 70));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 750));

        pnl_printPage.setBackground(new java.awt.Color(255, 255, 255));
        pnl_printPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("St. Mohammad Trust");
        pnl_printPage.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 200, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sir Ali Mohammad");
        pnl_printPage.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 240, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("School Of Science");
        pnl_printPage.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 380, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sector 14, Queens Road, Vaishali Nagar, Jaipur 302022");
        pnl_printPage.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 370, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/clg_1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        pnl_printPage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 170));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        pnl_printPage.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 840, 6));

        tf_receiptNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_receiptNo.setText("Receipt");
        pnl_printPage.add(tf_receiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 100, -1));

        tf_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_paymentMode.setText("PaymentMode");
        pnl_printPage.add(tf_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Receipt No.: JPR-");
        pnl_printPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        tf_chequeDD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_chequeDD.setText("ChequeNo");
        pnl_printPage.add(tf_chequeDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Payment Mode: ");
        pnl_printPage.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Payment for the year:");
        pnl_printPage.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, -1));

        tf_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_date.setText("22/02/2022");
        pnl_printPage.add(tf_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, -1));

        tf_bankName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_bankName.setText("Bank");
        pnl_printPage.add(tf_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, -1));

        tf_receivedFrom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_receivedFrom.setText("ReceivedFrom");
        pnl_printPage.add(tf_receivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 100, -1));

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_amount.setText("Amount (rs)");
        pnl_printPage.add(tf_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 100, -1));

        tf_yearFrom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_yearFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_yearFrom.setText("2021");
        pnl_printPage.add(tf_yearFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 40, -1));

        tf_yearTo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_yearTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_yearTo.setText("2022");
        pnl_printPage.add(tf_yearTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 70, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("-");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_printPage.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 20, -1));

        tf_rollNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_rollNo.setText("Roll No.:");
        pnl_printPage.add(tf_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 90, -1));

        tf_chequeDDNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_chequeDDNo.setText("Cheque:");
        pnl_printPage.add(tf_chequeDDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));

        tf_gst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_gst.setText("22HVSJG55A");
        pnl_printPage.add(tf_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 90, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Date:");
        pnl_printPage.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 60, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("GSTIN:");
        pnl_printPage.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 60, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));
        pnl_printPage.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 310, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 51));
        pnl_printPage.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 840, 10));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Bank Name:");
        pnl_printPage.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, -1));

        tf_head.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_head.setText("1");
        pnl_printPage.add(tf_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 170, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Head");
        pnl_printPage.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 100, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Sr No.");
        pnl_printPage.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, -1));

        tf_totalAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_totalAmount.setText("Total Amount");
        pnl_printPage.add(tf_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 100, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("1");
        pnl_printPage.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, -1));

        cgst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cgst.setText("CGST - (9%)");
        pnl_printPage.add(cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 100, -1));

        tf_sgst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_sgst.setText("Amount (rs)");
        pnl_printPage.add(tf_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 100, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Amount (rs)");
        pnl_printPage.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 100, -1));

        tf_cgst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_cgst.setText("Amount (rs)");
        pnl_printPage.add(tf_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 100, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 51, 51));
        pnl_printPage.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 840, 10));

        sgst1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sgst1.setText("SGST - (9%)");
        pnl_printPage.add(sgst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 100, -1));

        tf_totalInWords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_totalInWords.setText("Total in words");
        pnl_printPage.add(tf_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 260, -1));

        total2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total2.setText("Receiver's Signature");
        pnl_printPage.add(total2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, 120, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 51));
        pnl_printPage.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 310, 10));

        total4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total4.setText("Total Amount");
        pnl_printPage.add(total4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 100, -1));

        total5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total5.setText("Total in words");
        pnl_printPage.add(total5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 90, -1));

        total6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total6.setText("Remarks :");
        pnl_printPage.add(total6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 90, -1));

        ta_remarks.setColumns(20);
        ta_remarks.setRows(5);
        ta_remarks.setText("remarks....\n");
        ta_remarks.setEnabled(false);
        jScrollPane1.setViewportView(ta_remarks);

        pnl_printPage.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 200, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Received From:");
        pnl_printPage.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Roll No.:");
        pnl_printPage.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 60, -1));

        getContentPane().add(pnl_printPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 840, 690));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Print Receipt");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 200, 30));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 350, 10));

        setSize(new java.awt.Dimension(1179, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_print.setBackground(clr);
    }//GEN-LAST:event_btn_printMouseEntered

    private void btn_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_print.setBackground(clr);
    }//GEN-LAST:event_btn_printMouseExited

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
        Color clr = new Color(0, 102, 102);
        pnl_edit.setBackground(clr);
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        Color clr = new Color(0, 153, 153);
        pnl_edit.setBackground(clr);
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47, 0.47);

                pnl_printPage.print(g2);

                return Printable.PAGE_EXISTS;

            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_printMouseClicked

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
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_courses;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_editCourse;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_print;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_viewAllRecords;
    private javax.swing.JLabel cgst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_courses;
    private javax.swing.JPanel pnl_edit;
    private javax.swing.JPanel pnl_edit_course;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_print;
    private javax.swing.JPanel pnl_printPage;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JPanel pnl_viewAllRecords;
    private javax.swing.JLabel sgst1;
    private javax.swing.JTextArea ta_remarks;
    private javax.swing.JLabel tf_amount;
    private javax.swing.JLabel tf_bankName;
    private javax.swing.JLabel tf_cgst;
    private javax.swing.JLabel tf_chequeDD;
    private javax.swing.JLabel tf_chequeDDNo;
    private javax.swing.JLabel tf_date;
    private javax.swing.JLabel tf_gst;
    private javax.swing.JLabel tf_head;
    private javax.swing.JLabel tf_paymentMode;
    private javax.swing.JLabel tf_receiptNo;
    private javax.swing.JLabel tf_receivedFrom;
    private javax.swing.JLabel tf_rollNo;
    private javax.swing.JLabel tf_sgst;
    private javax.swing.JLabel tf_totalAmount;
    private javax.swing.JLabel tf_totalInWords;
    private javax.swing.JLabel tf_yearFrom;
    private javax.swing.JLabel tf_yearTo;
    private javax.swing.JLabel total2;
    private javax.swing.JLabel total4;
    private javax.swing.JLabel total5;
    private javax.swing.JLabel total6;
    // End of variables declaration//GEN-END:variables
}

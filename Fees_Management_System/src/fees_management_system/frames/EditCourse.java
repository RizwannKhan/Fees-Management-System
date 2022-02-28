package fees_management_system.frames;

import fees_management_system.connection.CourseDao;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import fees_management_system.entity.Course;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Rijwank
 */
public class EditCourse extends javax.swing.JFrame {

    DefaultTableModel model;
    int id;
    String courseName, coursePrice;

    public EditCourse() {
        initComponents();
        setCourses();
    }

    public void setCourses() {
        List<Course> courses = CourseDao.getCourses();
        String[] colName = {"Course Id", "Course Name", "Course Price"};
        Object[][] data = new Object[courses.size()][3];

        int i = 0;
        for (Course course : courses) {
            data[i][0] = course.getId();
            data[i][1] = course.getcName();
            data[i][2] = course.getCost();
            i++;
        }

        model = new DefaultTableModel(data, colName);
        tbl_courses.setModel(model);
    }

    public boolean addCourse() {
        boolean status = false;
        courseName = tf_courseName.getText();
        coursePrice = tf_coursePrice.getText();
        status = CourseDao.addCourse(new Course(courseName, coursePrice));
        return status;
    }

    public boolean updateCourse() {
        boolean status = false;
        int rowNum = tbl_courses.getSelectedRow();
        TableModel model = tbl_courses.getModel();
        id = (Integer) model.getValueAt(rowNum, 0);
        courseName = tf_courseName.getText();
        coursePrice = tf_coursePrice.getText();
        status = CourseDao.updateCourse(new Course(id, courseName, coursePrice));
        return status;
    }

    public boolean deleteCourse() {
        boolean status = false;
        int rowNum = tbl_courses.getSelectedRow();
        TableModel model = tbl_courses.getModel();
        id = (Integer) model.getValueAt(rowNum, 0);
        status = CourseDao.deleteCourse(id);
        return status;
    }

    public void clearTable() {
        model = (DefaultTableModel) tbl_courses.getModel();
        model.setRowCount(0);
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
        pnl_back = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_courses = new javax.swing.JTable();
        tf_courseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_deleteCourse = new javax.swing.JButton();
        btn_addCourse = new javax.swing.JButton();
        btn_updateCourse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tf_coursePrice = new javax.swing.JTextField();
        lbl_back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees Management System - Edit Course");
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

        pnl_sidebar.add(pnl_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 70));

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

        pnl_sidebar.add(pnl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, 70));

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

        pnl_sidebar.add(pnl_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 70));

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

        pnl_sidebar.add(pnl_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 250, 70));

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

        pnl_sidebar.add(pnl_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 250, 70));

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

        pnl_sidebar.add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 250, 70));

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

        pnl_sidebar.add(pnl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 250, 70));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 300, 660));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_courses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_courses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_courses.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_coursesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_courses);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 530, 540));

        tf_courseName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_courseNameActionPerformed(evt);
            }
        });
        jPanel1.add(tf_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 220, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Course Price :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 130, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit / Add Course");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 210, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Course Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 40));

        btn_deleteCourse.setBackground(new java.awt.Color(0, 153, 153));
        btn_deleteCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_deleteCourse.setForeground(new java.awt.Color(204, 255, 255));
        btn_deleteCourse.setText("Delete");
        btn_deleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteCourseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_deleteCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 100, 40));

        btn_addCourse.setBackground(new java.awt.Color(0, 153, 153));
        btn_addCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_addCourse.setForeground(new java.awt.Color(204, 255, 255));
        btn_addCourse.setText("Add");
        btn_addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCourseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_addCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 110, 40));

        btn_updateCourse.setBackground(new java.awt.Color(0, 153, 153));
        btn_updateCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_updateCourse.setForeground(new java.awt.Color(204, 255, 255));
        btn_updateCourse.setText("Update");
        btn_updateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateCourseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_updateCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 100, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 250, 10));

        tf_coursePrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_coursePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_coursePriceActionPerformed(evt);
            }
        });
        jPanel1.add(tf_coursePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 220, 40));

        lbl_back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/back-button.png"))); // NOI18N
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_backMouseEntered(evt);
            }
        });
        jPanel1.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 660));

        setSize(new java.awt.Dimension(1296, 697));
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

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_searchMouseClicked

    private void tf_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_courseNameActionPerformed

    private void btn_deleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteCourseActionPerformed
        if (deleteCourse()) {
            JOptionPane.showMessageDialog(this, "Course Deleted Successfully");
            tf_courseName.setText("");
            tf_coursePrice.setText("");
            clearTable();
            setCourses();
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong, try agsin!!!");
        }
    }//GEN-LAST:event_btn_deleteCourseActionPerformed

    private void btn_updateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateCourseActionPerformed
        if (updateCourse()) {
            JOptionPane.showMessageDialog(this, "Course Updated Successfully");
            clearTable();
            setCourses();
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong, try agsin!!!");
        }
    }//GEN-LAST:event_btn_updateCourseActionPerformed

    private void btn_addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCourseActionPerformed
        if (addCourse()) {
            JOptionPane.showMessageDialog(this, "Course Added Successfully");
            clearTable();
            setCourses();
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong, try agsin!!!");
        }
    }//GEN-LAST:event_btn_addCourseActionPerformed

    private void tbl_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_coursesMouseClicked
        int rowNum = tbl_courses.getSelectedRow();
        TableModel model = tbl_courses.getModel();
        //tf_courseId.setText(model.getValueAt(rowNum, 0).toString());
        tf_courseName.setText(model.getValueAt(rowNum, 1).toString());
        tf_coursePrice.setText(model.getValueAt(rowNum, 2).toString());
    }//GEN-LAST:event_tbl_coursesMouseClicked

    private void tf_coursePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_coursePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_coursePriceActionPerformed

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void lbl_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseEntered
        
    }//GEN-LAST:event_lbl_backMouseEntered

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCourse;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_courses;
    private javax.swing.JButton btn_deleteCourse;
    private javax.swing.JLabel btn_editCourse;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_search;
    private javax.swing.JButton btn_updateCourse;
    private javax.swing.JLabel btn_viewAllRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_courses;
    private javax.swing.JPanel pnl_edit_course;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JPanel pnl_viewAllRecords;
    private javax.swing.JTable tbl_courses;
    private javax.swing.JTextField tf_courseName;
    private javax.swing.JTextField tf_coursePrice;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system.frames;

import java.awt.Color;

/**
 *
 * @author Rijwank
 */
public class PrintReceipt extends javax.swing.JFrame {

    /**
     * Creates new form PrintReceipt
     */
    public PrintReceipt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        pnl_sidebar.add(pnl_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 250, 70));

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

        pnl_sidebar.add(pnl_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 250, 70));

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

        pnl_sidebar.add(pnl_viewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 250, 70));

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

        pnl_sidebar.add(pnl_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 250, 70));

        pnl_print.setBackground(new java.awt.Color(0, 153, 153));
        pnl_print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        pnl_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_print.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_print.setForeground(new java.awt.Color(204, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/printer-.png"))); // NOI18N
        btn_print.setText("  PRINT");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_printMouseExited(evt);
            }
        });
        pnl_print.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 60));

        pnl_sidebar.add(pnl_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 250, 70));

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

        pnl_sidebar.add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 250, 70));

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

        pnl_sidebar.add(pnl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 250, 70));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 750));

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
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_courses;
    private javax.swing.JPanel pnl_edit;
    private javax.swing.JPanel pnl_edit_course;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_print;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JPanel pnl_viewAllRecords;
    // End of variables declaration//GEN-END:variables
}
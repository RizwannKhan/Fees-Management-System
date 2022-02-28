package fees_management_system.frames;

import fees_management_system.entity.User;
import fees_management_system.connection.UserDao;
import fees_management_system.helper.PasswordEncoder;
import java.util.Date;
import javax.swing.JOptionPane;

public class Signup_Page extends javax.swing.JFrame {

    String fname, lname, uname, password, con_pass, contact;
    Date dob;

    public Signup_Page() {
        initComponents();
    }

    boolean validation() {

        fname = txt_firstname.getText();
        lname = txt_lastname.getText();
        uname = txt_username.getText();
        password = txt_password.getText();
        con_pass = txt_con_password.getText();
        contact = txt_contact.getText();
        dob = txt_dob.getDate();

        if (fname.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter firstname");
            return false;
        }
        if (lname.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter lastname");
            return false;
        }
        if (uname.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter username");
            return false;
        }
        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter password");
            return false;
        }
        if (con_pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Please confirm password");
            return false;
        }
        if (dob.equals(null)) {
            JOptionPane.showMessageDialog(this, "Please enter date");
            return false;
        }
        if (contact.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter contact");
            return false;
        }
        if (!con_pass.equals(password)) {
            JOptionPane.showMessageDialog(this, "Password not mached");
            return false;
        }
        return true;
    }

    public void checkPasswod() {
        password = String.valueOf(txt_password.getPassword());

        if (password.length() < 6) {
            lbl_password_err.setText("Password must be 6 digit");
        } else {
            lbl_password_err.setText("");
        }
    }

    public void checkContact() {
        contact = txt_contact.getText();
        if (contact.length() == 10) {
            lbl_contact_err.setText("");
        } else {
            lbl_contact_err.setText("contact must be 10 digit");
        }
    }

    void insertDetails() {
        try {
            String encryptPassword = PasswordEncoder.encrypt(password);
            User user = new User(fname, lname, uname, encryptPassword, dob, contact);
            boolean status = UserDao.createUser(user);
            if (status) {
                JOptionPane.showMessageDialog(this, "User created successfuly");
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong, please try again");
            }
        } catch (Exception e) {
            System.err.println("Error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_lastname = new javax.swing.JTextField();
        txt_firstname = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_con_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_signup = new javax.swing.JButton();
        lbl_password_err = new javax.swing.JLabel();
        lbl_contact_err = new javax.swing.JLabel();
        txt_dob = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees Management System - Register Page");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SignUp");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 22, 185, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/new-user.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 11, 122, 82));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("First Name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Last Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 63, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Username : ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Password : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 147, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Confirm Password : ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 182, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Contact : ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 264, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("D. O. B. : ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txt_lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 64, 233, -1));

        txt_firstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 22, 233, -1));

        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactKeyTyped(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 262, 233, -1));

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 106, 233, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 148, 233, -1));

        txt_con_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_con_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_con_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_con_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 183, 233, -1));

        btn_login.setBackground(new java.awt.Color(0, 102, 102));
        btn_login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(204, 255, 255));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/login.png"))); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 133, 32));

        btn_signup.setBackground(new java.awt.Color(0, 102, 102));
        btn_signup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_signup.setForeground(new java.awt.Color(204, 255, 255));
        btn_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/img/signup.png"))); // NOI18N
        btn_signup.setText("SignUp");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 133, 32));

        lbl_password_err.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_password_err.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(lbl_password_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 147, 140, -1));

        lbl_contact_err.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_contact_err.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(lbl_contact_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 262, 140, -1));

        txt_dob.setDateFormatString("MMM d, yyyy");
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 230, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 630, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastnameActionPerformed

    private void txt_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstnameActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Login login = new Login();
        login.show();
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        if (validation()) {
            insertDetails();
        }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_con_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_con_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_con_passwordActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        checkPasswod();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
        checkPasswod();
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        checkPasswod();
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyPressed
        checkContact();
    }//GEN-LAST:event_txt_contactKeyPressed

    private void txt_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyReleased
        checkContact();
    }//GEN-LAST:event_txt_contactKeyReleased

    private void txt_contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyTyped
        checkContact();
    }//GEN-LAST:event_txt_contactKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_err;
    private javax.swing.JLabel lbl_password_err;
    private javax.swing.JPasswordField txt_con_password;
    private javax.swing.JTextField txt_contact;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}

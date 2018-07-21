
package MainHome;

import Controls.Authentication;
import Controls.Validate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ChangePassword extends javax.swing.JDialog {

    private Authentication auth;
    private int role;

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword(java.awt.Frame parent, boolean modal, Authentication auth) {
        super(parent, modal);
        this.auth = auth;
        role = auth.getRole();
        initComponents();
        initUI();
        this.setLocationRelativeTo(parent);
    }
int xMouse;
int yMouse;
    private void initUI() {
        Connection connect = null;
        connect = DataSett.ConnectDB.getConnect();
        if (connect == null) {
            JOptionPane.showMessageDialog(this, "Connect fail !");
            return;
        }
        String SQL = "";
        ResultSet res = null;

        if (role == Authentication.HEADER_ADMIN) {
            try {
                SQL = "SELECT username FROM admin WHERE ID=" + auth.getID();
                res = connect.createStatement().executeQuery(SQL);
                if (res.next()) {
                    labelUsername.setText(res.getString(1));
                } else {
                    JOptionPane.showMessageDialog(this, "Have some error ! Please logout and try again !");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (role == Authentication.STAFF_MANAGER || role == Authentication.STUDENT_MANAGER) {
            try {
                SQL = "SELECT usrn FROM user WHERE ID=" + auth.getID();

                res = connect.createStatement().executeQuery(SQL);
                if (res.next()) {
                    labelUsername.setText(res.getString(1));

                } else {
                    JOptionPane.showMessageDialog(this, "Have some error ! Please logout and try again !");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void save() {
        if (!validateForm()) {
            return;
        }
        Connection connect = null;
        connect = DataSett.ConnectDB.getConnect();
        if (connect == null) {
            JOptionPane.showMessageDialog(this, "Connect fail !");
            return;
        }
        String SQLCheck = "";
        String SQLUpdate = "";
        PreparedStatement pre = null;
        ResultSet res = null;
        if (role == Authentication.HEADER_ADMIN) {
            SQLCheck = "SELECT 1 FROM admin WHERE ID=? AND password=?";
            SQLUpdate = "UPDATE admin SET password=? WHERE ID=?";
        } else if (role == Authentication.STAFF_MANAGER || role == Authentication.STUDENT_MANAGER) {
            SQLCheck = "SELECT 1 FROM user WHERE ID=? AND pswd=?";
            SQLUpdate = "UPDATE user SET email=? WHERE ID=?";
        }
        try {
            pre = connect.prepareStatement(SQLCheck);
            pre.setInt(1, auth.getID());
            pre.setString(2, new String(txtPswd.getPassword()));

            res = pre.executeQuery();
            if (!res.next()) {
                JOptionPane.showMessageDialog(this, "Password in correct ! Please try again !");
                return;
            }
            if (new String(txtPswd.getPassword()).equalsIgnoreCase(new String(txtNewPswd.getPassword()))) {
                JOptionPane.showMessageDialog(this, "New Password and old Password is match !");
                return;
            }
            pre = connect.prepareStatement(SQLUpdate);
            pre.setString(1, new String(txtNewPswd.getPassword()));
            pre.setInt(2, auth.getID());
            int result = pre.executeUpdate();
            if (result != 1) {
                JOptionPane.showMessageDialog(this, "Update fail !");
            } else {
                JOptionPane.showMessageDialog(this, "Update success !");
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validateForm() {
        if (Validate.isEmpty(new String(txtPswd.getPassword()))
                || Validate.isEmpty(new String(txtNewPswd.getPassword()))
                || Validate.isEmpty(new String(txtReNewPswd.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Password is required !");
            return false;
        }
        if (!Validate.checkPassword(new String(txtNewPswd.getPassword()), new String(txtReNewPswd.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Re-Password is not match !");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainFH = new javax.swing.JPanel();
        cnclBut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtReNewPswd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtNewPswd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPswd = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        setBackground(new java.awt.Color(4, 74, 121));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainFH.setBackground(new java.awt.Color(179, 209, 224));
        mainFH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainFH.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mainFH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainFHMouseDragged(evt);
            }
        });
        mainFH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainFHMousePressed(evt);
            }
        });
        mainFH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainFHKeyPressed(evt);
            }
        });
        mainFH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cnclBut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnclBut.setForeground(new java.awt.Color(255, 255, 255));
        cnclBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px.png"))); // NOI18N
        cnclBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnclButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cnclButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cnclButMouseExited(evt);
            }
        });
        mainFH.add(cnclBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 21, 20));

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Password_Reset_30px.png"))); // NOI18N
        jLabel1.setText("   Change Password");
        jLabel1.setOpaque(true);
        mainFH.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        getContentPane().add(mainFH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReNewPswd.setBackground(new java.awt.Color(85, 153, 187));
        txtReNewPswd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtReNewPswd.setForeground(new java.awt.Color(255, 255, 255));
        txtReNewPswd.setBorder(null);
        txtReNewPswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReNewPswdActionPerformed(evt);
            }
        });
        jPanel1.add(txtReNewPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 250, 25));

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 110, 25));

        txtNewPswd.setBackground(new java.awt.Color(85, 153, 187));
        txtNewPswd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNewPswd.setForeground(new java.awt.Color(255, 255, 255));
        txtNewPswd.setBorder(null);
        jPanel1.add(txtNewPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 250, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("New Password");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, 25));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Old Password");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, 25));

        labelUsername.setBackground(new java.awt.Color(85, 153, 187));
        labelUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));
        labelUsername.setText("Username");
        labelUsername.setOpaque(true);
        jPanel1.add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 250, 25));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px_3.png"))); // NOI18N
        jLabel5.setText("Cancel");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 70, 25));

        txtPswd.setBackground(new java.awt.Color(85, 153, 187));
        txtPswd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPswd.setForeground(new java.awt.Color(255, 255, 255));
        txtPswd.setBorder(null);
        jPanel1.add(txtPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, 25));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Verify Password");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 110, 25));

        jLabel7.setBackground(new java.awt.Color(51, 204, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_18px.png"))); // NOI18N
        jLabel7.setText("Save");
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 70, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 470, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReNewPswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReNewPswdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReNewPswdActionPerformed

    private void cnclButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnclButMouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cnclButMouseClicked

    private void cnclButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnclButMouseEntered
        cnclBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px_1.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_cnclButMouseEntered

    private void cnclButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnclButMouseExited
        cnclBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_cnclButMouseExited

    private void mainFHMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);// TODO add your handling code here:
    }//GEN-LAST:event_mainFHMouseDragged

    private void mainFHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_mainFHMousePressed

    private void mainFHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainFHKeyPressed

    }//GEN-LAST:event_mainFHKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
save();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cnclBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPanel mainFH;
    private javax.swing.JPasswordField txtNewPswd;
    private javax.swing.JPasswordField txtPswd;
    private javax.swing.JPasswordField txtReNewPswd;
    // End of variables declaration//GEN-END:variables
}

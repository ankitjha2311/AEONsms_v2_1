/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHome;

import Controls.Authentication;
import Controls.GeneralManager;
import Controls.Validate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class AccountInfo extends javax.swing.JInternalFrame {

    private Authentication auth;
    private GeneralManager manger;
    private int role;
    private String email;

    /**
     * Creates new form AccountInfo
     */
    public AccountInfo(int w, int h, Authentication auth) {
        initComponents();
        this.auth = auth;
        this.manger = new GeneralManager();
        role = auth.getRole();
        initUI();
        setSize(w, h + 30);

    }

    private void initUI() {
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        Connection connect = null;
        connect = DataSett.ConnectDB.getConnect();
        if (connect == null) {
            JOptionPane.showMessageDialog(this, "Connect fail !");
            return;
        }
        String SQL = "";
        ResultSet res = null;
        java.text.SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp time = null;
        DefaultTableModel model = (DefaultTableModel) tblHistory.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        if (role == Authentication.HEADER_ADMIN) {
            try {
                SQL = "SELECT username, name, email FROM admin WHERE ID=" + auth.getID();
                res = connect.createStatement().executeQuery(SQL);
                if (res.next()) {
                    labelUsername.setText(res.getString(1));
                    labelName.setText(res.getString(2));
                    email = res.getString(3);
                    txtEmail.setText(email);
                    labelRole.setText("Admin");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (role == Authentication.STAFF_MANAGER || role == Authentication.STUDENT_MANAGER) {
            try {
                SQL = "SELECT usrn , name,email, role FROM user WHERE ID=" + auth.getID();

                res = connect.createStatement().executeQuery(SQL);
                if (res.next()) {
                    labelUsername.setText(res.getString(1));
                    labelName.setText(res.getString(2));
                    txtEmail.setText(res.getString(3));
                    labelRole.setText(manger.parseRole(res.getInt(4)));
                } else {
                    JOptionPane.showMessageDialog(this, "Have some error ! Please logout and try again !");
                    return;
                }

            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        SQL = "SELECT time, action FROM authentication WHERE ID_People=" + auth.getID() + " AND role=" + auth.getRole() + " ORDER BY time desc;";
        try {
            res = connect.createStatement().executeQuery(SQL);
            while (res.next()) {
                Vector row = new Vector();
                time = res.getTimestamp(1);
                row.add(time);
                if (res.getInt(2) == 0) {
                    row.add("Logout");
                } else {
                    row.add("Login");
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save() {
        if(!validateForm()){
            return;
        }
        Connection connect = null;
        connect = DataSett.ConnectDB.getConnect();
        if (connect == null) {
            JOptionPane.showMessageDialog(this, "Connect fail !");
        }
        String SQL = "";
        PreparedStatement state = null;
        if (role == Authentication.HEADER_ADMIN) {
            SQL = "UPDATE admin SET email=? WHERE ID=?";
        } else if (role == Authentication.STAFF_MANAGER || role == Authentication.STUDENT_MANAGER) {
            SQL = "UPDATE user SET email=? WHERE ID=?";
        }
        try {
            state = connect.prepareStatement(SQL);
            state.setString(1, txtEmail.getText());
            state.setInt(2, auth.getID());
            int res = state.executeUpdate();
            if (res != 1) {
                JOptionPane.showMessageDialog(this, "Update fail !");
            } else {
                JOptionPane.showMessageDialog(this, "Update success !");
                initUI();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean validateForm(){
        if(!Validate.checkEmail(txtEmail.getText())){
            JOptionPane.showMessageDialog(this, "Email incorrect ! Please try again !");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        labelRole = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 129, 171));
        setBorder(null);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(1024, 680));
        setPreferredSize(new java.awt.Dimension(1024, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_More_Info_56px.png"))); // NOI18N
        jLabel1.setText("Account Infomation");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 70));

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 90, 25));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 90, 25));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Role");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 88, 25));

        jScrollPane1.setBackground(new java.awt.Color(179, 209, 224));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));

        tblHistory.setBackground(new java.awt.Color(4, 74, 121));
        tblHistory.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblHistory.setForeground(new java.awt.Color(255, 255, 255));
        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Time", "Action"
            }
        ));
        tblHistory.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tblHistory.setShowHorizontalLines(false);
        tblHistory.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblHistory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 800, 230));

        jLabel6.setBackground(new java.awt.Color(51, 204, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px_1.png"))); // NOI18N
        jLabel6.setText("User Details");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 800, 30));

        txtEmail.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 260, 25));

        labelRole.setBackground(new java.awt.Color(85, 153, 187));
        labelRole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelRole.setForeground(new java.awt.Color(255, 255, 255));
        labelRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRole.setText("Role");
        labelRole.setOpaque(true);
        getContentPane().add(labelRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 300, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 90, 25));

        labelName.setBackground(new java.awt.Color(85, 153, 187));
        labelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Name");
        labelName.setOpaque(true);
        getContentPane().add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 300, 25));

        labelUsername.setBackground(new java.awt.Color(85, 153, 187));
        labelUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername.setText("Username");
        labelUsername.setOpaque(true);
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 260, 25));

        jLabel7.setBackground(new java.awt.Color(255, 101, 101));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Activity_History_24px.png"))); // NOI18N
        jLabel7.setText("Action History");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 800, 30));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Reset_18px_1.png"))); // NOI18N
        jLabel8.setText("Reset");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 88, 25));

        jLabel9.setBackground(new java.awt.Color(51, 204, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_18px.png"))); // NOI18N
        jLabel9.setText("Save");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 90, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    save();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    txtEmail.setText(email);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}

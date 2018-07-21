/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHome;

import Controls.GeneralManager;
import Controls.Manager;
import MainObjects.BatchEntity;
import MainObjects.DepartmentEntity;
import MainObjects.ExtraCurricularEntity;
import MainObjects.PositionEntity;
import MainObjects.StaffEntity;
import MainObjects.StudentEntity;
import MainObjects.SubjectEntity;
import MainObjects.UserEntity;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListDeactived extends javax.swing.JInternalFrame {

    private int type;
    private String SQL;
    private GeneralManager manager;
    private String header;

    public ListDeactived(int type) {
        this.manager = new GeneralManager();
        this.type = type;
        this.SQL = "";
        initComponents();
        initUI();
        enableButton(false);
    }

    public void initUI() {
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        switch (type) {
            case Manager.USER:
                header = "Activate Users";
                SQL = "SELECT ID, name FROM user where status=0";
                break;
            case Manager.DEPARTMENT:
                header = "Activate Departments";
                SQL = "SELECT ID, name FROM department where status=0";
                break;
            case Manager.BATCH:
                header = "Activate Batch";
                SQL = "SELECT ID, name FROM batch where status=0";
                break;
            case Manager.EXTRA_CURRICULAR:
                header = "Activate Extra Curricular";
                SQL = "SELECT ID, name FROM extra_curricular where status=0";
                break;
            case Manager.SUBJECT:
                header = "Activate Courses";
                SQL = "SELECT ID, name FROM subject where status=0";
                break;
            case Manager.STUDENT:
                header = "Release Students";
                SQL = "SELECT ID, name FROM student where status=0";
                break;
            case Manager.STAFF:
                header = "Release Employee";
                SQL = "SELECT No, name FROM staff where status=0";
                break;
            case Manager.POSITION:
                header = "Activate Job Positions";
                SQL = "SELECT ID, name FROM position where status=0";
                break;
            default:
                break;
        }
        labelTitle.setText(header);
        manager.loadTable(SQL, tblList, new String[]{"ID", "Name"});
    }

    private void search(int ID, String name) {
        String query = SQL;
        if (ID != 0) {
            if (type == Manager.STAFF) {
                query += " AND No=" + ID;
            } else {
                query += " AND ID=" + ID;
            }
        }
        if (name != null && !name.isEmpty()) {
            query += " AND name like '%" + name + "%'";
        }
        manager.loadTable(query, tblList, new String[]{"ID", "Name"});
        enableButton(false);
    }

    private void remove() {
        int ID = manager.getSelectID(tblList);
        int res = 0;
        String query = "";
        switch (type) {
            case Manager.USER:
                query = "DELETE FROM user";
                break;
            case Manager.DEPARTMENT:
                System.out.println("nbull");
                res = new DepartmentEntity().remove(ID);
                break;
            case Manager.BATCH:
                res = new BatchEntity().remove(ID);
                break;
            case Manager.EXTRA_CURRICULAR:
                res = new ExtraCurricularEntity().remove(ID);
                break;
            case Manager.SUBJECT:
                res = new SubjectEntity().remove(ID);
                break;
            case Manager.STUDENT:
                res = new StudentEntity().remove(ID);
                break;
            case Manager.POSITION:
                res = new PositionEntity().remove(ID);
                break;
            case Manager.STAFF:
                res = new StaffEntity().remove(ID);
                break;
            default:
                break;
        }
        manager.showMessage(res, this);
        if (res == Manager.SUCCESS) {
            initUI();
        }
    }

    private void active() {
        int ID = manager.getSelectID(tblList);
        int res = 0;
        switch (type) {
            case Manager.USER:
                res = new UserEntity().active(ID);
                break;
            case Manager.DEPARTMENT:
                res = new DepartmentEntity().active(ID);
                break;
            case Manager.BATCH:
                res = new BatchEntity().active(ID);
                break;
            case Manager.EXTRA_CURRICULAR:
                res = new ExtraCurricularEntity().active(ID);
                break;
            case Manager.SUBJECT:
                res = new SubjectEntity().active(ID);
                break;
            case Manager.STUDENT:
                res = new StudentEntity().active(ID);
                break;
            case Manager.POSITION:
                res = new PositionEntity().active(ID);
                break;
            case Manager.STAFF:
                res = new StaffEntity().active(ID);
                break;
            default:
                break;
        }
        manager.showMessage(res, this);
        if (res == Manager.SUCCESS) {
            initUI();
        }
    }

    private void enableButton(boolean b) {
        btnRemove.setEnabled(b);
        btnActive.setEnabled(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnActive = new javax.swing.JLabel();
        btnRemove = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();

        setBackground(new java.awt.Color(179, 209, 224));
        setBorder(null);
        setFrameIcon(null);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setBackground(new java.awt.Color(0, 102, 153));
        labelTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Title");
        labelTitle.setOpaque(true);
        jPanel1.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 1080, 60));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 90, 26));

        txtID.setBackground(new java.awt.Color(85, 153, 187));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setBorder(null);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 230, 26));

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Search_18px_2.png"))); // NOI18N
        jLabel6.setText("Search");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 90, 26));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 240, 26));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Name");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 90, 26));

        btnActive.setBackground(new java.awt.Color(52, 203, 0));
        btnActive.setForeground(new java.awt.Color(255, 255, 255));
        btnActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Checked_18px.png"))); // NOI18N
        btnActive.setText("Activate");
        btnActive.setOpaque(true);
        btnActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActiveMouseClicked(evt);
            }
        });
        jPanel1.add(btnActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 590, 90, 26));

        btnRemove.setBackground(new java.awt.Color(255, 0, 102));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Remove_18px.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setOpaque(true);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 90, 26));

        jScrollPane1.setBackground(new java.awt.Color(179, 209, 224));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tblList.setBackground(new java.awt.Color(4, 74, 121));
        tblList.setForeground(new java.awt.Color(255, 255, 255));
        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.setGridColor(new java.awt.Color(0, 204, 51));
        tblList.setRowHeight(18);
        tblList.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tblList.setShowHorizontalLines(false);
        tblList.setShowVerticalLines(false);
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 780, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblListMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int ID = 0;
        try {
            ID = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException ex) {
            return;
        }
        search(ID, txtName.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActiveMouseClicked
     active();   // TODO add your handling code here:
    }//GEN-LAST:event_btnActiveMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
 int confirm = JOptionPane.showConfirmDialog(this, "Are you sure ?");
        if (confirm == 0) {
            remove();
        }
           // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActive;
    private javax.swing.JLabel btnRemove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

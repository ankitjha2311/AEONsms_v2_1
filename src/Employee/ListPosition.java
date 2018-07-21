/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import FileExport.ExportFile;
import Controls.Manager;
import Controls.StaffManager;
import Controls.Validate;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListPosition extends javax.swing.JInternalFrame implements UIInterface{
    StaffManager staffManager;
    private int act; 
    /**
     * Creates new form ListPosition
     */
    public ListPosition(int w, int h) {
        this.staffManager=new StaffManager();
        initComponents(); 
        initUI();
        setSize(w, h);
    }
    @Override
    public void initUI(){
        enableButton(false);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        editAddPanel.setVisible(false);
        staffManager.loadCombobox("SELECT name FROM department", comboDepartmentSearh);
        String SQL="SELECT position.ID, position.name, department.name FROM position, department WHERE position.department_ID=department.ID AND position.status=1";
        staffManager.loadTable(SQL, tblPosition, Manager.POSITION_MODEL);
    }
    @Override
    public void enableEditAddPanel(boolean b) {
        if(b==false){
            tblPosition.setEnabled(true); 
            txtName.setText(null);
            editAddPanel.setVisible(false);
            
            
            bannerPanel.setVisible(true);
        }else{
            if(act==EDIT){
                labelAction.setText("Edit Position");
                loadEdit();
            }else if(act==ADD){
                labelAction.setText("Add Position");
            }
            staffManager.loadCombobox("SELECT name FROM department", comboDepartment);
            tblPosition.setEnabled(false);
            editAddPanel.setVisible(true);
            btnReset.setVisible(true);
            
          
            bannerPanel.setVisible(false);
        }
    }

    @Override
    public void loadEdit() {
        Vector row=staffManager.getSelectRow(tblPosition);
        txtName.setText(row.get(1).toString());
        staffManager.loadCombobox("SELECT name FROM department", comboDepartment);
        comboDepartment.setSelectedItem(row.get(2).toString());
        txtName.setRequestFocusEnabled(true);
    }

    public void save(){
        if(!validateForm()){
            return;
        }
        if(act==ADD){
            add();
            return;
        }
        if(act==EDIT){
  
            edit();
            return;
        }
    }
 
    public void add() {
        String name=txtName.getText();
        String department=comboDepartment.getSelectedItem().toString();
        
        //Check Unique
//        staffManager.checkUnique();
        
        String data[]=new String[]{ name, department};
        int res=staffManager.addPosition(data);
        if(res==Manager.SUCCESS){
            initUI();
            enableEditAddPanel(false);
        }
        staffManager.showMessage(res, this);
    }


    public void edit() {
        String name=txtName.getText();
        
        String department=comboDepartment.getSelectedItem().toString();
        //Check Unique
//        staffManager.checkUnique();
        
        String data[]=new String[]{staffManager.getSelectID(tblPosition)+"", name, department};
        int res=staffManager.editPosition(data);
        staffManager.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
        enableEditAddPanel(false);
    }

    @Override
    public void deactive() {
        int res=staffManager.deactivePosition(staffManager.getSelectID(tblPosition));
        staffManager.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }


    @Override
    public void search(){
        String SQL="SELECT position.ID, position.name, department.name FROM position, department WHERE position.department_ID=department.ID AND position.status=1 ";
        if(!txtNameSearch.getText().isEmpty()){
            SQL+=" AND position.name like '%"+txtNameSearch.getText()+"%'";
        }
        if(comboDepartmentSearh.getSelectedIndex() !=0){
            SQL+=" AND department.name ='"+comboDepartmentSearh.getSelectedItem().toString()+"'";
        }
        staffManager.loadTable(SQL, tblPosition, Manager.POSITION_MODEL);
        enableButton(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bannerPanel = new javax.swing.JPanel();
        lebPosition = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        comboDepartmentSearh = new javax.swing.JComboBox();
        btnExport = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPosition = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        editAddPanel = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        comboDepartment = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();

        setBorder(null);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lebPosition.setBackground(new java.awt.Color(0, 102, 153));
        lebPosition.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lebPosition.setForeground(new java.awt.Color(255, 255, 255));
        lebPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lebPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Job_Seeker_30px_1.png"))); // NOI18N
        lebPosition.setText("Employee Post List");
        lebPosition.setIconTextGap(22);
        lebPosition.setOpaque(true);
        bannerPanel.add(lebPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        txtNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 212, 25));

        comboDepartmentSearh.setBackground(new java.awt.Color(85, 153, 187));
        comboDepartmentSearh.setEditable(true);
        comboDepartmentSearh.setBorder(null);
        bannerPanel.add(comboDepartmentSearh, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 200, 25));

        btnExport.setBackground(new java.awt.Color(0, 0, 204));
        btnExport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Outbox_17px.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setOpaque(true);
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        bannerPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 88, 25));

        btnDeactive.setBackground(new java.awt.Color(255, 0, 0));
        btnDeactive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeactive.setForeground(new java.awt.Color(255, 255, 255));
        btnDeactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeactive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Radio_Active_17px.png"))); // NOI18N
        btnDeactive.setText("Deactivate");
        btnDeactive.setOpaque(true);
        btnDeactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeactiveMouseClicked(evt);
            }
        });
        bannerPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 100, 25));

        btnEdit.setBackground(new java.awt.Color(204, 0, 204));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_Row_17px.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setOpaque(true);
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 88, 25));

        btnAdd.setBackground(new java.awt.Color(51, 204, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Add_New_17px.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 88, 25));

        btnSearch.setBackground(new java.awt.Color(255, 102, 0));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Google_Web_Search_17px.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setOpaque(true);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        bannerPanel.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 88, 25));

        jLabel18.setBackground(new java.awt.Color(0, 102, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Department");
        jLabel18.setOpaque(true);
        bannerPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 90, 25));

        jScrollPane1.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 74, 121), 1, true));

        tblPosition.setBackground(new java.awt.Color(4, 74, 121));
        tblPosition.setForeground(new java.awt.Color(255, 255, 255));
        tblPosition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPosition.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tblPosition.setShowHorizontalLines(false);
        tblPosition.setShowVerticalLines(false);
        tblPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPositionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPosition);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 720, 350));

        jLabel19.setBackground(new java.awt.Color(0, 102, 153));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Name");
        jLabel19.setOpaque(true);
        bannerPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 90, 25));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(1, 100, 151));
        labelAction.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_New_Job_30px_1.png"))); // NOI18N
        labelAction.setText("Add New Job Position");
        labelAction.setIconTextGap(22);
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1020, 60));

        jLabel2.setBackground(new java.awt.Color(1, 100, 151));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");
        jLabel2.setOpaque(true);
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 90, 25));

        jLabel5.setBackground(new java.awt.Color(1, 100, 151));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Department");
        jLabel5.setOpaque(true);
        editAddPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 90, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 240, 25));

        comboDepartment.setBackground(new java.awt.Color(85, 153, 187));
        comboDepartment.setEditable(true);
        comboDepartment.setBorder(null);
        editAddPanel.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 240, 25));

        jLabel3.setBackground(new java.awt.Color(1, 100, 151));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Job Title");
        jLabel3.setOpaque(true);
        editAddPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 90, 25));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Refresh_17px.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setOpaque(true);
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 88, 25));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Close_Window_17px.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setOpaque(true);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        editAddPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 88, 25));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_18px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setOpaque(true);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 88, 25));

        txtName1.setBackground(new java.awt.Color(85, 153, 187));
        txtName1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setBorder(null);
        editAddPanel.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 240, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAction
       
    }//GEN-LAST:event_searchAction

    private void tblPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPositionMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblPositionMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        export();        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
if(staffManager.confirmRemove(this, "Are you sure ?")==0){
            deactive();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
      if(staffManager.getSelectRow(tblPosition) !=null){
            act=EDIT;
            enableEditAddPanel(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
     act=ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        search();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
      enableEditAddPanel(false);   // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
     loadEdit();   // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
       save(); // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnDeactive;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExport;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JComboBox comboDepartmentSearh;
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JLabel lebPosition;
    private javax.swing.JTable tblPosition;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtNameSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableButton(boolean b) {
        btnEdit.setEnabled(b);
        btnDeactive.setEnabled(b);
    }

    @Override
    public boolean validateForm() {
        String name=txtName.getText();
        if(name==null || name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Name is required !");
            return false;
        }
        if(!Validate.choosedComboBox(comboDepartment)){
            JOptionPane.showMessageDialog(this, "Department is required !");
            return false;
        }
        return true;
    }

    private void export() {
        ExportFile export=new ExportFile(tblPosition, ExportFile.POSITION);
        export.toExcel();
    }
}

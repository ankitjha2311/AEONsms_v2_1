/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import FileExport.ExportFile;
import Controls.Manager;
import MainObjects.DepartmentEntity;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import TableModel.Department;
import MainHome.UIInterface; 

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListDepartment extends javax.swing.JInternalFrame implements UIInterface{
    private final DepartmentEntity departmentEntity=new DepartmentEntity();
    private int act;
    private Department department; 
    
   


 /**
     * Creates new form ListDepartment
     * @param w
     * @param h
     */
    public ListDepartment(int w, int h) {
        initComponents();
        initUI();
        setSize(w, h);
    }
    @Override
    public void initUI(){

        enableButton(false);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        editAddPanel.setVisible(false);
        departmentEntity.loadList(tblDepartment);
    }
    @Override
    public void enableEditAddPanel(boolean b){
        if(b==false){
            tblDepartment.setEnabled(true);
            txtName.setText(null);
            
            editAddPanel.setVisible(false);
           
            bannerPanel.setVisible(true);
        }else{
            if(act==EDIT){
                EditTitle.setText("Edit Department");
                loadEdit();
            }else if(act==ADD){
                EditTitle.setText("Add Department");
            }
            tblDepartment.setEnabled(false);
            btnReset.setVisible(true);
            
         
            bannerPanel.setVisible(false);
            editAddPanel.setVisible(true);
        }
    }
  
    
    @Override
    public void loadEdit() {
        department=departmentEntity.findByID(departmentEntity.getSelectID(tblDepartment));
        txtName.setText(department.getName());
        txtName.setRequestFocusEnabled(true);
    }
    @Override
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
        }
    }

    public void add(){
        department=new Department();
        String name=txtName.getText();
        if(departmentEntity.findByName(name) !=null){
            JOptionPane.showMessageDialog(this, "Name already exist !");
            return;
        }
        department.setName(name);
        departmentEntity.setDepartment(department);
        int res=departmentEntity.save();
        departmentEntity.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
            enableEditAddPanel(false);
        }
    }

    public void edit(){
        String name=txtName.getText();
        department.setName(name);
        if(!name.equalsIgnoreCase((String)tblDepartment.getValueAt(tblDepartment.getSelectedRow(), 1))){
            if(departmentEntity.findByName(name) !=null){
                JOptionPane.showMessageDialog(this, "Name already exist !");
                return;
            }
        }
        departmentEntity.setDepartment(department);
        int res=departmentEntity.save();
        departmentEntity.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
            enableEditAddPanel(false);
        }
    }
    @Override
    public void deactive(){
        int res=departmentEntity.deactive(departmentEntity.getSelectID(tblDepartment));
        departmentEntity.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }

    @Override
    public void search(){
        departmentEntity.search(txtSearchName.getText(), tblDepartment);
        enableButton(false);
    }
    @Override
    public void enableButton(boolean b) {
        btnEdit.setEnabled(b);
        btnDeactive.setEnabled(b);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editAddPanel = new javax.swing.JPanel();
        EditTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtName3 = new javax.swing.JTextField();
        bannerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(179, 209, 224));
        setBorder(null);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditTitle.setBackground(new java.awt.Color(0, 102, 153));
        EditTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        EditTitle.setForeground(new java.awt.Color(255, 255, 255));
        EditTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EditTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_38px.png"))); // NOI18N
        EditTitle.setText("Edit  Department Details");
        EditTitle.setIconTextGap(16);
        EditTitle.setOpaque(true);
        editAddPanel.add(EditTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 60));

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");
        jLabel1.setOpaque(true);
        editAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 100, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 250, 25));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Close_Window_17px.png"))); // NOI18N
        jLabel2.setText("Cancel");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 76, 25));

        jLabel6.setBackground(new java.awt.Color(51, 204, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_18px.png"))); // NOI18N
        jLabel6.setText("Save");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        editAddPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 76, 25));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 76, 25));

        txtName1.setBackground(new java.awt.Color(85, 153, 187));
        txtName1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setBorder(null);
        editAddPanel.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 250, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Id");
        jLabel7.setOpaque(true);
        editAddPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 25));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room No");
        jLabel8.setOpaque(true);
        editAddPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 100, 25));

        txtName2.setBackground(new java.awt.Color(85, 153, 187));
        txtName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName2.setForeground(new java.awt.Color(255, 255, 255));
        txtName2.setBorder(null);
        editAddPanel.add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 250, 25));

        jLabel9.setBackground(new java.awt.Color(0, 102, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("H.O.D");
        jLabel9.setOpaque(true);
        editAddPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 100, 25));

        txtName3.setBackground(new java.awt.Color(85, 153, 187));
        txtName3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName3.setForeground(new java.awt.Color(255, 255, 255));
        txtName3.setBorder(null);
        editAddPanel.add(txtName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 250, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Google_Web_Search_17px.png"))); // NOI18N
        jLabel3.setText("Search");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 88, 25));

        txtSearchName.setBackground(new java.awt.Color(85, 153, 187));
        txtSearchName.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchName.setBorder(null);
        txtSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtSearchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 100, 260, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_30px.png"))); // NOI18N
        jLabel4.setText("Departments");
        jLabel4.setIconTextGap(14);
        jLabel4.setOpaque(true);
        bannerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 60));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Name");
        jLabel5.setOpaque(true);
        bannerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 88, 25));

        jScrollPane1.setBackground(new java.awt.Color(0, 68, 102));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 68, 102), 1, true));

        tblDepartment.setBackground(new java.awt.Color(4, 74, 121));
        tblDepartment.setForeground(new java.awt.Color(255, 255, 255));
        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Room No", "H.O.D"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartment.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tblDepartment.setShowHorizontalLines(false);
        tblDepartment.setShowVerticalLines(false);
        tblDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentMouseClicked(evt);
            }
        });
        tblDepartment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDepartmentKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartment);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 770, 400));

        jLabel10.setBackground(new java.awt.Color(52, 203, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Add_New_17px.png"))); // NOI18N
        jLabel10.setText("Add");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 78, 25));

        jLabel11.setBackground(new java.awt.Color(0, 0, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Outbox_17px.png"))); // NOI18N
        jLabel11.setText("Export");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 78, 25));

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
        bannerPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 90, 25));

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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 78, 25));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAction
        search();
    }//GEN-LAST:event_searchAction

    private void tblDepartmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDepartmentKeyPressed
enableButton(true);
    }//GEN-LAST:event_tblDepartmentKeyPressed

    private void tblDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblDepartmentMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    search();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    act=ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        act=EDIT;
            enableEditAddPanel(true);    // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
     deactive();   // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      export();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        loadEdit();    // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        save();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        enableEditAddPanel(false);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel EditTitle;
    protected javax.swing.JPanel bannerPanel;
    private javax.swing.JLabel btnDeactive;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnReset;
    protected javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtSearchName;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean validateForm() {
        String name=txtName.getText();
        if(name==null || name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Name is required !");
            return false;
        }
        return true;
    }

    private void export() {
        ExportFile export=new ExportFile(tblDepartment, ExportFile.DEPARTMENT);
        export.toExcel();
    }

    

    

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import FileExport.ExportFile;
import Controls.Manager;
import Controls.StudentManager;
import Controls.Validate;
import MainObjects.BatchEntity;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import TableModel.Batch;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ClassMan extends javax.swing.JInternalFrame implements UIInterface{
    StudentManager studentManager=new StudentManager();
    private BatchEntity batchEntity=new BatchEntity();
    private Batch batch;
    private int act;
    /**
     * Creates new form ListBatch
     */
    public ClassMan() {
        initComponents();
    }
    public ClassMan(int w, int h) {
        initComponents();
        initUI();
        setSize(w, h);
    }
    @Override
    public void initUI(){
        enableButton(false);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        enableEditAddPanel(false);
        batchEntity.loadList(tblBatch);
    }
    @Override
    public void enableEditAddPanel(boolean b){
        if(b==false){
            tblBatch.setEnabled(true);
            txtName.setText("");
            dPic.setDate(null);
            
            editAddPanel.setVisible(false);
           
            bannerPanel.setVisible(true);
        }else{
            if(act==EDIT){
                labelAction.setText("Edit Batch");
                loadEdit();
            }else if(act==ADD){
                labelAction.setText("Add New Class");
            }
            tblBatch.setEnabled(false);
            btnReset.setVisible(true);
            
            
            bannerPanel.setVisible(false);
            editAddPanel.setVisible(true);
        }
    }
    public void save(){
        if(!validateForm()){
            return;
        }
        if(batch==null)
            batch=new Batch();
        batch.setName(txtName.getText());
        batch.setTime(dPic.getDate());
        batchEntity.setBatch(batch);
        int res=batchEntity.save();
        if(res==Manager.SUCCESS){
            initUI();
        }
        batchEntity.showMessage(res, this);
    }
    @Override
    public void loadEdit(){
        batch=batchEntity.findByID(batchEntity.getSelectID(tblBatch));
        txtName.setText(batch.getName());
        dPic.setDate(batch.getTime());
        txtName.setRequestFocusEnabled(true);
    }

//    public void add(){
//        String name=txtName.getText();
//        
//        if(!studentManager.checkUnique("name", "batch", name)){
//            JOptionPane.showMessageDialog(this, "Name already exist !");
//            return;
//        }
//        String time=txtDate.getText();
//        
//        String data[]=new String[]{ name, time };
//        Batch b=new Batch(name, batchEntity.parseDate(time));
//        batchEntity.setBatch(b);
//        int res=batchEntity.save();
//        if(res==Manager.SUCCESS){
//            initUI();
//            enableEditAddPanel(false);
//        }
//        studentManager.showMessage(res, this);
//    }
//
//    public void edit(){
//        String name=txtName.getText();
//        System.out.println(tblBatch.getValueAt(tblBatch.getSelectedRow(), 1));
//        if(!name.equalsIgnoreCase((String)tblBatch.getValueAt(tblBatch.getSelectedRow(), 1))){
//            if(!studentManager.checkUnique("name", "batch", name)){
//                JOptionPane.showMessageDialog(this, "Name already exist !");
//                return;
//            }
//        }
//        String time=txtDate.getText();
//
//        String data[]=new String[]{studentManager.getSelectID(tblBatch)+"", name, time};
//        int res=studentManager.editBatch(data);
//        studentManager.showMessage(res, this);
//        initUI();
//        enableEditAddPanel(false);
//    }
    @Override
    public void deactive(){
        int res=studentManager.deactiveBatch(studentManager.getSelectID(tblBatch));
        studentManager.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }

    @Override
    public void search(){
        String SQL="SELECT ID, name, date FROM batch WHERE status=1 ";
        if(!txtNameSearch.getText().isEmpty()){
            SQL+=" AND name like '%"+txtNameSearch.getText()+"%'";
        }
        studentManager.loadTable(SQL, tblBatch, Manager.BATCH_MODEL);
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

        editAddPanel = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        dPic = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        txtName2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bannerPanel = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBatch = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();

        setBackground(new java.awt.Color(224, 224, 255));
        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setForeground(new java.awt.Color(255, 255, 255));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(0, 102, 153));
        labelAction.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Training_36px.png"))); // NOI18N
        labelAction.setText("Add New Class");
        labelAction.setIconTextGap(24);
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1030, 50));

        jLabel1.setBackground(new java.awt.Color(1, 100, 151));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Title");
        jLabel1.setOpaque(true);
        editAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 88, 26));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 80, 26));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 70, 212, 26));

        dPic.setBackground(new java.awt.Color(255, 255, 255));
        editAddPanel.add(dPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 220, 26));

        jLabel7.setBackground(new java.awt.Color(1, 100, 151));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Date");
        jLabel7.setOpaque(true);
        editAddPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 26));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        editAddPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 80, 26));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_17px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setOpaque(true);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 80, 26));

        jLabel2.setBackground(new java.awt.Color(1, 100, 151));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Class");
        jLabel2.setOpaque(true);
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 90, 26));

        txtName1.setBackground(new java.awt.Color(85, 153, 187));
        txtName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setBorder(null);
        editAddPanel.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 210, 26));

        txtName2.setBackground(new java.awt.Color(85, 153, 187));
        txtName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName2.setForeground(new java.awt.Color(255, 255, 255));
        txtName2.setBorder(null);
        editAddPanel.add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 210, 26));

        jLabel3.setBackground(new java.awt.Color(1, 100, 151));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Room No");
        jLabel3.setOpaque(true);
        editAddPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 90, 26));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bannerPanelMouseClicked(evt);
            }
        });
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setBackground(new java.awt.Color(204, 0, 204));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 90, 26));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        txtNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 330, 26));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Training_36px.png"))); // NOI18N
        jLabel6.setText("Class Manager");
        jLabel6.setIconTextGap(24);
        jLabel6.setOpaque(true);
        bannerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1026, 60));

        jScrollPane1.setBackground(new java.awt.Color(224, 224, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jScrollPane1.setOpaque(false);

        tblBatch.setBackground(new java.awt.Color(4, 74, 121));
        tblBatch.setForeground(new java.awt.Color(255, 255, 255));
        tblBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBatch.setShowHorizontalLines(false);
        tblBatch.setShowVerticalLines(false);
        tblBatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBatchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBatch);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 700, 340));

        jLabel4.setBackground(new java.awt.Color(1, 100, 151));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");
        jLabel4.setOpaque(true);
        bannerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 90, 26));

        btnAdd.setBackground(new java.awt.Color(51, 204, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 90, 26));

        btnExport.setBackground(new java.awt.Color(0, 0, 204));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        bannerPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 90, 26));

        btnDeactive.setBackground(new java.awt.Color(255, 0, 0));
        btnDeactive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        bannerPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 100, 26));

        btnSearch.setBackground(new java.awt.Color(255, 102, 0));
        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
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
        bannerPanel.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 90, 26));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAction
        search();
    }//GEN-LAST:event_searchAction

    private void tblBatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBatchMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblBatchMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
export();     // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
       if(studentManager.confirmRemove(this, "Are you sure ?")==0){
            deactive();
       } // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void bannerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bannerPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bannerPanelMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
      if(studentManager.getSelectRow(tblBatch) !=null){
            act=EDIT;
            enableEditAddPanel(true);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
     act=ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);   // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
      save();  // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
     loadEdit();   // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
      enableEditAddPanel(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        search();   // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

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
    private com.toedter.calendar.JDateChooser dPic;
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JTable tblBatch;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
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
        if(Validate.isEmpty(name)){
            JOptionPane.showMessageDialog(this, "Name is required !");
            return false;
        }
        
        return true;
    }

    private void export() {
        ExportFile export=new ExportFile(tblBatch, ExportFile.BATCH);
        export.toExcel();
    }
}

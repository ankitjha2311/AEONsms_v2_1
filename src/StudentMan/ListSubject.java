/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import FileExport.ExportFile; 
import Controls.Manager;
import Controls.StudentManager;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListSubject extends javax.swing.JInternalFrame implements UIInterface{
    StudentManager studentManager=new StudentManager();
    private int act;
    /**
     * Creates new form ListPosition
     */
    public ListSubject() {
        initComponents();
        initUI();
    }
    public ListSubject(int w, int h) {
        initComponents();
        initUI();
        setSize(w, h);
    }
    @Override
    public void initUI(){
        enableButton(false);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        editAddPanel.setVisible(false);
        String SQL="SELECT ID, name FROM subject WHERE status=1 ";
        studentManager.loadTable(SQL, tblSubject, Manager.SUBJECT_MODEL);
    }
     @Override
    public void enableEditAddPanel(boolean b) {
        if(b==false){
            tblSubject.setEnabled(true);
            txtName.setText(null);
            
            editAddPanel.setVisible(false);
            
            bannerPanel.setVisible(true);
        }else{
            if(act==EDIT){
                labelAction.setText("Edit Subject");
                loadEdit();
            }else if(act==ADD){
                labelAction.setText("Add Subject");
            }
            tblSubject.setEnabled(false);
            editAddPanel.setVisible(true);
            btnReset.setVisible(true);
            
          
            bannerPanel.setVisible(false);
        }
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
        }
     }
    @Override
    public void loadEdit() {
        Vector row=studentManager.getSelectRow(tblSubject);
        txtName.setText(row.get(1).toString());
        txtName.setRequestFocusEnabled(true);
    }


    public void add() {
        String name=txtName.getText();
        
        if(!studentManager.checkUnique("name", "department", name)){
            JOptionPane.showMessageDialog(this, "Name already exist !");
            return;
        }
        
        String data[]=new String[]{ name};
        int res=studentManager.addSubject(data);
        if(res==Manager.SUCCESS){
            initUI();
            enableEditAddPanel(false);
        }else if(res==Manager.CONNECT_FAIL){
            JOptionPane.showMessageDialog(this, "Connect fail !");
        }else{
            JOptionPane.showMessageDialog(this, "Error !");
        }
        studentManager.showMessage(res, this);
    }

    public void edit() {
        String name=txtName.getText();
        if(!name.equalsIgnoreCase((String)tblSubject.getValueAt(tblSubject.getSelectedRow(), 1))){
            if(!studentManager.checkUnique("name", "department", name)){
                JOptionPane.showMessageDialog(this, "Name already exist !");
                return;
            }
        }
        String data[]=new String[]{studentManager.getSelectID(tblSubject)+"", name};
        int res=studentManager.editSubject(data);
        studentManager.showMessage(res, this);
        initUI();
        enableEditAddPanel(false);
    }

    @Override
    public void deactive() {
        int res=studentManager.deactiveSubject(studentManager.getSelectID(tblSubject));
        studentManager.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }


    @Override
    public void search(){
        String SQL="SELECT ID, name FROM subject WHERE status=1 ";
        if(!txtNameSearch.getText().isEmpty()){
            SQL+=" AND name like '%"+txtNameSearch.getText()+"%'";
        }
        studentManager.loadTable(SQL, tblSubject, Manager.SUBJECT_MODEL);
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
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtName3 = new javax.swing.JTextField();
        txtName4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bannerPanel = new javax.swing.JPanel();
        txtNameSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubject = new javax.swing.JTable();
        btnAdd = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(1, 100, 151));
        labelAction.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_30px.png"))); // NOI18N
        labelAction.setText("Add New Subject");
        labelAction.setIconTextGap(14);
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 3, 1040, 60));

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Title");
        jLabel2.setOpaque(true);
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 90, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 210, 25));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 90, 24));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px_3.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setOpaque(true);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        editAddPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 90, 24));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Reset_18px_1.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setOpaque(true);
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 90, 24));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID");
        jLabel5.setOpaque(true);
        editAddPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 90, 25));

        txtName1.setBackground(new java.awt.Color(85, 153, 187));
        txtName1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName1.setBorder(null);
        editAddPanel.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 210, 25));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Class");
        jLabel6.setOpaque(true);
        editAddPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 90, 25));

        txtName2.setBackground(new java.awt.Color(85, 153, 187));
        txtName2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtName2.setForeground(new java.awt.Color(255, 255, 255));
        txtName2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName2.setBorder(null);
        editAddPanel.add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 240, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Teacher");
        jLabel7.setOpaque(true);
        editAddPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 90, 25));

        txtName3.setBackground(new java.awt.Color(85, 153, 187));
        txtName3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtName3.setForeground(new java.awt.Color(255, 255, 255));
        txtName3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName3.setBorder(null);
        editAddPanel.add(txtName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 240, 25));

        txtName4.setBackground(new java.awt.Color(85, 153, 187));
        txtName4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtName4.setForeground(new java.awt.Color(255, 255, 255));
        txtName4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName4.setBorder(null);
        editAddPanel.add(txtName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 210, 25));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room No");
        jLabel8.setOpaque(true);
        editAddPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 90, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        txtNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 280, 25));

        jLabel4.setBackground(new java.awt.Color(1, 100, 151));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_30px.png"))); // NOI18N
        jLabel4.setText("Subjects");
        jLabel4.setIconTextGap(14);
        jLabel4.setOpaque(true);
        bannerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1040, 60));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));

        tblSubject.setBackground(new java.awt.Color(4, 74, 121));
        tblSubject.setForeground(new java.awt.Color(255, 255, 255));
        tblSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Subject Title", "Teacher", "Class", "Room No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubject.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblSubject.setShowHorizontalLines(false);
        tblSubject.setShowVerticalLines(false);
        tblSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSubject);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 740, 290));

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
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 88, 25));

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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 88, 25));

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
        bannerPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 100, 25));

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
        bannerPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 88, 25));

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
        bannerPanel.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 88, 25));

        jLabel18.setBackground(new java.awt.Color(0, 102, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Name");
        jLabel18.setOpaque(true);
        bannerPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 88, 25));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAction
       
    }//GEN-LAST:event_searchAction

    private void tblSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblSubjectMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        save();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        enableEditAddPanel(false);       // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        loadEdit();        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
 act=ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
 if(studentManager.getSelectRow(tblSubject) !=null){
            act=EDIT;
            enableEditAddPanel(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
 if(studentManager.confirmRemove(this, "Are you sure ?")==0){
            deactive();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
 export();        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        search();        // TODO add your handling code here:
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
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JTable tblSubject;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtName4;
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
        return true;
    }

    private void export() {
        ExportFile export =new ExportFile(tblSubject, ExportFile.SUBJECT);
        export.toExcel();
    }

   
}

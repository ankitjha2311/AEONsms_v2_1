package Employee;

import Controls.Manager;
import java.awt.Frame;
import java.util.Vector;
import javax.swing.JOptionPane;
import TableModel.Relative;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class RelationUpdate extends javax.swing.JDialog {
    private Relative relative;
    private Relative newRelative;
    Manager manager;
    /**
     * Creates new form StudentMoreInfoDialog
     * @param parent
     * @param modal
     * @param manager
     * @param data
     */
    public RelationUpdate(Frame parent, boolean modal, Manager manager, Vector data) {
        super(parent, modal);
        this.manager=manager;
        initComponents();
        if(data !=null){
            relative=new Relative(Integer.parseInt(data.get(0).toString()), (String)data.get(1), (String)data.get(2), (String)data.get(3), (String)data.get(4), (String)data.get(5), manager.formatGender(data.get(6).toString()));
        }
        initUI();
    }
    private void initUI(){
        setLocationRelativeTo(this);
        if(relative !=null){
            txtRelation.setText(relative.getRelation());
            txtName.setText(relative.getName());
            txtPhone.setText(relative.getPhone());
            txtAddress.setText(relative.getAddress());
            txtOccupation.setText(relative.getOccupation());
            comboGender.setSelectedItem(manager.parseGender(relative.getGender()));
        }
    }
    public Relative getRelaRelatives(){
        return newRelative;
    }
     private void save() {
         String relation=txtRelation.getText();
         if(relation ==null || relation.isEmpty()){
             JOptionPane.showMessageDialog(this, "Relation is required !");
         }
         String name=txtName.getText();
         if(name ==null || name.isEmpty()){
             JOptionPane.showMessageDialog(this, "Name is required !");
         }
         String phone=txtPhone.getText();
         String address=txtAddress.getText();
         String occupation=txtOccupation.getText();
         String gender=(String)comboGender.getSelectedItem();       
        if(relative==null){
            relative=new Relative(0, relation, name, phone, address, occupation, manager.formatGender(gender));
        }else{
            relative.setRelation(relation);
            relative.setName(name);
            relative.setPhone(phone);
            relative.setAddress(address);
            relative.setOccupation(occupation);
            relative.setGender(manager.formatGender(gender));
        }
        newRelative  = relative;
        dispose();
    }

    private void reset() {
        initUI();
    }

    private void cancel() {
        dispose();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRelation = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        comboGender = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Relation");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 25));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Name");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phone");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 90, 25));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Address");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 80));

        txtRelation.setBackground(new java.awt.Color(85, 153, 187));
        txtRelation.setBorder(null);
        jPanel1.add(txtRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 320, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setBorder(null);
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 320, 25));

        txtPhone.setBackground(new java.awt.Color(85, 153, 187));
        txtPhone.setBorder(null);
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 320, 25));

        jScrollPane1.setBorder(null);

        txtAddress.setBackground(new java.awt.Color(85, 153, 187));
        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setBorder(null);
        jScrollPane1.setViewportView(txtAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 320, 80));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Occupation");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gender");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, 23));

        txtOccupation.setBackground(new java.awt.Color(85, 153, 187));
        txtOccupation.setBorder(null);
        jPanel1.add(txtOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 320, 25));

        comboGender.setBackground(new java.awt.Color(85, 153, 187));
        comboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));
        comboGender.setBorder(null);
        jPanel1.add(comboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 120, 23));

        jLabel11.setBackground(new java.awt.Color(0, 68, 102));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Family_30px.png"))); // NOI18N
        jLabel11.setText("Family Update");
        jLabel11.setIconTextGap(14);
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 3, 540, 50));

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
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
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 88, 25));

        btnReset.setBackground(new java.awt.Color(0, 153, 204));
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
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 88, 25));

        btnSave.setBackground(new java.awt.Color(0, 153, 0));
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
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 88, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
save();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
     reset();        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
cancel();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private javax.swing.JComboBox comboGender;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRelation;
    // End of variables declaration//GEN-END:variables
}
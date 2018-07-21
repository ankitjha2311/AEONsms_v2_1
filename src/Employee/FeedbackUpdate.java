/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import MainObjects.StudentEntity;
import java.util.Vector;
import javax.swing.JOptionPane;
import TableModel.Feedback;
import TableModel.Student;
import StudentMan.StudentChooser; 

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class FeedbackUpdate extends javax.swing.JDialog {
    private Feedback feedback;
    private StudentEntity studentEntity;
    /**
     * Creates new form StudentMoreInfoDialog
     */
    public FeedbackUpdate(java.awt.Frame parent, boolean modal, Vector data) {
        super(parent, modal);
        this.studentEntity=new StudentEntity();
        initComponents();
        if(data !=null){
            this.feedback=new Feedback(Integer.parseInt(data.get(0).toString()), new Student(data.get(1).toString() , data.get(2).toString()), data.get(3).toString(), studentEntity.parseDate(data.get(4).toString()));
        }else{
            feedback=new Feedback();
        }
        
        initUI();
    }
    private void initUI(){
        setLocationRelativeTo(this);
        if(feedback.getStudent()==null){
            return;
        }
        labelNo.setText(feedback.getStudent().getNo());
        labelName.setText(feedback.getStudent().getName());
        txtContent.setText(feedback.getContent());
        dPic.setDate(feedback.getTime());
//        txtDate.setText(staffManager.formatDate(feedback.getTime()));
    }
    private void studentChooser(){
        StudentChooser chooser=new StudentChooser(null, true);
        chooser.setVisible(true);
        if(chooser.getChooser() >0){
            feedback.setStudent(studentEntity.findByID(chooser.getChooser()));
            labelNo.setText(feedback.getStudent().getNo());
            labelName.setText(feedback.getStudent().getName());
        }
    }
    private void save(){
        String content=txtContent.getText();
//        String date=txtDate.getText();
        if(feedback.getStudent()==null || feedback.getStudent().getID() <=0){
            JOptionPane.showMessageDialog(this, "You must choose Student !");
            return;
        }
        feedback.setContent(content);
//        feedback.setTime(staffManager.parseDate(date));
        feedback.setTime(dPic.getDate());
        dispose();
    }

    public Feedback getFeedback() {
        return feedback;
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
        btnChoose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Content = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextPane();
        labelName = new javax.swing.JLabel();
        labelNo = new javax.swing.JLabel();
        dPic = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChoose.setBackground(new java.awt.Color(0, 153, 0));
        btnChoose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnChoose.setForeground(new java.awt.Color(255, 255, 255));
        btnChoose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Browse_Folder_18px.png"))); // NOI18N
        btnChoose.setText("Select");
        btnChoose.setOpaque(true);
        btnChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChooseMouseClicked(evt);
            }
        });
        jPanel1.add(btnChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 90, 25));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Student name");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 25));

        Content.setBackground(new java.awt.Color(0, 102, 153));
        Content.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Content.setForeground(new java.awt.Color(255, 255, 255));
        Content.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Content.setText("Content");
        Content.setOpaque(true);
        jPanel1.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 90, 90));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 88, 25));

        jScrollPane1.setBorder(null);

        txtContent.setBackground(new java.awt.Color(85, 153, 187));
        txtContent.setBorder(null);
        txtContent.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtContent);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 400, 90));

        labelName.setBackground(new java.awt.Color(85, 153, 187));
        labelName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Student Name");
        labelName.setOpaque(true);
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 300, 25));

        labelNo.setBackground(new java.awt.Color(85, 153, 187));
        labelNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNo.setForeground(new java.awt.Color(255, 255, 255));
        labelNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNo.setText("No");
        labelNo.setOpaque(true);
        jPanel1.add(labelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 25));
        jPanel1.add(dPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 140, 25));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Feedback_30px_1.png"))); // NOI18N
        jLabel11.setText("Feedback Update");
        jLabel11.setIconTextGap(14);
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 50));

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 88, 25));

        btnReset.setBackground(new java.awt.Color(0, 153, 204));
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 88, 25));

        btnSave.setBackground(new java.awt.Color(0, 153, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 88, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Roll no.");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseMouseClicked
         studentChooser();
          // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
       save(); // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
initUI();        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
 feedback=null;
        dispose();
                // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Content;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnChoose;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private com.toedter.calendar.JDateChooser dPic;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNo;
    private javax.swing.JTextPane txtContent;
    // End of variables declaration//GEN-END:variables
}

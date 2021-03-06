/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import Controls.StudentManager;
import TableModel.Promotion;
import TableModel.Remark;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class RemarkDetail extends javax.swing.JDialog {
    private Remark remark;
    private StudentManager studentManager;
    /**
     * Creates new form StudentMoreInfoDialog
     */
    public RemarkDetail(java.awt.Frame parent, boolean modal, Remark remark, StudentManager studentManager) {
        super(parent, modal);
        this.remark=remark;
        this.studentManager=studentManager;
        initComponents();
        setLocationRelativeTo(this);
        initUI();
    }
    private void initUI(){
        labelStaffNo.setText(remark.getStaff().getNo()+"");
        labelStaffName.setText(remark.getStaff().getName());
        txtContent.setText(remark.getContent());
        labelTime.setText(studentManager.formatDate(remark.getTime()));
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelStaffName = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        labelStaffNo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Staff Name");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 90, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Content");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 90, 90));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Close");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 90, 25));

        labelStaffName.setBackground(new java.awt.Color(85, 153, 187));
        labelStaffName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelStaffName.setForeground(new java.awt.Color(255, 255, 255));
        labelStaffName.setText("Staff Name");
        labelStaffName.setOpaque(true);
        jPanel1.add(labelStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 390, 25));

        labelTime.setBackground(new java.awt.Color(85, 153, 187));
        labelTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTime.setForeground(new java.awt.Color(255, 255, 255));
        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTime.setText("Time");
        labelTime.setOpaque(true);
        jPanel1.add(labelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 280, 25));

        jScrollPane1.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane1.setBorder(null);

        txtContent.setEditable(false);
        txtContent.setBackground(new java.awt.Color(85, 153, 187));
        txtContent.setBorder(null);
        txtContent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtContent.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtContent);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 390, 90));

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff No");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 90, 25));

        labelStaffNo.setBackground(new java.awt.Color(85, 153, 187));
        labelStaffNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelStaffNo.setForeground(new java.awt.Color(255, 255, 255));
        labelStaffNo.setText("Staff No");
        labelStaffNo.setOpaque(true);
        jPanel1.add(labelStaffNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 390, 25));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Comments_30px.png"))); // NOI18N
        jLabel11.setText("Remark Detail");
        jLabel11.setToolTipText("");
        jLabel11.setIconTextGap(14);
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 616, 50));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Time");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 90, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelStaffName;
    private javax.swing.JLabel labelStaffNo;
    private javax.swing.JLabel labelTime;
    private javax.swing.JTextPane txtContent;
    // End of variables declaration//GEN-END:variables
}

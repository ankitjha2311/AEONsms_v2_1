/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import MainObjects.ExtraCurricularEntity;
import TableModel.ExtraCurricular;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ExtraCurricularDetail extends javax.swing.JDialog {
    private ExtraCurricular curricular;
    private ExtraCurricularEntity entity;
    /**
     * Creates new form StudentMoreInfoDialog
     */
    public ExtraCurricularDetail(java.awt.Frame parent, boolean modal, ExtraCurricular curricular) {
        super(parent, modal);
        this.curricular=curricular;
        this.entity=new ExtraCurricularEntity();
        initComponents();
        setLocationRelativeTo(this);
        initUI();
    }
    private void initUI(){
        labelName.setText(curricular.getName());
        labelLocation.setText(curricular.getName());
        labelStart.setText(entity.formatDate(curricular.getStart()));
        labelEnd.setText(entity.formatDate(curricular.getEnd()));
        labelNotes.setText(curricular.getNotes());
        
        
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
        labelName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelLocation = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelNotes = new javax.swing.JTextPane();
        labelStart = new javax.swing.JLabel();
        labelEnd = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(45, 129, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 90, 26));

        labelName.setBackground(new java.awt.Color(85, 153, 187));
        labelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Name");
        labelName.setOpaque(true);
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 320, 26));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Location");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 90, 26));

        labelLocation.setBackground(new java.awt.Color(85, 153, 187));
        labelLocation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelLocation.setForeground(new java.awt.Color(255, 255, 255));
        labelLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLocation.setText("location");
        labelLocation.setOpaque(true);
        jPanel1.add(labelLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 320, 26));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Start");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, 26));

        jLabel8.setBackground(new java.awt.Color(51, 204, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Ok_15px.png"))); // NOI18N
        jLabel8.setText("OK");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 90, 26));

        jLabel9.setBackground(new java.awt.Color(0, 102, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Notes");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 90, 100));

        jScrollPane2.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        labelNotes.setBackground(new java.awt.Color(85, 153, 187));
        labelNotes.setBorder(null);
        labelNotes.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(labelNotes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 320, 100));

        labelStart.setBackground(new java.awt.Color(85, 153, 187));
        labelStart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelStart.setForeground(new java.awt.Color(255, 255, 255));
        labelStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStart.setText("Start");
        labelStart.setOpaque(true);
        jPanel1.add(labelStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 320, 26));

        labelEnd.setBackground(new java.awt.Color(85, 153, 187));
        labelEnd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEnd.setForeground(new java.awt.Color(255, 255, 255));
        labelEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEnd.setText("End");
        labelEnd.setOpaque(true);
        jPanel1.add(labelEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 320, 26));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_40px.png"))); // NOI18N
        jLabel11.setText("Extra Curricular Detail");
        jLabel11.setIconTextGap(24);
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 570, 60));

        jLabel10.setBackground(new java.awt.Color(0, 102, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("End");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, 26));

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px_3.png"))); // NOI18N
        jLabel12.setText("Close");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 90, 26));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
     dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
     dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEnd;
    private javax.swing.JLabel labelLocation;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextPane labelNotes;
    private javax.swing.JLabel labelStart;
    // End of variables declaration//GEN-END:variables
}


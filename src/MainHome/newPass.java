/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHome;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class newPass extends javax.swing.JFrame {

    /**
     * Creates new form newPass
     */
    public newPass() {
        initComponents();
    }
int xMouse;
int yMouse;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_creAcc = new javax.swing.JPanel();
        mobno = new javax.swing.JLabel();
        usrnam = new javax.swing.JLabel();
        scqu = new javax.swing.JLabel();
        anssec = new javax.swing.JLabel();
        tf_usrnam = new javax.swing.JTextField();
        cb_scqu = new javax.swing.JComboBox<>();
        tf_anssq = new javax.swing.JTextField();
        tf_mobno = new javax.swing.JTextField();
        sap_usrnam = new javax.swing.JSeparator();
        sap_anssq = new javax.swing.JSeparator();
        sap_mob = new javax.swing.JSeparator();
        ico_usrnam = new javax.swing.JLabel();
        ico_pas = new javax.swing.JLabel();
        ico_scqu = new javax.swing.JLabel();
        ico_mobno = new javax.swing.JLabel();
        usrrol = new javax.swing.JLabel();
        cb_usrrol = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cancl = new javax.swing.JButton();
        mainFH = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pan_creAcc.setBackground(new java.awt.Color(0, 51, 102));
        pan_creAcc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobno.setBackground(new java.awt.Color(0, 51, 102));
        mobno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mobno.setForeground(new java.awt.Color(176, 224, 230));
        mobno.setText("Mobile Number");
        pan_creAcc.add(mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        usrnam.setBackground(new java.awt.Color(0, 51, 102));
        usrnam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrnam.setForeground(new java.awt.Color(176, 224, 230));
        usrnam.setText("Username ");
        pan_creAcc.add(usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 20));

        scqu.setBackground(new java.awt.Color(0, 51, 102));
        scqu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scqu.setForeground(new java.awt.Color(176, 224, 230));
        scqu.setText("Security Question");
        pan_creAcc.add(scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        anssec.setBackground(new java.awt.Color(0, 51, 102));
        anssec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        anssec.setForeground(new java.awt.Color(176, 224, 230));
        anssec.setText("Answer ");
        pan_creAcc.add(anssec, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        tf_usrnam.setBackground(new java.awt.Color(0, 51, 102));
        tf_usrnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_usrnam.setForeground(new java.awt.Color(255, 255, 255));
        tf_usrnam.setBorder(null);
        pan_creAcc.add(tf_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 200, 20));

        cb_scqu.setBackground(new java.awt.Color(0, 51, 102));
        cb_scqu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_scqu.setForeground(new java.awt.Color(255, 255, 255));
        cb_scqu.setBorder(null);
        pan_creAcc.add(cb_scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 240, 20));

        tf_anssq.setBackground(new java.awt.Color(0, 51, 102));
        tf_anssq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_anssq.setForeground(new java.awt.Color(255, 255, 255));
        tf_anssq.setBorder(null);
        pan_creAcc.add(tf_anssq, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 215, 20));

        tf_mobno.setBackground(new java.awt.Color(0, 51, 102));
        tf_mobno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_mobno.setForeground(new java.awt.Color(255, 255, 255));
        tf_mobno.setBorder(null);
        pan_creAcc.add(tf_mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 220, 20));

        sap_usrnam.setBackground(new java.awt.Color(0, 51, 102));
        sap_usrnam.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 10));

        sap_anssq.setBackground(new java.awt.Color(0, 51, 102));
        sap_anssq.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_anssq, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 240, 11));

        sap_mob.setBackground(new java.awt.Color(0, 51, 102));
        sap_mob.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 240, 11));

        ico_usrnam.setBackground(new java.awt.Color(51, 204, 255));
        ico_usrnam.setEnabled(false);
        pan_creAcc.add(ico_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        ico_pas.setBackground(new java.awt.Color(51, 204, 255));
        ico_pas.setEnabled(false);
        pan_creAcc.add(ico_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        ico_scqu.setBackground(new java.awt.Color(51, 204, 255));
        ico_scqu.setEnabled(false);
        pan_creAcc.add(ico_scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 30, 30));

        ico_mobno.setBackground(new java.awt.Color(51, 204, 255));
        ico_mobno.setEnabled(false);
        pan_creAcc.add(ico_mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        usrrol.setBackground(new java.awt.Color(0, 51, 102));
        usrrol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrrol.setForeground(new java.awt.Color(176, 224, 230));
        usrrol.setText("UserRole");
        pan_creAcc.add(usrrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        cb_usrrol.setBackground(new java.awt.Color(0, 51, 102));
        cb_usrrol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_usrrol.setForeground(new java.awt.Color(255, 255, 255));
        cb_usrrol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_usrrol.setBorder(null);
        pan_creAcc.add(cb_usrrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 240, 20));

        jButton1.setText("Clear");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pan_creAcc.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jButton2.setText("Next");
        jButton2.setBorderPainted(false);
        pan_creAcc.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));

        cancl.setText("Cancel");
        cancl.setBorderPainted(false);
        cancl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canclActionPerformed(evt);
            }
        });
        pan_creAcc.add(cancl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        mainFH.setBackground(new java.awt.Color(0, 102, 153));
        mainFH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainFH.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mainFH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainFHMouseDragged(evt);
            }
        });
        mainFH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainFHMousePressed(evt);
            }
        });
        mainFH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainFHKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Cancel_18px_1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Minus_21px_1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        exit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 255, 255));
        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Identification_Documents_19px_2.png"))); // NOI18N
        exit1.setText("Reset Your Password");
        exit1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                exit1MouseDragged(evt);
            }
        });
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout mainFHLayout = new javax.swing.GroupLayout(mainFH);
        mainFH.setLayout(mainFHLayout);
        mainFHLayout.setHorizontalGroup(
            mainFHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFHLayout.createSequentialGroup()
                .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        mainFHLayout.setVerticalGroup(
            mainFHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mainFHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(exit1)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pan_creAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainFH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 520, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 20, Short.MAX_VALUE)
                    .addComponent(pan_creAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void canclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canclActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_canclActionPerformed

    private void exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit1MouseClicked

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed
 xMouse=evt.getX();
        yMouse=evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_exit1MousePressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Cancel_18px.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Cancel_18px_1.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(this.ICONIFIED);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Minus_21px_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventManImg/icons8_Minus_21px_1.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void mainFHMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);// TODO add your handling code here:
    }//GEN-LAST:event_mainFHMouseDragged

    private void mainFHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_mainFHMousePressed

    private void mainFHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainFHKeyPressed

    }//GEN-LAST:event_mainFHKeyPressed

    private void exit1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseDragged
      int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);  // TODO add your handling code here:
    }//GEN-LAST:event_exit1MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anssec;
    private javax.swing.JButton cancl;
    private javax.swing.JComboBox<String> cb_scqu;
    private javax.swing.JComboBox<String> cb_usrrol;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel ico_mobno;
    private javax.swing.JLabel ico_pas;
    private javax.swing.JLabel ico_scqu;
    private javax.swing.JLabel ico_usrnam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainFH;
    private javax.swing.JLabel mobno;
    private javax.swing.JPanel pan_creAcc;
    private javax.swing.JSeparator sap_anssq;
    private javax.swing.JSeparator sap_mob;
    private javax.swing.JSeparator sap_usrnam;
    private javax.swing.JLabel scqu;
    private javax.swing.JTextField tf_anssq;
    private javax.swing.JTextField tf_mobno;
    private javax.swing.JTextField tf_usrnam;
    private javax.swing.JLabel usrnam;
    private javax.swing.JLabel usrrol;
    // End of variables declaration//GEN-END:variables
}
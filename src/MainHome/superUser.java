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
public class superUser extends javax.swing.JFrame {

    /**
     * Creates new form superUser
     */
    public superUser() {
   
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_creAcc = new javax.swing.JPanel();
        mobno = new javax.swing.JLabel();
        usrnam = new javax.swing.JLabel();
        usrpass = new javax.swing.JLabel();
        usrpassval = new javax.swing.JLabel();
        scqu = new javax.swing.JLabel();
        anssec = new javax.swing.JLabel();
        tf_usrnam = new javax.swing.JTextField();
        tf_pas = new javax.swing.JPasswordField();
        pf_conpass = new javax.swing.JPasswordField();
        cb_scqu = new javax.swing.JComboBox<>();
        tf_anssq = new javax.swing.JTextField();
        tf_mobno = new javax.swing.JTextField();
        sap_usrnam = new javax.swing.JSeparator();
        sap_pas = new javax.swing.JSeparator();
        sap_conpas = new javax.swing.JSeparator();
        sap_anssq = new javax.swing.JSeparator();
        sap_mob = new javax.swing.JSeparator();
        ico_usrnam = new javax.swing.JLabel();
        ico_pas = new javax.swing.JLabel();
        ico_scqu = new javax.swing.JLabel();
        ico_mobno = new javax.swing.JLabel();
        usrrol = new javax.swing.JLabel();
        cb_usrrol = new javax.swing.JComboBox<>();
        sap_creAcc = new javax.swing.JSeparator();
        creAcc = new javax.swing.JLabel();
        but_next = new javax.swing.JButton();
        but_creusr = new javax.swing.JButton();
        but_prev = new javax.swing.JButton();
        mainFH = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 20));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_creAcc.setBackground(new java.awt.Color(0, 31, 58));
        pan_creAcc.setEnabled(false);
        pan_creAcc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobno.setBackground(new java.awt.Color(51, 204, 255));
        mobno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mobno.setForeground(new java.awt.Color(255, 255, 255));
        mobno.setText("Mobile Number");
        pan_creAcc.add(mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        usrnam.setBackground(new java.awt.Color(51, 204, 255));
        usrnam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrnam.setForeground(new java.awt.Color(255, 255, 255));
        usrnam.setText("Username ");
        pan_creAcc.add(usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, 20));

        usrpass.setBackground(new java.awt.Color(51, 204, 255));
        usrpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrpass.setForeground(new java.awt.Color(255, 255, 255));
        usrpass.setText("Password ");
        pan_creAcc.add(usrpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        usrpassval.setBackground(new java.awt.Color(0, 102, 153));
        usrpassval.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrpassval.setForeground(new java.awt.Color(255, 255, 255));
        usrpassval.setText("Confirm Password ");
        pan_creAcc.add(usrpassval, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        scqu.setBackground(new java.awt.Color(51, 204, 255));
        scqu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scqu.setForeground(new java.awt.Color(255, 255, 255));
        scqu.setText("Security Question");
        pan_creAcc.add(scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        anssec.setBackground(new java.awt.Color(51, 204, 255));
        anssec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        anssec.setForeground(new java.awt.Color(255, 255, 255));
        anssec.setText("Answer ");
        pan_creAcc.add(anssec, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        tf_usrnam.setBackground(new java.awt.Color(0, 31, 58));
        tf_usrnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_usrnam.setForeground(new java.awt.Color(255, 255, 255));
        tf_usrnam.setBorder(null);
        pan_creAcc.add(tf_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 200, 20));

        tf_pas.setBackground(new java.awt.Color(0, 31, 58));
        tf_pas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_pas.setForeground(new java.awt.Color(255, 255, 255));
        tf_pas.setBorder(null);
        pan_creAcc.add(tf_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 215, 20));

        pf_conpass.setBackground(new java.awt.Color(0, 31, 58));
        pf_conpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pf_conpass.setForeground(new java.awt.Color(255, 255, 255));
        pf_conpass.setBorder(null);
        pf_conpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_conpassActionPerformed(evt);
            }
        });
        pan_creAcc.add(pf_conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 215, 20));

        cb_scqu.setBackground(new java.awt.Color(0, 31, 58));
        cb_scqu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_scqu.setForeground(new java.awt.Color(255, 255, 255));
        cb_scqu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What was your childhood nickname?", "What is the name of your favorite childhood friend?", "In what city or town did your mother and father meet?", "What is the middle name of your oldest child?", "What is your favorite team?", "What is your favorite movie?", "What was your favorite sport in high school?", "What was your favorite food as a child?" }));
        cb_scqu.setSelectedItem(null);
        cb_scqu.setBorder(null);
        pan_creAcc.add(cb_scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 240, 20));

        tf_anssq.setBackground(new java.awt.Color(0, 31, 58));
        tf_anssq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_anssq.setForeground(new java.awt.Color(255, 255, 255));
        tf_anssq.setBorder(null);
        tf_anssq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_anssqActionPerformed(evt);
            }
        });
        pan_creAcc.add(tf_anssq, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 215, 20));

        tf_mobno.setBackground(new java.awt.Color(0, 31, 58));
        tf_mobno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_mobno.setForeground(new java.awt.Color(255, 255, 255));
        tf_mobno.setBorder(null);
        pan_creAcc.add(tf_mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 220, 20));

        sap_usrnam.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 240, 10));

        sap_pas.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 240, 10));

        sap_conpas.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_conpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 240, 11));

        sap_anssq.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_anssq, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 240, 11));

        sap_mob.setForeground(new java.awt.Color(255, 255, 255));
        pan_creAcc.add(sap_mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 240, 11));

        ico_usrnam.setBackground(new java.awt.Color(51, 204, 255));
        ico_usrnam.setEnabled(false);
        pan_creAcc.add(ico_usrnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        ico_pas.setBackground(new java.awt.Color(51, 204, 255));
        ico_pas.setEnabled(false);
        pan_creAcc.add(ico_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        ico_scqu.setBackground(new java.awt.Color(51, 204, 255));
        pan_creAcc.add(ico_scqu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 30, 30));

        ico_mobno.setBackground(new java.awt.Color(51, 204, 255));
        ico_mobno.setEnabled(false);
        pan_creAcc.add(ico_mobno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        usrrol.setBackground(new java.awt.Color(51, 204, 255));
        usrrol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usrrol.setForeground(new java.awt.Color(255, 255, 255));
        usrrol.setText("UserRole");
        pan_creAcc.add(usrrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, -1, -1));

        cb_usrrol.setBackground(new java.awt.Color(0, 31, 58));
        cb_usrrol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_usrrol.setForeground(new java.awt.Color(255, 255, 255));
        cb_usrrol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator" }));
        cb_usrrol.setBorder(null);
        pan_creAcc.add(cb_usrrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 240, 20));
        pan_creAcc.add(sap_creAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, 10));

        creAcc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        creAcc.setForeground(new java.awt.Color(255, 255, 255));
        creAcc.setText("Create System User");
        pan_creAcc.add(creAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        but_next.setBackground(new java.awt.Color(0, 102, 0));
        but_next.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        but_next.setForeground(new java.awt.Color(255, 255, 255));
        but_next.setText("Next");
        but_next.setBorder(null);
        but_next.setBorderPainted(false);
        but_next.setEnabled(false);
        but_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_nextActionPerformed(evt);
            }
        });
        pan_creAcc.add(but_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 50, 20));

        but_creusr.setBackground(new java.awt.Color(0, 102, 255));
        but_creusr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        but_creusr.setForeground(new java.awt.Color(255, 255, 255));
        but_creusr.setText("Create User");
        but_creusr.setBorder(null);
        but_creusr.setBorderPainted(false);
        but_creusr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_creusrActionPerformed(evt);
            }
        });
        pan_creAcc.add(but_creusr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 90, 20));

        but_prev.setBackground(new java.awt.Color(204, 0, 51));
        but_prev.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        but_prev.setForeground(new java.awt.Color(255, 255, 255));
        but_prev.setText("Prev");
        but_prev.setBorder(null);
        but_prev.setBorderPainted(false);
        pan_creAcc.add(but_prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 50, 20));

        getContentPane().add(pan_creAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 640));

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

        javax.swing.GroupLayout mainFHLayout = new javax.swing.GroupLayout(mainFH);
        mainFH.setLayout(mainFHLayout);
        mainFHLayout.setHorizontalGroup(
            mainFHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFHLayout.createSequentialGroup()
                .addGap(0, 343, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        mainFHLayout.setVerticalGroup(
            mainFHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(mainFH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents




    private void pf_conpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_conpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_conpassActionPerformed

    private void tf_anssqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_anssqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_anssqActionPerformed

    private void but_creusrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_creusrActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_but_creusrActionPerformed

    private void but_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_nextActionPerformed

       
    }//GEN-LAST:event_but_nextActionPerformed

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
int yMouse;
int xMouse;

    private void mainFHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainFHKeyPressed

    }//GEN-LAST:event_mainFHKeyPressed

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
            java.util.logging.Logger.getLogger(superUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(superUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(superUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(superUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new superUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anssec;
    private javax.swing.JButton but_creusr;
    private javax.swing.JButton but_next;
    private javax.swing.JButton but_prev;
    private javax.swing.JComboBox<String> cb_scqu;
    private javax.swing.JComboBox<String> cb_usrrol;
    private javax.swing.JLabel creAcc;
    private javax.swing.JLabel ico_mobno;
    private javax.swing.JLabel ico_pas;
    private javax.swing.JLabel ico_scqu;
    private javax.swing.JLabel ico_usrnam;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainFH;
    private javax.swing.JLabel mobno;
    private javax.swing.JPanel pan_creAcc;
    private javax.swing.JPasswordField pf_conpass;
    private javax.swing.JSeparator sap_anssq;
    private javax.swing.JSeparator sap_conpas;
    private javax.swing.JSeparator sap_creAcc;
    private javax.swing.JSeparator sap_mob;
    private javax.swing.JSeparator sap_pas;
    private javax.swing.JSeparator sap_usrnam;
    private javax.swing.JLabel scqu;
    private javax.swing.JTextField tf_anssq;
    private javax.swing.JTextField tf_mobno;
    private javax.swing.JPasswordField tf_pas;
    private javax.swing.JTextField tf_usrnam;
    private javax.swing.JLabel usrnam;
    private javax.swing.JLabel usrpass;
    private javax.swing.JLabel usrpassval;
    private javax.swing.JLabel usrrol;
    // End of variables declaration//GEN-END:variables
}

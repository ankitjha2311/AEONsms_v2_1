/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHome;

import Controls.Authentication;
import Controls.Manager;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Employee.ListDepartment;
import Employee.ListPosition;
import AdminMan.ListUser;
import Employee.ListStaff;
import StudentMan.ClassMan;
import StudentMan.ListBatch;
import StudentMan.ListExtraCurricular;
import StudentMan.ListStudent;
import StudentMan.ListSubject;
import StudentMan.ListMark;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class Main extends javax.swing.JFrame {

    Authentication authentication;
    
  
   public static final int WIDTH = 1219;
    public static final int HEIGHT = 713; 
  int depart;
    /**
     * Creates new form Main
     */
    public Main(Authentication authentication) {
        this.authentication = authentication;
        initComponents();
       
        enableComponent(authentication.getRole());
        initUI();
    }
    int xMouse;
     int   yMouse;
    private void initUI(){
       setSize(WIDTH,HEIGHT);
        mainPane.setSize(1070,680);
       
        showAccountInfo();
    }
    private static ImageIcon loadImageIcon(String path) {
        URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }

    private void refreshMainPane() {
        mainPane.removeAll();
        mainPane.repaint();
    }

    private void enableComponent(int pess) {
        Admin.setVisible(false); 
        StuMan.setVisible(false);
        EmpMan.setVisible(false);
        SideEmp.setVisible(false);
        SideAdmin.setVisible(false);
        SideStu.setVisible(false);
                SideStu1.setVisible(false);

                SideEmp1.setVisible(false);

        
        if (pess == Authentication.HEADER_ADMIN) {
  
           Admin.setVisible(true);    
           aeon.setText("AeonSMS V_1.0 Administrative Manager");
        } else if (pess == Authentication.STAFF_MANAGER) {
         
        EmpMan.setVisible(true);
                   aeon.setText("AeonSMS V_1.0 Employee Manager");  
        } else if (pess == Authentication.STUDENT_MANAGER) {
      
       StuMan.setVisible(true);
                  aeon.setText("AeonSMS V_1.0 Student Manager");  
        }
    }
private void adminCom(boolean b){
  mainPane.setVisible(b);
  SideAdmin.setVisible(b);
  Admin.setVisible(!b);
}
private void adminComS(boolean b){
  mainPane.setVisible(b);
  SideStu1.setVisible(b);
  Admin.setVisible(!b);
}
private void adminComE(boolean b){
  mainPane.setVisible(b);
  SideEmp1.setVisible(b);
  Admin.setVisible(!b);
}
private void stuCom(boolean b){
   mainPane.setVisible(b);
  SideStu.setVisible(b);
  StuMan.setVisible(!b); 
}
private void empCom(boolean b){
 mainPane.setVisible(b);
  SideEmp.setVisible(b);
  EmpMan.setVisible(!b);   
}
    private void showComponent(int comp) {
        switch (comp) {
            case Manager.USER:
                setTitle("Manage User");
                ListUser users = new ListUser(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(users);
                users.show();
                break;     
            case Manager.STAFF:
                setTitle("Manage Staff");
                ListStaff listStaff = new ListStaff(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(listStaff);
                listStaff.show();
                break;
            case Manager.STUDENT:
                setTitle("Manage Student");
                ListStudent listStudent = new ListStudent(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(listStudent);
                listStudent.show();
               
                break;
            case Manager.SUBJECT:
                setTitle("Manage Subject");
                ListSubject listSubject = new ListSubject(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(listSubject);
                listSubject.show();
                break;
            case Manager.BATCH:
                setTitle("Manage Batch");
                ListBatch batchs = new ListBatch(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(batchs);
                batchs.show();
                break;
            case Manager.DEPARTMENT:
                setTitle("Manage Department");
                ListDepartment department = new ListDepartment(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(department);
                department.show();
                break;
          
                  
               
                
            case Manager.POSITION:
                setTitle("Manage Position");
                ListPosition listPosition = new ListPosition(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(listPosition);
                listPosition.show();
                break;
            case Manager.EXTRA_CURRICULAR:
                setTitle("Manage Extra curricular");
                ListExtraCurricular extraCurricular = new ListExtraCurricular(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(extraCurricular);
                extraCurricular.show();
                break;
            case Manager.MARK:
                setTitle("Manage Mark");
                ListMark searchMark = new ListMark(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(searchMark);
                searchMark.show(); 
                break;
                
            
            
               
            default:
                break;
        }
    }

    private void showDeactived(int type) {
        refreshMainPane();
        ListDeactived listDeactived = null;
        switch (type) {
            case Manager.USER:
                setTitle("Deactived User");
                break;
            case Manager.DEPARTMENT:
                setTitle("Deactived Department");
                break;
            case Manager.POSITION:
                setTitle("Deactived Position");
                break;
            case Manager.STAFF:
                setTitle("Deactived Staff");
                break;
            case Manager.STUDENT:
                setTitle("Deactived Student");
                break;
            case Manager.SUBJECT:
                setTitle("Deactived Subject");
                break;
            case Manager.BATCH:
                setTitle("Deactived Batch");
                break;
            case Manager.EXTRA_CURRICULAR:
                setTitle("Deactived Extra curricular");
                break;
                
            default:
                break;
        }
        listDeactived = new ListDeactived(type);
        mainPane.add(listDeactived);
        listDeactived.show();
    }
    private void showAccountInfo(){
        AccountInfo accountInfo=new AccountInfo(WIDTH, HEIGHT, authentication);
        setTitle("Account Infomation");
        refreshMainPane();
        mainPane.add(accountInfo);
        accountInfo.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SideAdmin = new javax.swing.JPanel();
        UsManButS = new javax.swing.JLabel();
        miListStaff2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        miDeactStaff4 = new javax.swing.JLabel();
        miDeactStaff5 = new javax.swing.JLabel();
        mainFH = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        miLogout = new javax.swing.JLabel();
        miInfo = new javax.swing.JLabel();
        miChangePassword = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        aeon = new javax.swing.JLabel();
        mainPane = new javax.swing.JDesktopPane();
        Admin = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel207 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel296 = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jLabel324 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel364 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        jLabel366 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel367 = new javax.swing.JLabel();
        jLabel368 = new javax.swing.JLabel();
        jLabel369 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel371 = new javax.swing.JLabel();
        jLabel372 = new javax.swing.JLabel();
        jLabel387 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel374 = new javax.swing.JLabel();
        jLabel375 = new javax.swing.JLabel();
        jLabel384 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel377 = new javax.swing.JLabel();
        jLabel378 = new javax.swing.JLabel();
        jLabel385 = new javax.swing.JLabel();
        jLabel386 = new javax.swing.JLabel();
        jLabel379 = new javax.swing.JLabel();
        jLabel380 = new javax.swing.JLabel();
        jLabel381 = new javax.swing.JLabel();
        StuMan = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel281 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jLabel287 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel290 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel311 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel370 = new javax.swing.JLabel();
        jLabel373 = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel382 = new javax.swing.JLabel();
        jLabel383 = new javax.swing.JLabel();
        jLabel388 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel389 = new javax.swing.JLabel();
        jLabel390 = new javax.swing.JLabel();
        jLabel391 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel392 = new javax.swing.JLabel();
        jLabel393 = new javax.swing.JLabel();
        jLabel394 = new javax.swing.JLabel();
        jLabel395 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        EmpMan = new javax.swing.JPanel();
        jLabel263 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel329 = new javax.swing.JLabel();
        jLabel330 = new javax.swing.JLabel();
        jLabel331 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel332 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jLabel334 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        jLabel336 = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel342 = new javax.swing.JLabel();
        jLabel343 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel347 = new javax.swing.JLabel();
        jLabel348 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel338 = new javax.swing.JLabel();
        jLabel339 = new javax.swing.JLabel();
        jLabel340 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel341 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jLabel359 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel345 = new javax.swing.JLabel();
        jLabel346 = new javax.swing.JLabel();
        jLabel351 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel353 = new javax.swing.JLabel();
        jLabel354 = new javax.swing.JLabel();
        jLabel360 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel355 = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        jLabel357 = new javax.swing.JLabel();
        SideEmp = new javax.swing.JPanel();
        miChangePassword7 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        miDeactStaff11 = new javax.swing.JLabel();
        miDeactStaff12 = new javax.swing.JLabel();
        miDeactStaff13 = new javax.swing.JLabel();
        miChangePassword8 = new javax.swing.JLabel();
        miChangePassword9 = new javax.swing.JLabel();
        SideStu1 = new javax.swing.JPanel();
        miChangePassword10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        miDeactStaff15 = new javax.swing.JLabel();
        miDeactStaff16 = new javax.swing.JLabel();
        miDeactStaff17 = new javax.swing.JLabel();
        miListStaff9 = new javax.swing.JLabel();
        miChangePassword11 = new javax.swing.JLabel();
        miDeactStaff18 = new javax.swing.JLabel();
        miListStaff10 = new javax.swing.JLabel();
        miChangePassword12 = new javax.swing.JLabel();
        miListStaff13 = new javax.swing.JLabel();
        miListStaff15 = new javax.swing.JLabel();
        SideEmp1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        miDeactStaff21 = new javax.swing.JLabel();
        miChangePassword19 = new javax.swing.JLabel();
        miDeactStaff23 = new javax.swing.JLabel();
        miDeactStaff29 = new javax.swing.JLabel();
        miChangePassword20 = new javax.swing.JLabel();
        miChangePassword21 = new javax.swing.JLabel();
        SideStu = new javax.swing.JPanel();
        miChangePassword16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        miDeactStaff25 = new javax.swing.JLabel();
        miDeactStaff26 = new javax.swing.JLabel();
        miDeactStaff27 = new javax.swing.JLabel();
        miListStaff17 = new javax.swing.JLabel();
        miChangePassword17 = new javax.swing.JLabel();
        miDeactStaff28 = new javax.swing.JLabel();
        miListStaff18 = new javax.swing.JLabel();
        miChangePassword18 = new javax.swing.JLabel();
        miListStaff19 = new javax.swing.JLabel();
        miListStaff20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("School Management System");
        setBackground(new java.awt.Color(0, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 0));
        setMinimumSize(new java.awt.Dimension(1200, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SideAdmin.setBackground(new java.awt.Color(8, 107, 156));
        SideAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsManButS.setBackground(new java.awt.Color(45, 129, 171));
        UsManButS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UsManButS.setForeground(new java.awt.Color(255, 255, 255));
        UsManButS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Groups_24px.png"))); // NOI18N
        UsManButS.setText("  Users Management");
        UsManButS.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        UsManButS.setOpaque(true);
        UsManButS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsManButSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UsManButSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UsManButSMouseExited(evt);
            }
        });
        SideAdmin.add(UsManButS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 40));

        miListStaff2.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff2.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Remove_User_Group_Man_Man_24px.png"))); // NOI18N
        miListStaff2.setText("  Deactivate Users");
        miListStaff2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miListStaff2.setOpaque(true);
        miListStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff2MouseClicked(evt);
            }
        });
        SideAdmin.add(miListStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 40));

        jLabel5.setBackground(new java.awt.Color(45, 129, 171));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_24px.png"))); // NOI18N
        jLabel5.setText("  Home");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        SideAdmin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        miDeactStaff4.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff4.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Database_Administrator_24px.png"))); // NOI18N
        miDeactStaff4.setText("  Database Settings");
        miDeactStaff4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff4.setOpaque(true);
        miDeactStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff4MouseClicked(evt);
            }
        });
        SideAdmin.add(miDeactStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 40));

        miDeactStaff5.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff5.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px.png"))); // NOI18N
        miDeactStaff5.setText("  About");
        miDeactStaff5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff5.setOpaque(true);
        miDeactStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff5MouseClicked(evt);
            }
        });
        SideAdmin.add(miDeactStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 210, 40));

        getContentPane().add(SideAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 700));

        mainFH.setBackground(new java.awt.Color(8, 107, 156));
        mainFH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainFH.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mainFH.setPreferredSize(new java.awt.Dimension(1220, 20));
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
        mainFH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        mainFH.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 20, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_22px.png"))); // NOI18N
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        mainFH.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 20, 20));

        miLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        miLogout.setForeground(new java.awt.Color(255, 255, 255));
        miLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        miLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Logout_Rounded_Up_15px.png"))); // NOI18N
        miLogout.setText("Logout");
        miLogout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        miLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miLogoutMouseClicked(evt);
            }
        });
        mainFH.add(miLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 70, 20));

        miInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        miInfo.setForeground(new java.awt.Color(255, 255, 255));
        miInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_15px.png"))); // NOI18N
        miInfo.setText("info");
        miInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miInfoMouseClicked(evt);
            }
        });
        mainFH.add(miInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 60, 20));

        miChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        miChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Password_Reset_15px.png"))); // NOI18N
        miChangePassword.setText("    Change Password");
        miChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePasswordMouseClicked(evt);
            }
        });
        mainFH.add(miChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 140, 20));

        UserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_15px.png"))); // NOI18N
        UserName.setText("  UserName");
        UserName.setIconTextGap(14);
        UserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserNameMouseClicked(evt);
            }
        });
        mainFH.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 190, 20));

        aeon.setBackground(new java.awt.Color(4, 74, 121));
        aeon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aeon.setForeground(new java.awt.Color(255, 255, 255));
        aeon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aeon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_School_16px.png"))); // NOI18N
        aeon.setText("Aeon SMS V_1.0");
        aeon.setIconTextGap(14);
        aeon.setOpaque(true);
        aeon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aeonMouseClicked(evt);
            }
        });
        mainFH.add(aeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 20));

        getContentPane().add(mainFH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 20));

        mainPane.setVisible(false);
        mainPane.setBackground(new java.awt.Color(45, 129, 171));
        mainPane.setPreferredSize(new java.awt.Dimension(1010, 700));

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 700));

        StuMan.setVisible(false);
        Admin.setBackground(new java.awt.Color(0, 102, 153));
        Admin.setMinimumSize(new java.awt.Dimension(1234, 530));
        Admin.setPreferredSize(new java.awt.Dimension(1210, 700));
        Admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Admin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 10, 60));

        jLabel207.setBackground(new java.awt.Color(4, 74, 121));
        jLabel207.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Conference_60px.png"))); // NOI18N
        jLabel207.setText("     Administrator                      School Management System");
        jLabel207.setOpaque(true);
        Admin.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 60));

        jPanel74.setBackground(new java.awt.Color(45, 129, 171));
        jPanel74.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel74MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel74MouseMoved(evt);
            }
        });
        jPanel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel74MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel74MouseExited(evt);
            }
        });

        jLabel269.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_38px.png"))); // NOI18N

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(255, 255, 255));
        jLabel270.setText("Student ");

        jLabel271.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(255, 255, 255));
        jLabel271.setText("Infomation");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel270, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel74Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel269)))
                        .addGap(17, 17, 17))
                    .addComponent(jLabel271, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel269)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel270)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel271)
                .addGap(22, 22, 22))
        );

        Admin.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, 120));

        jPanel84.setBackground(new java.awt.Color(45, 129, 171));
        jPanel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel84MouseClicked(evt);
            }
        });

        jLabel272.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Groups_38px.png"))); // NOI18N

        jLabel273.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel273.setForeground(new java.awt.Color(255, 255, 255));
        jLabel273.setText("Batch");

        jLabel274.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel274.setForeground(new java.awt.Color(255, 255, 255));
        jLabel274.setText(" Management");

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel274))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel272)
                            .addComponent(jLabel273))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel272)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel273)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel274)
                .addGap(22, 22, 22))
        );

        Admin.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, 120));

        jPanel85.setBackground(new java.awt.Color(45, 129, 171));
        jPanel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel85MouseClicked(evt);
            }
        });

        jLabel275.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_38px.png"))); // NOI18N

        jLabel276.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel276.setForeground(new java.awt.Color(255, 255, 255));
        jLabel276.setText("Course");

        jLabel277.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel277.setForeground(new java.awt.Color(255, 255, 255));
        jLabel277.setText(" Management");

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel276, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel85Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel277))
                        .addGroup(jPanel85Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel275))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel275)
                .addGap(18, 18, 18)
                .addComponent(jLabel276)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel277)
                .addGap(21, 21, 21))
        );

        Admin.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, 120));

        jPanel86.setBackground(new java.awt.Color(45, 129, 171));
        jPanel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel86MouseClicked(evt);
            }
        });

        jLabel278.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Graduation_Cap_38px.png"))); // NOI18N

        jLabel279.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(255, 255, 255));
        jLabel279.setText("Marks");

        jLabel280.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(255, 255, 255));
        jLabel280.setText(" Management");

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel278))
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel86Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel279))
                            .addComponent(jLabel280))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel278)
                .addGap(18, 18, 18)
                .addComponent(jLabel279)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel280)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Admin.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 120, 120));

        jPanel91.setBackground(new java.awt.Color(45, 129, 171));
        jPanel91.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel91MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel91MouseMoved(evt);
            }
        });
        jPanel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel91MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel91MouseExited(evt);
            }
        });

        jLabel293.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Profile_38px.png"))); // NOI18N

        jLabel294.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel294.setForeground(new java.awt.Color(255, 255, 255));
        jLabel294.setText("Employees");

        jLabel295.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel295.setForeground(new java.awt.Color(255, 255, 255));
        jLabel295.setText("Infomation");

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel91Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel91Layout.createSequentialGroup()
                        .addComponent(jLabel293)
                        .addGap(24, 24, 24))
                    .addComponent(jLabel295, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel294, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel293)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel294)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel295)
                .addGap(22, 22, 22))
        );

        Admin.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, -1, 120));

        jPanel92.setBackground(new java.awt.Color(45, 129, 171));
        jPanel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel92MouseClicked(evt);
            }
        });

        jLabel296.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_38px_1.png"))); // NOI18N

        jLabel297.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel297.setForeground(new java.awt.Color(255, 255, 255));
        jLabel297.setText(" Job Position");

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel92Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel297)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel296)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel296)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel297)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Admin.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, 120, 120));

        jPanel93.setBackground(new java.awt.Color(45, 129, 171));
        jPanel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel93MouseClicked(evt);
            }
        });
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel298.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel298.setForeground(new java.awt.Color(255, 255, 255));
        jLabel298.setText("Suspended");
        jPanel93.add(jLabel298, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 93, -1));

        jLabel299.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel299.setForeground(new java.awt.Color(255, 255, 255));
        jLabel299.setText("Employee");
        jPanel93.add(jLabel299, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel300.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Profile_38px.png"))); // NOI18N
        jPanel93.add(jLabel300, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, -1));

        jLabel301.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jLabel301.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel301.setMinimumSize(new java.awt.Dimension(25, 25));
        jPanel93.add(jLabel301, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 10));

        Admin.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 220, 120, 120));

        jPanel95.setBackground(new java.awt.Color(45, 129, 171));
        jPanel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel95MouseClicked(evt);
            }
        });

        jLabel306.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_38px.png"))); // NOI18N

        jLabel307.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel307.setForeground(new java.awt.Color(255, 255, 255));
        jLabel307.setText("Departments");

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel306)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel307)
                        .addGap(16, 16, 16))))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel306)
                .addGap(18, 18, 18)
                .addComponent(jLabel307)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Admin.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 120, 120));

        jPanel98.setBackground(new java.awt.Color(45, 129, 171));
        jPanel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel98MouseClicked(evt);
            }
        });
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel315.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel315.setForeground(new java.awt.Color(255, 255, 255));
        jLabel315.setText("Suspended");
        jPanel98.add(jLabel315, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 65, 70, -1));

        jLabel316.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel316.setForeground(new java.awt.Color(255, 255, 255));
        jLabel316.setText(" Department");
        jPanel98.add(jLabel316, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 86, -1, -1));

        jLabel317.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_38px.png"))); // NOI18N
        jPanel98.add(jLabel317, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 50, -1));

        jLabel318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jPanel98.add(jLabel318, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 30, 20));

        Admin.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 120, 120));

        jPanel100.setBackground(new java.awt.Color(45, 129, 171));
        jPanel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel100MouseClicked(evt);
            }
        });

        jLabel322.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Remove_User_Group_Man_Man_38px.png"))); // NOI18N

        jLabel323.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel323.setForeground(new java.awt.Color(255, 255, 255));
        jLabel323.setText("Users");

        jLabel324.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel324.setForeground(new java.awt.Color(255, 255, 255));
        jLabel324.setText("Deactivated");

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel322)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel100Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel100Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel323, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel324, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel322)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel324)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel323)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        Admin.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 120, 120));

        jLabel257.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Help_24px_8.png"))); // NOI18N
        jLabel257.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel257MouseClicked(evt);
            }
        });
        Admin.add(jLabel257, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 40, 30));

        jPanel101.setBackground(new java.awt.Color(45, 129, 171));
        jPanel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel101MouseClicked(evt);
            }
        });

        jLabel325.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Class_38px.png"))); // NOI18N

        jLabel326.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel326.setForeground(new java.awt.Color(255, 255, 255));
        jLabel326.setText("Extra ");

        jLabel327.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel327.setForeground(new java.awt.Color(255, 255, 255));
        jLabel327.setText("Curricular");

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel327)
                    .addGroup(jPanel101Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel325)
                            .addComponent(jLabel326))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel325)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel326)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel327)
                .addGap(22, 22, 22))
        );

        Admin.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, 120));

        jPanel114.setBackground(new java.awt.Color(45, 129, 171));
        jPanel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel114MouseClicked(evt);
            }
        });

        jLabel364.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Account_38px.png"))); // NOI18N

        jLabel365.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel365.setForeground(new java.awt.Color(255, 255, 255));
        jLabel365.setText("Users");

        jLabel366.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel366.setForeground(new java.awt.Color(255, 255, 255));
        jLabel366.setText(" Management");

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel114Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel366))
                    .addGroup(jPanel114Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel365, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel364))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel364)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel365)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel366)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Admin.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 120));

        jPanel115.setBackground(new java.awt.Color(45, 129, 171));
        jPanel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel115MouseClicked(evt);
            }
        });

        jLabel367.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Database_Administrator_38px.png"))); // NOI18N

        jLabel368.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel368.setForeground(new java.awt.Color(255, 255, 255));
        jLabel368.setText("Setup");

        jLabel369.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel369.setForeground(new java.awt.Color(255, 255, 255));
        jLabel369.setText("Database");

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel369, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addGroup(jPanel115Layout.createSequentialGroup()
                        .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel368, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel367))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel367)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel369)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel368)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        Admin.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 120, 120));

        jPanel116.setBackground(new java.awt.Color(45, 129, 171));
        jPanel116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel116MouseClicked(evt);
            }
        });

        jLabel371.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel371.setForeground(new java.awt.Color(255, 255, 255));
        jLabel371.setText("Course");

        jLabel372.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel372.setForeground(new java.awt.Color(255, 255, 255));
        jLabel372.setText("Activate");

        jLabel387.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_Assign_38px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addGroup(jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel116Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel387))
                    .addGroup(jPanel116Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel371, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel372, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel387)
                .addGap(18, 18, 18)
                .addComponent(jLabel372)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel371)
                .addGap(20, 20, 20))
        );

        Admin.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, 120));

        jPanel117.setBackground(new java.awt.Color(45, 129, 171));
        jPanel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel117MouseClicked(evt);
            }
        });

        jLabel374.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel374.setForeground(new java.awt.Color(255, 255, 255));
        jLabel374.setText("Batch");

        jLabel375.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel375.setForeground(new java.awt.Color(255, 255, 255));
        jLabel375.setText("Activate");

        jLabel384.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_38px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel374)
                    .addComponent(jLabel384)
                    .addComponent(jLabel375))
                .addGap(35, 35, 35))
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel384)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel375)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel374)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Admin.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 120, 120));

        jPanel118.setBackground(new java.awt.Color(45, 129, 171));
        jPanel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel118MouseClicked(evt);
            }
        });
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel377.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel377.setForeground(new java.awt.Color(255, 255, 255));
        jLabel377.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel377.setText("Suspended");
        jPanel118.add(jLabel377, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 65, 120, 20));

        jLabel378.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel378.setForeground(new java.awt.Color(255, 255, 255));
        jLabel378.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel378.setText("Student");
        jPanel118.add(jLabel378, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 90, 120, -1));

        jLabel385.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jPanel118.add(jLabel385, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel386.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_38px.png"))); // NOI18N
        jPanel118.add(jLabel386, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        Admin.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 120, 120));

        jLabel379.setBackground(new java.awt.Color(4, 74, 121));
        jLabel379.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel379.setForeground(new java.awt.Color(255, 255, 255));
        jLabel379.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel379.setText("Student Management");
        jLabel379.setOpaque(true);
        Admin.add(jLabel379, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 380, 35));

        jLabel380.setBackground(new java.awt.Color(4, 74, 121));
        jLabel380.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel380.setForeground(new java.awt.Color(255, 255, 255));
        jLabel380.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel380.setText("Users Administration");
        jLabel380.setOpaque(true);
        Admin.add(jLabel380, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 35));

        jLabel381.setBackground(new java.awt.Color(4, 74, 121));
        jLabel381.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel381.setForeground(new java.awt.Color(255, 255, 255));
        jLabel381.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel381.setText("Employee Management");
        jLabel381.setOpaque(true);
        Admin.add(jLabel381, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 380, 35));

        getContentPane().add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1220, 700));

        StuMan.setVisible(false);
        StuMan.setBackground(new java.awt.Color(0, 102, 153));
        StuMan.setMinimumSize(new java.awt.Dimension(1234, 700));
        StuMan.setPreferredSize(new java.awt.Dimension(1234, 700));
        StuMan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel235.setBackground(new java.awt.Color(4, 74, 121));
        jLabel235.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 255, 255));
        jLabel235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Center_56px.png"))); // NOI18N
        jLabel235.setText("    Student  Manager");
        jLabel235.setOpaque(true);
        StuMan.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 60));

        jPanel87.setBackground(new java.awt.Color(45, 129, 171));
        jPanel87.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel87MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel87MouseMoved(evt);
            }
        });
        jPanel87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel87MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel87MouseExited(evt);
            }
        });

        jLabel281.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_38px.png"))); // NOI18N

        jLabel282.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel282.setForeground(new java.awt.Color(255, 255, 255));
        jLabel282.setText("Student ");

        jLabel283.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel283.setForeground(new java.awt.Color(255, 255, 255));
        jLabel283.setText("Infomation");

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel87Layout.createSequentialGroup()
                        .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel282, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel281))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel87Layout.createSequentialGroup()
                        .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel281)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel282)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel283)
                .addGap(17, 17, 17))
        );

        StuMan.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, 120));

        jPanel89.setBackground(new java.awt.Color(45, 129, 171));
        jPanel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel89MouseClicked(evt);
            }
        });

        jLabel287.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Groups_38px.png"))); // NOI18N

        jLabel288.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel288.setForeground(new java.awt.Color(255, 255, 255));
        jLabel288.setText("Class");

        jLabel289.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel289.setForeground(new java.awt.Color(255, 255, 255));
        jLabel289.setText(" Management");

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel289))
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel89Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel288))
                            .addComponent(jLabel287))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel288)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel289)
                .addGap(22, 22, 22))
        );

        StuMan.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, 120));

        jPanel90.setBackground(new java.awt.Color(45, 129, 171));
        jPanel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel90MouseClicked(evt);
            }
        });

        jLabel290.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_38px.png"))); // NOI18N

        jLabel291.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel291.setForeground(new java.awt.Color(255, 255, 255));
        jLabel291.setText("Course");

        jLabel292.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel292.setForeground(new java.awt.Color(255, 255, 255));
        jLabel292.setText(" Management");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel292))
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel290))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel290)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel292)
                .addGap(21, 21, 21))
        );

        StuMan.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, -1, 120));

        jPanel97.setBackground(new java.awt.Color(45, 129, 171));
        jPanel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel97MouseClicked(evt);
            }
        });

        jLabel311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Graduation_Cap_38px.png"))); // NOI18N

        jLabel312.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel312.setForeground(new java.awt.Color(255, 255, 255));
        jLabel312.setText("Marks");

        jLabel313.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(255, 255, 255));
        jLabel313.setText(" Management");

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel313)
                    .addGroup(jPanel97Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel311)
                            .addComponent(jLabel312))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel311)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel312)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel313)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        StuMan.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 120, 120));

        jPanel119.setBackground(new java.awt.Color(45, 129, 171));
        jPanel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel119MouseClicked(evt);
            }
        });

        jLabel370.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Class_38px.png"))); // NOI18N

        jLabel373.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel373.setForeground(new java.awt.Color(255, 255, 255));
        jLabel373.setText("Curricular");

        jLabel376.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel376.setForeground(new java.awt.Color(255, 255, 255));
        jLabel376.setText(" Management");

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel119Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel376))
                    .addGroup(jPanel119Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel373)
                            .addComponent(jLabel370))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel370)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel373)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel376)
                .addGap(22, 22, 22))
        );

        StuMan.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, 120));

        jPanel120.setBackground(new java.awt.Color(45, 129, 171));
        jPanel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel120MouseClicked(evt);
            }
        });

        jLabel382.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel382.setForeground(new java.awt.Color(255, 255, 255));
        jLabel382.setText("Course");

        jLabel383.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel383.setForeground(new java.awt.Color(255, 255, 255));
        jLabel383.setText("Activate");

        jLabel388.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_Assign_38px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addGroup(jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel120Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel382, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel120Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel383, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel120Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel388)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel388)
                .addGap(18, 18, 18)
                .addComponent(jLabel383)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel382)
                .addGap(20, 20, 20))
        );

        StuMan.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, 120));

        jPanel121.setBackground(new java.awt.Color(45, 129, 171));
        jPanel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel121MouseClicked(evt);
            }
        });

        jLabel389.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel389.setForeground(new java.awt.Color(255, 255, 255));
        jLabel389.setText("Class");

        jLabel390.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel390.setForeground(new java.awt.Color(255, 255, 255));
        jLabel390.setText("Activate");

        jLabel391.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_38px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel391)
                    .addComponent(jLabel390)
                    .addGroup(jPanel121Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel389)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel391)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel390)
                .addGap(12, 12, 12)
                .addComponent(jLabel389)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        StuMan.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 120, 120));

        jPanel122.setBackground(new java.awt.Color(45, 129, 171));
        jPanel122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel122MouseClicked(evt);
            }
        });
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel392.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel392.setForeground(new java.awt.Color(255, 255, 255));
        jLabel392.setText("Suspended");
        jPanel122.add(jLabel392, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 83, -1));

        jLabel393.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel393.setForeground(new java.awt.Color(255, 255, 255));
        jLabel393.setText("Student");
        jPanel122.add(jLabel393, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel394.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jPanel122.add(jLabel394, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel395.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_38px.png"))); // NOI18N
        jPanel122.add(jLabel395, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        StuMan.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 120, 120));

        jLabel258.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Help_24px_8.png"))); // NOI18N
        jLabel258.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel258MouseClicked(evt);
            }
        });
        StuMan.add(jLabel258, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 40, 30));

        jLabel266.setBackground(new java.awt.Color(4, 74, 121));
        jLabel266.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel266.setForeground(new java.awt.Color(255, 255, 255));
        jLabel266.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel266.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Menu_30px_1.png"))); // NOI18N
        jLabel266.setText("Available Employee Related Options");
        jLabel266.setIconTextGap(20);
        jLabel266.setOpaque(true);
        StuMan.add(jLabel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 660, 40));

        jScrollPane4.setBorder(null);

        jTextPane3.setEditable(false);
        jTextPane3.setBackground(new java.awt.Color(4, 74, 121));
        jTextPane3.setBorder(null);
        jTextPane3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextPane3.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane3.setText("                                                   Welcome to Student Manager of Aeon School Management System");
        jTextPane3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTextPane3.setMargin(new java.awt.Insets(30, 3, 3, 3));
        jScrollPane4.setViewportView(jTextPane3);

        StuMan.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1240, 40));

        jScrollPane5.setBorder(null);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(31, 93, 135));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("                                                                          \n                                                                            Using Student Manager of AeonSMS, you can see list of all enrolled student in your Institution\n                                                                            as wel you can control addmission,updation of marks,slc of students and addition of class,batch\n                                                                            and courses to your institute.\n                                                                            As AeonSMS is in its initial stage several functions  like attendence management,id card generation\n                                                                            system,examination management system,schedule management system will be added in the future \n                                                                            releases.\n                                                              \n                                                                            Thank You for Evaluation AeonSMS\n                                                                                                                                                                                                   ~Ankit Rudra Ashok Jha(Developer)\n ");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jScrollPane5.setViewportView(jTextArea2);

        StuMan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1240, 220));

        getContentPane().add(StuMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1220, 700));

        StuMan.setVisible(false);
        EmpMan.setBackground(new java.awt.Color(0, 102, 153));
        EmpMan.setMinimumSize(new java.awt.Dimension(1234, 530));
        EmpMan.setPreferredSize(new java.awt.Dimension(1234, 530));
        EmpMan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel263.setBackground(new java.awt.Color(4, 74, 121));
        jLabel263.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel263.setForeground(new java.awt.Color(255, 255, 255));
        jLabel263.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel263.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Menu_30px_1.png"))); // NOI18N
        jLabel263.setText("Available Employee Related Options");
        jLabel263.setIconTextGap(20);
        jLabel263.setOpaque(true);
        EmpMan.add(jLabel263, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 640, 40));

        jPanel102.setBackground(new java.awt.Color(45, 129, 171));
        jPanel102.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel102MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel102MouseMoved(evt);
            }
        });
        jPanel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel102MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel102MouseExited(evt);
            }
        });

        jLabel329.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Profile_38px.png"))); // NOI18N

        jLabel330.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel330.setForeground(new java.awt.Color(255, 255, 255));
        jLabel330.setText("Employees");

        jLabel331.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel331.setForeground(new java.awt.Color(255, 255, 255));
        jLabel331.setText("Infomation");

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel329)
                        .addGap(24, 24, 24))
                    .addComponent(jLabel331, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel330, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel102Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel329)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel330)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel331)
                .addGap(6, 6, 6))
        );

        EmpMan.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, 120));

        jPanel103.setBackground(new java.awt.Color(45, 129, 171));
        jPanel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel103MouseClicked(evt);
            }
        });

        jLabel332.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_38px_1.png"))); // NOI18N

        jLabel333.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel333.setForeground(new java.awt.Color(255, 255, 255));
        jLabel333.setText(" Job Position");

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel333, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel103Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel332)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel103Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel332)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel333)
                .addGap(24, 24, 24))
        );

        EmpMan.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 120, 120));

        jPanel104.setBackground(new java.awt.Color(45, 129, 171));
        jPanel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel104MouseClicked(evt);
            }
        });
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel334.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel334.setForeground(new java.awt.Color(255, 255, 255));
        jLabel334.setText("Suspended");
        jPanel104.add(jLabel334, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 93, -1));

        jLabel335.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel335.setForeground(new java.awt.Color(255, 255, 255));
        jLabel335.setText("Employee");
        jPanel104.add(jLabel335, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 100, 70, -1));

        jLabel336.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Profile_38px.png"))); // NOI18N
        jPanel104.add(jLabel336, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, -1));

        jLabel337.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jLabel337.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel337.setMinimumSize(new java.awt.Dimension(25, 25));
        jPanel104.add(jLabel337, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 10));

        EmpMan.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 120, 120));

        jPanel106.setBackground(new java.awt.Color(45, 129, 171));
        jPanel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel106MouseClicked(evt);
            }
        });

        jLabel342.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_38px.png"))); // NOI18N

        jLabel343.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel343.setForeground(new java.awt.Color(255, 255, 255));
        jLabel343.setText("Departments");

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel106Layout.createSequentialGroup()
                        .addComponent(jLabel342)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel106Layout.createSequentialGroup()
                        .addComponent(jLabel343)
                        .addGap(19, 19, 19))))
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel342)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel343)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        EmpMan.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 120, 120));

        jPanel108.setBackground(new java.awt.Color(45, 129, 171));
        jPanel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel108MouseClicked(evt);
            }
        });
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel347.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel347.setForeground(new java.awt.Color(255, 255, 255));
        jLabel347.setText("Suspended");
        jPanel108.add(jLabel347, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, -1));

        jLabel348.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel348.setForeground(new java.awt.Color(255, 255, 255));
        jLabel348.setText(" Department");
        jPanel108.add(jLabel348, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel349.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_38px.png"))); // NOI18N
        jPanel108.add(jLabel349, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, -1));

        jLabel350.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_12px.png"))); // NOI18N
        jPanel108.add(jLabel350, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 30, 20));

        EmpMan.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 120, 120));

        jLabel259.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Help_24px_8.png"))); // NOI18N
        jLabel259.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel259MouseClicked(evt);
            }
        });
        EmpMan.add(jLabel259, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 40, 30));

        jScrollPane2.setBorder(null);

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(4, 74, 121));
        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane2.setText("                                                 Welcome to Employee Manager of Aeon School Management System");
        jTextPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTextPane2.setMargin(new java.awt.Insets(30, 3, 3, 3));
        jScrollPane2.setViewportView(jTextPane2);

        EmpMan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1240, 40));

        jScrollPane3.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(31, 93, 135));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("                                                                        \n\n                                                                            In Employee Manager of AeonSMS, you can see list of all working employee in your  Institution\n                                                                            in addition to employee details you can also add,delete and inactivate new departments and \n                                                                            departmental posts.\n                                                                            As AeonSMS  is developed to fulfill my graduation project assingment so it is limited in funtionality \n                                                                            but, I am willing to add new features  like employee payroll,employee attendance, leave,employee\n                                                                            id card generation system,employee job profile,employee performance register and web integration\n                                                                            in furthur releases.\n                                                                           \n                                                                            Thank you for Evaluating AeonSMS                                                                      ~Ankit RAJ(Developer)");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jScrollPane3.setViewportView(jTextArea1);

        EmpMan.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1240, 220));

        jLabel264.setBackground(new java.awt.Color(4, 74, 121));
        jLabel264.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel264.setForeground(new java.awt.Color(255, 255, 255));
        jLabel264.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel264.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Front_Desk_56px.png"))); // NOI18N
        jLabel264.setText("    Employee Manager");
        jLabel264.setOpaque(true);
        EmpMan.add(jLabel264, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 60));

        jLabel265.setBackground(new java.awt.Color(4, 74, 121));
        jLabel265.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel265.setForeground(new java.awt.Color(255, 255, 255));
        jLabel265.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel265.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Menu_30px_1.png"))); // NOI18N
        jLabel265.setText("Upcoming Employee Related Options");
        jLabel265.setIconTextGap(20);
        jLabel265.setOpaque(true);
        EmpMan.add(jLabel265, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 640, 40));

        jPanel105.setBackground(new java.awt.Color(45, 129, 171));
        jPanel105.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel105MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel105MouseMoved(evt);
            }
        });
        jPanel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel105MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel105MouseExited(evt);
            }
        });

        jLabel338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Attendance_30px.png"))); // NOI18N

        jLabel339.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel339.setForeground(new java.awt.Color(255, 255, 255));
        jLabel339.setText("Employees");

        jLabel340.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel340.setForeground(new java.awt.Color(255, 255, 255));
        jLabel340.setText("Attendence");

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel105Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel340, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel339, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel105Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel338)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel105Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel338)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel339)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel340)
                .addGap(18, 18, 18))
        );

        EmpMan.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, 120));

        jPanel107.setBackground(new java.awt.Color(45, 129, 171));
        jPanel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel107MouseClicked(evt);
            }
        });

        jLabel341.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Profiles_30px.png"))); // NOI18N

        jLabel344.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel344.setForeground(new java.awt.Color(255, 255, 255));
        jLabel344.setText("Job Profile");

        jLabel359.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel359.setForeground(new java.awt.Color(255, 255, 255));
        jLabel359.setText("Employee ");

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                        .addComponent(jLabel344)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                        .addComponent(jLabel341)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                        .addComponent(jLabel359, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel341)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel359)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel344)
                .addGap(15, 15, 15))
        );

        EmpMan.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 120, 120));

        jPanel109.setBackground(new java.awt.Color(45, 129, 171));
        jPanel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel109MouseClicked(evt);
            }
        });
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel345.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel345.setForeground(new java.awt.Color(255, 255, 255));
        jLabel345.setText("Employee ");
        jPanel109.add(jLabel345, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 93, -1));

        jLabel346.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel346.setForeground(new java.awt.Color(255, 255, 255));
        jLabel346.setText("Salary");
        jPanel109.add(jLabel346, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        jLabel351.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Payroll_30px.png"))); // NOI18N
        jPanel109.add(jLabel351, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 30, -1));

        EmpMan.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 120, 120));

        jPanel110.setBackground(new java.awt.Color(45, 129, 171));
        jPanel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel110MouseClicked(evt);
            }
        });

        jLabel353.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Identification_Documents_30px.png"))); // NOI18N

        jLabel354.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel354.setForeground(new java.awt.Color(255, 255, 255));
        jLabel354.setText("Generate");

        jLabel360.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel360.setForeground(new java.awt.Color(255, 255, 255));
        jLabel360.setText("ID card");

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel110Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel353)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel110Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel110Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel360))
                    .addComponent(jLabel354, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel353)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel354)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel360)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        EmpMan.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 120, 120));

        jPanel111.setBackground(new java.awt.Color(45, 129, 171));
        jPanel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel111MouseClicked(evt);
            }
        });
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel355.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel355.setForeground(new java.awt.Color(255, 255, 255));
        jLabel355.setText("Leave");
        jPanel111.add(jLabel355, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, -1));

        jLabel356.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel356.setForeground(new java.awt.Color(255, 255, 255));
        jLabel356.setText(" History");
        jPanel111.add(jLabel356, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 90, 50, -1));

        jLabel357.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Leave_30px.png"))); // NOI18N
        jPanel111.add(jLabel357, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 30, -1));

        EmpMan.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 120, 120));

        getContentPane().add(EmpMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1220, 700));

        SideEmp.setBackground(new java.awt.Color(8, 107, 156));
        SideEmp.setMinimumSize(new java.awt.Dimension(210, 690));
        SideEmp.setPreferredSize(new java.awt.Dimension(210, 690));
        SideEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SideEmpMouseClicked(evt);
            }
        });
        SideEmp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        miChangePassword7.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword7.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_24px.png"))); // NOI18N
        miChangePassword7.setText("  Employee Info");
        miChangePassword7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword7.setIconTextGap(15);
        miChangePassword7.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword7.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword7.setOpaque(true);
        miChangePassword7.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword7MouseClicked(evt);
            }
        });
        SideEmp.add(miChangePassword7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 40));

        jLabel7.setBackground(new java.awt.Color(45, 129, 171));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_24px.png"))); // NOI18N
        jLabel7.setText("  Home");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        jLabel7.setIconTextGap(15);
        jLabel7.setMaximumSize(new java.awt.Dimension(165, 28));
        jLabel7.setMinimumSize(new java.awt.Dimension(165, 28));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(165, 28));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        SideEmp.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        miDeactStaff11.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff11.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Manager_24px.png"))); // NOI18N
        miDeactStaff11.setText("Inactive Employee");
        miDeactStaff11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff11.setIconTextGap(15);
        miDeactStaff11.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff11.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff11.setOpaque(true);
        miDeactStaff11.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff11MouseClicked(evt);
            }
        });
        SideEmp.add(miDeactStaff11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 40));

        miDeactStaff12.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff12.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px.png"))); // NOI18N
        miDeactStaff12.setText("  About");
        miDeactStaff12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff12.setIconTextGap(15);
        miDeactStaff12.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff12.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff12.setOpaque(true);
        miDeactStaff12.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff12MouseClicked(evt);
            }
        });
        SideEmp.add(miDeactStaff12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 210, 40));

        miDeactStaff13.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff13.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_24px_1.png"))); // NOI18N
        miDeactStaff13.setText("Activate Departments");
        miDeactStaff13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff13.setIconTextGap(15);
        miDeactStaff13.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff13.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff13.setOpaque(true);
        miDeactStaff13.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff13MouseClicked(evt);
            }
        });
        SideEmp.add(miDeactStaff13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 40));

        miChangePassword8.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword8.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_24px.png"))); // NOI18N
        miChangePassword8.setText(" Department Info");
        miChangePassword8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword8.setIconTextGap(15);
        miChangePassword8.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword8.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword8.setOpaque(true);
        miChangePassword8.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword8MouseClicked(evt);
            }
        });
        SideEmp.add(miChangePassword8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 40));

        miChangePassword9.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword9.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_24px_1.png"))); // NOI18N
        miChangePassword9.setText(" Job Position");
        miChangePassword9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword9.setIconTextGap(15);
        miChangePassword9.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword9.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword9.setOpaque(true);
        miChangePassword9.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword9MouseClicked(evt);
            }
        });
        SideEmp.add(miChangePassword9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 40));

        getContentPane().add(SideEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 700));

        SideStu1.setBackground(new java.awt.Color(8, 107, 156));
        SideStu1.setMinimumSize(new java.awt.Dimension(210, 690));
        SideStu1.setPreferredSize(new java.awt.Dimension(210, 690));
        SideStu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SideStu1MouseClicked(evt);
            }
        });
        SideStu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        miChangePassword10.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword10.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_24px.png"))); // NOI18N
        miChangePassword10.setText("  Student Info");
        miChangePassword10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword10.setIconTextGap(14);
        miChangePassword10.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword10.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword10.setOpaque(true);
        miChangePassword10.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword10MouseClicked(evt);
            }
        });
        SideStu1.add(miChangePassword10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 209, 40));

        jLabel8.setBackground(new java.awt.Color(45, 129, 171));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_24px.png"))); // NOI18N
        jLabel8.setText("  Home");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.setIconTextGap(14);
        jLabel8.setMaximumSize(new java.awt.Dimension(165, 28));
        jLabel8.setMinimumSize(new java.awt.Dimension(165, 28));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(165, 28));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        SideStu1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 209, 40));

        miDeactStaff15.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff15.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Center_24px.png"))); // NOI18N
        miDeactStaff15.setText(" Suspended Student");
        miDeactStaff15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff15.setIconTextGap(14);
        miDeactStaff15.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff15.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff15.setOpaque(true);
        miDeactStaff15.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff15MouseClicked(evt);
            }
        });
        SideStu1.add(miDeactStaff15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 209, 40));

        miDeactStaff16.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff16.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px.png"))); // NOI18N
        miDeactStaff16.setText("  About");
        miDeactStaff16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff16.setIconTextGap(14);
        miDeactStaff16.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff16.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff16.setOpaque(true);
        miDeactStaff16.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff16MouseClicked(evt);
            }
        });
        SideStu1.add(miDeactStaff16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 209, 40));

        miDeactStaff17.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff17.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_24px_1.png"))); // NOI18N
        miDeactStaff17.setText("Activate Batch");
        miDeactStaff17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff17.setIconTextGap(14);
        miDeactStaff17.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff17.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff17.setOpaque(true);
        miDeactStaff17.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff17MouseClicked(evt);
            }
        });
        SideStu1.add(miDeactStaff17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 209, 40));

        miListStaff9.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff9.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_24px_2.png"))); // NOI18N
        miListStaff9.setText("Activate Extra Curricular");
        miListStaff9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff9.setIconTextGap(14);
        miListStaff9.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff9.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff9.setOpaque(true);
        miListStaff9.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff9MouseClicked(evt);
            }
        });
        SideStu1.add(miListStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 209, 40));

        miChangePassword11.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword11.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_24px_1.png"))); // NOI18N
        miChangePassword11.setText("Extra Curricular");
        miChangePassword11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword11.setIconTextGap(14);
        miChangePassword11.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword11.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword11.setOpaque(true);
        miChangePassword11.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword11MouseClicked(evt);
            }
        });
        SideStu1.add(miChangePassword11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 209, 40));

        miDeactStaff18.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff18.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Exam_24px.png"))); // NOI18N
        miDeactStaff18.setText("Marks  Management");
        miDeactStaff18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff18.setIconTextGap(14);
        miDeactStaff18.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff18.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff18.setOpaque(true);
        miDeactStaff18.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff18MouseClicked(evt);
            }
        });
        SideStu1.add(miDeactStaff18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 209, 40));

        miListStaff10.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff10.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_24px_1.png"))); // NOI18N
        miListStaff10.setText("Activate Course");
        miListStaff10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff10.setIconTextGap(14);
        miListStaff10.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff10.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff10.setOpaque(true);
        miListStaff10.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff10MouseClicked(evt);
            }
        });
        SideStu1.add(miListStaff10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 209, 40));

        miChangePassword12.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword12.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_24px.png"))); // NOI18N
        miChangePassword12.setText("Course");
        miChangePassword12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword12.setIconTextGap(14);
        miChangePassword12.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword12.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword12.setOpaque(true);
        miChangePassword12.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword12MouseClicked(evt);
            }
        });
        SideStu1.add(miChangePassword12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 209, 40));

        miListStaff13.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff13.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_24px.png"))); // NOI18N
        miListStaff13.setText("Batch");
        miListStaff13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff13.setIconTextGap(14);
        miListStaff13.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff13.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff13.setOpaque(true);
        miListStaff13.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff13MouseClicked(evt);
            }
        });
        SideStu1.add(miListStaff13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 209, 40));

        miListStaff15.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff15.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Classroom_24px.png"))); // NOI18N
        miListStaff15.setText("Class List");
        miListStaff15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff15.setIconTextGap(14);
        miListStaff15.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff15.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff15.setOpaque(true);
        miListStaff15.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff15MouseClicked(evt);
            }
        });
        SideStu1.add(miListStaff15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 209, 40));

        getContentPane().add(SideStu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 700));

        SideEmp1.setBackground(new java.awt.Color(8, 107, 156));
        SideEmp1.setMinimumSize(new java.awt.Dimension(210, 690));
        SideEmp1.setPreferredSize(new java.awt.Dimension(210, 690));
        SideEmp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(45, 129, 171));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_24px.png"))); // NOI18N
        jLabel9.setText("  Home");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        jLabel9.setIconTextGap(15);
        jLabel9.setMaximumSize(new java.awt.Dimension(209, 40));
        jLabel9.setMinimumSize(new java.awt.Dimension(209, 40));
        jLabel9.setOpaque(true);
        jLabel9.setPreferredSize(new java.awt.Dimension(209, 40));
        jLabel9.setVerifyInputWhenFocusTarget(false);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        SideEmp1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 209, 40));

        miDeactStaff21.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff21.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px.png"))); // NOI18N
        miDeactStaff21.setText("  About");
        miDeactStaff21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff21.setIconTextGap(15);
        miDeactStaff21.setMaximumSize(new java.awt.Dimension(209, 40));
        miDeactStaff21.setMinimumSize(new java.awt.Dimension(209, 40));
        miDeactStaff21.setOpaque(true);
        miDeactStaff21.setPreferredSize(new java.awt.Dimension(209, 40));
        miDeactStaff21.setVerifyInputWhenFocusTarget(false);
        miDeactStaff21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff21MouseClicked(evt);
            }
        });
        SideEmp1.add(miDeactStaff21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 209, 40));

        miChangePassword19.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword19.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_24px.png"))); // NOI18N
        miChangePassword19.setText("  Employee Info");
        miChangePassword19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword19.setIconTextGap(15);
        miChangePassword19.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword19.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword19.setOpaque(true);
        miChangePassword19.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword19MouseClicked(evt);
            }
        });
        SideEmp1.add(miChangePassword19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 40));

        miDeactStaff23.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff23.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Manager_24px.png"))); // NOI18N
        miDeactStaff23.setText("Inactive Employee");
        miDeactStaff23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff23.setIconTextGap(15);
        miDeactStaff23.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff23.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff23.setOpaque(true);
        miDeactStaff23.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff23MouseClicked(evt);
            }
        });
        SideEmp1.add(miDeactStaff23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 40));

        miDeactStaff29.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff29.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_24px_1.png"))); // NOI18N
        miDeactStaff29.setText("Activate Departments");
        miDeactStaff29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff29.setIconTextGap(15);
        miDeactStaff29.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff29.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff29.setOpaque(true);
        miDeactStaff29.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff29MouseClicked(evt);
            }
        });
        SideEmp1.add(miDeactStaff29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 40));

        miChangePassword20.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword20.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Department_24px.png"))); // NOI18N
        miChangePassword20.setText(" Department Info");
        miChangePassword20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword20.setIconTextGap(15);
        miChangePassword20.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword20.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword20.setOpaque(true);
        miChangePassword20.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword20MouseClicked(evt);
            }
        });
        SideEmp1.add(miChangePassword20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 40));

        miChangePassword21.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword21.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Permanent_Job_24px_1.png"))); // NOI18N
        miChangePassword21.setText(" Job Position");
        miChangePassword21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miChangePassword21.setIconTextGap(15);
        miChangePassword21.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword21.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword21.setOpaque(true);
        miChangePassword21.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword21MouseClicked(evt);
            }
        });
        SideEmp1.add(miChangePassword21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 40));

        getContentPane().add(SideEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 700));

        SideStu.setBackground(new java.awt.Color(8, 107, 156));
        SideStu.setMinimumSize(new java.awt.Dimension(210, 690));
        SideStu.setPreferredSize(new java.awt.Dimension(210, 690));
        SideStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SideStuMouseClicked(evt);
            }
        });
        SideStu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        miChangePassword16.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword16.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_24px.png"))); // NOI18N
        miChangePassword16.setText("  Student Info");
        miChangePassword16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword16.setIconTextGap(14);
        miChangePassword16.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword16.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword16.setOpaque(true);
        miChangePassword16.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword16MouseClicked(evt);
            }
        });
        SideStu.add(miChangePassword16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 209, 40));

        jLabel10.setBackground(new java.awt.Color(45, 129, 171));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_24px.png"))); // NOI18N
        jLabel10.setText("  Home");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setIconTextGap(14);
        jLabel10.setMaximumSize(new java.awt.Dimension(165, 28));
        jLabel10.setMinimumSize(new java.awt.Dimension(165, 28));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(165, 28));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        SideStu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 209, 40));

        miDeactStaff25.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff25.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Center_24px.png"))); // NOI18N
        miDeactStaff25.setText(" Suspended Student");
        miDeactStaff25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff25.setIconTextGap(14);
        miDeactStaff25.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff25.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff25.setOpaque(true);
        miDeactStaff25.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff25MouseClicked(evt);
            }
        });
        SideStu.add(miDeactStaff25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 209, 40));

        miDeactStaff26.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff26.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_24px.png"))); // NOI18N
        miDeactStaff26.setText("  About");
        miDeactStaff26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 107, 156), 1, true));
        miDeactStaff26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff26.setIconTextGap(14);
        miDeactStaff26.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff26.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff26.setOpaque(true);
        miDeactStaff26.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff26MouseClicked(evt);
            }
        });
        SideStu.add(miDeactStaff26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 209, 40));

        miDeactStaff27.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff27.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_24px_1.png"))); // NOI18N
        miDeactStaff27.setText("Activate Batch");
        miDeactStaff27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff27.setIconTextGap(14);
        miDeactStaff27.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff27.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff27.setOpaque(true);
        miDeactStaff27.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff27MouseClicked(evt);
            }
        });
        SideStu.add(miDeactStaff27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 209, 40));

        miListStaff17.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff17.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_24px_2.png"))); // NOI18N
        miListStaff17.setText("Activate Extra Curricular");
        miListStaff17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff17.setIconTextGap(14);
        miListStaff17.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff17.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff17.setOpaque(true);
        miListStaff17.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff17MouseClicked(evt);
            }
        });
        SideStu.add(miListStaff17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 209, 40));

        miChangePassword17.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword17.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_24px_1.png"))); // NOI18N
        miChangePassword17.setText("Extra Curricular");
        miChangePassword17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword17.setIconTextGap(14);
        miChangePassword17.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword17.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword17.setOpaque(true);
        miChangePassword17.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword17MouseClicked(evt);
            }
        });
        SideStu.add(miChangePassword17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 209, 40));

        miDeactStaff28.setBackground(new java.awt.Color(45, 129, 171));
        miDeactStaff28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miDeactStaff28.setForeground(new java.awt.Color(255, 255, 255));
        miDeactStaff28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miDeactStaff28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Exam_24px.png"))); // NOI18N
        miDeactStaff28.setText("Marks  Management");
        miDeactStaff28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miDeactStaff28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miDeactStaff28.setIconTextGap(14);
        miDeactStaff28.setMaximumSize(new java.awt.Dimension(165, 28));
        miDeactStaff28.setMinimumSize(new java.awt.Dimension(165, 28));
        miDeactStaff28.setOpaque(true);
        miDeactStaff28.setPreferredSize(new java.awt.Dimension(165, 28));
        miDeactStaff28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miDeactStaff28MouseClicked(evt);
            }
        });
        SideStu.add(miDeactStaff28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 209, 40));

        miListStaff18.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff18.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_24px_1.png"))); // NOI18N
        miListStaff18.setText("Activate Course");
        miListStaff18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff18.setIconTextGap(14);
        miListStaff18.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff18.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff18.setOpaque(true);
        miListStaff18.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff18MouseClicked(evt);
            }
        });
        SideStu.add(miListStaff18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 209, 40));

        miChangePassword18.setBackground(new java.awt.Color(45, 129, 171));
        miChangePassword18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miChangePassword18.setForeground(new java.awt.Color(255, 255, 255));
        miChangePassword18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miChangePassword18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Course_24px.png"))); // NOI18N
        miChangePassword18.setText("Course");
        miChangePassword18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miChangePassword18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miChangePassword18.setIconTextGap(14);
        miChangePassword18.setMaximumSize(new java.awt.Dimension(165, 28));
        miChangePassword18.setMinimumSize(new java.awt.Dimension(165, 28));
        miChangePassword18.setOpaque(true);
        miChangePassword18.setPreferredSize(new java.awt.Dimension(165, 28));
        miChangePassword18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miChangePassword18MouseClicked(evt);
            }
        });
        SideStu.add(miChangePassword18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 209, 40));

        miListStaff19.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff19.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Batch_Assign_24px.png"))); // NOI18N
        miListStaff19.setText("Batch");
        miListStaff19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff19.setIconTextGap(14);
        miListStaff19.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff19.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff19.setOpaque(true);
        miListStaff19.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff19MouseClicked(evt);
            }
        });
        SideStu.add(miListStaff19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 209, 40));

        miListStaff20.setBackground(new java.awt.Color(45, 129, 171));
        miListStaff20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miListStaff20.setForeground(new java.awt.Color(255, 255, 255));
        miListStaff20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miListStaff20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Classroom_24px.png"))); // NOI18N
        miListStaff20.setText("Class List");
        miListStaff20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));
        miListStaff20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miListStaff20.setIconTextGap(14);
        miListStaff20.setMaximumSize(new java.awt.Dimension(165, 28));
        miListStaff20.setMinimumSize(new java.awt.Dimension(165, 28));
        miListStaff20.setOpaque(true);
        miListStaff20.setPreferredSize(new java.awt.Dimension(165, 28));
        miListStaff20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miListStaff20MouseClicked(evt);
            }
        });
        SideStu.add(miListStaff20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 209, 40));

        getContentPane().add(SideStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miLogoutMouseClicked
     int res=JOptionPane.showConfirmDialog(this, "Are you sure logout ?");

        try {
            if(res==0)
            authentication.logout();
            else{
                return;
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Can't logout ! Please try again !");
            return;
        }
        dispose();
        new LoginForm().setVisible(true);
           // TODO add your handling code here:
    }//GEN-LAST:event_miLogoutMouseClicked

    private void miInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miInfoMouseClicked

if(Admin.isVisible()){
    adminCom(true);
    showAccountInfo();
}
else if(StuMan.isVisible()){
    stuCom(true);
    showAccountInfo();
}
else if(EmpMan.isVisible()){
    empCom(true);
    showAccountInfo();
}else {
    
    showAccountInfo();
}
    }//GEN-LAST:event_miInfoMouseClicked

    private void miChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePasswordMouseClicked
        ChangePassword changePassword=new ChangePassword(this, true, authentication);
        changePassword.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePasswordMouseClicked

    private void UserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameMouseClicked

    private void jPanel74MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel74MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel74MouseDragged

    private void jPanel74MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel74MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel74MouseMoved

    private void jPanel74MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel74MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel74MouseExited

    private void jPanel91MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel91MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel91MouseDragged

    private void jPanel91MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel91MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel91MouseMoved

    private void jPanel91MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel91MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel91MouseExited

    private void jPanel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel100MouseClicked
adminCom(true);
 showDeactived(Manager.USER); 

    }//GEN-LAST:event_jPanel100MouseClicked

    private void jPanel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel74MouseClicked
showComponent(Manager.STUDENT);
        adminComS(true);
 // TODO add your handling code here:
    }//GEN-LAST:event_jPanel74MouseClicked

    private void jPanel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel86MouseClicked
showComponent(Manager.MARK);
        adminComS(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel86MouseClicked

    private void jPanel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel84MouseClicked
showComponent(Manager.BATCH);
        adminComS(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel84MouseClicked

    private void jPanel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel85MouseClicked
showComponent(Manager.SUBJECT); 
        adminComS(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel85MouseClicked

    private void jPanel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel91MouseClicked
showComponent(Manager.STAFF);
        adminComE(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel91MouseClicked

    private void jPanel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel93MouseClicked
adminComE(true);
        showDeactived(Manager.STAFF);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel93MouseClicked

    private void jPanel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel95MouseClicked
adminComE(true); 
showComponent(Manager.DEPARTMENT);// TODO add your handling code here:
    }//GEN-LAST:event_jPanel95MouseClicked

    private void jPanel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel98MouseClicked
adminComE(true);
        showDeactived(Manager.DEPARTMENT);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel98MouseClicked

    private void jPanel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel92MouseClicked
adminComE(true);
showComponent(Manager.POSITION);// TODO add your handling code here:
    }//GEN-LAST:event_jPanel92MouseClicked

    private void jPanel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel101MouseClicked
adminComS(true);
showComponent(Manager.EXTRA_CURRICULAR);
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel101MouseClicked

    private void jPanel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel114MouseClicked
showComponent(Manager.USER);
        adminCom(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel114MouseClicked

    private void jPanel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel115MouseClicked
new SettingsGUI(this, true).setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel115MouseClicked

    private void jPanel116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel116MouseClicked
adminComS(true);
        showDeactived(Manager.SUBJECT);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel116MouseClicked

    private void jPanel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel117MouseClicked
     adminComS(true);
        showDeactived(Manager.BATCH);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel117MouseClicked

    private void jPanel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel118MouseClicked
   adminComS(true);
        showDeactived(Manager.STUDENT);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel118MouseClicked

    private void mainFHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainFHKeyPressed

    }//GEN-LAST:event_mainFHKeyPressed

    private void mainFHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_mainFHMousePressed

    private void mainFHMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainFHMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);// TODO add your handling code here:
    }//GEN-LAST:event_mainFHMouseDragged

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_22px.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_22px_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setState(LoginForm.ICONIFIED);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_18px_1.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
adminCom(false); 
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void miListStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff2MouseClicked
showDeactived(Manager.USER);        // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff2MouseClicked

    private void UsManButSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsManButSMouseClicked
showComponent(Manager.USER);
             // TODO add your handling code here:
    }//GEN-LAST:event_UsManButSMouseClicked

    private void miDeactStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff4MouseClicked
new SettingsGUI(this, true).setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff4MouseClicked

    private void miDeactStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff5MouseClicked
 new About(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff5MouseClicked

    private void miChangePassword7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword7MouseClicked
showComponent(Manager.STAFF);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword7MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
empCom(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void miDeactStaff11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff11MouseClicked
showDeactived(Manager.STAFF);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff11MouseClicked

    private void miDeactStaff12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff12MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff12MouseClicked

    private void miDeactStaff13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff13MouseClicked
showDeactived(Manager.DEPARTMENT);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff13MouseClicked

    private void miChangePassword8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword8MouseClicked
showComponent(Manager.DEPARTMENT);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword8MouseClicked

    private void miChangePassword9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword9MouseClicked
showComponent(Manager.POSITION);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword9MouseClicked

    private void jPanel87MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel87MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel87MouseDragged

    private void jPanel87MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel87MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel87MouseMoved

    private void jPanel87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel87MouseClicked
showComponent(Manager.STUDENT);
        stuCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel87MouseClicked

    private void jPanel87MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel87MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel87MouseExited

    private void jPanel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel89MouseClicked
showComponent(Manager.BATCH);
        stuCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel89MouseClicked

    private void jPanel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel90MouseClicked
showComponent(Manager.SUBJECT);
        stuCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel90MouseClicked

    private void jPanel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel97MouseClicked
showComponent(Manager.MARK);
        stuCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel97MouseClicked

    private void jPanel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel119MouseClicked
showComponent(Manager.BATCH);
        stuCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel119MouseClicked

    private void jPanel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel120MouseClicked
stuCom(true); 
        showDeactived(Manager.SUBJECT);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel120MouseClicked

    private void jPanel121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel121MouseClicked
stuCom(true); 
        showDeactived(Manager.BATCH);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel121MouseClicked

    private void jPanel122MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel122MouseClicked
stuCom(true); 
        showDeactived(Manager.STUDENT);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel122MouseClicked

    private void jPanel102MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel102MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel102MouseDragged

    private void jPanel102MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel102MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel102MouseMoved

    private void jPanel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel102MouseClicked
showComponent(Manager.STAFF);
        empCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel102MouseClicked

    private void jPanel102MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel102MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel102MouseExited

    private void jPanel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel103MouseClicked
showComponent(Manager.POSITION);
        empCom(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel103MouseClicked

    private void jPanel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel104MouseClicked
showDeactived(Manager.STAFF);
        empCom(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel104MouseClicked

    private void jPanel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel106MouseClicked
showComponent(Manager.DEPARTMENT);
        empCom(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel106MouseClicked

    private void jPanel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel108MouseClicked
showDeactived(Manager.DEPARTMENT);
        empCom(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel108MouseClicked

    private void miChangePassword10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword10MouseClicked
showComponent(Manager.STUDENT);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword10MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
adminComS(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void miDeactStaff15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff15MouseClicked
showDeactived(Manager.STUDENT);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff15MouseClicked

    private void miDeactStaff16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff16MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff16MouseClicked

    private void miDeactStaff17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff17MouseClicked
 showDeactived(Manager.BATCH);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff17MouseClicked

    private void miListStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff9MouseClicked
  showDeactived(Manager.EXTRA_CURRICULAR);   // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff9MouseClicked

    private void miChangePassword11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword11MouseClicked
showComponent(Manager.EXTRA_CURRICULAR);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword11MouseClicked

    private void miDeactStaff18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff18MouseClicked
showComponent(Manager.MARK);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff18MouseClicked

    private void miListStaff10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff10MouseClicked
showDeactived(Manager.SUBJECT);        // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff10MouseClicked

    private void miChangePassword12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword12MouseClicked
 showComponent(Manager.SUBJECT);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword12MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
adminComE(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void miDeactStaff21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff21MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff21MouseClicked

    private void SideStu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SideStu1MouseClicked
adminComS(false);        // TODO add your handling code here:
    }//GEN-LAST:event_SideStu1MouseClicked

    private void SideEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SideEmpMouseClicked
empCom(false);        // TODO add your handling code here:
    }//GEN-LAST:event_SideEmpMouseClicked

    private void miListStaff13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff13MouseClicked
showComponent(Manager.BATCH);        // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff13MouseClicked

    private void miListStaff15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff15MouseClicked

                ClassMan batchs = new ClassMan(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(batchs);
                batchs.show();          // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff15MouseClicked

    private void miChangePassword16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword16MouseClicked
showComponent(Manager.STUDENT);         // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword16MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
stuCom(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void miDeactStaff25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff25MouseClicked
showDeactived(Manager.STUDENT);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff25MouseClicked

    private void miDeactStaff26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff26MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff26MouseClicked

    private void miDeactStaff27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff27MouseClicked
showDeactived(Manager.BATCH);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff27MouseClicked

    private void miListStaff17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff17MouseClicked
showDeactived(Manager.EXTRA_CURRICULAR);        // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff17MouseClicked

    private void miChangePassword17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword17MouseClicked
showComponent(Manager.EXTRA_CURRICULAR);         // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword17MouseClicked

    private void miDeactStaff28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff28MouseClicked
showComponent(Manager.MARK);         // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff28MouseClicked

    private void miListStaff18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff18MouseClicked
showDeactived(Manager.SUBJECT);        // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff18MouseClicked

    private void miChangePassword18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword18MouseClicked
showComponent(Manager.SUBJECT);         // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword18MouseClicked

    private void miListStaff19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff19MouseClicked
showComponent(Manager.BATCH);         // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff19MouseClicked

    private void miListStaff20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miListStaff20MouseClicked
 ClassMan batchs = new ClassMan(WIDTH, HEIGHT);
                refreshMainPane();
                mainPane.add(batchs);
                batchs.show();         // TODO add your handling code here:
    }//GEN-LAST:event_miListStaff20MouseClicked

    private void SideStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SideStuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SideStuMouseClicked

    private void miChangePassword19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword19MouseClicked
showComponent(Manager.STAFF);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword19MouseClicked

    private void miDeactStaff23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff23MouseClicked
showDeactived(Manager.STAFF);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff23MouseClicked

    private void miDeactStaff29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miDeactStaff29MouseClicked
showDeactived(Manager.DEPARTMENT);        // TODO add your handling code here:
    }//GEN-LAST:event_miDeactStaff29MouseClicked

    private void miChangePassword20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword20MouseClicked
showComponent(Manager.DEPARTMENT);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword20MouseClicked

    private void miChangePassword21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miChangePassword21MouseClicked
showComponent(Manager.POSITION);        // TODO add your handling code here:
    }//GEN-LAST:event_miChangePassword21MouseClicked

    private void jLabel257MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel257MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel257MouseClicked

    private void jLabel258MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel258MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel258MouseClicked

    private void jLabel259MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel259MouseClicked
 new About(this, true).setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel259MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void UsManButSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsManButSMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UsManButSMouseEntered

    private void UsManButSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsManButSMouseExited

                // TODO add your handling code here:
    }//GEN-LAST:event_UsManButSMouseExited

    private void jPanel105MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel105MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel105MouseDragged

    private void jPanel105MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel105MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel105MouseMoved

    private void jPanel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel105MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel105MouseClicked

    private void jPanel105MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel105MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel105MouseExited

    private void jPanel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel107MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel107MouseClicked

    private void jPanel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel109MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel109MouseClicked

    private void jPanel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel110MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel110MouseClicked

    private void jPanel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel111MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel111MouseClicked

    private void aeonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aeonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_aeonMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JPanel EmpMan;
    private javax.swing.JPanel SideAdmin;
    private javax.swing.JPanel SideEmp;
    private javax.swing.JPanel SideEmp1;
    private javax.swing.JPanel SideStu;
    private javax.swing.JPanel SideStu1;
    private javax.swing.JPanel StuMan;
    private javax.swing.JLabel UsManButS;
    public javax.swing.JLabel UserName;
    public javax.swing.JLabel aeon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel339;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel341;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel343;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel347;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel351;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel357;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel373;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel382;
    private javax.swing.JLabel jLabel383;
    private javax.swing.JLabel jLabel384;
    private javax.swing.JLabel jLabel385;
    private javax.swing.JLabel jLabel386;
    private javax.swing.JLabel jLabel387;
    private javax.swing.JLabel jLabel388;
    private javax.swing.JLabel jLabel389;
    private javax.swing.JLabel jLabel390;
    private javax.swing.JLabel jLabel391;
    private javax.swing.JLabel jLabel392;
    private javax.swing.JLabel jLabel393;
    private javax.swing.JLabel jLabel394;
    private javax.swing.JLabel jLabel395;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JPanel mainFH;
    private javax.swing.JDesktopPane mainPane;
    private javax.swing.JLabel miChangePassword;
    private javax.swing.JLabel miChangePassword10;
    private javax.swing.JLabel miChangePassword11;
    private javax.swing.JLabel miChangePassword12;
    private javax.swing.JLabel miChangePassword16;
    private javax.swing.JLabel miChangePassword17;
    private javax.swing.JLabel miChangePassword18;
    private javax.swing.JLabel miChangePassword19;
    private javax.swing.JLabel miChangePassword20;
    private javax.swing.JLabel miChangePassword21;
    private javax.swing.JLabel miChangePassword7;
    private javax.swing.JLabel miChangePassword8;
    private javax.swing.JLabel miChangePassword9;
    private javax.swing.JLabel miDeactStaff11;
    private javax.swing.JLabel miDeactStaff12;
    private javax.swing.JLabel miDeactStaff13;
    private javax.swing.JLabel miDeactStaff15;
    private javax.swing.JLabel miDeactStaff16;
    private javax.swing.JLabel miDeactStaff17;
    private javax.swing.JLabel miDeactStaff18;
    private javax.swing.JLabel miDeactStaff21;
    private javax.swing.JLabel miDeactStaff23;
    private javax.swing.JLabel miDeactStaff25;
    private javax.swing.JLabel miDeactStaff26;
    private javax.swing.JLabel miDeactStaff27;
    private javax.swing.JLabel miDeactStaff28;
    private javax.swing.JLabel miDeactStaff29;
    private javax.swing.JLabel miDeactStaff4;
    private javax.swing.JLabel miDeactStaff5;
    private javax.swing.JLabel miInfo;
    private javax.swing.JLabel miListStaff10;
    private javax.swing.JLabel miListStaff13;
    private javax.swing.JLabel miListStaff15;
    private javax.swing.JLabel miListStaff17;
    private javax.swing.JLabel miListStaff18;
    private javax.swing.JLabel miListStaff19;
    private javax.swing.JLabel miListStaff2;
    private javax.swing.JLabel miListStaff20;
    private javax.swing.JLabel miListStaff9;
    private javax.swing.JLabel miLogout;
    // End of variables declaration//GEN-END:variables
}

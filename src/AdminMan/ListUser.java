/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminMan;

import Controls.Admin;
import Controls.Manager;
import Controls.Validate;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListUser extends javax.swing.JInternalFrame implements UIInterface{
    Admin admin=new Admin();
    private int act;
    
    public ListUser(int w, int h){
        this.admin=admin;
        initComponents();
        initUI();
        setSize(w, h);
    }
    @Override
    public void initUI(){
        
        enableButton(false);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        editAddPanel.setVisible(false);
        String SQL="SELECT ID, usrn, pswd, name, role, email FROM user";
        admin.loadTable(SQL, tblUser, Manager.USER_MODEL);
    }
     @Override
    public void enableEditAddPanel(boolean b) {
        if(b==false){
            tblUser.setEnabled(true);
            txtName.setText(null);
            editAddPanel.setVisible(false);

           
            bannerPanel.setVisible(true);
        }else{
            if(act==EDIT){
                labelAction.setText("Edit User");
                loadEdit();
            }else if(act==ADD){
                labelAction.setText("Add User");
                loadEdit();
            }
            tblUser.setEnabled(false);
            editAddPanel.setVisible(true);
            btnReset.setVisible(true);
          
            bannerPanel.setVisible(false);
        }
    }

    @Override
    public void loadEdit() {
        if(act==EDIT){
            Vector row=admin.getSelectRow(tblUser);
            txtUsername.setText(row.get(1).toString());
            txtPassword.setText(row.get(2).toString());
            txtName.setText(row.get(3).toString());
            comboType.setSelectedItem(row.get(4).toString());
            txtEmail.setText(row.get(5).toString());
        }else if(act==ADD){
            txtUsername.setText("");
            txtPassword.setText("");
            txtName.setText("");
            comboType.setSelectedIndex(0);
            txtEmail.setText("");
        }
        txtUsername.setRequestFocusEnabled(true);
    }


    public void add() {
        String username=txtUsername.getText();
        String password=txtPassword.getText();
        String role=comboType.getSelectedItem().toString();
        String name=txtName.getText();
        String email=txtEmail.getText();
        
        //Check Unique
        if(!admin.checkUnique("usrn", "user", username)){
            JOptionPane.showMessageDialog(this, "Username must be unique !");
            return;
        }
        int roleUser=admin.parseType(role);
        if(roleUser ==-1){
            JOptionPane.showMessageDialog(this, "Role incorrect !");
            return;
        }
        String data[]=new String[]{ username, password, name, roleUser+"", email};
        int res=admin.addUser(data);
        if(res==Manager.SUCCESS){
            initUI();
            enableEditAddPanel(false);
        }
        admin.showMessage(res, this);
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
            return;
        }
    }


    public void edit() {
        int ID=admin.getSelectID(tblUser);
        String username=txtUsername.getText();
        String password=txtPassword.getText();
        String role=comboType.getSelectedItem().toString();
        String name=txtName.getText();
        String email=txtEmail.getText();
        int roleUser=admin.parseType(role);
        
        String data[]=new String[]{admin.getSelectID(tblUser)+"", username, password, name, roleUser+"", email};
        int res=admin.editUser(data);
        admin.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
        enableEditAddPanel(false);
    }

    @Override
    public void deactive() {
        int res=admin.deactiveUser(admin.getSelectID(tblUser));
        admin.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }


    @Override
    public void search(){
        String SQL="SELECT ID, usrn, pswd, name, role, email FROM user WHERE 2>1 ";
        if(!txtNameSearch.getText().isEmpty()){
            SQL+=" AND name like '%"+txtNameSearch.getText()+"%'";
        }
        if(!txtUsernameSearch.getText().isEmpty()){
            SQL+=" AND usrn like '%"+txtUsernameSearch.getText()+"%'";
        }
        if(comboTypeSearch.getSelectedIndex() !=0){
            if(comboTypeSearch.getSelectedItem().equals("Staff manager")){
                SQL+=" AND role=2";
            }else if(comboTypeSearch.getSelectedItem().equals("Student manager")){
                SQL+=" AND role=3";
            }
        }
        admin.loadTable(SQL, tblUser, Manager.USER_MODEL);
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

        bannerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsernameSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTypeSearch = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnDeactivate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        editAddPanel = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboType1 = new javax.swing.JComboBox();
        txtEmail3 = new javax.swing.JTextField();
        txtEmail4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        bthCancle = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        dPic = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(179, 209, 224));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(1, 100, 151));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Account_38px.png"))); // NOI18N
        jLabel2.setText("Users Management");
        jLabel2.setOpaque(true);
        bannerPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 60));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jLabel3.setOpaque(true);
        bannerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 90, 25));

        txtUsernameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtUsernameSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUsernameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtUsernameSearch.setBorder(null);
        txtUsernameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtUsernameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 220, 25));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");
        jLabel4.setOpaque(true);
        bannerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 90, 25));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        txtNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 180, 25));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Role");
        jLabel5.setOpaque(true);
        bannerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 90, 25));

        comboTypeSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboTypeSearch.setEditable(true);
        comboTypeSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Staff manager", "Student manager" }));
        comboTypeSearch.setBorder(null);
        bannerPanel.add(comboTypeSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, 25));

        jLabel12.setBackground(new java.awt.Color(0, 102, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Refresh_17px.png"))); // NOI18N
        jLabel12.setText("Reset");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 88, 25));

        jLabel13.setBackground(new java.awt.Color(255, 102, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Google_Web_Search_17px.png"))); // NOI18N
        jLabel13.setText("Search");
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 90, 25));

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
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 88, 26));

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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 88, 26));

        btnDeactivate.setBackground(new java.awt.Color(255, 0, 0));
        btnDeactivate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeactivate.setForeground(new java.awt.Color(255, 255, 255));
        btnDeactivate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeactivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Radio_Active_17px.png"))); // NOI18N
        btnDeactivate.setText("Deactivate");
        btnDeactivate.setOpaque(true);
        btnDeactivate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeactivateMouseClicked(evt);
            }
        });
        bannerPanel.add(btnDeactivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 88, 26));

        jScrollPane1.setBackground(new java.awt.Color(179, 209, 224));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tblUser.setBackground(new java.awt.Color(4, 74, 121));
        tblUser.setForeground(new java.awt.Color(255, 255, 255));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Password", "Name", "Role", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setRowHeight(18);
        tblUser.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tblUser.setShowHorizontalLines(false);
        tblUser.setShowVerticalLines(false);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 830, 210));

        jLabel10.setBackground(new java.awt.Color(255, 101, 101));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("All Users List ");
        jLabel10.setOpaque(true);
        bannerPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 830, 40));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1014, 700));

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(0, 102, 153));
        labelAction.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Account_38px.png"))); // NOI18N
        labelAction.setText("Add New User");
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1040, 60));

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jLabel1.setOpaque(true);
        editAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 90, 25));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Password");
        jLabel6.setOpaque(true);
        editAddPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 90, 25));

        txtUsername.setBackground(new java.awt.Color(85, 153, 187));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(null);
        editAddPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 250, 25));

        txtPassword.setBackground(new java.awt.Color(85, 153, 187));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        editAddPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 250, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Name");
        jLabel7.setOpaque(true);
        editAddPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 90, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 250, 25));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Role");
        jLabel8.setOpaque(true);
        editAddPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 90, 25));

        comboType.setBackground(new java.awt.Color(85, 153, 187));
        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose", "Admin", "Staff manager", "Student manager" }));
        comboType.setBorder(null);
        editAddPanel.add(comboType, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 250, 25));

        jLabel9.setBackground(new java.awt.Color(0, 102, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Email");
        jLabel9.setOpaque(true);
        editAddPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 90, 25));

        txtEmail.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        editAddPanel.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 250, 25));

        txtEmail1.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail1.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail1.setBorder(null);
        editAddPanel.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 250, 25));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Emp.ID");
        jLabel11.setOpaque(true);
        editAddPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 90, 25));

        jLabel14.setBackground(new java.awt.Color(0, 102, 153));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Security Ques");
        jLabel14.setOpaque(true);
        editAddPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 90, 25));

        jLabel15.setBackground(new java.awt.Color(0, 102, 153));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ans");
        jLabel15.setOpaque(true);
        editAddPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 90, 25));

        jLabel16.setBackground(new java.awt.Color(0, 102, 153));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("D.O.B");
        jLabel16.setOpaque(true);
        editAddPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 90, 25));

        comboType1.setBackground(new java.awt.Color(85, 153, 187));
        comboType1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is Your 1st Pets Name ?", "What is Your the name of your first school ?", "What is your favorite Book ?", "What is your eternal desire ?", "What is the name of your best friend ?", " " }));
        comboType1.setSelectedItem(null);
        comboType1.setBorder(null);
        editAddPanel.add(comboType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 250, 25));

        txtEmail3.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail3.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail3.setBorder(null);
        editAddPanel.add(txtEmail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 250, 25));

        txtEmail4.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail4.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail4.setBorder(null);
        editAddPanel.add(txtEmail4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 250, 25));

        jLabel17.setBackground(new java.awt.Color(0, 102, 153));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Mob.");
        jLabel17.setOpaque(true);
        editAddPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 90, 25));

        bthCancle.setBackground(new java.awt.Color(255, 0, 0));
        bthCancle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bthCancle.setForeground(new java.awt.Color(255, 255, 255));
        bthCancle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bthCancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Close_Window_17px.png"))); // NOI18N
        bthCancle.setText("Cancel");
        bthCancle.setOpaque(true);
        bthCancle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthCancleMouseClicked(evt);
            }
        });
        editAddPanel.add(bthCancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 90, 25));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 90, 25));

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
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 90, 25));
        editAddPanel.add(dPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 250, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1014, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAction
        search();
    }//GEN-LAST:event_searchAction

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblUserMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
     search();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       txtNameSearch.setText("");
        txtUsernameSearch.setText("");
        comboTypeSearch.setSelectedIndex(0);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
    act=ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
      if(admin.getSelectRow(tblUser) !=null){
            act=EDIT;
            enableEditAddPanel(true);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeactivateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactivateMouseClicked
      if(admin.confirmRemove(this, "Are you sure ?")==0){
            deactive();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactivateMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
     save();   // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void bthCancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthCancleMouseClicked
      enableEditAddPanel(false);    // TODO add your handling code here:
    }//GEN-LAST:event_bthCancleMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JLabel bthCancle;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnDeactivate;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private javax.swing.JComboBox comboType;
    private javax.swing.JComboBox comboType1;
    private javax.swing.JComboBox comboTypeSearch;
    private com.toedter.calendar.JDateChooser dPic;
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtEmail4;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableButton(boolean b) {
        btnEdit.setEnabled(b);
        btnDeactivate.setEnabled(b);
    }

    @Override
    public boolean validateForm() {
        String username=txtUsername.getText();
        String password=txtPassword.getText();
        String role=comboType.getSelectedItem().toString();
        String name=txtName.getText();
        String email=txtEmail.getText();
        int roleUser=admin.parseType(role);
        
        if(Validate.isEmpty(username)){
            JOptionPane.showMessageDialog(this, "Username is required !");
            return false;
        }
        if(Validate.isEmpty(password)){
            JOptionPane.showMessageDialog(this, "Password is required !");
            return false;
        }
        if(Validate.isEmpty(name)){
            JOptionPane.showMessageDialog(this, "Name is required !");
            return false;
        }
        
        if(!Validate.choosedComboBox(comboType)){
            JOptionPane.showMessageDialog(this, "Role is required !");
            return false;
        }
        
        if(roleUser ==-1){
            JOptionPane.showMessageDialog(this, "Type User incorrect !");
            return false;
        }
        return true;
    }

   
}

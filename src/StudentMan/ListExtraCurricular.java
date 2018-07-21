/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import FileExport.ExportFile;
import Controls.Manager;
import Controls.Validate;
import MainHome.LoginForm;
import MainObjects.ExtraCurricularEntity;
import java.util.Date; 
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import TableModel.ExtraCurricular;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListExtraCurricular extends javax.swing.JInternalFrame implements UIInterface {
    private ExtraCurricularEntity entity; 
    private ExtraCurricular extraCurricular;
    private int actionType;
    /**
     * Creates new form ListPosition
     */
    public ListExtraCurricular(int w, int h) {
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.entity=new ExtraCurricularEntity();
        initUI();
        setSize(w, h);
        
        setSize(w, h);
    }

    @Override
    public void initUI() {
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        enableButton(false);
        editAddPanel.setVisible(false);
        entity.loadList(tblExtraCurricular);
    }

    @Override
    public void search() {
        String name=txtNameSearch.getText();
        if( !Validate.isEmpty(txtYearStartSearch.getText()) && !Validate.isNumber(txtYearStartSearch.getText())){
            JOptionPane.showMessageDialog(this, "Year is incorrect !");
            return;
        }
        if( !Validate.isEmpty(txtYearEndSearch.getText()) && !Validate.isNumber(txtYearEndSearch.getText())){
            JOptionPane.showMessageDialog(this, "Year is incorrect !");
            return;
        }
        int monthStart = 0;
        int monthEnd = 0;
        int yearStart = 0;
        int yearEnd = 0;
        try {
            if (comboMonthStartSearch.getSelectedIndex() != 0) {
                monthStart=Integer.parseInt(comboMonthStartSearch.getSelectedItem().toString());
            }
            if (comboMonthEndSearch.getSelectedIndex() != 0) {
                monthEnd=Integer.parseInt(comboMonthEndSearch.getSelectedItem().toString());
            }
            if(!txtYearStartSearch.getText().isEmpty()){
                yearStart=Integer.parseInt(txtYearStartSearch.getText());
            }
            if(!txtYearEndSearch.getText().isEmpty()){
                yearEnd=Integer.parseInt(txtYearStartSearch.getText());
            }
            entity.search(name, monthStart, yearStart, monthEnd, yearEnd, tblExtraCurricular);
        } catch (NullPointerException | NumberFormatException ex) {}
        enableButton(false);
    }

    @Override
    public void enableEditAddPanel(boolean b) {
        if (b == false) {
            tblExtraCurricular.setEnabled(true);
            txtName.setText(null);

            editAddPanel.setVisible(false);
            bannerPanel.setVisible(true);
            
        } else {
            if (actionType == EDIT) {
                labelAction.setText("Edit Extra Curricular");
                loadEdit();
            } else if (actionType == ADD) {
                labelAction.setText("Add Extra Curricular");
            }
            tblExtraCurricular.setEnabled(false);
            btnReset.setVisible(true);

            editAddPanel.setVisible(true);
            bannerPanel.setVisible(false);
           
        }
    }

    @Override
    public void save() {
        if (!validateForm()) {
            return;
        }
        if(extraCurricular==null){
            extraCurricular=new ExtraCurricular();
        }
        String name = txtName.getText();
        String location=txtLocation.getText();
        Date start=null;
        start=dPicStart.getDate();
        Date end=null;
        end=dPicEnd.getDate();
        
        extraCurricular.setName(name);
        extraCurricular.setLocation(location);
        extraCurricular.setStart(start);
        extraCurricular.setEnd(end);
        entity.setExtraCurricular(extraCurricular);
        int res=0;
        res=entity.save();
        if (res == Manager.SUCCESS) {
            initUI();
            enableEditAddPanel(false);
        }
        entity.showMessage(res, this);
        
    }

    @Override
    public void loadEdit() {
        if(actionType==ADD){
            txtName.setText("");
            txtLocation.setText("");
            dPicStart.setDate(null);
            dPicEnd.setDate(null);
        }else{
        extraCurricular=entity.findByID(entity.getSelectID(tblExtraCurricular));
        if(extraCurricular!=null){
            txtName.setText(extraCurricular.getName());
            txtLocation.setText(extraCurricular.getLocation());
            dPicStart.setDate(extraCurricular.getStart());
            dPicEnd.setDate(extraCurricular.getEnd());
        }
        }
    }

    @Override
    public void deactive() {
        int res = 0;
        res=entity.deactive(entity.getSelectID(tblExtraCurricular));
        entity.showMessage(res, this);
        if (res == Manager.SUCCESS) {
            initUI();
        }
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        comboMonthStartSearch = new javax.swing.JComboBox();
        txtYearStartSearch = new javax.swing.JTextField();
        comboMonthEndSearch = new javax.swing.JComboBox();
        txtYearEndSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExtraCurricular = new javax.swing.JTable();
        btnResetSearch = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        txtNameSearch1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        editAddPanel = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dPicStart = new com.toedter.calendar.JDateChooser();
        dPicEnd = new com.toedter.calendar.JDateChooser();
        btnReset = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();

        setBackground(java.awt.Color.white);
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1024, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_40px.png"))); // NOI18N
        jLabel4.setText("     Extra Curricular");
        jLabel4.setOpaque(true);
        bannerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 60));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Name");
        jLabel3.setOpaque(true);
        bannerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 90, 25));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNameSearch.setBorder(null);
        txtNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameSearchsearchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 230, 25));

        comboMonthStartSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboMonthStartSearch.setEditable(true);
        comboMonthStartSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboMonthStartSearch.setForeground(new java.awt.Color(51, 51, 51));
        comboMonthStartSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        comboMonthStartSearch.setAutoscrolls(true);
        comboMonthStartSearch.setBorder(null);
        bannerPanel.add(comboMonthStartSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 90, 25));

        txtYearStartSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtYearStartSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtYearStartSearch.setBorder(null);
        bannerPanel.add(txtYearStartSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 88, 25));

        comboMonthEndSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboMonthEndSearch.setEditable(true);
        comboMonthEndSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboMonthEndSearch.setForeground(new java.awt.Color(51, 51, 51));
        comboMonthEndSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        comboMonthEndSearch.setAutoscrolls(true);
        comboMonthEndSearch.setBorder(null);
        comboMonthEndSearch.setLightWeightPopupEnabled(false);
        bannerPanel.add(comboMonthEndSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 90, 25));

        txtYearEndSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtYearEndSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtYearEndSearch.setBorder(null);
        bannerPanel.add(txtYearEndSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 88, 25));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Start");
        jLabel7.setOpaque(true);
        bannerPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 90, 25));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("End");
        jLabel8.setOpaque(true);
        bannerPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 90, 25));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane1.setForeground(new java.awt.Color(4, 74, 121));

        tblExtraCurricular.setAutoCreateRowSorter(true);
        tblExtraCurricular.setBackground(new java.awt.Color(4, 74, 121));
        tblExtraCurricular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblExtraCurricular.setForeground(new java.awt.Color(255, 255, 255));
        tblExtraCurricular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Location", "Start", "End"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExtraCurricular.setGridColor(new java.awt.Color(51, 153, 0));
        tblExtraCurricular.setShowHorizontalLines(false);
        tblExtraCurricular.setShowVerticalLines(false);
        tblExtraCurricular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExtraCurricularMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExtraCurricular);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 890, 290));

        btnResetSearch.setBackground(new java.awt.Color(0, 102, 255));
        btnResetSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnResetSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnResetSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Refresh_17px.png"))); // NOI18N
        btnResetSearch.setText("Reset");
        btnResetSearch.setOpaque(true);
        btnResetSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetSearchMouseClicked(evt);
            }
        });
        bannerPanel.add(btnResetSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 80, 25));

        btnSearch.setBackground(new java.awt.Color(255, 102, 0));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        bannerPanel.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 80, 25));

        txtNameSearch1.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNameSearch1.setBorder(null);
        txtNameSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameSearch1searchAction(evt);
            }
        });
        bannerPanel.add(txtNameSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 230, 25));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ID");
        jLabel11.setOpaque(true);
        bannerPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, 25));

        btnAdd.setBackground(new java.awt.Color(51, 204, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 90, 25));

        btnEdit.setBackground(new java.awt.Color(204, 0, 204));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 90, 25));

        btnDeactive.setBackground(new java.awt.Color(255, 0, 0));
        btnDeactive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        bannerPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 90, 25));

        btnExport.setBackground(new java.awt.Color(0, 0, 204));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        bannerPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 90, 25));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(0, 102, 153));
        labelAction.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Curriculum_40px.png"))); // NOI18N
        labelAction.setText("    Add New Extra Curricular");
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1030, 60));

        jLabel1.setBackground(new java.awt.Color(1, 100, 151));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");
        jLabel1.setOpaque(true);
        editAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 90, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);
        editAddPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 180, 25));

        jLabel2.setBackground(new java.awt.Color(1, 100, 151));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Location");
        jLabel2.setOpaque(true);
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 90, 25));

        txtLocation.setBackground(new java.awt.Color(85, 153, 187));
        txtLocation.setForeground(new java.awt.Color(255, 255, 255));
        txtLocation.setBorder(null);
        editAddPanel.add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 180, 25));

        jLabel5.setBackground(new java.awt.Color(1, 100, 151));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Start");
        jLabel5.setOpaque(true);
        editAddPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 88, 25));

        jLabel6.setBackground(new java.awt.Color(1, 100, 151));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("End");
        jLabel6.setOpaque(true);
        editAddPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 88, 25));

        dPicStart.setBackground(new java.awt.Color(85, 153, 187));
        dPicStart.setForeground(new java.awt.Color(102, 102, 102));
        editAddPanel.add(dPicStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 180, 25));

        dPicEnd.setBackground(new java.awt.Color(85, 153, 187));
        dPicEnd.setForeground(new java.awt.Color(102, 102, 102));
        editAddPanel.add(dPicEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 180, 25));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 88, 25));

        btnSave.setBackground(new java.awt.Color(52, 203, 0));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 88, 25));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
        editAddPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 88, 25));

        txtName1.setBackground(new java.awt.Color(85, 153, 187));
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setBorder(null);
        editAddPanel.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, 25));

        jLabel13.setBackground(new java.awt.Color(1, 100, 151));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ID");
        jLabel13.setOpaque(true);
        editAddPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, 25));

        jLabel14.setBackground(new java.awt.Color(1, 100, 151));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Points");
        jLabel14.setOpaque(true);
        editAddPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 90, 25));

        txtName2.setBackground(new java.awt.Color(85, 153, 187));
        txtName2.setForeground(new java.awt.Color(255, 255, 255));
        txtName2.setBorder(null);
        editAddPanel.add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 180, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameSearchsearchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameSearchsearchAction
        search();
    }//GEN-LAST:event_txtNameSearchsearchAction

    private void tblExtraCurricularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExtraCurricularMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblExtraCurricularMouseClicked

    private void txtNameSearch1searchAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameSearch1searchAction
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameSearch1searchAction

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
     search();   // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchMouseClicked
        txtNameSearch.setText("");
        comboMonthStartSearch.setSelectedIndex(0);
        comboMonthEndSearch.setSelectedIndex(0);
        txtYearEndSearch.setText("");
        txtYearStartSearch.setText("");  // TODO add your handling code here:
    }//GEN-LAST:event_btnResetSearchMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
 actionType=ADD;
        enableEditAddPanel(true);
        loadEdit();
        btnReset.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
   if (entity.getSelectID(tblExtraCurricular) != 0) {
            enableEditAddPanel(true);
            actionType=EDIT;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
 if (entity.confirmRemove(this, "Are you sure ?") == 0) {
            deactive();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
export();        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
 save();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
loadEdit();        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
   enableEditAddPanel(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnDeactive;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExport;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnResetSearch;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JComboBox comboMonthEndSearch;
    private javax.swing.JComboBox comboMonthStartSearch;
    private com.toedter.calendar.JDateChooser dPicEnd;
    private com.toedter.calendar.JDateChooser dPicStart;
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JTable tblExtraCurricular;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtNameSearch1;
    private javax.swing.JTextField txtYearEndSearch;
    private javax.swing.JTextField txtYearStartSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableButton(boolean b) { 
        btnEdit.setEnabled(b);
        btnDeactive.setEnabled(b);
    }

    @Override
    public boolean validateForm() {
        String name = txtName.getText();
        if (Validate.isEmpty(name)) {
            JOptionPane.showMessageDialog(this, "Name is required !");
            return false;
        }
        return true;
    }

    private void export() {
        ExportFile export =new ExportFile(tblExtraCurricular, ExportFile.EXTRA_CURRICULAR);
        export.toExcel();
        
    }
}

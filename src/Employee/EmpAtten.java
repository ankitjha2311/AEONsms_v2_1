/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import FileExport.ExportFile;
import Controls.Manager;
import Controls.Validate;
import MainObjects.DepartmentEntity;
import MainObjects.PositionEntity;
import MainObjects.StaffEntity;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import TableModel.FamilyStaff;
import TableModel.Feedback;
import TableModel.Position;
import TableModel.Promotion;
import TableModel.Relative;
import TableModel.Staff;
import MainHome.UIInterface;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class EmpAtten extends javax.swing.JInternalFrame implements UIInterface {
    private StaffEntity entity;
    private DepartmentEntity departmentEntity;
    private PositionEntity positionEntity;
    Staff currentStaff;
    Staff newStaff;
    private int act;

    public EmpAtten(int w, int h) {
        this.entity=new StaffEntity();
        this.departmentEntity=new DepartmentEntity();
        this.positionEntity=new PositionEntity();
        initComponents();
        initUI();
        setSize(w, h+30); 
    }

    @Override
    public void initUI() {
        enableButton(false);
        showPanel("List Staff",listPanel,detailPanel,cont);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        entity.loadList(tblStaff);
        List<String> listDepartment=departmentEntity.getNameList();
        comboDepartmentSearch.removeAllItems();
        comboDepartmentSearch.addItem("All");
        for(String str:listDepartment){
            comboDepartmentSearch.addItem(str);
        }
        comboPositionSearch.setEnabled(false);
        
        
    }

    @Override
    public void enableEditAddPanel(boolean b) {
    }

    @Override
    public void search() {
        if(!Validate.isEmpty(txtNoSearch.getText()) && !Validate.isNumber(txtNoSearch.getText())){
            JOptionPane.showMessageDialog(this, "No must be a number !");
            return;
            
        }
        int department=0;
        int position=0;
        String name=txtNameSearch.getText();
        int No=0;
        try{
            No=Integer.parseInt(txtNoSearch.getText());
        }catch(NumberFormatException ex){ex.printStackTrace();}
        if(comboDepartmentSearch.getSelectedIndex() !=0){
            try{
            department=departmentEntity.findByName(comboDepartmentSearch.getSelectedItem().toString()).getID();
            }catch(NullPointerException ex){ex.printStackTrace();};
        }
        if(comboPositionSearch.getSelectedIndex() !=0){
            try{
            position=positionEntity.findByName(comboPositionSearch.getSelectedItem().toString(), department).getID();
            }catch(NullPointerException ex){ex.printStackTrace();};
        }
        entity.search(No, name, department, position, tblStaff);
        enableButton(false);
    }


    @Override
    public void deactive() {
        int res=entity.deactive(entity.getSelectID(tblStaff));
        entity.showMessage(res, this);
        if(res==Manager.SUCCESS)
            initUI();
    }



    public void showPanel(String name,JPanel panel,JPanel pane1,JPanel pane2) {
      panel.setVisible(true);
      pane1.setVisible(false);
      pane2.setVisible(false);
    }

    public void loadDetail() {
        btnFeedbackDetail.setEnabled(false);
        btnFamilyDetail.setEnabled(false);
        btnPromotionDetail.setEnabled(false);
        
        nameStaff.setText(currentStaff.getName());
        birthdayStaff.setText(entity.formatDate(currentStaff.getBirthday()));
        addressStaff.setText(currentStaff.getAddress());
        educationStaff.setText(currentStaff.getEducation());
        emailStaff.setText(currentStaff.getEmail());
        experienceStaff.setText(currentStaff.getExperience());
        labelGender.setText(entity.parseGender(currentStaff.getGender()));
        if (currentStaff.getFamilyStaff() != null) {
            labelMarried.setText(entity.parseMarried(currentStaff.getFamilyStaff().getMarried()));
        }
        phoneStaff.setText(currentStaff.getPhone());

        loadPromotionTable(tblPromotionDetail);
        loadRelationsTable(tblRelationDetail);
        loadFeedbackTable(tblFeedbackDetail);

    }

    @Override
    public void loadEdit() {
        newStaff=currentStaff;
        btnPromotionDelete.setEnabled(false);
        btnPromotionEdit.setEnabled(false);
        btnRelationDelete.setEnabled(false);
        btnRelationEdit.setEnabled(false);
        btnFeedbackDelete.setEnabled(false);
        btnFeedbackEdit.setEnabled(false);
        
        txtName.setText(currentStaff.getName());
        txtPhone.setText(currentStaff.getPhone());
        txtAddress.setText(currentStaff.getAddress());
        dPicBirthday.setDate(currentStaff.getBirthday());
        txtEducation.setText(currentStaff.getEducation());
        txtExperience.setText(currentStaff.getExperience());
        txtEmail.setText(currentStaff.getEmail());
        comboGender.setSelectedItem(entity.parseGender(currentStaff.getGender()));
        if (currentStaff.getFamilyStaff() != null) {
            comboMarried.setSelectedItem(entity.parseMarried(currentStaff.getFamilyStaff().getMarried()));
        }

        loadPromotionTable(tblPromotion);
        loadRelationsTable(tblRelation);
        loadFeedbackTable(tblFeedback);
    }

    private void loadAdd() {
        
        btnPromotionDelete.setEnabled(false);
        btnPromotionEdit.setEnabled(false);
        btnRelationDelete.setEnabled(false);
        btnRelationEdit.setEnabled(false);
        btnFeedbackDelete.setEnabled(false);
        btnFeedbackEdit.setEnabled(false);
        
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
//        txtBirthday.setText("");
        dPicBirthday.setDate(null);
        txtEducation.setText("");
        txtExperience.setText("");
        txtEmail.setText("");
        entity.refreshTable(tblPromotion);
        entity.refreshTable(tblRelation);
        entity.refreshTable(tblFeedback);

    }

    private void loadPromotionTable(JTable tbl) {
        if (currentStaff.getPromotions() == null) {
            return;
        }
        List<Promotion> listPromotion = currentStaff.getPromotions();
        String[][] data = new String[listPromotion.size()][4];
        int count = 0;
        for (Promotion promotion : listPromotion) {
            Position position = promotion.getPosition();
            data[count++] = new String[]{
                promotion.getID() + "",
                position.getName(),
                position.getDepartment().getName(),
                entity.formatDate(promotion.getTime())
            };
        }
        entity.loadTable(data, tbl);
    }

    private void loadRelationsTable(JTable tbl) {
        if (currentStaff.getFamilyStaff() == null || currentStaff.getFamilyStaff().getRelatives() == null) {
            return;
        }
        int count = 0;
        List<Relative> listreRelatives = currentStaff.getFamilyStaff().getRelatives();
        String[][] data = new String[listreRelatives.size()][7];
        for (Relative r : listreRelatives) {
            data[count++] = new String[]{
                r.getID() + "",
                r.getRelation(),
                r.getName(),
                r.getPhone(),
                r.getAddress(),
                r.getOccupation(),
                entity.parseGender(r.getGender())
            };
        }
        entity.loadTable(data, tbl);
    }

    private void loadFeedbackTable(JTable tbl) {
        if (currentStaff.getFeedbacks() == null || currentStaff.getFeedbacks().size() < 1) {
            return;
        }
        int count = 0;
        List<Feedback> feedbacks = currentStaff.getFeedbacks();
        String[][] data = new String[feedbacks.size()][5];
        for (Feedback f : feedbacks) {
            data[count++] = new String[]{
                f.getID() + "",
                f.getStudent().getNo(),
                f.getStudent().getName(),
                f.getContent(),
                entity.formatDate(f.getTime()),
                f.getStatus()+""
            };
        }
        entity.loadTable(data, tbl);

    }

    private void loadPromotionInfo(int mode) {
        if (act == DETAIL) {
            new PromotionDetail(null, true, currentStaff.getPromotions().get(tblPromotionDetail.getSelectedRow())).setVisible(true);
            return;
        }
        PromotionUpdate promotionUpdate = null;
        if (mode == ADD) {
            promotionUpdate = new PromotionUpdate(null, true, null);
            promotionUpdate.setVisible(true);
        } else if (mode == EDIT) {
            promotionUpdate = new PromotionUpdate(null, true, entity.getSelectRow(tblPromotion));
            promotionUpdate.setVisible(true);
            if (promotionUpdate.getPromotion() != null) {
                removeSelectedPromotion();
            }
        }
        if (promotionUpdate.getPromotion() != null) {
            addRowTablePromotion(promotionUpdate.getPromotion());
            newStaff.addPromotion(promotionUpdate.getPromotion());
        }

    }

    private void addRowTablePromotion(Promotion promotion) {
        Vector row = new Vector();
        row.add(promotion.getID());
        row.add(promotion.getPosition().getName());
        row.add(promotion.getPosition().getDepartment().getName());
        row.add(entity.formatDate(promotion.getTime()));
        DefaultTableModel model = (DefaultTableModel) tblPromotion.getModel();
        model.addRow(row);
    }

    private void removeSelectedPromotion() {
        Vector row = entity.getSelectRow(tblPromotion);
        int ID=0;
        try{
            ID=Integer.parseInt(row.get(0).toString());
        }catch(NumberFormatException | NullPointerException ex){
            ex.printStackTrace();
        }
        if(ID >0){
            entity.removePromotion(ID);
        }
        newStaff.removePromotion(entity.parseDate((String) row.get(3)));
        entity.removeSelectedRowTable(tblPromotion);
        
        
    }

    private void loadRelationInfo(int mode) {
        if (act == DETAIL) {
            new RelationDetail(null, true, currentStaff.getFamilyStaff().getRelatives().get(tblRelationDetail.getSelectedRow())).setVisible(true);
            return;
        }
        RelationUpdate relationUpdate = null;
        if (mode == ADD) {
            relationUpdate = new RelationUpdate(null, true, entity, null);
            relationUpdate.setVisible(true);
        } else if (mode == EDIT) {
            relationUpdate = new RelationUpdate(null, true, entity, entity.getSelectRow(tblRelation));
            relationUpdate.setVisible(true);
            if (relationUpdate.getRelaRelatives() != null) {
                removeSelectedRelation();
            }
        }
        if (relationUpdate.getRelaRelatives() != null) {
            addRowTableRelation(relationUpdate.getRelaRelatives());
            newStaff.getFamilyStaff().addRelative(relationUpdate.getRelaRelatives());
        }
    }

    private void addRowTableRelation(Relative r) {
        Vector row = new Vector();
        row.add(r.getID());
        row.add(r.getRelation());
        row.add(r.getName());
        row.add(r.getPhone());
        row.add(r.getAddress());
        row.add(r.getOccupation());
        row.add(entity.parseGender(r.getGender()));
        DefaultTableModel model = (DefaultTableModel) tblRelation.getModel();
        model.addRow(row);
    }

    private void removeSelectedRelation() {
        Vector row = entity.getSelectRow(tblRelation);
        int ID=0;
        try{
            ID=Integer.parseInt(row.get(0).toString());
        }catch(NumberFormatException | NullPointerException ex){
            ex.printStackTrace();
        }
        if(ID >0){
            entity.removeRelative(ID);
        }
        newStaff.getFamilyStaff().removeRelative((String) row.get(1), (String) row.get(2));
        entity.removeSelectedRowTable(tblRelation);
    }
    private void loadFeedbackInfo(int mode) {
        if (act == DETAIL) {
            new FeedbackDetail(null, true, currentStaff.getFeedbacks().get(tblFeedbackDetail.getSelectedRow())).setVisible(true);
            return;
        }
        FeedbackUpdate feedbackUpdate = null;
        if (mode == ADD) {
            feedbackUpdate = new FeedbackUpdate(null, true, null);
            feedbackUpdate.setVisible(true);
        } else if (mode == EDIT) {
            feedbackUpdate = new FeedbackUpdate(null, true, entity.getSelectRow(tblFeedback));
            feedbackUpdate.setVisible(true);
            if (feedbackUpdate.getFeedback()!= null) {
                removeSelectedFeedback();
            }
        }
        if (feedbackUpdate.getFeedback()!= null) {
            addRowTableFeedback(feedbackUpdate.getFeedback());
            newStaff.addFeedback(feedbackUpdate.getFeedback());
        }
    }

    private void addRowTableFeedback(Feedback f) {
        Vector row = new Vector();
        row.add(f.getID());
        row.add(f.getStudent().getNo());
        row.add(f.getStudent().getName());
        row.add(f.getContent());
        row.add(entity.formatDate(f.getTime()));
        row.add(f.getStatus());
        DefaultTableModel model = (DefaultTableModel) tblFeedback.getModel();
        model.addRow(row);
    }

    private void removeSelectedFeedback() {
        Vector row = entity.getSelectRow(tblFeedback);
        int ID=0;
        try{
            ID=Integer.parseInt(row.get(0).toString());
        }catch(NumberFormatException | NullPointerException ex){
            ex.printStackTrace();
        }
        if(ID >0){
            entity.removeFeedback(ID);
        }
        newStaff.removeFeedback(row.get(1).toString(), entity.parseDate(row.get(4).toString()));
        entity.removeSelectedRowTable(tblFeedback);
    }

    @Override
    public void save() {
        if(!validateForm()){
            return;
        }
        newStaff.setName(txtName.getText());
        newStaff.setAddress(txtAddress.getText());
        newStaff.setEducation(txtEducation.getText());
        newStaff.setEmail(txtEmail.getText());
        newStaff.setExperience(txtExperience.getText());
        newStaff.setGender(entity.formatGender((String) comboGender.getSelectedItem()));
        newStaff.setPhone(txtPhone.getText());
        newStaff.setBirthday(dPicBirthday.getDate());
//        newStaff.setBirthday(entity.parseDate(txtBirthday.getText()));
        if (newStaff.getFamilyStaff() == null) {
            newStaff.setFamilyStaff(new FamilyStaff());
        }
        newStaff.getFamilyStaff().setMaried(entity.formatMarried((String) comboMarried.getSelectedItem()));
        
        entity.setStaff(newStaff);
        int res=entity.save();
        if(res==Manager.SUCCESS){
            initUI();
            listPanel.setVisible(true);
       
        }
        entity.showMessage(res, this);
        
    }

    private void reset() {
        newStaff = currentStaff;
        if (act == EDIT) {
            entity.refreshTable(tblPromotion);
            entity.refreshTable(tblRelation);
            entity.refreshTable(tblFeedback);
            loadEdit();
        } else if (act == ADD) {
            loadAdd();
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

        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        comboPositionSearch = new javax.swing.JComboBox();
        comboDepartmentSearch = new javax.swing.JComboBox();
        txtNameSearch = new javax.swing.JTextField();
        txtNoSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        detailPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailPaneld = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnEdit1 = new javax.swing.JLabel();
        btnFeedbackDetail = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblRelationDetail = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        nameStaff = new javax.swing.JLabel();
        phoneStaff = new javax.swing.JLabel();
        emailStaff = new javax.swing.JLabel();
        birthdayStaff = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        addressStaff = new javax.swing.JTextPane();
        labelGender = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        educationStaff = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        experienceStaff = new javax.swing.JTextPane();
        labelMarried = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblPromotionDetail = new javax.swing.JTable();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblFeedbackDetail = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        btnViewList = new javax.swing.JLabel();
        jButton8 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnPromotionDetail = new javax.swing.JLabel();
        btnFamilyDetail = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        emailStaff1 = new javax.swing.JLabel();
        emailStaff2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        updatePanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        cont = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnFeedbackDelete = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        comboGender = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEducation = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtExperience = new javax.swing.JTextArea();
        labelAction = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPromotion = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboMarried = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblRelation = new javax.swing.JTable();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblFeedback = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        dPicBirthday = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnFeedbackEdit = new javax.swing.JLabel();
        btnRelationDelete = new javax.swing.JLabel();
        btnRelationEdit = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnPromotionDelete = new javax.swing.JLabel();
        btnPromotionEdit = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dPicBirthday1 = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(4, 74, 121));
        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1012, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listPanel.setBackground(new java.awt.Color(224, 224, 255));
        listPanel.setMinimumSize(new java.awt.Dimension(1012, 700));
        listPanel.setPreferredSize(new java.awt.Dimension(1012, 700));
        listPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(85, 153, 187), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tblStaff.setBackground(new java.awt.Color(4, 74, 121));
        tblStaff.setForeground(new java.awt.Color(255, 255, 255));
        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Name", "Phone", "Email", "Position", "Department", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaff.setShowHorizontalLines(false);
        tblStaff.setShowVerticalLines(false);
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaff);

        listPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 800, 380));

        jLabel9.setBackground(new java.awt.Color(0, 68, 102));
        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Employee Attendence Manager ");
        jLabel9.setOpaque(true);
        listPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 2, 1050, 50));

        comboPositionSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboPositionSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPositionSearch.setForeground(new java.awt.Color(255, 255, 255));
        comboPositionSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 68, 102), 1, true));
        listPanel.add(comboPositionSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 190, 25));

        comboDepartmentSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboDepartmentSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboDepartmentSearch.setForeground(new java.awt.Color(255, 255, 255));
        comboDepartmentSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 68, 102), 1, true));
        comboDepartmentSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepartmentSearchActionPerformed(evt);
            }
        });
        listPanel.add(comboDepartmentSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 180, 25));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        listPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 180, 25));

        txtNoSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNoSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNoSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNoSearch.setText("ID ");
        txtNoSearch.setBorder(null);
        txtNoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSearchActionPerformed(evt);
            }
        });
        listPanel.add(txtNoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 190, 25));

        jLabel10.setBackground(new java.awt.Color(0, 102, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Search");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        listPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 88, 25));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Add");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        listPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 88, 25));

        btnEdit.setBackground(new java.awt.Color(0, 102, 153));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEdit.setText("Edit");
        btnEdit.setOpaque(true);
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        listPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, 88, 25));

        btnDeactive.setBackground(new java.awt.Color(0, 102, 153));
        btnDeactive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeactive.setForeground(new java.awt.Color(255, 255, 255));
        btnDeactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeactive.setText("Deactivate");
        btnDeactive.setOpaque(true);
        btnDeactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeactiveMouseClicked(evt);
            }
        });
        listPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 88, 25));

        btnExport.setBackground(new java.awt.Color(0, 102, 153));
        btnExport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExport.setText("Export");
        btnExport.setOpaque(true);
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        listPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, 88, 25));

        jLabel18.setBackground(new java.awt.Color(0, 102, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Reset");
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        listPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 88, 25));

        btnDetail.setBackground(new java.awt.Color(0, 102, 153));
        btnDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDetail.setText("Detail");
        btnDetail.setOpaque(true);
        btnDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetailMouseClicked(evt);
            }
        });
        listPanel.add(btnDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, 88, 25));

        jLabel20.setBackground(new java.awt.Color(0, 102, 153));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Position");
        jLabel20.setOpaque(true);
        listPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 90, 25));

        jLabel21.setBackground(new java.awt.Color(0, 102, 153));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Name");
        jLabel21.setOpaque(true);
        listPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 90, 25));

        jLabel22.setBackground(new java.awt.Color(0, 102, 153));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ID");
        jLabel22.setOpaque(true);
        listPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 90, 25));

        jLabel28.setBackground(new java.awt.Color(0, 102, 153));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Department");
        jLabel28.setOpaque(true);
        listPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 90, 25));

        getContentPane().add(listPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        detailPanel.setMinimumSize(new java.awt.Dimension(1010, 700));
        detailPanel.setPreferredSize(new java.awt.Dimension(1010, 700));
        detailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(980, 690));

        detailPaneld.setBackground(new java.awt.Color(224, 224, 255));
        detailPaneld.setMaximumSize(new java.awt.Dimension(1020, 1181));
        detailPaneld.setMinimumSize(new java.awt.Dimension(1020, 1181));
        detailPaneld.setPreferredSize(new java.awt.Dimension(1000, 1181));
        detailPaneld.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(0, 93, 140));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Emp.ID");
        jLabel23.setOpaque(true);
        detailPaneld.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 90, 25));

        jLabel24.setBackground(new java.awt.Color(0, 93, 140));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Phone");
        jLabel24.setOpaque(true);
        detailPaneld.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 90, 25));

        jLabel25.setBackground(new java.awt.Color(0, 93, 140));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Email");
        jLabel25.setOpaque(true);
        detailPaneld.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, 25));

        jLabel26.setBackground(new java.awt.Color(0, 93, 140));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Birthday");
        jLabel26.setOpaque(true);
        detailPaneld.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 90, 25));

        jLabel27.setBackground(new java.awt.Color(0, 93, 140));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Address");
        jLabel27.setOpaque(true);
        detailPaneld.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 88, 60));

        jLabel34.setBackground(new java.awt.Color(0, 93, 140));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Gender");
        jLabel34.setOpaque(true);
        detailPaneld.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 90, 25));

        jLabel35.setBackground(new java.awt.Color(0, 93, 140));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Education");
        jLabel35.setOpaque(true);
        detailPaneld.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 235, 88, 50));

        btnEdit1.setBackground(new java.awt.Color(0, 93, 140));
        btnEdit1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdit1.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEdit1.setText("Edit");
        btnEdit1.setOpaque(true);
        btnEdit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdit1MouseClicked(evt);
            }
        });
        detailPaneld.add(btnEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 780, 88, 25));

        btnFeedbackDetail.setBackground(new java.awt.Color(0, 93, 140));
        btnFeedbackDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFeedbackDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedbackDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFeedbackDetail.setText("Details");
        btnFeedbackDetail.setOpaque(true);
        btnFeedbackDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeedbackDetailMouseClicked(evt);
            }
        });
        detailPaneld.add(btnFeedbackDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 88, 25));

        jLabel38.setBackground(new java.awt.Color(0, 93, 140));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Family Infomation");
        jLabel38.setOpaque(true);
        detailPaneld.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 550, 25));

        jLabel39.setBackground(new java.awt.Color(0, 93, 140));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Married");
        jLabel39.setOpaque(true);
        detailPaneld.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 90, 25));

        jScrollPane17.setBackground(new java.awt.Color(0, 93, 140));
        jScrollPane17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 93, 140), 1, true));
        jScrollPane17.setForeground(new java.awt.Color(255, 255, 255));

        tblRelationDetail.setBackground(new java.awt.Color(0, 93, 140));
        tblRelationDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblRelationDetail.setForeground(new java.awt.Color(255, 255, 255));
        tblRelationDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Relation", "Name", "Phone", "Address", "Occupation", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRelationDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRelationDetailMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblRelationDetail);

        detailPaneld.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 850, 75));

        jLabel41.setBackground(new java.awt.Color(0, 68, 102));
        jLabel41.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Employee Details");
        jLabel41.setOpaque(true);
        detailPaneld.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 990, 60));

        nameStaff.setBackground(new java.awt.Color(85, 153, 187));
        nameStaff.setText("                           ");
        nameStaff.setOpaque(true);
        detailPaneld.add(nameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 200, 25));

        phoneStaff.setBackground(new java.awt.Color(85, 153, 187));
        phoneStaff.setText("                         ");
        phoneStaff.setOpaque(true);
        detailPaneld.add(phoneStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 200, 25));

        emailStaff.setBackground(new java.awt.Color(85, 153, 187));
        emailStaff.setText("                           ");
        emailStaff.setOpaque(true);
        detailPaneld.add(emailStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 200, 25));

        birthdayStaff.setBackground(new java.awt.Color(85, 153, 187));
        birthdayStaff.setText("                              ");
        birthdayStaff.setOpaque(true);
        detailPaneld.add(birthdayStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 210, 25));

        jScrollPane10.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane10.setBorder(null);

        addressStaff.setEditable(false);
        addressStaff.setBackground(new java.awt.Color(85, 153, 187));
        addressStaff.setBorder(null);
        addressStaff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressStaff.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(addressStaff);

        detailPaneld.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 170, 513, 60));

        labelGender.setBackground(new java.awt.Color(85, 153, 187));
        labelGender.setForeground(new java.awt.Color(255, 255, 255));
        labelGender.setText("                             ");
        labelGender.setOpaque(true);
        detailPaneld.add(labelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 210, 25));

        jScrollPane14.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane14.setBorder(null);

        educationStaff.setEditable(false);
        educationStaff.setBackground(new java.awt.Color(85, 153, 187));
        educationStaff.setBorder(null);
        educationStaff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        educationStaff.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane14.setViewportView(educationStaff);

        detailPaneld.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 235, 204, 50));

        jScrollPane15.setBackground(new java.awt.Color(85, 153, 187));
        jScrollPane15.setBorder(null);

        experienceStaff.setEditable(false);
        experienceStaff.setBackground(new java.awt.Color(85, 153, 187));
        experienceStaff.setBorder(null);
        experienceStaff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        experienceStaff.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setViewportView(experienceStaff);

        detailPaneld.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 235, 210, 50));

        labelMarried.setBackground(new java.awt.Color(85, 153, 187));
        labelMarried.setForeground(new java.awt.Color(255, 255, 255));
        labelMarried.setText("                           ");
        labelMarried.setOpaque(true);
        detailPaneld.add(labelMarried, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 200, 25));

        jScrollPane18.setBackground(new java.awt.Color(0, 93, 140));
        jScrollPane18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 93, 140), 1, true));

        tblPromotionDetail.setBackground(new java.awt.Color(0, 93, 140));
        tblPromotionDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblPromotionDetail.setForeground(new java.awt.Color(255, 255, 255));
        tblPromotionDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Position name", "Department name", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPromotionDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPromotionDetailMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblPromotionDetail);

        detailPaneld.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 850, 101));

        jScrollPane21.setBackground(new java.awt.Color(0, 93, 140));
        jScrollPane21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 93, 140), 1, true));

        tblFeedbackDetail.setBackground(new java.awt.Color(0, 93, 140));
        tblFeedbackDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblFeedbackDetail.setForeground(new java.awt.Color(255, 255, 255));
        tblFeedbackDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No", "Student name", "Content", "Time", "Status"
            }
        ));
        tblFeedbackDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeedbackDetailMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tblFeedbackDetail);

        detailPaneld.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, 850, 80));

        jLabel42.setBackground(new java.awt.Color(0, 93, 140));
        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Experience");
        jLabel42.setOpaque(true);
        detailPaneld.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 235, 90, 50));

        btnViewList.setBackground(new java.awt.Color(0, 93, 140));
        btnViewList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewList.setForeground(new java.awt.Color(255, 255, 255));
        btnViewList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnViewList.setText("Back");
        btnViewList.setOpaque(true);
        btnViewList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewListMouseClicked(evt);
            }
        });
        detailPaneld.add(btnViewList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 780, 88, 25));

        jButton8.setBackground(new java.awt.Color(0, 93, 140));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton8.setText("Add");
        jButton8.setOpaque(true);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        detailPaneld.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 780, 88, 25));

        jLabel45.setBackground(new java.awt.Color(0, 93, 140));
        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Promotion");
        jLabel45.setOpaque(true);
        detailPaneld.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 88, 25));

        jLabel46.setBackground(new java.awt.Color(0, 93, 140));
        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Relatives");
        jLabel46.setOpaque(true);
        detailPaneld.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 88, 25));

        jLabel50.setBackground(new java.awt.Color(0, 93, 140));
        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Feedback");
        jLabel50.setOpaque(true);
        detailPaneld.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 88, 25));

        btnPromotionDetail.setBackground(new java.awt.Color(0, 93, 140));
        btnPromotionDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPromotionDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnPromotionDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPromotionDetail.setText("Details");
        btnPromotionDetail.setOpaque(true);
        btnPromotionDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromotionDetailMouseClicked(evt);
            }
        });
        detailPaneld.add(btnPromotionDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 88, 25));

        btnFamilyDetail.setBackground(new java.awt.Color(0, 93, 140));
        btnFamilyDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFamilyDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnFamilyDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFamilyDetail.setText("Details");
        btnFamilyDetail.setOpaque(true);
        btnFamilyDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFamilyDetailMouseClicked(evt);
            }
        });
        detailPaneld.add(btnFamilyDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 88, 25));

        jLabel30.setBackground(new java.awt.Color(0, 93, 140));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Name");
        jLabel30.setOpaque(true);
        detailPaneld.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, 25));

        emailStaff1.setBackground(new java.awt.Color(85, 153, 187));
        emailStaff1.setText("                           ");
        emailStaff1.setOpaque(true);
        detailPaneld.add(emailStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 210, 25));

        emailStaff2.setBackground(new java.awt.Color(85, 153, 187));
        emailStaff2.setText("                           ");
        emailStaff2.setOpaque(true);
        detailPaneld.add(emailStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 130, 170));

        jLabel31.setBackground(new java.awt.Color(0, 93, 140));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Emp.ID");
        jLabel31.setOpaque(true);
        detailPaneld.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 130, 25));

        jScrollPane2.setViewportView(detailPaneld);
        detailPaneld.getAccessibleContext().setAccessibleParent(detailPanel);

        detailPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        getContentPane().add(detailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        updatePanel.setMinimumSize(new java.awt.Dimension(1012, 700));
        updatePanel.setPreferredSize(new java.awt.Dimension(1012, 700));
        updatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cont.setBackground(new java.awt.Color(224, 224, 255));
        cont.setMinimumSize(new java.awt.Dimension(1012, 1300));
        cont.setPreferredSize(new java.awt.Dimension(1012, 1300));
        cont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(4, 74, 121));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Emp.ID");
        jLabel1.setOpaque(true);
        cont.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 90, 25));

        jLabel2.setBackground(new java.awt.Color(4, 74, 121));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Phone");
        jLabel2.setOpaque(true);
        cont.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 90, 25));

        jLabel3.setBackground(new java.awt.Color(4, 74, 121));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Email");
        jLabel3.setOpaque(true);
        cont.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 90, 25));

        jLabel4.setBackground(new java.awt.Color(4, 74, 121));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Birthday");
        jLabel4.setOpaque(true);
        cont.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 90, 25));

        jLabel5.setBackground(new java.awt.Color(4, 74, 121));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Address");
        jLabel5.setOpaque(true);
        cont.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 90, 100));

        jLabel6.setBackground(new java.awt.Color(4, 74, 121));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gender");
        jLabel6.setOpaque(true);
        cont.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 90, 25));

        jLabel7.setBackground(new java.awt.Color(4, 74, 121));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Education");
        jLabel7.setOpaque(true);
        cont.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 90, 70));

        btnFeedbackDelete.setBackground(new java.awt.Color(0, 68, 102));
        btnFeedbackDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFeedbackDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnFeedbackDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFeedbackDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeedbackDeleteMouseClicked(evt);
            }
        });
        cont.add(btnFeedbackDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 780, 30, 25));

        txtName.setBackground(new java.awt.Color(0, 102, 153));
        txtName.setBorder(null);
        cont.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 210, 25));

        txtPhone.setBackground(new java.awt.Color(0, 102, 153));
        txtPhone.setBorder(null);
        cont.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 200, 25));

        txtEmail.setBackground(new java.awt.Color(0, 102, 153));
        txtEmail.setBorder(null);
        cont.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 210, 25));

        jScrollPane3.setBorder(null);

        txtAddress.setBackground(new java.awt.Color(0, 102, 153));
        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAddress.setRows(5);
        txtAddress.setBorder(null);
        jScrollPane3.setViewportView(txtAddress);

        cont.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 670, 100));

        comboGender.setBackground(new java.awt.Color(0, 102, 153));
        comboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));
        comboGender.setBorder(null);
        cont.add(comboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 210, 25));

        jScrollPane4.setBorder(null);

        txtEducation.setBackground(new java.awt.Color(0, 102, 153));
        txtEducation.setColumns(20);
        txtEducation.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtEducation.setLineWrap(true);
        txtEducation.setRows(5);
        txtEducation.setBorder(null);
        txtEducation.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(txtEducation);

        cont.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 210, 70));

        jScrollPane5.setBorder(null);

        txtExperience.setBackground(new java.awt.Color(0, 102, 153));
        txtExperience.setColumns(20);
        txtExperience.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtExperience.setForeground(new java.awt.Color(255, 255, 255));
        txtExperience.setRows(5);
        txtExperience.setBorder(null);
        jScrollPane5.setViewportView(txtExperience);

        cont.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 200, 70));

        labelAction.setBackground(new java.awt.Color(0, 68, 102));
        labelAction.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setText("Add Employee ");
        labelAction.setOpaque(true);
        cont.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1010, 60));

        jScrollPane6.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));

        tblPromotion.setBackground(new java.awt.Color(4, 74, 121));
        tblPromotion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Position name", "Department name", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPromotion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPromotionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblPromotion);

        cont.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 760, 101));

        jLabel12.setBackground(new java.awt.Color(4, 74, 121));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Family Infomation");
        jLabel12.setOpaque(true);
        cont.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 280, 25));

        jLabel13.setBackground(new java.awt.Color(4, 74, 121));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Maried");
        jLabel13.setOpaque(true);
        cont.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 90, 25));

        comboMarried.setBackground(new java.awt.Color(0, 102, 153));
        comboMarried.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Married", "Single" }));
        comboMarried.setBorder(null);
        cont.add(comboMarried, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 200, 25));

        jLabel14.setBackground(new java.awt.Color(4, 74, 121));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Relatives");
        jLabel14.setOpaque(true);
        cont.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 280, 25));

        jLabel29.setBackground(new java.awt.Color(4, 74, 121));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Promotion");
        jLabel29.setOpaque(true);
        cont.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 280, 25));

        jScrollPane11.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));

        tblRelation.setBackground(new java.awt.Color(4, 74, 121));
        tblRelation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Relation", "Name", "Phone", "Address", "Occupation", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRelation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRelationMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblRelation);

        cont.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 760, 87));

        jScrollPane22.setBackground(new java.awt.Color(0, 102, 153));
        jScrollPane22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));

        tblFeedback.setBackground(new java.awt.Color(0, 102, 153));
        tblFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student register no", "Student name", "Content", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeedbackMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tblFeedback);

        cont.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 810, 760, 90));

        jLabel49.setBackground(new java.awt.Color(4, 74, 121));
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Feedback");
        jLabel49.setOpaque(true);
        cont.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 780, 88, 25));
        cont.add(dPicBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 210, 25));

        jLabel15.setBackground(new java.awt.Color(4, 74, 121));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Experience");
        jLabel15.setOpaque(true);
        cont.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 90, 70));

        jLabel16.setBackground(new java.awt.Color(4, 74, 121));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Save");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        cont.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 990, 88, 25));

        jLabel17.setBackground(new java.awt.Color(4, 74, 121));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Reset");
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        cont.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 990, 88, 25));

        jLabel19.setBackground(new java.awt.Color(4, 74, 121));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cancel");
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        cont.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 990, 88, 25));

        jLabel32.setBackground(new java.awt.Color(224, 224, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        cont.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 780, 30, 25));

        btnFeedbackEdit.setBackground(new java.awt.Color(0, 68, 102));
        btnFeedbackEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFeedbackEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnFeedbackEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFeedbackEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeedbackEditMouseClicked(evt);
            }
        });
        cont.add(btnFeedbackEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 780, 30, 25));

        btnRelationDelete.setBackground(new java.awt.Color(0, 68, 102));
        btnRelationDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelationDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnRelationDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRelationDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelationDeleteMouseClicked(evt);
            }
        });
        cont.add(btnRelationDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 30, 25));

        btnRelationEdit.setBackground(new java.awt.Color(0, 68, 102));
        btnRelationEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelationEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnRelationEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRelationEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelationEditMouseClicked(evt);
            }
        });
        cont.add(btnRelationEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 30, 25));

        jLabel40.setBackground(new java.awt.Color(224, 224, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        cont.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 30, 25));

        btnPromotionDelete.setBackground(new java.awt.Color(0, 68, 102));
        btnPromotionDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPromotionDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnPromotionDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPromotionDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromotionDeleteMouseClicked(evt);
            }
        });
        cont.add(btnPromotionDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 30, 25));

        btnPromotionEdit.setBackground(new java.awt.Color(0, 68, 102));
        btnPromotionEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPromotionEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnPromotionEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPromotionEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromotionEditMouseClicked(evt);
            }
        });
        cont.add(btnPromotionEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 30, 25));

        jLabel47.setBackground(new java.awt.Color(224, 224, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        cont.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 30, 25));

        txtName1.setBackground(new java.awt.Color(0, 102, 153));
        txtName1.setBorder(null);
        cont.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 200, 25));

        jLabel8.setBackground(new java.awt.Color(4, 74, 121));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Name");
        jLabel8.setOpaque(true);
        cont.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 90, 25));
        cont.add(dPicBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 200, 25));

        jLabel33.setBackground(new java.awt.Color(4, 74, 121));
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("D.O.J");
        jLabel33.setOpaque(true);
        cont.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 90, 25));

        jLabel36.setBackground(new java.awt.Color(0, 102, 153));
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("photo");
        jLabel36.setOpaque(true);
        cont.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 130, 160));

        jLabel37.setBackground(new java.awt.Color(4, 74, 121));
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Browse_Folder_18px.png"))); // NOI18N
        jLabel37.setText("Browse");
        jLabel37.setIconTextGap(14);
        jLabel37.setOpaque(true);
        cont.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 130, 25));

        jScrollPane7.setViewportView(cont);

        updatePanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        getContentPane().add(updatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1012, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeedbackMouseClicked
        btnFeedbackDelete.setEnabled(true);
        btnFeedbackEdit.setEnabled(true);
    }//GEN-LAST:event_tblFeedbackMouseClicked

    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked
//        currentStaff = entity.getDetailStaff(entity.getSelectID(tblStaff));
        enableButton(true);
    }//GEN-LAST:event_tblStaffMouseClicked

    private void tblPromotionDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPromotionDetailMouseClicked
        btnPromotionDetail.setEnabled(true);
    }//GEN-LAST:event_tblPromotionDetailMouseClicked

    private void tblFeedbackDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeedbackDetailMouseClicked
        btnFeedbackDetail.setEnabled(true);
    }//GEN-LAST:event_tblFeedbackDetailMouseClicked

    private void tblPromotionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPromotionMouseClicked
        btnPromotionDelete.setEnabled(true);
        btnPromotionEdit.setEnabled(true);
    }//GEN-LAST:event_tblPromotionMouseClicked

    private void tblRelationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRelationMouseClicked
        btnRelationDelete.setEnabled(true);
        btnRelationEdit.setEnabled(true);
    }//GEN-LAST:event_tblRelationMouseClicked

    private void comboDepartmentSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepartmentSearchActionPerformed
        if(comboDepartmentSearch.getSelectedIndex() >0){
        comboPositionSearch.setEnabled(true);
        comboPositionSearch.removeAllItems();
        comboPositionSearch.addItem("All");
        List<String> listPos=positionEntity.getNameList(comboDepartmentSearch.getSelectedItem().toString());
        for(String str:listPos){
            comboPositionSearch.addItem(str);
        }
        }
    }//GEN-LAST:event_comboDepartmentSearchActionPerformed

    private void txtNoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSearchActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      search();           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       act = ADD;
        newStaff = new Staff();
        showPanel("Add Staff", cont,listPanel,detailPanel);
        loadAdd();     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
     act = EDIT;
        currentStaff = entity.findByID(entity.getSelectID(tblStaff));
        if (currentStaff == null) {
            return;
        }
        newStaff = currentStaff;
        loadEdit();
        showPanel("Edit Staff", cont,listPanel,detailPanel);           // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
 deactive();               // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        export();    // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
       txtNoSearch.setText("");
        txtNameSearch.setText("");
       
        comboDepartmentSearch.setSelectedIndex(0);

        comboPositionSearch.setSelectedIndex(0);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void btnDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailMouseClicked
     act = DETAIL;
        currentStaff = entity.findByID(entity.getSelectID(tblStaff));
        showPanel("Staff Detail",detailPanel,listPanel,cont);
        loadDetail();    // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailMouseClicked

    private void btnFeedbackDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackDetailMouseClicked
     loadFeedbackInfo(DETAIL);   // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackDetailMouseClicked

    private void btnFamilyDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFamilyDetailMouseClicked
      loadRelationInfo(DETAIL);    // TODO add your handling code here:
    }//GEN-LAST:event_btnFamilyDetailMouseClicked

    private void btnPromotionDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromotionDetailMouseClicked
     loadPromotionInfo(DETAIL);   // TODO add your handling code here:
    }//GEN-LAST:event_btnPromotionDetailMouseClicked

    private void btnEdit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdit1MouseClicked
        act=EDIT;
        loadEdit();
        showPanel("Edit Staff", cont,listPanel,detailPanel);    // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
     act = ADD;
        newStaff = new Staff();
        showPanel("Add Staff", cont,listPanel,detailPanel);
        loadAdd();   // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void btnViewListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewListMouseClicked
       showPanel("List Staff", listPanel,listPanel,cont);  // TODO add your handling code here:
    }//GEN-LAST:event_btnViewListMouseClicked

    private void tblRelationDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRelationDetailMouseClicked
        btnFamilyDetail.setEnabled(true);
    }//GEN-LAST:event_tblRelationDetailMouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
    loadPromotionInfo(ADD);     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void btnPromotionEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromotionEditMouseClicked
   loadPromotionInfo(EDIT);     // TODO add your handling code here:
    }//GEN-LAST:event_btnPromotionEditMouseClicked

    private void btnPromotionDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromotionDeleteMouseClicked
    removeSelectedPromotion();        // TODO add your handling code here:
    }//GEN-LAST:event_btnPromotionDeleteMouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
     loadRelationInfo(ADD);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void btnRelationEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelationEditMouseClicked
         loadRelationInfo(EDIT);   // TODO add your handling code here:
    }//GEN-LAST:event_btnRelationEditMouseClicked

    private void btnRelationDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelationDeleteMouseClicked
    removeSelectedRelation();    // TODO add your handling code here:
    }//GEN-LAST:event_btnRelationDeleteMouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
      loadFeedbackInfo(ADD);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked

    private void btnFeedbackEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackEditMouseClicked
     loadFeedbackInfo(EDIT);    // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackEditMouseClicked

    private void btnFeedbackDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackDeleteMouseClicked
     removeSelectedFeedback();   // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackDeleteMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
       save();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
       reset();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
    newStaff = null;
        showPanel("List Staff", listPanel,cont,detailPanel);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane addressStaff;
    private javax.swing.JLabel birthdayStaff;
    private javax.swing.JLabel btnDeactive;
    private javax.swing.JLabel btnDetail;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEdit1;
    private javax.swing.JLabel btnExport;
    private javax.swing.JLabel btnFamilyDetail;
    private javax.swing.JLabel btnFeedbackDelete;
    private javax.swing.JLabel btnFeedbackDetail;
    private javax.swing.JLabel btnFeedbackEdit;
    private javax.swing.JLabel btnPromotionDelete;
    private javax.swing.JLabel btnPromotionDetail;
    private javax.swing.JLabel btnPromotionEdit;
    private javax.swing.JLabel btnRelationDelete;
    private javax.swing.JLabel btnRelationEdit;
    private javax.swing.JLabel btnViewList;
    private javax.swing.JComboBox comboDepartmentSearch;
    private javax.swing.JComboBox comboGender;
    private javax.swing.JComboBox comboMarried;
    private javax.swing.JComboBox comboPositionSearch;
    private javax.swing.JPanel cont;
    private com.toedter.calendar.JDateChooser dPicBirthday;
    private com.toedter.calendar.JDateChooser dPicBirthday1;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JPanel detailPaneld;
    private javax.swing.JTextPane educationStaff;
    private javax.swing.JLabel emailStaff;
    private javax.swing.JLabel emailStaff1;
    private javax.swing.JLabel emailStaff2;
    private javax.swing.JTextPane experienceStaff;
    private javax.swing.JLabel jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelAction;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelMarried;
    private javax.swing.JPanel listPanel;
    private javax.swing.JLabel nameStaff;
    private javax.swing.JLabel phoneStaff;
    private javax.swing.JTable tblFeedback;
    private javax.swing.JTable tblFeedbackDetail;
    private javax.swing.JTable tblPromotion;
    private javax.swing.JTable tblPromotionDetail;
    private javax.swing.JTable tblRelation;
    private javax.swing.JTable tblRelationDetail;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtEducation;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtExperience;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtNoSearch;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableButton(boolean b) {
        btnDetail.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDeactive.setEnabled(b);
    }

    @Override
    public boolean validateForm() {
        return true;
    }

    private void export() {
        ExportFile export=new ExportFile(tblStaff, ExportFile.STAFF);
        export.toExcel();
    }
}

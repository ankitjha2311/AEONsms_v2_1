/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import FileExport.ExportFile;
import Controls.Manager;
import Controls.StudentManager;
import Controls.Validate;
import MainObjects.ExtraCurricularEntity;
import MainObjects.StudentEntity;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import TableModel.Admission;
import TableModel.Batch;
import TableModel.ExtraCurricular;
import TableModel.FamilyStudent;
import TableModel.Student;
import TableModel.Mark;
import TableModel.Relative;
import TableModel.Remark;
import MainHome.UIInterface;
import Employee.RelationDetail;
import Employee.RelationUpdate;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class assign extends javax.swing.JInternalFrame implements UIInterface{
    StudentManager studentManager=new StudentManager();
    private ExtraCurricularEntity extraCurricularEntity;
    private StudentEntity entity;
    private int act;
    private int currentPage=1;
    private int totalPage=3; 
    Student currenStudent;
    Student newStudent;
    /**
     * Creates new form ListStudent
     */
    public assign() {
        initComponents();
    }
    public assign(int w, int h ) {
        this.extraCurricularEntity=new ExtraCurricularEntity();
        this.entity=new StudentEntity();
        initComponents();
        initUI();
        setSize(w, h+30);
    }
    public void initUI(){
        enableButton(false);
        showPanel("List Student", listPanel,detailPanel,updatePanel);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        studentManager.loadCombobox("SELECT name FROM batch", comboBatchSearch);
        studentManager.loadTable(studentManager.getStudentList(currentPage), tblStudent, Manager.STUDENT_MODEL);
    }
    public void showPanel(String name, JPanel panel,JPanel panel1,JPanel panel2) {
       panel.setVisible(true);
       panel1.setVisible(false);
       panel2.setVisible(false);
    }
    @Override
    public void enableEditAddPanel(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void add() {
        int res = studentManager.addStudent(newStudent);
        studentManager.showMessage(res, this);
    }


    public void edit() {
        int res = studentManager.editStudent(newStudent, currenStudent);
        studentManager.showMessage(res, this);
    }

    @Override
    public void deactive() {
        int res=studentManager.deactiveStudent(studentManager.getSelectID(tblStudent));
        entity.showMessage(res, this);
        if(res==Manager.SUCCESS){
            initUI();
        }
    }
    private void reset(){
        newStudent = currenStudent;
        if (act == EDIT) {
            studentManager.refreshTable(tblMark);
            studentManager.refreshTable(tblRelation);
            studentManager.refreshTable(tblRemark);
            loadEdit();
        } else if (act == ADD) {
            loadAdd();
        }
    }
    @Override
    public void save(){
        newStudent.setName(txtName.getText());
        newStudent.setAddress(txtAddress.getText());
        newStudent.setEmail(txtEmail.getText());
        newStudent.setGender(studentManager.formatGender((String) comboGender.getSelectedItem()));
        newStudent.setPhone(txtPhone.getText());
        newStudent.setNo(txtNo.getText());
        newStudent.setAdmission(new Admission( admiDPic.getDate(), txtPrevInstituteEdit.getText(), txtReasonLeavingEdit.getText()));
        newStudent.getAcademic().setBatch(new Batch((String)comboBatch.getSelectedItem()));
        newStudent.setGender(studentManager.formatGender((String)comboGender.getSelectedItem()));
        newStudent.setBirthday(dPic.getDate());
        if (newStudent.getFamilyStudent()== null) {
            newStudent.setFamilyStudent(new FamilyStudent());
        }
        if (act == EDIT) {
            edit();
        } else if (act == ADD) {
            add();

        }
        initUI();
    
        return;
    }

    @Override
    public void search(){
        if(!Validate.isEmpty(txtRegisterNoSearch.getText()) && !Validate.isNumber(txtRegisterNoSearch.getText())){
            JOptionPane.showMessageDialog(this, "Register No must be number");
            return;
        }
        String SQL = "SELECT student.ID, student.academic_register_No, student.No, student.name,batch.name AS Batch, student.phone, student.email, student.gender "
                + "from student LEFT JOIN (academic LEFT JOIN batch on academic.batch_ID=batch.ID) ON academic.register_No=student.academic_register_No WHERE student.status=1  ";
        if(!txtRegisterNoSearch.getText().isEmpty()){
            SQL+=" AND student.academic_register_No="+Integer.parseInt(txtRegisterNoSearch.getText());
        }
        if(!txtNoSearch.getText().isEmpty()){
            SQL+=" AND student.No='"+txtNoSearch.getText()+"'";
        }
        if(!txtNameSearch.getText().isEmpty()){
            SQL+=" AND student.name='"+txtNameSearch.getText()+"'";
        }
        if(comboBatchSearch.getSelectedIndex() !=0){
            SQL+=" AND batch.name='"+(String)comboBatchSearch.getSelectedItem()+"'";
        }
        studentManager.loadTable(SQL, tblStudent, Manager.STUDENT_MODEL);
        enableButton(false);
    }
    @Override
    public void loadEdit(){
        
        btnDeleteMark.setEnabled(false);
        btnEditMark.setEnabled(false);
        btnDeleteRelation.setEnabled(false);
        btnEditRelation.setEnabled(false);
        btnDeleteRemark.setEnabled(false);
        btnEditRemark.setEnabled(false);
        
        loadMarkTbl(tblMark);
        loadRelationTbl(tblRelation);
        loadRemarkTbl(tblRemark);
        loadExtraTbl(tblExtraCurricular);
        studentManager.loadCombobox("SELECT name FROM batch", comboBatch);
        
        txtRegisterNo.setText(currenStudent.getRegisterNo()+"");
        txtAddress.setText(currenStudent.getAddress());
        dPic.setDate(currenStudent.getBirthday());
        txtEmail.setText(currenStudent.getEmail());
        txtPhone.setText(currenStudent.getPhone());
        txtName.setText(currenStudent.getName());
        txtNo.setText(currenStudent.getNo());
        if(currenStudent.getAdmission() !=null){
            txtPrevInstituteEdit.setText(currenStudent.getAdmission().getPrev_Institute());
            txtReasonLeavingEdit.setText(currenStudent.getAdmission().getReason_Leaving());
            admiDPic.setDate(currenStudent.getAdmission().getTime());
        }
        comboGender.setSelectedItem(studentManager.parseGender(currenStudent.getGender()));
        
        if(currenStudent.getAcademic() !=null && currenStudent.getAcademic().getBatch() !=null)
            comboBatch.setSelectedItem(currenStudent.getAcademic().getBatch().getName());
        
    }
    private void loadAdd(){
        
        btnDeleteMark.setEnabled(false);
        btnEditMark.setEnabled(false);
        btnDeleteRelation.setEnabled(false);
        btnEditRelation.setEnabled(false);
        btnDeleteRemark.setEnabled(false);
        btnEditRemark.setEnabled(false);
        
        studentManager.refreshTable(tblMark);
        studentManager.refreshTable(tblRelation);
        studentManager.refreshTable(tblRemark);
        studentManager.loadCombobox("SELECT name FROM batch", comboBatch);
        
        txtAddress.setText("");
        dPic.setDate(null);
        txtEmail.setText("");
        txtName.setText("");
        txtNo.setText("");
        txtPrevInstituteEdit.setText("");
        txtReasonLeavingEdit.setText("");
        admiDPic.setDate(null);
    }
    private void loadDetail(){
        if(currenStudent==null)
            return;
        btnRelationDetail.setEnabled(false);
        btnExtraDetail.setEnabled(false);
        
        loadMarkTbl(tblExtraCurricularDetail);
        loadRelationTbl(tblRelationDetail);
        loadRemarkTbl(tblRemarkDetail);
        loadExtraTbl(tblExtraCurricularDetail);
        
        labelAddress.setText(currenStudent.getAddress());
        if(currenStudent.getAdmission() !=null){
            labelAdmissionTime.setText(studentManager.formatDate(currenStudent.getAdmission().getTime()));
            labelPrevInstitute.setText(currenStudent.getAdmission().getPrev_Institute());
            labelReasonLeaving.setText(currenStudent.getAdmission().getReason_Leaving());
        }
        if(currenStudent.getAcademic() !=null){
            labelRegisterNo.setText(currenStudent.getAcademic().getRegisterNo()+"");
            if(currenStudent.getAcademic().getBatch() !=null){
                labelBatch.setText(currenStudent.getAcademic().getBatch().getName());
            }
        }
        labelBirthday.setText(studentManager.formatDate(currenStudent.getBirthday()));
        labelEmail1.setText(currenStudent.getEmail());
        labelGender.setText(studentManager.parseGender(currenStudent.getGender()));
        labelName.setText(currenStudent.getName());
        labelNo.setText(currenStudent.getNo());
        labelPhone.setText(currenStudent.getPhone());
        
    }
    private void loadMarkTbl(JTable tbl){
        List<Mark> marks=currenStudent.getMarks();
        if(marks==null || marks.size() <1){
            return;
        }
        int count=0;
        String[][] data=new String[marks.size()][4];
        for(Mark m:marks){
            data[count++]=new String[]{
              m.getID()+"",
              m.getSubject().getName(),
              m.getPoint()+"",
              studentManager.formatDate(m.getTime())
            };
        }
        studentManager.loadTable(data, tbl);
    }
    private void loadRelationTbl(JTable tbl){
        int count = 0;
        if (currenStudent.getFamilyStudent()== null || currenStudent.getFamilyStudent().getListRelative()== null) {
            return;
        }
        List<Relative> listreRelatives = currenStudent.getFamilyStudent().getListRelative();
        String[][] data = new String[listreRelatives.size()][7];
        for (Relative r : listreRelatives) {
            data[count++] = new String[]{
                r.getID() + "",
                r.getRelation(),
                r.getName(),
                r.getPhone(),
                r.getAddress(),
                r.getOccupation(),
                studentManager.parseGender(r.getGender())
            };
        }
        studentManager.loadTable(data, tbl);
    }
    private void loadRemarkTbl(JTable tbl){
        int count = 0;
        if (currenStudent.getRemarks()== null || currenStudent.getRemarks().size()<1) {
            return;
        }
        List<Remark> remarks = currenStudent.getRemarks();
        String[][] data = new String[remarks.size()][4];
        for (Remark r : remarks) {
            data[count++] = new String[]{
                r.getID()+"",
                r.getStaff().getNo()+"",
                r.getStaff().getName(),
                r.getContent(),
                studentManager.formatDate(r.getTime())
            };
        }
        studentManager.loadTable(data, tbl);
    }
    private void loadRemarkInfo(int mode){
        if (act == DETAIL) {
            new RemarkDetail(null, true, currenStudent.getRemarks().get(tblRemarkDetail.getSelectedRow()), studentManager).setVisible(true);
            return;
        }
        RemarkUpdate remarkUpdate = null;
        if (mode == ADD) {
            remarkUpdate = new RemarkUpdate(null, true, null, studentManager);
            remarkUpdate.setVisible(true);
        } else if (mode == EDIT) {
            remarkUpdate = new RemarkUpdate(null, true, studentManager.getSelectRow(tblRemark), studentManager);
            remarkUpdate.setVisible(true);
            if (remarkUpdate.getRemark()!= null) {
                removeSelectedRemark();
            }
        }
        if (remarkUpdate.getRemark() != null) {
            addRowTableRemark(remarkUpdate.getRemark());
            newStudent.addRemark(remarkUpdate.getRemark());
        }
    }
    private void removeSelectedRemark(){
        Vector row = studentManager.getSelectRow(tblRemark);
        newStudent.removeRemark(Integer.parseInt(row.get(1).toString()), entity.parseDate(row.get(4).toString()));
        studentManager.removeSelectedRowTable(tblRemark); 
    }
    private void addRowTableRemark(Remark r){
        Vector row = new Vector();
        row.add(r.getID());
        row.add(r.getStaff().getNo());
        row.add(r.getStaff().getName());
        row.add(r.getContent());
        row.add(studentManager.formatDate(r.getTime()));
        DefaultTableModel model = (DefaultTableModel) tblRemark.getModel();
        model.addRow(row);
    }
   
    private void loadExtraTbl(JTable tbl){
        int count = 0;
        if (currenStudent.getExtraCurriculars()== null || currenStudent.getExtraCurriculars().size()<1) {
            return;
        }
        List<ExtraCurricular> extraCurriculars = currenStudent.getExtraCurriculars();
        String[][] data = new String[extraCurriculars.size()][4];
        for (ExtraCurricular extra : extraCurriculars) {
            data[count++] = new String[]{
                extra.getID()+"",
                extra.getName(),
                extra.getLocation(),
                extraCurricularEntity.formatDate(extra.getStart()),
                extraCurricularEntity.formatDate(extra.getEnd()),
                extra.getNotes()
            };
        }
        studentManager.loadTable(data, tbl);
    }
    private void loadExtraInfo(int mode){
        if (act == DETAIL) {
            new ExtraCurricularDetail(null, true, currenStudent.getExtraCurriculars().get(tblExtraCurricularDetail.getSelectedRow())).setVisible(true);
            return;
        }
        ExtraCurricularUpdate extraCurricularUpdate = null;
        if (mode == ADD) {
            extraCurricularUpdate = new ExtraCurricularUpdate(null, true, null);
            extraCurricularUpdate.setVisible(true);
        } else if (mode == EDIT) {
            extraCurricularUpdate = new ExtraCurricularUpdate(null, true, entity.getSelectRow(tblExtraCurricular));
            extraCurricularUpdate.setVisible(true);
            if (extraCurricularUpdate.getExtraCurricular()!= null) {
                removeSelectedRemark();
            }
        }
        if (extraCurricularUpdate.getExtraCurricular()!= null) {
            addRowTableExtra(extraCurricularUpdate.getExtraCurricular());
            newStudent.addExtraCurricalar(extraCurricularUpdate.getExtraCurricular());
        }
    }
    private void removeSelectedExtra(){
        Vector row = studentManager.getSelectRow(tblExtraCurricular);
        newStudent.removeExtraCurricular(row.get(0).toString(), row.get(1).toString(), entity.parseDate(row.get(2).toString()), entity.parseDate(row.get(3).toString()));
        studentManager.removeSelectedRowTable(tblExtraCurricular);
    }
    private void addRowTableExtra(ExtraCurricular extra){
        Vector row = new Vector();
        row.add(extra.getID());
        row.add(extra.getName());
        row.add(extra.getLocation());
        row.add(entity.formatDate(extra.getStart()));
        row.add(entity.formatDate(extra.getEnd()));
        row.add(extra.getNotes());
        DefaultTableModel model = (DefaultTableModel) tblExtraCurricular.getModel();
        model.addRow(row);
    }
    private void loadRelationInfo(int mode){
        if (act == DETAIL) {
            new RelationDetail(null, true, currenStudent.getFamilyStudent().getListRelative().get(tblRelationDetail.getSelectedRow())).setVisible(true);
            return;
        }
        RelationUpdate relationUpdate = null;
        if (mode == ADD) {
            relationUpdate = new RelationUpdate(null, true, studentManager, null);
            relationUpdate.setVisible(true);
        } else if (mode == EDIT) {
            relationUpdate = new RelationUpdate(null, true, studentManager, studentManager.getSelectRow(tblRelation));
            relationUpdate.setVisible(true);
            if (relationUpdate.getRelaRelatives() != null) {
                removeSelectedRelation();
            }
        }
        if (relationUpdate.getRelaRelatives() != null) {
            addRowTableRelation(relationUpdate.getRelaRelatives());
            newStudent.getFamilyStudent().addRelative(relationUpdate.getRelaRelatives());
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
        row.add(studentManager.parseGender(r.getGender()));
        DefaultTableModel model = (DefaultTableModel) tblRelation.getModel();
        model.addRow(row);
    }
    private void removeSelectedRelation() {
        Vector row = studentManager.getSelectRow(tblRelation);
        newStudent.getFamilyStudent().removeRelative((String) row.get(1), (String) row.get(2));
        studentManager.removeSelectedRowTable(tblRelation);
    }
    private void loadMarkinfo(int mode){
        
        MarkUpdate markUpdate=null;
        if(mode==EDIT){
            markUpdate=new MarkUpdate(null, true, studentManager.getSelectRow(tblMark), studentManager);
            markUpdate.setVisible(true);
            if (markUpdate.getMark()!= null) {
                removeSelectedMark();
            }
        }else if(mode==ADD){
            markUpdate=new MarkUpdate(null, true, null, studentManager);
            markUpdate.setVisible(true);
        }
        if(markUpdate.getMark() !=null){
            addRowTableMark(markUpdate.getMark());
            newStudent.addMark(markUpdate.getMark());
        }
        
    }
    private void removeSelectedMark(){
        Vector row = studentManager.getSelectRow(tblMark);
        newStudent.removeMark((String)row.get(1), studentManager.parseDate(row.get(3).toString()));
        studentManager.removeSelectedRowTable(tblMark);
    }
    private void addRowTableMark(Mark mark){
        Vector row=new Vector();
        row.add(mark.getID());
        row.add(mark.getSubject().getName());
        row.add(mark.getPoint());
        row.add(studentManager.formatDate(mark.getTime()));
        DefaultTableModel model = (DefaultTableModel) tblMark.getModel();
        model.addRow(row);
    }
    private void enableButton(Boolean b){}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updatePanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        can = new javax.swing.JPanel();
        txtNo = new javax.swing.JTextField();
        comboBatch = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMark = new javax.swing.JTable();
        comboGender = new javax.swing.JComboBox();
        labelUpdate = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblRelation = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtPrevInstituteEdit = new javax.swing.JTextField();
        txtReasonLeavingEdit = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblRemark = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tblExtraCurricular = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        txtRegisterNo = new javax.swing.JTextField();
        dPic = new com.toedter.calendar.JDateChooser();
        admiDPic = new com.toedter.calendar.JDateChooser();
        comboBatch1 = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btnAddRelation = new javax.swing.JLabel();
        btnEditRelation = new javax.swing.JLabel();
        btnDeleteRelation = new javax.swing.JLabel();
        btnEditMark = new javax.swing.JLabel();
        btnDeleteMark = new javax.swing.JLabel();
        btnAddMark = new javax.swing.JLabel();
        btnDeleteRemark = new javax.swing.JLabel();
        btnEditRemark = new javax.swing.JLabel();
        btnAddRemark = new javax.swing.JLabel();
        btnDeleteExtra = new javax.swing.JLabel();
        btnEditExtra = new javax.swing.JLabel();
        btnAddExtra = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtRegisterNoSearch = new javax.swing.JTextField();
        txtNoSearch = new javax.swing.JTextField();
        txtNameSearch = new javax.swing.JTextField();
        comboBatchSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        btnEdit1 = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        btnDeactive = new javax.swing.JLabel();
        detailPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExtraDetail = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        labelReasonLeaving = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelNo = new javax.swing.JLabel();
        labelBirthday = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnDeactive1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        labelRegisterNo = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMarkDetail3 = new javax.swing.JTable();
        btnRelationDetail = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblRemarkDetail = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelAdmissionTime = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        labelBatch = new javax.swing.JLabel();
        btnRemarkDetail = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelAddress = new javax.swing.JTextPane();
        labelPrevInstitute = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblRelationDetail = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblExtraCurricularDetail = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnViewList = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        labelEmail1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(224, 224, 255));
        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        can.setBackground(new java.awt.Color(178, 208, 224));
        can.setMinimumSize(new java.awt.Dimension(1050, 1365));
        can.setPreferredSize(new java.awt.Dimension(1031, 1300));
        can.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNo.setBackground(new java.awt.Color(85, 153, 187));
        txtNo.setBorder(null);
        can.add(txtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 180, 25));

        can.add(comboBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 180, 25));

        jLabel40.setBackground(new java.awt.Color(0, 102, 153));
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Roll No");
        jLabel40.setOpaque(true);
        can.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 90, 25));

        jLabel42.setBackground(new java.awt.Color(0, 102, 153));
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Batch");
        jLabel42.setOpaque(true);
        can.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 90, 25));

        txtName.setBackground(new java.awt.Color(85, 153, 187));
        txtName.setBorder(null);
        can.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 200, 25));

        jLabel43.setBackground(new java.awt.Color(0, 102, 153));
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Name");
        jLabel43.setOpaque(true);
        can.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 88, 25));

        jLabel51.setBackground(new java.awt.Color(0, 102, 153));
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Email");
        jLabel51.setOpaque(true);
        can.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 88, 25));

        txtEmail.setBackground(new java.awt.Color(85, 153, 187));
        txtEmail.setBorder(null);
        can.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 200, 25));

        jLabel52.setBackground(new java.awt.Color(0, 102, 153));
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Phone");
        jLabel52.setOpaque(true);
        can.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 90, 25));

        jScrollPane6.setBorder(null);
        jScrollPane6.setForeground(new java.awt.Color(255, 255, 255));

        txtAddress.setBackground(new java.awt.Color(85, 153, 187));
        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAddress.setRows(5);
        txtAddress.setToolTipText("");
        txtAddress.setBorder(null);
        jScrollPane6.setViewportView(txtAddress);

        can.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 670, 90));

        jLabel53.setBackground(new java.awt.Color(0, 102, 153));
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("D.O.B");
        jLabel53.setOpaque(true);
        can.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 90, 25));

        jLabel54.setBackground(new java.awt.Color(0, 102, 153));
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Gender");
        jLabel54.setOpaque(true);
        can.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 88, 25));

        jLabel55.setBackground(new java.awt.Color(0, 102, 153));
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Mark");
        jLabel55.setOpaque(true);
        can.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, 88, 25));

        jScrollPane7.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane7.setForeground(new java.awt.Color(255, 255, 255));

        tblMark.setBackground(new java.awt.Color(4, 74, 121));
        tblMark.setForeground(new java.awt.Color(255, 255, 255));
        tblMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "Mark", "Time"
            }
        ));
        tblMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarkMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMark);

        can.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 710, 760, 100));

        comboGender.setBackground(new java.awt.Color(85, 153, 187));
        comboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));
        comboGender.setBorder(null);
        can.add(comboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 200, 25));

        labelUpdate.setBackground(new java.awt.Color(4, 74, 121));
        labelUpdate.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        labelUpdate.setForeground(new java.awt.Color(255, 255, 255));
        labelUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUpdate.setText("EDIT STUDENT");
        labelUpdate.setOpaque(true);
        can.add(labelUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        btnCancel.setBackground(new java.awt.Color(0, 102, 153));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setText("Cancel");
        btnCancel.setOpaque(true);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        can.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 1140, 88, 25));

        jScrollPane21.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane21.setForeground(new java.awt.Color(255, 255, 255));

        tblRelation.setBackground(new java.awt.Color(4, 74, 121));
        tblRelation.setForeground(new java.awt.Color(255, 255, 255));
        tblRelation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Relation", "Name", "Phone", "Address", "Occupation", "Gender"
            }
        ));
        tblRelation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRelationMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tblRelation);

        can.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1020, 760, 100));

        jLabel60.setBackground(new java.awt.Color(0, 102, 153));
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Last School");
        jLabel60.setOpaque(true);
        can.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 90, 25));

        jLabel61.setBackground(new java.awt.Color(0, 102, 153));
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Reason leaving");
        jLabel61.setOpaque(true);
        can.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 90, 25));

        jLabel62.setBackground(new java.awt.Color(0, 102, 153));
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Time");
        jLabel62.setOpaque(true);
        can.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 88, 25));

        txtPrevInstituteEdit.setBackground(new java.awt.Color(85, 153, 187));
        txtPrevInstituteEdit.setBorder(null);
        can.add(txtPrevInstituteEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 495, 25));

        txtReasonLeavingEdit.setBackground(new java.awt.Color(85, 153, 187));
        txtReasonLeavingEdit.setBorder(null);
        can.add(txtReasonLeavingEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 495, 25));

        jLabel63.setBackground(new java.awt.Color(0, 102, 153));
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Remark");
        jLabel63.setOpaque(true);
        can.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 830, 88, 25));

        jScrollPane22.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane22.setForeground(new java.awt.Color(255, 255, 255));

        tblRemark.setBackground(new java.awt.Color(4, 74, 121));
        tblRemark.setForeground(new java.awt.Color(255, 255, 255));
        tblRemark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Staff No", "Staff name", "Content", "Time"
            }
        ));
        tblRemark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRemarkMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tblRemark);

        can.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 860, 760, 100));

        jLabel3.setBackground(new java.awt.Color(0, 102, 153));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Address");
        jLabel3.setOpaque(true);
        can.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 90, 90));

        txtPhone.setBackground(new java.awt.Color(85, 153, 187));
        txtPhone.setBorder(null);
        can.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 180, 25));

        jLabel67.setBackground(new java.awt.Color(0, 102, 153));
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Extra Curricular");
        jLabel67.setOpaque(true);
        can.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 88, 25));

        jScrollPane23.setBackground(new java.awt.Color(4, 74, 121));
        jScrollPane23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));
        jScrollPane23.setForeground(new java.awt.Color(255, 255, 255));

        tblExtraCurricular.setBackground(new java.awt.Color(4, 74, 121));
        tblExtraCurricular.setForeground(new java.awt.Color(255, 255, 255));
        tblExtraCurricular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Start", "End", "Notes"
            }
        ));
        tblExtraCurricular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExtraCurricularMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tblExtraCurricular);

        can.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 760, 75));

        jLabel44.setBackground(new java.awt.Color(0, 102, 153));
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Register No");
        jLabel44.setOpaque(true);
        can.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 90, 25));

        txtRegisterNo.setEditable(false);
        txtRegisterNo.setBackground(new java.awt.Color(85, 153, 187));
        txtRegisterNo.setBorder(null);
        can.add(txtRegisterNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 180, 25));
        can.add(dPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 180, 25));
        can.add(admiDPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 200, 25));

        comboBatch1.setBackground(new java.awt.Color(85, 153, 187));
        comboBatch1.setBorder(null);
        can.add(comboBatch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 200, 25));

        jLabel45.setBackground(new java.awt.Color(0, 102, 153));
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Batch");
        jLabel45.setOpaque(true);
        can.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 88, 25));

        jLabel46.setBackground(new java.awt.Color(85, 153, 187));
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Name");
        jLabel46.setOpaque(true);
        can.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 140, 180));

        jLabel47.setBackground(new java.awt.Color(0, 102, 153));
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Browse");
        jLabel47.setOpaque(true);
        can.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 140, 25));

        btnAddRelation.setBackground(new java.awt.Color(224, 224, 255));
        btnAddRelation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddRelation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        btnAddRelation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAddRelation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddRelationMouseClicked(evt);
            }
        });
        can.add(btnAddRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 990, 30, 25));

        btnEditRelation.setBackground(new java.awt.Color(0, 68, 102));
        btnEditRelation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditRelation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnEditRelation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditRelation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditRelationMouseClicked(evt);
            }
        });
        can.add(btnEditRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 990, 30, 25));

        btnDeleteRelation.setBackground(new java.awt.Color(0, 68, 102));
        btnDeleteRelation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteRelation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnDeleteRelation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteRelation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteRelationMouseClicked(evt);
            }
        });
        can.add(btnDeleteRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 990, 30, 25));

        btnEditMark.setBackground(new java.awt.Color(0, 68, 102));
        btnEditMark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnEditMark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMarkMouseClicked(evt);
            }
        });
        can.add(btnEditMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 680, 30, 25));

        btnDeleteMark.setBackground(new java.awt.Color(0, 68, 102));
        btnDeleteMark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnDeleteMark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMarkMouseClicked(evt);
            }
        });
        can.add(btnDeleteMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 30, 25));

        btnAddMark.setBackground(new java.awt.Color(224, 224, 255));
        btnAddMark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        btnAddMark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAddMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMarkMouseClicked(evt);
            }
        });
        can.add(btnAddMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 680, 30, 25));

        btnDeleteRemark.setBackground(new java.awt.Color(0, 68, 102));
        btnDeleteRemark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteRemark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnDeleteRemark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteRemark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteRemarkMouseClicked(evt);
            }
        });
        can.add(btnDeleteRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 830, 30, 25));

        btnEditRemark.setBackground(new java.awt.Color(0, 68, 102));
        btnEditRemark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditRemark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnEditRemark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditRemark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditRemarkMouseClicked(evt);
            }
        });
        can.add(btnEditRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 830, 30, 25));

        btnAddRemark.setBackground(new java.awt.Color(224, 224, 255));
        btnAddRemark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddRemark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        btnAddRemark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAddRemark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddRemarkMouseClicked(evt);
            }
        });
        can.add(btnAddRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 830, 30, 25));

        btnDeleteExtra.setBackground(new java.awt.Color(0, 68, 102));
        btnDeleteExtra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        btnDeleteExtra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteExtraMouseClicked(evt);
            }
        });
        can.add(btnDeleteExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 30, 25));

        btnEditExtra.setBackground(new java.awt.Color(0, 68, 102));
        btnEditExtra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        btnEditExtra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditExtraMouseClicked(evt);
            }
        });
        can.add(btnEditExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 30, 25));

        btnAddExtra.setBackground(new java.awt.Color(224, 224, 255));
        btnAddExtra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_Math_20px_1.png"))); // NOI18N
        btnAddExtra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAddExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddExtraMouseClicked(evt);
            }
        });
        can.add(btnAddExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 30, 25));

        jLabel58.setBackground(new java.awt.Color(0, 102, 153));
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Family ");
        jLabel58.setOpaque(true);
        can.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 990, 88, 25));

        btnSave.setBackground(new java.awt.Color(0, 102, 153));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.setOpaque(true);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        can.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1140, 88, 25));

        btnReset.setBackground(new java.awt.Color(0, 102, 153));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setText("Reset");
        btnReset.setOpaque(true);
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        can.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1140, 88, 25));

        jScrollPane4.setViewportView(can);

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        getContentPane().add(updatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        listPanel.setBackground(new java.awt.Color(179, 209, 224));
        listPanel.setPreferredSize(new java.awt.Dimension(1010, 700));
        listPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(224, 224, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));

        tblStudent.setBackground(new java.awt.Color(179, 209, 224));
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Register No", "No", "Name", "Batch", "Phone", "Email", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudent.setOpaque(false);
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        listPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 733, 285));

        jLabel19.setBackground(new java.awt.Color(45, 129, 171));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Register no");
        jLabel19.setOpaque(true);
        listPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, 25));

        jLabel64.setBackground(new java.awt.Color(45, 129, 171));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Roll No");
        jLabel64.setOpaque(true);
        listPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 90, 25));

        jLabel65.setBackground(new java.awt.Color(45, 129, 171));
        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Name");
        jLabel65.setOpaque(true);
        listPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 90, 25));

        jLabel66.setBackground(new java.awt.Color(0, 68, 102));
        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Search");
        jLabel66.setOpaque(true);
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });
        listPanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 90, 25));

        txtRegisterNoSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtRegisterNoSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRegisterNoSearch.setBorder(null);
        listPanel.add(txtRegisterNoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 200, 25));

        txtNoSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNoSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoSearch.setBorder(null);
        listPanel.add(txtNoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 200, 25));

        txtNameSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtNameSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNameSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtNameSearch.setBorder(null);
        listPanel.add(txtNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 170, 25));

        comboBatchSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboBatchSearch.setEditable(true);
        comboBatchSearch.setBorder(null);
        listPanel.add(comboBatchSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 170, 25));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Student_Male_38px.png"))); // NOI18N
        jLabel5.setText("Student List");
        jLabel5.setIconTextGap(12);
        jLabel5.setOpaque(true);
        listPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jLabel68.setBackground(new java.awt.Color(45, 129, 171));
        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Batch");
        jLabel68.setOpaque(true);
        listPanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 90, 25));

        jLabel69.setBackground(new java.awt.Color(0, 68, 102));
        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Reset");
        jLabel69.setOpaque(true);
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });
        listPanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 90, 25));

        jLabel70.setBackground(new java.awt.Color(0, 68, 102));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Add");
        jLabel70.setOpaque(true);
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
        });
        listPanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 90, 25));

        btnEdit1.setBackground(new java.awt.Color(0, 68, 102));
        btnEdit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit1.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEdit1.setText("Edit");
        btnEdit1.setOpaque(true);
        btnEdit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdit1MouseClicked(evt);
            }
        });
        listPanel.add(btnEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 90, 25));

        btnExport.setBackground(new java.awt.Color(0, 68, 102));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExport.setText("Export");
        btnExport.setOpaque(true);
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        listPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 90, 25));

        btnDetail.setBackground(new java.awt.Color(0, 68, 102));
        btnDetail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDetail.setText("Detail");
        btnDetail.setOpaque(true);
        btnDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetailMouseClicked(evt);
            }
        });
        listPanel.add(btnDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 90, 25));

        btnDeactive.setBackground(new java.awt.Color(0, 68, 102));
        btnDeactive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeactive.setForeground(new java.awt.Color(255, 255, 255));
        btnDeactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeactive.setText("Deactivate");
        btnDeactive.setOpaque(true);
        btnDeactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeactiveMouseClicked(evt);
            }
        });
        listPanel.add(btnDeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 90, 25));

        getContentPane().add(listPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        detailPanel.setMinimumSize(new java.awt.Dimension(1010, 700));
        detailPanel.setPreferredSize(new java.awt.Dimension(1010, 700));
        detailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(179, 209, 224));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 1181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 102, 153));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Name");
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 120, 26));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phone");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 120, 26));

        btnExtraDetail.setBackground(new java.awt.Color(0, 102, 153));
        btnExtraDetail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExtraDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnExtraDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_18px_1.png"))); // NOI18N
        btnExtraDetail.setText("Detail");
        btnExtraDetail.setBorderPainted(false);
        btnExtraDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraDetailActionPerformed(evt);
            }
        });
        jPanel1.add(btnExtraDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, 100, 26));

        jLabel16.setBackground(new java.awt.Color(0, 102, 153));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Gender");
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 26));

        jLabel39.setBackground(new java.awt.Color(0, 102, 153));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Extra Curricular");
        jLabel39.setOpaque(true);
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 680, 26));

        labelReasonLeaving.setBackground(new java.awt.Color(85, 153, 187));
        labelReasonLeaving.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelReasonLeaving.setForeground(new java.awt.Color(255, 255, 255));
        labelReasonLeaving.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReasonLeaving.setText("Reason leaving");
        labelReasonLeaving.setOpaque(true);
        jPanel1.add(labelReasonLeaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 660, 50));

        jLabel20.setBackground(new java.awt.Color(0, 102, 153));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Roll No");
        jLabel20.setOpaque(true);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 26));

        labelNo.setBackground(new java.awt.Color(85, 153, 187));
        labelNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNo.setForeground(new java.awt.Color(255, 255, 255));
        labelNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNo.setText("No");
        labelNo.setOpaque(true);
        jPanel1.add(labelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 280, 26));

        labelBirthday.setBackground(new java.awt.Color(85, 153, 187));
        labelBirthday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelBirthday.setForeground(new java.awt.Color(255, 255, 255));
        labelBirthday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBirthday.setText("Birthday");
        labelBirthday.setOpaque(true);
        jPanel1.add(labelBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 240, 26));

        labelPhone.setBackground(new java.awt.Color(85, 153, 187));
        labelPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPhone.setForeground(new java.awt.Color(255, 255, 255));
        labelPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPhone.setText("Phone");
        labelPhone.setOpaque(true);
        jPanel1.add(labelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 280, 26));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/20x20/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 1150, 80, -1));

        jLabel11.setBackground(new java.awt.Color(0, 102, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Family Infomation");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 760, 690, 26));

        btnDeactive1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/20x20/Export.png"))); // NOI18N
        btnDeactive1.setText("Deactive");
        btnDeactive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeactiveActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeactive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 1150, -1, -1));

        jLabel25.setBackground(new java.awt.Color(0, 102, 153));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Reason leaving");
        jLabel25.setOpaque(true);
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 50));

        labelRegisterNo.setBackground(new java.awt.Color(85, 153, 187));
        labelRegisterNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelRegisterNo.setForeground(new java.awt.Color(255, 255, 255));
        labelRegisterNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegisterNo.setText("Register No");
        labelRegisterNo.setOpaque(true);
        jPanel1.add(labelRegisterNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 240, 26));

        tblMarkDetail3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "Mark", "Time"
            }
        ));
        tblMarkDetail3.setPreferredSize(new java.awt.Dimension(245, 120));
        jScrollPane10.setViewportView(tblMarkDetail3);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 950, 780, 140));

        btnRelationDetail.setBackground(new java.awt.Color(0, 102, 153));
        btnRelationDetail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRelationDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnRelationDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_18px_1.png"))); // NOI18N
        btnRelationDetail.setText("Detail");
        btnRelationDetail.setBorderPainted(false);
        btnRelationDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelationDetailActionPerformed(evt);
            }
        });
        jPanel1.add(btnRelationDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 760, -1, 26));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Date of Birth");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, 26));

        jLabel1.setBackground(new java.awt.Color(0, 68, 102));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT DETAIL");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 60));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Email");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 26));

        tblRemarkDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Staff No", "Staff name", "Content", "Time"
            }
        ));
        tblRemarkDetail.setPreferredSize(new java.awt.Dimension(245, 120));
        tblRemarkDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRemarkDetailMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblRemarkDetail);

        jPanel1.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 780, 120));

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register No");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 120, 26));

        labelName.setBackground(new java.awt.Color(85, 153, 187));
        labelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Name");
        labelName.setOpaque(true);
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 240, 26));

        labelAdmissionTime.setBackground(new java.awt.Color(85, 153, 187));
        labelAdmissionTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelAdmissionTime.setForeground(new java.awt.Color(255, 255, 255));
        labelAdmissionTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdmissionTime.setText("Time");
        labelAdmissionTime.setOpaque(true);
        jPanel1.add(labelAdmissionTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 280, 26));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/20x20/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1150, 80, -1));

        labelBatch.setBackground(new java.awt.Color(85, 153, 187));
        labelBatch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelBatch.setForeground(new java.awt.Color(255, 255, 255));
        labelBatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBatch.setText("Batch");
        labelBatch.setOpaque(true);
        jPanel1.add(labelBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 280, 26));

        btnRemarkDetail.setBackground(new java.awt.Color(0, 102, 153));
        btnRemarkDetail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemarkDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnRemarkDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_18px_1.png"))); // NOI18N
        btnRemarkDetail.setText("Detail");
        btnRemarkDetail.setBorderPainted(false);
        btnRemarkDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemarkDetailActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemarkDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 590, 100, 26));

        jLabel23.setBackground(new java.awt.Color(0, 102, 153));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Batch");
        jLabel23.setOpaque(true);
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, 26));

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        labelAddress.setEditable(false);
        labelAddress.setBackground(new java.awt.Color(85, 153, 187));
        labelAddress.setBorder(null);
        labelAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(labelAddress);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 660, 80));

        labelPrevInstitute.setBackground(new java.awt.Color(85, 153, 187));
        labelPrevInstitute.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPrevInstitute.setForeground(new java.awt.Color(255, 255, 255));
        labelPrevInstitute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrevInstitute.setText("Previous institute");
        labelPrevInstitute.setOpaque(true);
        jPanel1.add(labelPrevInstitute, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 240, 26));

        tblRelationDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Relation", "Name", "Phone", "Address", "Occupation", "Gender"
            }
        ));
        tblRelationDetail.setPreferredSize(new java.awt.Dimension(245, 120));
        tblRelationDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRelationDetailMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblRelationDetail);

        jPanel1.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 790, 780, 110));

        jScrollPane9.setBackground(new java.awt.Color(0, 102, 153));
        jScrollPane9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));

        tblExtraCurricularDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Start", "End", "Notes"
            }
        ));
        tblExtraCurricularDetail.setPreferredSize(new java.awt.Dimension(245, 120));
        jScrollPane9.setViewportView(tblExtraCurricularDetail);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 780, 120));

        jLabel10.setBackground(new java.awt.Color(0, 102, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Address");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 120, 80));

        labelGender.setBackground(new java.awt.Color(85, 153, 187));
        labelGender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelGender.setForeground(new java.awt.Color(255, 255, 255));
        labelGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGender.setText("Gender");
        labelGender.setOpaque(true);
        jPanel1.add(labelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 280, 26));

        jLabel30.setBackground(new java.awt.Color(0, 102, 153));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Remark");
        jLabel30.setOpaque(true);
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 680, 26));

        jLabel41.setBackground(new java.awt.Color(0, 102, 153));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Mark");
        jLabel41.setOpaque(true);
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 910, 780, 30));

        btnViewList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/20x20/list.jpg"))); // NOI18N
        btnViewList.setText("View List");
        btnViewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewListActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1150, -1, -1));

        jLabel28.setBackground(new java.awt.Color(0, 102, 153));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Previous School");
        jLabel28.setOpaque(true);
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 26));

        labelEmail1.setBackground(new java.awt.Color(85, 153, 187));
        labelEmail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEmail1.setForeground(new java.awt.Color(255, 255, 255));
        labelEmail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail1.setText("Email");
        labelEmail1.setOpaque(true);
        jPanel1.add(labelEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 240, 26));

        jLabel27.setBackground(new java.awt.Color(0, 102, 153));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Time");
        jLabel27.setOpaque(true);
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 120, 26));

        jScrollPane3.setViewportView(jPanel1);

        detailPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1004, 670));

        getContentPane().add(detailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        act=ADD;
        newStudent=new Student();
        showPanel("Add Student",updatePanel,listPanel,detailPanel);
        loadAdd();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        act=EDIT;
        currenStudent=studentManager.getStudentDetail(studentManager.getSelectID(tblStudent));
        newStudent=currenStudent;
        showPanel("Edit Student",updatePanel,listPanel,detailPanel);
        loadEdit();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeactiveActionPerformed
        deactive();
    }//GEN-LAST:event_btnDeactiveActionPerformed

    private void btnExtraDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraDetailActionPerformed
        loadExtraInfo(DETAIL);
    }//GEN-LAST:event_btnExtraDetailActionPerformed

    private void btnRelationDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelationDetailActionPerformed
        loadRelationInfo(DETAIL);
    }//GEN-LAST:event_btnRelationDetailActionPerformed

    private void btnViewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewListActionPerformed
        showPanel("List Student", listPanel,updatePanel,detailPanel);
    }//GEN-LAST:event_btnViewListActionPerformed

    private void tblRelationDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRelationDetailMouseClicked
        btnRelationDetail.setEnabled(true);
    }//GEN-LAST:event_tblRelationDetailMouseClicked

    private void tblRemarkDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRemarkDetailMouseClicked
        btnExtraDetail.setEnabled(true);
    }//GEN-LAST:event_tblRemarkDetailMouseClicked

    private void btnRemarkDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemarkDetailActionPerformed
        loadRemarkInfo(DETAIL);
    }//GEN-LAST:event_btnRemarkDetailActionPerformed

    private void tblExtraCurricularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExtraCurricularMouseClicked
        btnDeleteExtra.setEnabled(true);
        btnEditExtra.setEnabled(true);
    }//GEN-LAST:event_tblExtraCurricularMouseClicked

    private void tblRemarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRemarkMouseClicked
        btnDeleteRemark.setEnabled(true);
        btnEditRemark.setEnabled(true);
    }//GEN-LAST:event_tblRemarkMouseClicked

    private void tblRelationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRelationMouseClicked
        btnDeleteRelation.setEnabled(true);
        btnEditRelation.setEnabled(true);
    }//GEN-LAST:event_tblRelationMouseClicked

    private void tblMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarkMouseClicked
        btnAddMark.setEnabled(true);
        btnDeleteMark.setEnabled(true);
        btnEditMark.setEnabled(true);
    }//GEN-LAST:event_tblMarkMouseClicked

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        txtRegisterNoSearch.setText("");
        txtNoSearch.setText("");
        txtNameSearch.setText("");
        comboBatchSearch.setSelectedIndex(0);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel69MouseClicked

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        search();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel66MouseClicked

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        currenStudent=studentManager.getStudentDetail(studentManager.getSelectID(tblStudent));
        enableButton(true);
        loadDetail();
        loadEdit();

    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailMouseClicked
  act=DETAIL;
        currenStudent=studentManager.getStudentDetail(studentManager.getSelectID(tblStudent));
        showPanel("Detail Student", detailPanel,listPanel,can);
        loadDetail();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailMouseClicked

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
  act=ADD;
        newStudent=new Student();
        showPanel("Add Student",updatePanel,listPanel,detailPanel);
        loadAdd();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel70MouseClicked

    private void btnEdit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdit1MouseClicked
 act=EDIT;
        currenStudent=studentManager.getStudentDetail(studentManager.getSelectID(tblStudent));
        newStudent=currenStudent;
        showPanel("Edit Student",updatePanel,listPanel,detailPanel);
        loadEdit();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1MouseClicked

    private void btnDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeactiveMouseClicked
 deactive();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeactiveMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
export();        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnAddRelationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRelationMouseClicked
      loadRelationInfo(ADD);  // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRelationMouseClicked

    private void btnEditRelationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditRelationMouseClicked
        loadRelationInfo(EDIT);   // TODO add your handling code here:
    }//GEN-LAST:event_btnEditRelationMouseClicked

    private void btnDeleteRelationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteRelationMouseClicked
       removeSelectedRelation();  // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteRelationMouseClicked

    private void btnEditMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMarkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMarkMouseClicked

    private void btnDeleteMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMarkMouseClicked
removeSelectedMark();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMarkMouseClicked

    private void btnAddMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMarkMouseClicked
 loadMarkinfo(ADD);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMarkMouseClicked

    private void btnDeleteRemarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteRemarkMouseClicked
 removeSelectedRemark();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteRemarkMouseClicked

    private void btnEditRemarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditRemarkMouseClicked
 loadRemarkInfo(EDIT);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditRemarkMouseClicked

    private void btnAddRemarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRemarkMouseClicked
 loadRemarkInfo(ADD);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRemarkMouseClicked

    private void btnDeleteExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteExtraMouseClicked
 removeSelectedExtra();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteExtraMouseClicked

    private void btnEditExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditExtraMouseClicked
   loadExtraInfo(EDIT);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditExtraMouseClicked

    private void btnAddExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddExtraMouseClicked
loadExtraInfo(ADD);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddExtraMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        newStudent=null;
        showPanel("List Student", listPanel,updatePanel,detailPanel); // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        reset(); // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        save(); // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser admiDPic;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel btnAddExtra;
    private javax.swing.JLabel btnAddMark;
    private javax.swing.JLabel btnAddRelation;
    private javax.swing.JLabel btnAddRemark;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnDeactive;
    private javax.swing.JButton btnDeactive1;
    private javax.swing.JLabel btnDeleteExtra;
    private javax.swing.JLabel btnDeleteMark;
    private javax.swing.JLabel btnDeleteRelation;
    private javax.swing.JLabel btnDeleteRemark;
    private javax.swing.JLabel btnDetail;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel btnEdit1;
    private javax.swing.JLabel btnEditExtra;
    private javax.swing.JLabel btnEditMark;
    private javax.swing.JLabel btnEditRelation;
    private javax.swing.JLabel btnEditRemark;
    private javax.swing.JLabel btnExport;
    private javax.swing.JButton btnExtraDetail;
    private javax.swing.JButton btnRelationDetail;
    private javax.swing.JButton btnRemarkDetail;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private javax.swing.JButton btnViewList;
    private javax.swing.JPanel can;
    private javax.swing.JComboBox comboBatch;
    private javax.swing.JComboBox comboBatch1;
    private javax.swing.JComboBox comboBatchSearch;
    private javax.swing.JComboBox comboGender;
    private com.toedter.calendar.JDateChooser dPic;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane labelAddress;
    private javax.swing.JLabel labelAdmissionTime;
    private javax.swing.JLabel labelBatch;
    private javax.swing.JLabel labelBirthday;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNo;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelPrevInstitute;
    private javax.swing.JLabel labelReasonLeaving;
    private javax.swing.JLabel labelRegisterNo;
    private javax.swing.JLabel labelUpdate;
    private javax.swing.JPanel listPanel;
    private javax.swing.JTable tblExtraCurricular;
    private javax.swing.JTable tblExtraCurricularDetail;
    private javax.swing.JTable tblMark;
    private javax.swing.JTable tblMarkDetail3;
    private javax.swing.JTable tblRelation;
    private javax.swing.JTable tblRelationDetail;
    private javax.swing.JTable tblRemark;
    private javax.swing.JTable tblRemarkDetail;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtNoSearch;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrevInstituteEdit;
    private javax.swing.JTextField txtReasonLeavingEdit;
    private javax.swing.JTextField txtRegisterNo;
    private javax.swing.JTextField txtRegisterNoSearch;
    private javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableButton(boolean b) {
        btnDetail.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDeactive1.setEnabled(b);
    }

    @Override
    public boolean validateForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void export() {
        ExportFile export=new ExportFile(tblStudent, ExportFile.STUDENT);
        export.toExcel();
    }


    
}

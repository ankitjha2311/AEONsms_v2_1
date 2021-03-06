/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMan;

import Controls.Manager;
import FileExport.ExportFile;
import MainHome.UIInterface;
import static MainHome.UIInterface.ADD;
import static MainHome.UIInterface.EDIT;
import MainObjects.MarkEntity;
import MainObjects.StudentEntity;
import MainObjects.SubjectEntity;
import TableModel.Mark;
import TableModel.Subject;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class ListMark extends javax.swing.JInternalFrame implements UIInterface {

    private int act;
    private MarkEntity entity;
    private SubjectEntity subjectEntity;
    private StudentEntity studentEntity;
    private Mark mark;

    /**
     * Creates new form SearchMark
     */
    public ListMark(int w, int h) {
        initComponents();
        this.entity = new MarkEntity();
        this.subjectEntity=new SubjectEntity();
        this.studentEntity=new StudentEntity();
        initUI();
        setSize(w, h);
    }

    @Override
    public void initUI() {
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        enableEditAddPanel(false);
        entity.loadList(tblMark);
        List<String> subjectList=subjectEntity.getNameList();
        comboSubject.removeAllItems();
        comboSubject.addItem("Choose");
        for(String s:subjectList){
            comboSubject.addItem(s);
        }
        
        enableButton(false);
    }
    private void export(){

        ExportFile export=new ExportFile(tblMark, ExportFile.MARK);
        export.toExcel();
    
    }

    private void studentChooser() {
        StudentChooser studentChooser = new StudentChooser(null, true);
        studentChooser.setVisible(true);
        if (studentChooser.getChooser() > 0) {
            if(mark==null){
                mark=new Mark();
            }
            mark.setStudent(new StudentEntity().findByID(studentChooser.getChooser()));
            labelStudentNo.setText(mark.getStudent().getNo() + "");
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
        txtYearSearch = new javax.swing.JTextField();
        comboSearchSubject = new javax.swing.JComboBox();
        comboMonthSearch = new javax.swing.JComboBox();
        txtSearchStudentName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSearchStudentNo = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMark = new javax.swing.JTable();
        btnEdit = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnExport = new javax.swing.JLabel();
        btnRemove = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnSearchReset = new javax.swing.JLabel();
        editAddPanel = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelStudentNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPoint = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dPicTime = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        comboSubject = new javax.swing.JComboBox();
        btnReset = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnStudentChooser = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        labelStudentNo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelStudentNo2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bannerPanel.setBackground(new java.awt.Color(45, 129, 171));
        bannerPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        bannerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtYearSearch.setBackground(new java.awt.Color(85, 153, 187));
        txtYearSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtYearSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtYearSearch.setBorder(null);
        bannerPanel.add(txtYearSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 80, 24));

        comboSearchSubject.setBackground(new java.awt.Color(85, 153, 187));
        comboSearchSubject.setEditable(true);
        comboSearchSubject.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboSearchSubject.setForeground(new java.awt.Color(255, 255, 255));
        comboSearchSubject.setBorder(null);
        bannerPanel.add(comboSearchSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 170, 24));

        comboMonthSearch.setBackground(new java.awt.Color(85, 153, 187));
        comboMonthSearch.setEditable(true);
        comboMonthSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboMonthSearch.setForeground(new java.awt.Color(255, 255, 255));
        comboMonthSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        comboMonthSearch.setBorder(null);
        bannerPanel.add(comboMonthSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 80, 24));

        txtSearchStudentName.setBackground(new java.awt.Color(85, 153, 187));
        txtSearchStudentName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchStudentName.setBorder(null);
        bannerPanel.add(txtSearchStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 166, 24));

        jLabel6.setBackground(new java.awt.Color(1, 100, 151));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Date");
        jLabel6.setOpaque(true);
        bannerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 70, 24));

        txtSearchStudentNo.setBackground(new java.awt.Color(85, 153, 187));
        txtSearchStudentNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchStudentNo.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchStudentNo.setBorder(null);
        bannerPanel.add(txtSearchStudentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 160, 24));

        jLabel44.setBackground(new java.awt.Color(1, 100, 151));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Student name");
        jLabel44.setOpaque(true);
        bannerPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 112, 24));

        jLabel47.setBackground(new java.awt.Color(1, 100, 151));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Subject");
        jLabel47.setOpaque(true);
        bannerPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 110, 24));

        jLabel14.setBackground(new java.awt.Color(0, 102, 153));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Exam_36px.png"))); // NOI18N
        jLabel14.setText("Mark");
        jLabel14.setIconTextGap(24);
        jLabel14.setOpaque(true);
        bannerPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        jLabel15.setBackground(new java.awt.Color(1, 100, 151));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Roll  no");
        jLabel15.setOpaque(true);
        bannerPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 70, 24));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 74, 121)));

        tblMark.setBackground(new java.awt.Color(4, 74, 121));
        tblMark.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblMark.setForeground(new java.awt.Color(255, 255, 255));
        tblMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Subject", "Student No", "Student", "Point", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMark);

        bannerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 730, 250));

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
        bannerPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 90, 26));

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
        bannerPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 90, 26));

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
        bannerPanel.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 90, 26));

        btnRemove.setBackground(new java.awt.Color(255, 0, 0));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_17px.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setOpaque(true);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        bannerPanel.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 490, 90, 26));

        jLabel16.setBackground(new java.awt.Color(255, 102, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Google_Web_Search_17px.png"))); // NOI18N
        jLabel16.setText("Search");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        bannerPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 90, 24));

        btnSearchReset.setBackground(new java.awt.Color(0, 102, 255));
        btnSearchReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearchReset.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Refresh_17px.png"))); // NOI18N
        btnSearchReset.setText("Reset");
        btnSearchReset.setOpaque(true);
        btnSearchReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchResetMouseClicked(evt);
            }
        });
        bannerPanel.add(btnSearchReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 90, 24));

        getContentPane().add(bannerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        editAddPanel.setBackground(new java.awt.Color(45, 129, 171));
        editAddPanel.setMinimumSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setPreferredSize(new java.awt.Dimension(1020, 700));
        editAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAction.setBackground(new java.awt.Color(0, 102, 153));
        labelAction.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setText("Update Students Result");
        labelAction.setOpaque(true);
        editAddPanel.add(labelAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        jLabel1.setBackground(new java.awt.Color(4, 74, 121));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student No");
        jLabel1.setOpaque(true);
        editAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 112, 25));

        labelStudentNo.setBackground(new java.awt.Color(85, 153, 187));
        labelStudentNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStudentNo.setForeground(new java.awt.Color(255, 255, 255));
        labelStudentNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStudentNo.setText("    Unknown");
        labelStudentNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelStudentNo.setOpaque(true);
        editAddPanel.add(labelStudentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 170, 25));

        jLabel4.setBackground(new java.awt.Color(4, 74, 121));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Marks");
        jLabel4.setOpaque(true);
        editAddPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 112, 25));

        txtPoint.setBackground(new java.awt.Color(85, 153, 187));
        txtPoint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtPoint.setForeground(new java.awt.Color(255, 255, 255));
        txtPoint.setBorder(null);
        editAddPanel.add(txtPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 130, 25));

        jLabel5.setBackground(new java.awt.Color(4, 74, 121));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date");
        jLabel5.setOpaque(true);
        editAddPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 112, 25));

        dPicTime.setOpaque(false);
        editAddPanel.add(dPicTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 130, 25));

        jLabel2.setBackground(new java.awt.Color(4, 74, 121));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Subject");
        jLabel2.setOpaque(true);
        editAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 112, 25));

        comboSubject.setBackground(new java.awt.Color(85, 153, 187));
        comboSubject.setEditable(true);
        comboSubject.setBorder(null);
        editAddPanel.add(comboSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 210, 25));

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Refresh_17px.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setOpaque(true);
        editAddPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 80, 25));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        editAddPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 80, 25));

        btnStudentChooser.setBackground(new java.awt.Color(4, 74, 121));
        btnStudentChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStudentChooser.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentChooser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStudentChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Browse_Folder_18px.png"))); // NOI18N
        btnStudentChooser.setOpaque(true);
        btnStudentChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStudentChooserMouseClicked(evt);
            }
        });
        editAddPanel.add(btnStudentChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 40, 25));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        editAddPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 80, 25));

        labelStudentNo1.setBackground(new java.awt.Color(85, 153, 187));
        labelStudentNo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStudentNo1.setForeground(new java.awt.Color(255, 255, 255));
        labelStudentNo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStudentNo1.setText("    Unknown");
        labelStudentNo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelStudentNo1.setOpaque(true);
        editAddPanel.add(labelStudentNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 210, 25));

        jLabel3.setBackground(new java.awt.Color(4, 74, 121));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Class");
        jLabel3.setOpaque(true);
        editAddPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 112, 25));

        labelStudentNo2.setBackground(new java.awt.Color(85, 153, 187));
        labelStudentNo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStudentNo2.setForeground(new java.awt.Color(255, 255, 255));
        labelStudentNo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStudentNo2.setText("    Unknown");
        labelStudentNo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelStudentNo2.setOpaque(true);
        editAddPanel.add(labelStudentNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 130, 25));

        jLabel7.setBackground(new java.awt.Color(4, 74, 121));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Roll No");
        jLabel7.setOpaque(true);
        editAddPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 110, 25));

        getContentPane().add(editAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarkMouseClicked
        enableButton(true);
    }//GEN-LAST:event_tblMarkMouseClicked
                            
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
search();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
     export();    // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
     int confirm = entity.confirmRemove(this, "Are you Sure");
        if (confirm == 0) {
            int res=entity.remove(entity.getSelectID(tblMark));
            if(res==Manager.SUCCESS){
                initUI();
            }
            entity.showMessage(res, this);
            
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
      act = EDIT;
        enableEditAddPanel(true);
        btnReset.setVisible(false);   // TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
       act = ADD;
        enableEditAddPanel(true);
        btnReset.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSearchResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchResetMouseClicked
     initUI();   // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchResetMouseClicked

    private void btnStudentChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentChooserMouseClicked
     studentChooser();   // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentChooserMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
      save();  // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
      enableEditAddPanel(false);   // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExport;
    private javax.swing.JLabel btnRemove;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSearchReset;
    private javax.swing.JLabel btnStudentChooser;
    private javax.swing.JComboBox comboMonthSearch;
    private javax.swing.JComboBox comboSearchSubject;
    private javax.swing.JComboBox comboSubject;
    private com.toedter.calendar.JDateChooser dPicTime;
    private javax.swing.JPanel editAddPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JLabel labelStudentNo;
    private javax.swing.JLabel labelStudentNo1;
    private javax.swing.JLabel labelStudentNo2;
    private javax.swing.JTable tblMark;
    private javax.swing.JTextField txtPoint;
    private javax.swing.JTextField txtSearchStudentName;
    private javax.swing.JTextField txtSearchStudentNo;
    private javax.swing.JTextField txtYearSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enableEditAddPanel(boolean b) {
        if (b == false) {
            tblMark.setEnabled(true);
            labelStudentNo.setText("");
            txtPoint.setText("");
            dPicTime.setDate(null);
            
            editAddPanel.setVisible(false);
            
            bannerPanel.setVisible(true);
        } else {
            if (act == EDIT) {
                labelAction.setText("Edit Mark");
                loadEdit();
            } else if (act == ADD) {
                labelAction.setText("Add Mark");
            }
            tblMark.setEnabled(false);
            editAddPanel.setVisible(true);
            btnReset.setVisible(true);
            
          
            bannerPanel.setVisible(false);
        }
    }
    
    @Override
    public void enableButton(boolean b) {
        btnEdit.setEnabled(b);
        btnRemove.setEnabled(b);
    }
    
    @Override
    public void loadEdit() {
        mark = entity.findByID(entity.getSelectID(tblMark));
        labelStudentNo.setText(mark.getStudent().getNo());
        comboSubject.setSelectedItem(mark.getSubject().getName());
        txtPoint.setText(mark.getPoint() + "");
        dPicTime.setDate(mark.getTime());
    }
    
    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(){
        if(!validateForm()){
             return;
         }
         if(mark==null){
             mark=new Mark();
         }
         Subject sub=subjectEntity.findByName(comboSubject.getSelectedItem().toString());
         int point=0;
         Date date=null;
         try{
         point=Integer.parseInt(txtPoint.getText());
         }catch(NumberFormatException ex){}
         date=dPicTime.getDate();
         mark.setSubject(sub);
         mark.setPoint(point);
         mark.setTime(date);
         entity.setMark(mark);
         int res=entity.save();
         initUI();
    }
    
    @Override
    public void deactive() {
        
    }
    
    @Override
    public boolean validateForm() {
        if(mark==null || mark.getStudent()==null || mark.getStudent().getID() <1){
            JOptionPane.showMessageDialog(this, "You must be choose Student !");
            return false;
        }
        if(comboSubject.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(this, "You must be choose subject !");
            return false;
        }
        return true;
    }
}

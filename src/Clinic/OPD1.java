/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import drugs.Bridge;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

/**
 *
 * @author yibe1
 */
public class OPD1 extends javax.swing.JFrame {

    private ArrayList<String[]> patients;
    private ArrayList<ArrayList<String>> my_patients;
    private ArrayList<Patient> patients_detail;
    private ArrayList<Patient_Full_info> patient_history;
    private ArrayList<ArrayList<Labratory>> patient_lab;
    private ArrayList<ArrayList<Prescription>> patient_prescription;
    private Diagnoses patient_diagnoses;
    private History hx;
    private ArrayList<Labratory> labTest;
    private String userId;
    private String chc, hpi, pmh, fh, da, pe, lab, dx, tx;
    private int lock_chc, lock_hpi, lock_pmh, lock_fh, lock_da, lock_pe, lock_lab, lock_dx, lock_tx, room;
    private String id = "";
    private ArrayList<Prescription> prescriptions;
    private SimpleAttributeSet set;
    public String clinicianName;
    private Document doc;
    private String drName;
    private ArrayList<Patient_Full_info> patientHist;
    private int pt_status = 0;
    private boolean referal_visit = false;
    private String referalDate;
    private ArrayList<String> ls;
    private Clip clip;
    private int alarmdelay = 60000;
    private boolean waiting_pts;
    int lock = 0;// to prevent un intended double calling of patients for waiting area. when the arived button is clicked lock will be 0 and dr can call next

    public void setReferalVist(boolean x) {
        referal_visit = x;
    }

    public void getDrugList() {
        Bridge repo = new Bridge();
        ls = repo.getDispensary_stock();
        System.out.println("lis size is........" + ls.size());
    }

    public void setStudentId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Creates new form OPD
     */
    public void maximize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    public OPD1(String userId, String name, String roll, int room) throws BadLocationException, SQLException {
//   
        initComponents();
        maximize();
        
        this.room = room;
        clinicianName = name;
        history_t.setLayout(new WrapLayout(FlowLayout.LEFT));
        uncompleted_board.setLayout(new WrapLayout(FlowLayout.LEFT));
        board.setLayout(new WrapLayout(FlowLayout.LEFT));
        rf_board.setLayout(new WrapLayout(FlowLayout.LEFT));
//        history_t.setLayout(new WrapLayout(FlowLayout.LEFT));
        drName = name;
        user.setText(drName);
        patients_detail = new ArrayList<Patient>();
        patient_history = new ArrayList<Patient_Full_info>();
        patient_lab = new ArrayList<ArrayList<Labratory>>();
        patient_prescription = new ArrayList<ArrayList<Prescription>>();
        patient_diagnoses = new Diagnoses();
        prescriptions = new ArrayList<Prescription>();
        hx = new History();
        labTest = new ArrayList<Labratory>();
        this.userId = userId;
        resetTables();
//        resetButtons();
        patients = getPatients();
        my_patients = getMyPatients();
        fill_waiting_patients_table();
        fill_called_table();
        fill_rf_board();
        button_lab.setEnabled(false);

        this.clinicianName = name;
        chc = "";
        hpi = "";
        pmh = "";
        fh = "";
        da = "";
        pe = "";
        lab = "";
        dx = "Not Set";
        tx = "";
        pt_name.setText("");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Refresh2 refresher = new Refresh2(this);
        refresher.start();

        roomSelected.setText(String.valueOf(room));
        student_id.setText("");
        getDrugList();
        clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        searchId = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        uncompleted_board = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        board = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subj = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        obj = new javax.swing.JTextArea();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ass = new javax.swing.JTextArea();
        title3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        plan = new javax.swing.JTextArea();
        button_lab = new javax.swing.JButton();
        button_diagnoses = new javax.swing.JButton();
        button_prescription = new javax.swing.JButton();
        Internal_refer = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sex = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        department = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        roomSelected = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        history_t = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        rf_board = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/logo_2.png")).getImage());

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        searchId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchIdKeyPressed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Visit Date");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Action");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel14)))
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchId)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        jLabel7.setBackground(new java.awt.Color(204, 0, 51));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("Patients Waiting");

        uncompleted_board.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout uncompleted_boardLayout = new javax.swing.GroupLayout(uncompleted_board);
        uncompleted_board.setLayout(uncompleted_boardLayout);
        uncompleted_boardLayout.setHorizontalGroup(
            uncompleted_boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        uncompleted_boardLayout.setVerticalGroup(
            uncompleted_boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        jScrollPane8.setViewportView(uncompleted_board);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("MRN");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("NAME");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("ACTION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(48, 48, 48)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(jLabel12)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
        );

        jScrollPane2.setBackground(new java.awt.Color(0, 153, 153));

        board.setBackground(new java.awt.Color(255, 255, 255));
        board.setMaximumSize(new java.awt.Dimension(360, 60));

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(board);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "History Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        subj.setColumns(20);
        subj.setLineWrap(true);
        subj.setRows(5);
        jScrollPane1.setViewportView(subj);

        title.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        title.setText("Subjective");

        save.setBackground(new java.awt.Color(0, 153, 102));
        save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        obj.setColumns(20);
        obj.setLineWrap(true);
        obj.setRows(5);
        jScrollPane4.setViewportView(obj);

        title1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        title1.setText("Objective");

        title2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        title2.setText("Assessment");

        ass.setColumns(20);
        ass.setLineWrap(true);
        ass.setRows(5);
        jScrollPane6.setViewportView(ass);

        title3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        title3.setText("Plan");

        plan.setColumns(20);
        plan.setLineWrap(true);
        plan.setRows(5);
        jScrollPane7.setViewportView(plan);

        button_lab.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button_lab.setText("Labratory");
        button_lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_labActionPerformed(evt);
            }
        });

        button_diagnoses.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button_diagnoses.setText("Diagnosis");
        button_diagnoses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_diagnosesActionPerformed(evt);
            }
        });

        button_prescription.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button_prescription.setText("Prescription");
        button_prescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_prescriptionActionPerformed(evt);
            }
        });

        Internal_refer.setBackground(new java.awt.Color(255, 51, 51));
        Internal_refer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Internal_refer.setForeground(new java.awt.Color(255, 255, 255));
        Internal_refer.setText("Internal Referal");
        Internal_refer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Internal_referActionPerformed(evt);
            }
        });

        save1.setBackground(new java.awt.Color(0, 153, 102));
        save1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        save1.setForeground(new java.awt.Color(255, 255, 255));
        save1.setText("Reset");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title1)
                    .addComponent(title2)
                    .addComponent(title3)
                    .addComponent(title)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Internal_refer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(button_diagnoses, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(button_prescription, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(title2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(title3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_lab)
                    .addComponent(button_diagnoses)
                    .addComponent(button_prescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Internal_refer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel7.setBackground(new java.awt.Color(153, 0, 153));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Id");

        student_id.setEditable(false);
        student_id.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Pt. Name: ");

        pt_name.setBackground(new java.awt.Color(204, 204, 204));
        pt_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Sex:");

        sex.setBackground(new java.awt.Color(204, 204, 204));
        sex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sex.setText(" ");

        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("User:");

        user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("default");

        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Department:");

        department.setBackground(new java.awt.Color(204, 204, 204));
        department.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Age:");

        age.setBackground(new java.awt.Color(204, 204, 204));
        age.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("RM: ");

        roomSelected.setForeground(new java.awt.Color(255, 255, 255));
        roomSelected.setText("jLabel19");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(pt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(user)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomSelected)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18)
                    .addComponent(roomSelected))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );

        history_t.setBackground(new java.awt.Color(204, 204, 255));
        history_t.setMaximumSize(new java.awt.Dimension(360, 60));
        history_t.setMinimumSize(new java.awt.Dimension(360, 60));
        history_t.setPreferredSize(new java.awt.Dimension(360, 60));

        javax.swing.GroupLayout history_tLayout = new javax.swing.GroupLayout(history_t);
        history_t.setLayout(history_tLayout);
        history_tLayout.setHorizontalGroup(
            history_tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        history_tLayout.setVerticalGroup(
            history_tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(history_t);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Uncompleted Encounters");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("MRN");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("NAME");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("ACTION");

        rf_board.setBackground(new java.awt.Color(204, 204, 255));
        rf_board.setMaximumSize(new java.awt.Dimension(360, 60));
        rf_board.setMinimumSize(new java.awt.Dimension(360, 60));

        javax.swing.GroupLayout rf_boardLayout = new javax.swing.GroupLayout(rf_board);
        rf_board.setLayout(rf_boardLayout);
        rf_boardLayout.setHorizontalGroup(
            rf_boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rf_boardLayout.setVerticalGroup(
            rf_boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        jScrollPane9.setViewportView(rf_board);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Internal Referal Sent to You");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(71, 71, 71))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String lid = searchId.getText();
        fill_hist_table(lid.toLowerCase());
        clear();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void button_prescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_prescriptionActionPerformed

        if ("".equals(student_id.getText())) {
            JOptionPane.showMessageDialog(null, "You did not select any patient");
            return;
        }
        Dimer dm = new Dimer();
        dm.setVisible(true);
        this.setEnabled(false);
        dm.setEnabled(false);
        //        if ("".equals(dx)) {
        //            JOptionPane.showMessageDialog(null, "Please, select diagnose before ordering medicines");
        //            return;
        //        }
        //        resetButtons();
//        button_prescription.setBackground(Color.gray);
//        button_prescription.setForeground(Color.white);

        try {
            //        title.setText("Prescription");
            //        subj.setEnabled(true);
            //        lock_manager("tx");
            new Prescription_Form(ls, prescriptions, student_id.getText(), this, dm).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(OPD1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_prescriptionActionPerformed

    private void button_diagnosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_diagnosesActionPerformed
        // TODO add your handling code here:
        if ("".equals(student_id.getText())) {
            JOptionPane.showMessageDialog(null, "You did not select any patient");
            return;
        }
        //        resetButtons();
//        button_diagnoses.setBackground(Color.gray);
//        button_diagnoses.setForeground(Color.white);
        Dimer dm = new Dimer();
        dm.setVisible(true);
        this.setEnabled(false);
        dm.setEnabled(false);
        try {
            new Diagnose(student_id.getText(), this, dm).setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error code Dx1 " + ex);
            Logger.getLogger(Diagnose.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OPD1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_button_diagnosesActionPerformed

    private void button_labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_labActionPerformed
        // TODO add your handling code here:
        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "You did not select any patient");
            return;
        }
        //        resetButtons();
//        button_lab.setBackground(Color.gray);
//        button_lab.setForeground(Color.white);
        //        title.setText("Laboratory");
        subj.setEnabled(true);
        //        lock_manager("lab");
        new Labratory_form(subj, labTest, id).setVisible(true);
    }//GEN-LAST:event_button_labActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if (pt_name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Patient not selected! Nothing to save");
            return;
        } else {
            try {
                saveUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OPD1.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("about to do....saving....................");
            if (referal_visit) {
                Repo repo = new Repo();
                try {
                    repo.updateReferalStatus(userId, id, referalDate, room);
                } catch (SQLException ex) {
                    Logger.getLogger(OPD1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void Internal_referActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Internal_referActionPerformed
        // TODO add your handling code here:

        if (pt_name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Patient not selected! Nothing to refer");
            return;
        }

        new Interna_Referal(student_id.getText(), userId, plan, this).setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_Internal_referActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton5KeyPressed

    private void searchIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchIdKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String lid = searchId.getText().toUpperCase();
            fill_hist_table(lid);
            clear();
        }

    }//GEN-LAST:event_searchIdKeyPressed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_save1ActionPerformed
    public void saveUpdate() throws SQLException {

//        pt_status = JOptionPane.showConfirmDialog(null, "Is the visit complete?", "", 1);
//        if (pt_status == 2) {
//            return;
//        }
//        System.out.println("here..............222222");
        if (pt_name.getText().equals("")) {
            return;
        }
        if (save.getText().equals("Update")) {
//            System.out.println("here..............33333");
            updateHistory(pt_status);
        } else {
//            System.out.println("here..............4444444");
            saveHistory(pt_status);
            save.setText("Update");
        }

        fill_called_table();
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OPD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OPD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OPD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OPD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                try {
////                    new OPD().setVisible(true);
////                } catch (BadLocationException ex) {
////                    Logger.getLogger(OPD.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                try {
////                    new OPD().setVisible(true);
////                } catch (BadLocationException ex) {
////                    Logger.getLogger(OPD.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                try {
////                    new OPD().setVisible(true);
////                } catch (BadLocationException ex) {
////                    Logger.getLogger(OPD.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                try {
////                    new OPD().setVisible(true);
////                } catch (BadLocationException ex) {
////                    Logger.getLogger(OPD.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
//        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Internal_refer;
    private javax.swing.JTextField age;
    private javax.swing.JTextArea ass;
    public javax.swing.JPanel board;
    private javax.swing.JButton button_diagnoses;
    private javax.swing.JButton button_lab;
    private javax.swing.JButton button_prescription;
    private javax.swing.JTextField department;
    public javax.swing.JPanel history_t;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea obj;
    private javax.swing.JTextArea plan;
    private javax.swing.JTextField pt_name;
    public javax.swing.JPanel rf_board;
    public javax.swing.JLabel roomSelected;
    public javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JTextField searchId;
    private javax.swing.JTextField sex;
    private javax.swing.JTextField student_id;
    private javax.swing.JTextArea subj;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JPanel uncompleted_board;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

    public ArrayList<String[]> getPatients() {
        ArrayList<String[]> todays_patients = new Repo().getWaiting();

        return todays_patients;
    }

    public ArrayList<ArrayList<String>> getMyPatients() {
        ArrayList<ArrayList<String>> todays_patients = new Repo().getMyWaiting2(userId);
        return todays_patients;
    }

    public void fill_waiting_patients_table() {
        waiting_pts = false;
        patients = getPatients();
        resetTables();
        board.removeAll();
        int j = 0;
        GridBagConstraints c = new GridBagConstraints();
        int number_of_waiting_pts = 0;
        for (int i = 0; i < patients.size(); i++) {
            if ("1".equals(patients.get(i)[4]) || "2".equals(patients.get(i)[4])) {
                continue;
            }
            System.out.println("..........,,,,..,sdf.." + patients.get(i)[4]);
            System.out.println("..........,,,,..,sdf.." + patients.get(i)[3]);
            pp p = new pp(patients.get(i)[0], Integer.parseInt(patients.get(i)[4]), this);

            c.gridx = 0;
//            c.anchor = GridBagConstraints.NORTHWEST;
            try {
                board.add(p);
//                history_t.setBackground(Color.red);
//                history_t.add(new JLabel("JJJJJJJJ"), c);
////                System.out.println("adedddddd................");
            } catch (Exception e) {
////                System.out.println(e);
            }
            j++;
            number_of_waiting_pts++;
        }
        if (number_of_waiting_pts > 0) {
            System.out.println("here........");
            if (!isActive()) {
//                new PlaySound("alarm.wav", alarmdelay, this).start();
                waiting_pts = true;
            }
        } else {
            waiting_pts = false;
        }
        c.weightx = 1;
        c.weighty = 1;
//        board.add(new JLabel(" "), c);
//        history_t.add(new JLabel(" "), c);
    }

    public void call_pt() {
        new Repo().changeStatus(student_id.getText(), userId, room, 1);
        resetTables();
        fill_called_table();
    }

    public void fill_called_table() {
        my_patients = new Repo().getMyWaiting2(userId);
        uncompleted_board.removeAll();
        for (int i = 0; i < my_patients.size(); i++) {

            for (int j = 0; j < my_patients.get(i).size(); j++) {
                System.out.println("........" + my_patients.get(i).get(j));
            }
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date today = new java.sql.Date(utilDate.getTime());
            uncompleted_board.add(new uncompleted(my_patients.get(i).get(0), my_patients.get(i).get(1), today.toString(), this));
//            called_patients_table.getModel().setValueAt(, i, 0);
//            called_patients_table.getModel().setValueAt(my_patients.get(i).get(3), i, 1);
        }
        fill_waiting_patients_table();
        this.repaint();
    }

    public void fill_hist_table(String stId) {
        ArrayList<String> data = new ArrayList<>();
//        history_t.removeAll();
//        GridBagConstraints c = new GridBagConstraints();
        history_t.removeAll();
        System.out.println("here........////////.........//////" + stId);
        patientHist = new Repo().getPatient_History(stId);

        for (int i = 0; i < patientHist.size(); i++) {
            String date = patientHist.get(i).getHistory().getDate().toString();
//            System.out.println(stId + " ?" + date);
            if (data.contains(stId + " " + date)) {
                continue;
            } else {
                history_t.add(new History_board(stId, date, this));
                data.add(stId + " " + date);
//                System.out.println("id is.................." + stId);
            }

        }
        this.repaint();
        pack();
        maximize();
//        fill_waiting_patients_table();
    }

    public void saveHistory(int st) {
        patient_diagnoses.setStudent_id(student_id.getText());
        patient_diagnoses.setDiagnoses(dx);
        Repo repo = new Repo();
        repo.saveHistory(student_id.getText(), subj.getText(), obj.getText(), ass.getText(), plan.getText(), drName, st);
        System.out.println("sent........." + student_id.getText());
        repo.saveLab(labTest);
        repo.saveDx(dx, student_id.getText());
//        new Repo().savePrescription(prescriptions);
        repo.changeStatus(id, userId, room, pt_status);
    }

    public void resetTables() {
//        board.removeAll();
//        history_t.removeAll();
    }

    private String getDifference(Date date) {
        Calendar today = Calendar.getInstance();

        long diff = today.getTimeInMillis() - date.getTime(); //result in millis

        long days = diff / (24 * 60 * 60 * 1000);
        if (days == 0) {
            return "Today";
        }
        return days + " days ago";
    }

    public Patient getPatient(String id) {
        
        Patient patient = new Repo().getPatient(id);
        return patient;
    }
    
    public void updateHistory(int st) throws SQLException {
//        System.out.println("here..............1245");
        patient_diagnoses.setStudent_id(student_id.getText());
        patient_diagnoses.setDiagnoses(dx);
        Repo repo = new Repo();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        System.out.println("here..............1245...........1111111111");
        repo.updateHistory(student_id.getText(), subj.getText(), obj.getText(), ass.getText(), plan.getText(), drName, sqlDate.toString(), st);
//        System.out.println(".......///.......");
        repo.changeStatus(id, userId, room, pt_status);
    }

    private void clear() {
        subj.setText("");
        obj.setText("");
        ass.setText("");
        plan.setText("");
        save.setText("Save");
        searchId.setText("");
        student_id.setText("");
        pt_name.setText("");
        sex.setText("");
        age.setText("");
        department.setText("");
        prescriptions.clear();
//        history_t.removeAll();

    }

    public void call(String id) throws SQLException {

        saveHistory(0);//save previous patient history before cleared
        history_t.removeAll();//to clear previous history of previeous patient
        clear();// to clear fields before new pt loaded
        Patient patient = getPatient(id);
        pt_name.setText(patient.getFull_name());
        department.setText(patient.getDepartment());
        sex.setText(patient.getSex());
        student_id.setText(id);
        patient_history = new Repo().getPatient_History(id);
        call_pt();

        my_patients = getMyPatients();
//        System.out.println("on call.........");
        fill_hist_table(id);
        fill_waiting_patients_table();
//        fill_called_table();
        this.pack();
        maximize();
    }

    public void view_history(String stid, String Date) {
//        System.out.println("it is here in view h");
        patientHist = new Repo().getPatient_History(stid);
        for (int j = 0; j < patientHist.size(); j++) {
//            System.out.println("there is...........");
            History data = patientHist.get(j).getHistory();
            Diagnoses dx = patientHist.get(j).getDx();
            String prescription = "";
            int n = patientHist.get(j).getPrescription().size();
            for (int k = 0; k < n; k++) {

                prescription = prescription + "/n" + patientHist.get(j).getPrescription().get(k);
            }

            if (data.getDate().toString().equals(Date)) {
                new Patient_History(patientHist.get(j).getPatient().getStudent_id(), patientHist.get(j).getPatient().getFull_name(),
                        data.getDate().toString(), data.getSubjective(), data.getObjective(), data.getAssessment(), data.getPlan(), dx.getDiagnoses(), prescription, data.getCreatedBy(), data.getModifiedBy(), this).setVisible(true);
                break;
            }
        }

    }

    public void load_uncompleted(String Date, String id) throws SQLException {

        saveHistory(0);

        ArrayList<Patient_Full_info> pt = new Repo().getPatient_History(id);
//        String st = "about to load...............and size is " + pt.size();
//        JOptionPane.showMessageDialog(null, st);
        clear();

        for (int j = 0; j < pt.size(); j++) {
            History data = pt.get(j).getHistory();
            Patient ptinfo = pt.get(j).getPatient();
//            System.out.println("....." + data.getDate().toString() + "......." + Date);
//            System.out.println("id...." + data.getStudent_id() + "...and...." + id);
//            JOptionPane.showMessageDialog(null, "1   "+data.getDate().toString()+"="+Date+  " "+data.getStudent_id().toUpperCase()+"= "+id.toUpperCase());
            if (data.getDate().toString().equals(Date) && data.getStudent_id().toUpperCase().equals(id.toUpperCase())) {
//                System.out.println("in...........");
//                JOptionPane.showMessageDialog(null, "2");
                subj.setText(data.getSubjective());
                obj.setText(data.getObjective());
                ass.setText(data.getAssessment());
                plan.setText(data.getPlan());
                save.setText("Update");
                student_id.setText(id);
                pt_name.setText(ptinfo.getFull_name());
//                String st2 = "name is ///////////" + ptinfo.getFirst_name() + " " + ptinfo.getSecond_name();
//                JOptionPane.showMessageDialog(null, st2);
                sex.setText(ptinfo.getSex());
                department.setText(ptinfo.getDepartment());
                break;
            }
        }
        history_t.removeAll();
        this.pack();
        maximize();
        fill_hist_table(student_id.getText());
    }

    void load_rf(String stid, String date) throws SQLException {
        clear();
        if (save.getText().equals("Update")) {
            saveUpdate();
        } else {
            if (!student_id.getText().equals("")) {
                saveHistory(0);
            }
        }

        this.referalDate = date;
        ArrayList<Patient_Full_info> pt = new Repo().getPatient_History(stid);
        String st = "about to load...............and size is " + pt.size();
        System.out.println("ooooooostid = " + stid + " date = " + date + " st..." + st);
//        JOptionPane.showMessageDialog(null, st);
        for (int j = 0; j < pt.size(); j++) {
            History data = pt.get(j).getHistory();
            Patient ptinfo = pt.get(j).getPatient();
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            System.out.println("....." + data.getDate().toString() + "......." + sqlDate);
//            System.out.println("id...." + data.getStudent_id() + "...and...." + stid);
//            JOptionPane.showMessageDialog(null, "1   " + data.getDate().toString() + "=" + sqlDate + " " + data.getStudent_id().toUpperCase() + "= " + id.toUpperCase());

            if (data.getStudent_id().toUpperCase().equals(stid.toUpperCase())) {
//                System.out.println("in...........");
//                JOptionPane.showMessageDialog(null, "2");
                subj.setText(data.getSubjective());
                obj.setText(data.getObjective());
                ass.setText(data.getAssessment());
                plan.setText(data.getPlan());
                save.setText("Update");
                student_id.setText(stid);
                pt_name.setText(ptinfo.getFull_name());
//                String st2 = "name is ///////////" + ptinfo.getFirst_name() + " " + ptinfo.getSecond_name();
//                JOptionPane.showMessageDialog(null, st2);
                sex.setText(ptinfo.getSex());
                department.setText(ptinfo.getDepartment());
                break;
            }
        }
        rf_board.removeAll();
        this.pack();
        maximize();

    }

    public void fill_rf_board() throws SQLException {
        ArrayList<String> data = new ArrayList<>();
//        history_t.removeAll();
//        GridBagConstraints c = new GridBagConstraints();
//        System.out.println("here........////////.........//////");
        ArrayList<String> referals = new Repo().getReferals(room);

        for (int i = 0; i < referals.size(); i++) {
            String[] stData = referals.get(i).split(",");
            if (data.contains(referals.get(i))) {
                continue;
            } else {
                rf_board.add(new rf_detail(stData[0], stData[1], this));
                data.add(referals.get(i));
            }

        }
    }

    public boolean isWaiting_pts() {
        return waiting_pts;
    }

    public void setWaiting_pts(boolean waiting_pts) {
        this.waiting_pts = waiting_pts;
    }

}

class Refresh2 extends Thread {

    private OPD1 opd;

    public Refresh2(OPD1 opd) {
        this.opd = opd;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Refresh2.class.getName()).log(Level.SEVERE, null, ex);
            }

            opd.board.removeAll();
            opd.fill_waiting_patients_table();
            opd.repaint();
            opd.pack();
            opd.maximize();
        }
    }

}

class PlaySound extends Thread {

    private String filename;
    private int interval;
    private final OPD1 opd;

    public PlaySound(String wavfile, int interval, OPD1 opd) {
        filename = wavfile;
        this.interval = interval;
        this.opd = opd;
    }

    @Override
    public void run() {

        if (opd.isWaiting_pts()) {
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filename));
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        } else {
        }

    }
}

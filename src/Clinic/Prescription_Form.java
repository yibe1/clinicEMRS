/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import drugs.Bridge;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author yibe1
 */
public class Prescription_Form extends javax.swing.JFrame {

    JTextArea tf;
    ArrayList<Prescription> prescriptions;
    String id;
    ArrayList<String> ls, ls2, selected_prescriptions;
    ArrayList<String> ordered_drugs = new ArrayList<>();
    OPD1 ds;
    private String tax = "15";
    private String profit_margin = "20";
    private Prescription drug_name;
    private Dimer dm;

    /**
     * Creates new form Prescription_Form
     */
    public Prescription_Form(ArrayList<String> ls, ArrayList<Prescription> prescriptions, String id, OPD1 ds, Dimer dm) throws FileNotFoundException, IOException {
        initComponents();
        setButtonsInactive(true);
        this.ds = ds;
        this.tf = tf;
        this.prescriptions = prescriptions;
        this.id = id;
        this.ls = ls;
        this.dm = dm;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Do activity here
                System.out.println("JFrame Closed!");
                ds.setEnabled(true);
                dm.dispose();
            }
        });

        ls2 = new ArrayList<>();
//        File file = new File("drugs.txt");
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//
//        while (br.ready()) {
//            ls.add(br.readLine());
//        }
        DefaultListModel<String> model = new DefaultListModel<>();
        list_of_drugs.setModel(model);
        for (int i = 0; i < ls.size(); i++) {
            String[] temp = ls.get(i).split("@");
//            drugName.addItem(temp[1]);
            model.addElement(temp[1]);
            ls2.add(temp[1]);
        }
        for (int i = 0; i < prescriptions.size(); i++) {
            rx.setValueAt(i + 1, i, 0);
            rx.setValueAt(prescriptions.get(i).getDrug_name() + " " + prescriptions.get(i).getDetail(), i, 1);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        routlabel = new javax.swing.JLabel();
        route = new javax.swing.JComboBox<>();
        freqlabel = new javax.swing.JLabel();
        frequency = new javax.swing.JComboBox<>();
        durunit = new javax.swing.JLabel();
        duration = new javax.swing.JComboBox<>();
        addtotable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rx = new javax.swing.JTable();
        send_order = new javax.swing.JButton();
        delete_drug = new javax.swing.JButton();
        prnlabel = new javax.swing.JLabel();
        prnq = new javax.swing.JComboBox<>();
        durlabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_of_drugs = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        drugName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        multiplier = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jimma University Student Health Center Prescription Form");

        routlabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        routlabel.setForeground(new java.awt.Color(255, 255, 255));
        routlabel.setText("Route");

        route.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        route.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..", "PO", "IV", "IM", "SC", "ID", "IT", "TP" }));
        route.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeActionPerformed(evt);
            }
        });

        freqlabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        freqlabel.setForeground(new java.awt.Color(255, 255, 255));
        freqlabel.setText("Frequency");

        frequency.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        frequency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..", "Daily", "BID", "TID", "QID", "QOD", "Stat", "PRN" }));
        frequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequencyActionPerformed(evt);
            }
        });

        durunit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durunit.setForeground(new java.awt.Color(255, 255, 255));
        durunit.setText("Day");

        duration.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        duration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "45", "60", "90", "120" }));

        addtotable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addtotable.setText("Add");
        addtotable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtotableActionPerformed(evt);
            }
        });

        rx.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "S.No", "Medication", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rx.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(rx);
        if (rx.getColumnModel().getColumnCount() > 0) {
            rx.getColumnModel().getColumn(0).setMinWidth(20);
            rx.getColumnModel().getColumn(0).setPreferredWidth(20);
            rx.getColumnModel().getColumn(0).setMaxWidth(20);
            rx.getColumnModel().getColumn(1).setMinWidth(400);
        }

        send_order.setText("Send Order");
        send_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_orderActionPerformed(evt);
            }
        });

        delete_drug.setText("Delete");
        delete_drug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_drugActionPerformed(evt);
            }
        });

        prnlabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        prnlabel.setForeground(new java.awt.Color(255, 255, 255));
        prnlabel.setText("Quantity");

        prnq.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        prnq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "3", "5", "10", "15", "20", "25", "30", "35", "40", "50", "60", "70", "80", "90", "100", " " }));
        prnq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prnqActionPerformed(evt);
            }
        });

        durlabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durlabel.setForeground(new java.awt.Color(255, 255, 255));
        durlabel.setText("Duration");

        jScrollPane2.setViewportView(list_of_drugs);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Available Drugs");

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Select >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        drugName.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("X");

        multiplier.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Close Window");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(delete_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(send_order)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(routlabel)
                                                            .addComponent(freqlabel)
                                                            .addComponent(durlabel))
                                                        .addGap(30, 30, 30)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(frequency, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(prnlabel))
                                                            .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(durunit))))
                                                    .addComponent(addtotable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(prnq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(drugName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drugName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freqlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(frequency, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(prnlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(prnq, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(durunit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(durlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addtotable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send_order, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void addtotableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtotableActionPerformed
        // TODO add your handling code here:
        if (route.getSelectedItem().equals("..")) {
            new Warnings("Please select route",this).setVisible(true);
            return;
        }
        if (frequency.getSelectedItem().equals("..")) {
            new Warnings("Please select frequency",this).setVisible(true);
            return;
        }
        String det = "";
        int mult = (int) multiplier.getValue();
        if (duration.isEnabled()) {
            det = " for " + duration.getSelectedItem() + " days";
        } else {
            if (frequency.getSelectedItem().equals("PRN") || route.getSelectedItem().equals("TP")) {
                if (prnq.getSelectedItem().equals("0")) {
                    new Warnings("Please specify amount of drug",this).setVisible(true);
                    return;
                }
                det = " " + prnq.getSelectedItem() + " " + drug_name.getUnit();
            }
        }

        int freq = getFrequency((String) frequency.getSelectedItem());
        int dr = 1;//if stat by default it means 1
        if (duration.isEnabled()) {
            dr = Integer.parseInt((String) duration.getSelectedItem());
        }
        if (drug_name.getUnit().equals("bottle") || drug_name.getUnit().equals("tube")) {
            mult = 1;
            freq = 1;// because when it is tube or bottle frequency will multiply the bottles and tubes which is not intended.
        } else {
//            duration.setEnabled(true);
//            prnlabel.setEnabled(false);
//            prnq.setEnabled(false);
        }
        int amount = 1 * mult;
        if (freq == -2) {//-2 indicates prn
            if (prnq.getSelectedItem().equals("0")) {
                new Warnings("Please specify amount of drug",this).setVisible(true);
                return;
            }
            amount = Integer.parseInt((String) prnq.getSelectedItem()) * mult;
        } else if (freq == -3) {
            amount = 1 * mult;
        } else {
            amount = freq * dr * mult;
        }

        drug_name.setQty(amount);
        drug_name.setDetail(route.getSelectedItem() + " " + frequency.getSelectedItem() + det + "(BN=" + drug_name.getBatchN() + ") #" + amount + drug_name.getUnit());
        drug_name.setStudent_id(id);
        drug_name.setTax(tax);
        drug_name.setProfit_margin(profit_margin);
        drug_name.setTotal_price(calculatePrice(amount, drug_name.getUnitPrice(), tax, profit_margin));
        drug_name.setStatus("Pending");

        System.out.println("drug unit........." + drug_name.getUnit());

        prescriptions.add(drug_name);
        for (int i = 0; i < prescriptions.size(); i++) {
            rx.setValueAt(i + 1, i, 0);
            rx.setValueAt(prescriptions.get(i).getDrug_name() + " " + prescriptions.get(i).getDetail(), i, 1);
        }
    }//GEN-LAST:event_addtotableActionPerformed

    private void delete_drugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_drugActionPerformed
        // TODO add your handling code here:
        int x = rx.getSelectedRow();

        if (x == -1) {
            new Warnings("Please Select drug to be removed",this).setVisible(true);
        } else {
            for (int i = 0; i < prescriptions.size(); i++) {
                String temp = prescriptions.get(i).getDrug_name() + " " + prescriptions.get(i).getDetail();
                temp = temp.trim();
                String drug = (String) rx.getValueAt(x, 1);
//                System.out.println("data is #"++"#   selected is #"++"#");

                if (temp.length() == drug.length()) {
                    prescriptions.remove(i);
                    ds.setEnabled(true);
                    this.dispose();
                    try {
                        new Prescription_Form(ls, prescriptions, id, ds,dm).setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Prescription_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            for (int j = 0; j < prescriptions.size(); j++) {
                rx.setValueAt(j + 1, j, 0);
                rx.setValueAt(prescriptions.get(j).getDrug_name() + " " + prescriptions.get(j).getDetail(), j, 1);
            }
        }
    }//GEN-LAST:event_delete_drugActionPerformed

    private void send_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_orderActionPerformed
        // TODO add your handling code here:
        Repo repo = new Repo();
        repo.addPrescription(prescriptions);
        ds.setEnabled(true);
        dm.dispose();
        this.dispose();
    }//GEN-LAST:event_send_orderActionPerformed

    private void frequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequencyActionPerformed
        // TODO add your handling code here:
        if (route.getSelectedItem().equals("..")) {
            new Warnings("Please select route first",this).setVisible(true);
            return;
        }
        if (frequency.getSelectedItem().equals("PRN") || frequency.getSelectedItem().equals("Stat") || drug_name.getUnit().equals("bottle") || drug_name.getUnit().equals("tube")) {
            duration.setEnabled(false);
            prnlabel.setEnabled(true);
            prnq.setEnabled(true);
        } else {
            duration.setEnabled(true);
            prnlabel.setEnabled(false);
            prnq.setEnabled(false);
        }


    }//GEN-LAST:event_frequencyActionPerformed

    private void routeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeActionPerformed

        // TODO add your handling code here:
        if (frequency.getSelectedItem().equals("PRN") || frequency.getSelectedItem().equals("Stat") || drug_name.getUnit().equals("bottle") || drug_name.getUnit().equals("tube")) {
            duration.setEnabled(false);
            prnlabel.setEnabled(true);
            prnq.setEnabled(true);
        } else {
            duration.setEnabled(true);
            prnlabel.setEnabled(false);
            prnq.setEnabled(false);
        }

    }//GEN-LAST:event_routeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        multiplier.setValue(1);
        if (drugName.getText() == null) {
            new Warnings("Please select medication from the left side", this).setVisible(true);
        }
        {
            setButtonsInactive(false);
        }
        String text = list_of_drugs.getSelectedValue();
        drugName.setText(text);

        drug_name = new Prescription();
        if (drugName.getText().equals("Start writing....")) {
            new Warnings("Please select a drug to add", this).setVisible(true);
            return;
        }
        if (!ls2.contains(drugName.getText())) {
            new Warnings("This drug may be stock out. Please select another drug",this).setVisible(true);
            return;
        }

        drug_name.setClinicianName(ds.clinicianName);
        Bridge br = new Bridge();
        String st = br.getBatchEP(drugName.getText());
        System.out.println("st======" + st);
        drug_name.setBatchN(st.split("@")[0].trim());
        drug_name.setUnitPrice(Double.parseDouble(st.split("@")[1]));
        drug_name.setExpiry_date(st.split("@")[2]);
        drug_name.setUnit(st.split("@")[3]);
        drug_name.setDrug_name((String) drugName.getText());
//        String det = "";
//        if (duration.isEnabled()) {
//            det = " for " + duration.getSelectedItem() + " days";
//        } else {
//            if (frequency.getSelectedItem().equals("PRN") || route.getSelectedItem().equals("TP")) {
//                if (prnq.getSelectedItem().equals("0")) {
//                    JOptionPane.showMessageDialog(null, "Please specify amount of drug");
//                    return;
//                }
//                det = " " + prnq.getSelectedItem() + " " + drug_name.getUnit();
//            }
//        }
//
//        int freq = getFrequency((String) frequency.getSelectedItem());
//        int dr = 1;//if stat by default it means 1
//        if (duration.isEnabled()) {
//            dr = Integer.parseInt((String) duration.getSelectedItem());
//        }
//        int amount = 0;
//        if (freq == -2) {//-2 indicates prn
//            if (prnq.getSelectedItem().equals("0")) {
//                JOptionPane.showMessageDialog(null, "Please specify amount of drug");
//                return;
//            }
//            amount = Integer.parseInt((String) prnq.getSelectedItem());
//        } else if (freq == -3) {
//            amount = 1;
//        } else {
//            amount = freq * dr;
//        }
//        drug_name.setQty(amount);
//        drug_name.setDetail(route.getSelectedItem() + " " + frequency.getSelectedItem() + det + "(BN=" + drug_name.getBatchN() + ")");
//        drug_name.setStudent_id(id);
//        drug_name.setTax(tax);
//        drug_name.setProfit_margin(profit_margin);
//        drug_name.setTotal_price(calculatePrice(amount, drug_name.getUnitPrice(), tax, profit_margin));
//        drug_name.setStatus("Pending");

        System.out.println("drug unit........." + drug_name.getUnit());
        if (drug_name.getUnit().equals("bottle") || drug_name.getUnit().equals("tube")) {
            duration.setEnabled(false);
            prnlabel.setEnabled(true);
            prnq.setEnabled(true);
            multiplier.setEnabled(false);
        } else {
            duration.setEnabled(true);
            prnlabel.setEnabled(false);
            prnq.setEnabled(false);
            multiplier.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ds.setEnabled(true);
        dm.dispose();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prnqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prnqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prnqActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtotable;
    private javax.swing.JButton delete_drug;
    private javax.swing.JTextField drugName;
    private javax.swing.JComboBox<String> duration;
    private javax.swing.JLabel durlabel;
    private javax.swing.JLabel durunit;
    private javax.swing.JLabel freqlabel;
    private javax.swing.JComboBox<String> frequency;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_of_drugs;
    private javax.swing.JSpinner multiplier;
    private javax.swing.JLabel prnlabel;
    private javax.swing.JComboBox<String> prnq;
    private javax.swing.JComboBox<String> route;
    private javax.swing.JLabel routlabel;
    private javax.swing.JTable rx;
    private javax.swing.JButton send_order;
    // End of variables declaration//GEN-END:variables

    public String getUnit(String str) {
        String reverse = "";
        boolean first = true;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (first) {
                first = false;
                continue;
            }
            if (ch == ',') {
                String text = "";
                for (int l = reverse.length() - 1; l >= 0; l--) {
                    text = text + reverse.charAt(l);
                }
                return text;
            }
            reverse = reverse + ch;
        }
        System.out.println("Reversed string is:");
        System.out.println(reverse);
        return null;
    }

    private int getFrequency(String string) {
        System.out.println("at gtf " + string);
        switch (string) {
            case "BID":
                return 2;
            case "TID":
                return 3;
            case "QID":
                return 4;
            case "PRN":
                return -2;
            case "Stat":
                return -3;
            case "Daily":
                return 1;

        }
        return 0;
    }

    private double calculatePrice(int amount, double unitPrice, String tax, String profit_margin) {
        double tax1 = Double.parseDouble(tax);
        double profit_margin1 = Double.parseDouble(profit_margin);
        double price = amount * unitPrice;
        double total_price = price + price * profit_margin1 / 100;
        double grand_total = total_price + total_price * tax1 / 100;

        System.out.println("tax = " + tax1 + "%");
        System.out.println("profit = " + profit_margin1 + "%");
        System.out.println("price = " + price);
        System.out.println("total_price = " + total_price);
        System.out.println("grand_total = " + grand_total);
        return grand_total;
    }

    public void setButtonsInactive(boolean status) {
        if (status) {
            route.setEnabled(false);
            frequency.setEnabled(false);
            duration.setEnabled(false);
            prnq.setEnabled(false);
            prnlabel.setEnabled(false);
            addtotable.setEnabled(false);
            durlabel.setEnabled(false);
            freqlabel.setEnabled(false);
            durlabel.setEnabled(false);
            routlabel.setEnabled(false);
            durunit.setEnabled(false);
        } else {
            route.setEnabled(true);
            frequency.setEnabled(true);
            duration.setEnabled(true);
            prnq.setEnabled(true);
            prnlabel.setEnabled(true);
            addtotable.setEnabled(true);
            durlabel.setEnabled(true);
            freqlabel.setEnabled(true);
            durlabel.setEnabled(true);
            routlabel.setEnabled(true);
            durunit.setEnabled(true);
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharm;

import Clinic.OPD1;

/**
 *
 * @author Jimma University
 */
public class list_of_prescriptions extends javax.swing.JPanel {

    /**
     * Creates new form
     */
    private String stid;
    Dispensery_welcome all_tx;
    private final String full_prescription;
    String[] st;
    private final String full_prescription_to_db;
    private request_old_rx all_tx_requested;

    public list_of_prescriptions(String data, Dispensery_welcome all_tx) {
        initComponents();
//        System.out.println("?"+data);
        this.all_tx = all_tx;
        st = data.split("@");
        date.setText("Date: " + st[1]);
        student_id.setText("MRN: " + st[2]);
        name.setText("Patient Name: " + st[3]);
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '@') {
                count++;
            }
            if (count == 5) {
                count = i;
                break;
            }
        }
        String temp = data.substring(count);
        String[] x = temp.split("@");
        String ext = "1. " + temp;
        String temp2 = ext.replace("@", " ");
        
        String[] gross = temp2.split("\n");
        String drug = "";
        for (int i = 0; i < gross.length; i++) {
            String[] det = gross[i].substring(gross[i].indexOf('&')).split("&");
            
            String quant;
            if(det[1].equals("tube")){
                quant = "";
            }else{
                quant = " #"+det[4]+" "+det[1];
            }
            String med = gross[i].substring(0,gross[i].indexOf('&')) +quant;
          
            
            if(drug.equals("")){
                drug = med;
            }else{
                drug= drug+"\n"+med;
            }
        }
        full_prescription = st[1] + "@" + st[2] + "@" + st[3]+"@"+st[4] + "@" + drug;
        full_prescription_to_db = st[1] + "@" + st[2] + "@" + st[3]+"@"+st[4] + "@" + temp2;
        detail.setText(drug);
        clinician.setText("Prescriber: "+st[4]);
    }
    public list_of_prescriptions(String data, request_old_rx all_tx) {
        initComponents();
//        System.out.println("?"+data);
        this.all_tx_requested = all_tx;
        st = data.split("@");
        date.setText("Date: " + st[1]);
        student_id.setText("MRN: " + st[2]);
        name.setText("Patient Name: " + st[3]);
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '@') {
                count++;
            }
            if (count == 5) {
                count = i;
                break;
            }
        }
        String temp = data.substring(count);
        String[] x = temp.split("@");
        String ext = "1. " + temp;
        String temp2 = ext.replace("@", " ");
        
        String[] gross = temp2.split("\n");
        String drug = "";
        for (int i = 0; i < gross.length; i++) {
            String[] det = gross[i].substring(gross[i].indexOf('&')).split("&");
            
            String quant;
            if(det[1].equals("tube")){
                quant = "";
            }else{
                quant = " #"+det[4]+" "+det[1];
            }
            String med = gross[i].substring(0,gross[i].indexOf('&')) +quant;
          
            
            if(drug.equals("")){
                drug = med;
            }else{
                drug= drug+"\n"+med;
            }
        }
        full_prescription = st[1] + "@" + st[2] + "@" + st[3]+"@"+st[4] + "@" + drug;
        full_prescription_to_db = st[1] + "@" + st[2] + "@" + st[3]+"@"+st[4] + "@" + temp2;
        detail.setText(drug);
        clinician.setText("Prescriber: "+st[4]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selected_p = new javax.swing.JRadioButton();
        student_id = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail = new javax.swing.JTextArea();
        date = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        clinician = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 102));
        setMaximumSize(new java.awt.Dimension(360, 12));

        selected_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selected_pActionPerformed(evt);
            }
        });

        student_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        student_id.setForeground(new java.awt.Color(255, 255, 255));
        student_id.setText("jLabel1");

        detail.setColumns(20);
        detail.setRows(5);
        jScrollPane1.setViewportView(detail);

        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(255, 153, 0));
        date.setText("jLabel1");

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 0));
        name.setText("jLabel1");

        clinician.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clinician.setForeground(new java.awt.Color(255, 255, 255));
        clinician.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(selected_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clinician)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(selected_p, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(student_id)
                            .addComponent(name)
                            .addComponent(date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(clinician))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selected_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selected_pActionPerformed
        // TODO add your handling code here:
        System.out.println("id selected..." + student_id.getText());
        if (selected_p.isSelected()) {
            if(all_tx!=null)
            all_tx.selected_prescriptions.add(full_prescription_to_db);
            if(all_tx_requested!=null)
            all_tx_requested.selected_prescriptions.add(full_prescription_to_db);
        } else {
            if(all_tx!=null)
            all_tx.selected_prescriptions.remove(full_prescription_to_db);
            if(all_tx_requested!=null)
            all_tx_requested.selected_prescriptions.remove(full_prescription_to_db);
        }
    }//GEN-LAST:event_selected_pActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clinician;
    private javax.swing.JLabel date;
    private javax.swing.JTextArea detail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JRadioButton selected_p;
    private javax.swing.JLabel student_id;
    // End of variables declaration//GEN-END:variables

}

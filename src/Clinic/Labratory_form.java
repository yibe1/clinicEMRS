/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author yibe1
 */
public class Labratory_form extends javax.swing.JFrame {

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<Labratory> labTest;
    JTextArea text_area;
    String id;//patient id

    /**
     * Creates new form Labratory_form
     */
    public Labratory_form(JTextArea test_area, ArrayList<Labratory> labTest, String id) {
        initComponents();
        table.getSelectionModel().setSelectionMode(SINGLE_SELECTION);
        this.labTest = labTest;
        this.text_area = test_area;
        this.id = id;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        test = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        select_order = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fill_result = new javax.swing.JButton();
        result_title = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        select_order1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Lab Test");

        test.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        test.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Test", "Blood Film", "Stool Examination", "HPylori St.Ag", "Widal Test", "Weilfelix Test ", "Uring Analysis", "Erythrocyte Sedmentation Rate (ESR)", "Complete Blood Count (CBC)", "Hiv Test", " ", " " }));

        result.setColumns(20);
        result.setRows(5);
        jScrollPane1.setViewportView(result);

        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "S.No", "Test Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(20);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        select_order.setBackground(new java.awt.Color(255, 204, 0));
        select_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select_order.setForeground(new java.awt.Color(0, 153, 51));
        select_order.setText("Order Selected Test >>");
        select_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_orderActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Labratory Orders");

        fill_result.setBackground(new java.awt.Color(255, 255, 255));
        fill_result.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fill_result.setForeground(new java.awt.Color(255, 0, 0));
        fill_result.setText("<< Result ");
        fill_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fill_resultActionPerformed(evt);
            }
        });

        result_title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        result_title.setText("Select From Ordered Tests");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ordered Test");

        select_order1.setBackground(new java.awt.Color(255, 204, 0));
        select_order1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select_order1.setForeground(new java.awt.Color(204, 51, 0));
        select_order1.setText("Remove Test ");
        select_order1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_order1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fill_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(select_order)))
                            .addComponent(result_title)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(select_order1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(select_order))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(select_order1)
                        .addGap(23, 23, 23)
                        .addComponent(result_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fill_result)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void select_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_orderActionPerformed
        // TODO add your handling code here:
        String temp = (String) test.getSelectedItem();
        Labratory lab = new Labratory();
        if (temp.equals("Select Test")) {
            JOptionPane.showMessageDialog(rootPane, "Please Select Test First");
        } else {
            for (int i = 0; i < labTest.size(); i++) {
                if (temp.equals(labTest.get(i).getTestType())) {

                    JOptionPane.showMessageDialog(rootPane, "Test already selected");
                    return;

                };
            }

            lab.setTestType(temp);
            lab.setResult("No result yet!");
            lab.setStudent_id(id);
            labTest.add(lab);
            fill_table();
        }

    }//GEN-LAST:event_select_orderActionPerformed

    private void select_order1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_order1ActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Select test to remove");
            return;
        }
        String temp = (String) table.getModel().getValueAt(row, 1);
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to remove test " + temp, "Warning!", 1);
        System.out.println("you selected " + option);
        if (option == 0) {
            int j = -1;
            for (int i = 0; i < labTest.size(); i++) {
                if (temp.equals(labTest.get(i).getTestType())) {
                    j = i;
                }
            }
            if (j != -1) {
                labTest.remove(labTest.get(j));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selected Item not found!");
                return;
            }

            fill_table();
        }

    }//GEN-LAST:event_select_order1ActionPerformed

    private void fill_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fill_resultActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Select test first");
            return;
        } else {
            String temp = (String) table.getModel().getValueAt(row, 1);
            result_title.setText(temp);
        }
    }//GEN-LAST:event_fill_resultActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ;
        String text = "";
        for (int i = 0; i < labTest.size(); i++) {
            if (!"".equals(text)) {
                text = text + "\n***************************\n" + (i + 1) + ") ";
            } else {
                text = (i + 1) + ") " + text;
            }
            text = text + labTest.get(i).getTestType() + "\n    :" + labTest.get(i).getResult();
        }
        text_area.setText(text);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Labratory_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labratory_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labratory_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labratory_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fill_result;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea result;
    private javax.swing.JLabel result_title;
    private javax.swing.JButton select_order;
    private javax.swing.JButton select_order1;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> test;
    // End of variables declaration//GEN-END:variables
public void fill_table() {
        for (int i = 0; i < 10; i++) {
            table.getModel().setValueAt("", i, 0);
            table.getModel().setValueAt("", i, 1);
        }
        table.clearSelection();
        for (int i = 0; i < labTest.size(); i++) {
            table.getModel().setValueAt(i + 1, i, 0);
            table.getModel().setValueAt(labTest.get(i).getTestType(), i, 1);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

/**
 *
 * @author Jimma University
 */
import Clinic.Prescription;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pharm.Requests;

public class Bridge {

    private String dbname = "all_drugs";
    private String sec = "i)//0LACK]LAZ!k]";
    private String user = "admin";
    private java.util.Date dt;
    private String date, ip;

    Connection conn = null;
    Statement stmt = null;
    private int x;

    public Bridge() {
        FileReader fr = null;
        try {
            File file = new File("ip.txt");
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ip = br.readLine();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            }
        }
    }

    public void drug(String drug_name, String unit, int received_quantity, int issued_quantity, int balance, double unit_price, String batch_number, Date expiry_date, String supplied_from, String sells_invoice_number, Date transaction_date) {

        // Connect to the database server using the JDBC driver
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            // Create a prepared statement object to execute SQL commands with parameters
//            String s = "Select * from drugs where drut_name = "+drug_name;
//            ResultSet rs = stmt.executeQuery(s);
//            if(rs.next()){
//                int existingQ = rs.getInt("received_quantity");
//                int newquantity = existingQ + received_quantity;
//                
//                String sql = "update drugs set received_quantity ="+newquantity+", unit_price, batch_number, expiry_date, supplied_from, sells_invoice_number, transaction_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            }

            String sql = "INSERT INTO drugs (drug_name, unit, quantity, unit_price, batch_number, expiry_date, supplied_from, sells_invoice_number, transaction_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the values for the parameters
            pstmt.setString(1, drug_name); // drug_name
            pstmt.setString(2, unit); // package_unit
            pstmt.setInt(3, received_quantity); // received_quantity
            pstmt.setDouble(4, unit_price);
            pstmt.setString(5, batch_number); // batch_number
            pstmt.setDate(6, expiry_date); // expiry_date
            pstmt.setString(7, supplied_from); // supplied_from
            pstmt.setString(8, sells_invoice_number); // sells_invoice_number
            pstmt.setDate(9, transaction_date); // package_quantity
            // Execute the prepared statement
            pstmt.executeUpdate();
            // Close the prepared statement object
            pstmt.close();
            // Print a success message
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int add_request(String requested_drugs, String userName, String department) {
        int x = 0;
        System.out.println("req drug..." + requested_drugs);
        String[] drug = requested_drugs.split("@");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {

            String sql = "INSERT INTO requested_drugs (drug_name, unit, quantity,requested_by,department, status, request_date, review_date) VALUES (?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the values for the parameters
            pstmt.setString(1, drug[0]); // drug_name
            pstmt.setString(2, drug[1]); // package_unit
            pstmt.setInt(3, Integer.parseInt(drug[2])); // received_quantity
            pstmt.setString(4, userName);
            pstmt.setString(5, department); // issued_quantity
            pstmt.setString(6, "Pending"); // issued_quantity
            java.util.Date date = new java.util.Date();
            pstmt.setDate(7, new Datetosql().convert(date)); // convert date to sql date
            pstmt.setDate(8, new Datetosql().convert(date));

            x = pstmt.executeUpdate();
            // Close the prepared statement object
            pstmt.close();
            // Print a success message
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Connect to the database server using the JDBC driver
        return x;
    }

    public ArrayList<String> getRequests() {
        ArrayList<String> drugs = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select * from requested_drugs where status = 'Pending'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String data = String.valueOf(rs.getInt("req_no")) + "," + String.valueOf(rs.getDate("request_date")) + "," + String.valueOf(rs.getString("requested_by")) + "," + String.valueOf(rs.getString("department"));
                drugs.add(data);
                System.out.println("req data = " + data);
            }
            // Close the prepared statement object
            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public ArrayList<String> getDrug(int req_no) throws SQLException {
        ArrayList<String> drugs = new ArrayList();
        String drName = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select ad.drug_name,ad.unit,ad.unit_price, rd.quantity, ad.batch_number, ad.expiry_date, ad.quantity from requested_drugs rd join drugs ad on rd.drug_name = ad.drug_name where rd.status = 'Pending' and req_no = " + req_no + " and rd.unit = ad.unit and ad.quantity > 0 order by ad.expiry_date";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("loop requasted.....");
            while (rs.next()) {
                drName = rs.getString("ad.drug_name");
                String data = req_no + "@" + rs.getString("ad.drug_name") + "@" + rs.getString("ad.unit") + "@" + rs.getString("ad.batch_number") + "@" + rs.getString("ad.expiry_date") + "@" + rs.getInt("rd.quantity") + "@" + rs.getInt("ad.quantity") + "@" + rs.getDouble("ad.unit_price");
                drugs.add(data);
                System.out.println("at loop..." + data);
            }
//
            stmt.close();
        }
        return drugs;
    }

    public void add_to_dispensary(ArrayList<String> approved_requests, String userName, Requests req) {
        for (int i = 0; i < approved_requests.size(); i++) {

            String[] drug = approved_requests.get(i).split("@");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO `dispensary_drugs`(`Req_no`,`drug_name`, `unit`, `quantity`, `unit_price`, `batch_number`, `expiry_date`) VALUES "
                        + "(" + drug[0] + ",'" + drug[1] + "','" + drug[2] + "'," + Integer.parseInt(drug[3]) + "," + Double.parseDouble((String) drug[4]) + ",'" + drug[5] + "','" + drug[6] + "')";

                // Close the prepared statement object
                stmt.executeUpdate(sql);
                sql = "UPDATE `requested_drugs` SET `status`='complete', `reviewed_by` = '" + userName + "' where req_no = " + drug[0];
                stmt.executeUpdate(sql);
                sql = "INSERT INTO `drugs`(`drug_name`, `unit`, `quantity`, `unit_price`, `batch_number`, `expiry_date`,`transaction_date`) VALUES "
                        + "('" + drug[1] + "','" + drug[2] + "'," + (Integer.parseInt(drug[3]) * -1) + "," + Double.parseDouble((String) drug[4]) + ",'" + drug[5] + "','" + drug[6] + "', NOW())";

                stmt.executeUpdate(sql);

                stmt.close();
                // Print a success message
                System.out.println("Data inserted successfully.");
                req.dispose();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void reject_request(ArrayList<String> rejected_requests, String userName, Requests req) {
        for (int i = 0; i < rejected_requests.size(); i++) {
            String[] drug = rejected_requests.get(i).split(",");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
                stmt = conn.createStatement();
                String sql = "UPDATE `requested_drugs` SET `status`='rejected', `comment` = '" + drug[1] + "', `reviewed_by` = '" + userName + "' where req_no = " + Integer.parseInt(drug[0]);
                stmt.executeUpdate(sql);
                stmt.close();
                // Print a success message
                System.out.println("Data updated successfully.");
                req.dispose();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public ArrayList<String> getRequests_for_confirmation() {
        ArrayList<String> drugs = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select * from requested_drugs where status = 'complete' and transaction_confirmed = 0";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String data = String.valueOf(rs.getInt("req_no")) + ",'" + rs.getString("drug_name") + "','" + rs.getString("unit") + "'," + rs.getInt("quantity") + ",'" + rs.getString("requested_by") + "','" + rs.getString("department") + "','" + String.valueOf(rs.getDate("request_date") + "','" + rs.getString("reviewed_by") + "','" + String.valueOf(rs.getDate("review_date")) + "'");
                drugs.add(data);
            }
            // Close the prepared statement object
            stmt.close();
            // Print a success message
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public void confirm(int req_no) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "UPDATE `requested_drugs` SET `transaction_confirmed` = 1 where req_no = " + req_no;
            stmt.executeUpdate(sql);
            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMy_Requests(String userName) {
        ArrayList<String> drugs = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select * from requested_drugs r join drugs d on r.drug_name = d.drug_name where transaction_confirmed = 0 and requested_by = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("here.............1");
            while (rs.next()) {
                String c = "No";
                int confirmation = rs.getInt("transaction_confirmed");
                if (confirmation == 1) {
                    c = "Yes";
                }
                System.out.println("here.............2");
                String data = String.valueOf(rs.getInt("req_no")) + "," + rs.getString("drug_name") + "," + rs.getString("unit") + "," + rs.getString("batch_number") + "," + String.valueOf(rs.getDate("expiry_date")) + "," + rs.getInt("r.quantity") + "," + String.valueOf(rs.getDate("request_date")) + "," + rs.getInt("d.quantity") + "," + rs.getString("status") + "," + c;
                drugs.add(data);
            }
            // Close the prepared statement object
            stmt.close();
            // Print a success message
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public void remove(String req_no, String userName) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "DELETE FROM `requested_drugs` where req_no = " + req_no + " and requested_by = '" + userName + "'";
            stmt.executeUpdate(sql);

            sql = "DELETE FROM `dispensary_drugs` where req_no = " + req_no;
            stmt.executeUpdate(sql);

            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove2(String drug_name, String userName) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "DELETE FROM `requested_drugs` where drug_name = '" + drug_name + "' and requested_by = '" + userName + "'";
            stmt.executeUpdate(sql);
            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMy_unuproved_Requests(String userName) {
        ArrayList<String> drugs = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select * from requested_drugs where status = 'Pending' and requested_by = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String c = "No";
                int confirmation = rs.getInt("transaction_confirmed");
                if (confirmation == 1) {
                    c = "Yes";
                }
                String data = rs.getString("drug_name") + "@" + rs.getString("unit") + "@" + rs.getInt("quantity");
                drugs.add(data);
            }
            // Close the prepared statement object
            stmt.close();
            // Print a success message
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public int update_request(String usrName, String drugName, String unit, int qty) {
        int x = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "UPDATE `requested_drugs` SET `quantity` = " + qty + " where requested_by = '" + usrName + "' and drug_name = '" + drugName + "' and status = 'Pending'";
            x = stmt.executeUpdate(sql);

            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public int remove_unaproved_request(String drugName, String userName) {
        int x = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "DELETE FROM `requested_drugs` where requested_by  = '" + userName + "' and drug_name = '" + drugName + "' and status = 'Pending'";
            x = stmt.executeUpdate(sql);
            System.out.println("x is " + x);
            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception " + e);
        }
        return x;
    }

    public ArrayList<String> getDispensary_stock() {
        ArrayList<String> drugs = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "select drug_name,unit,unit_price, quantity, batch_number, expiry_date from dispensary_drugs order by drug_name";
            ResultSet rs = stmt.executeQuery(sql);
            int j = 1, x = 0;
            String data = null;
            String temp = "";
            while (rs.next()) {

                if (temp.equals("")) {
                    data = j + "@" + rs.getString("drug_name") + "@" + rs.getString("unit") + "@" + rs.getDouble("unit_price") + "@" + rs.getString("expiry_date") + "@" + rs.getString("batch_number") + "@" + rs.getInt("quantity");
                    temp = rs.getString("drug_name") + rs.getString("batch_number");
                    x = rs.getInt("quantity");
                    System.out.println(data);
                } else if (temp.equals(rs.getString("drug_name") + rs.getString("batch_number"))) {
                    x = x + rs.getInt("quantity");
                    data = j + "@" + rs.getString("drug_name") + "@" + rs.getString("unit") + "@" + rs.getDouble("unit_price") + "@" + rs.getString("expiry_date") + "@" + rs.getString("batch_number") + "@" + x;
                } else {
                    if (x >= 0) {
                        drugs.add(data);
                        System.out.println(data + "....... x added");
                    }
                    temp = rs.getString("drug_name") + rs.getString("batch_number");
                    x = rs.getInt("quantity");
                    data = j + "@" + rs.getString("drug_name") + "@" + rs.getString("unit") + "@" + rs.getDouble("unit_price") + "@" + rs.getString("expiry_date") + "@" + rs.getString("batch_number") + "@" + x;

                }

            }
            if (x >= 0) {
                drugs.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("return the requested...........");
        return drugs;
    }

    ArrayList<String> drugs = new ArrayList();
    ArrayList<String> modified_drugs = new ArrayList();

    public ArrayList<String> get_drugs() {
        // Connect to the database server using the JDBC driver
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String s = "Select drug_name,unit, quantity from drugs order by drug_name";
            ResultSet rs = stmt.executeQuery(s);
            String temp = "";
            int x = 0;
            while (rs.next()) {
                if (temp.equals("")) {
                    temp = rs.getString("drug_name") + "&" + rs.getString("unit");
                    x = rs.getInt("quantity");
                } else if (temp.equals(rs.getString("drug_name") + "&" + rs.getString("unit"))) {
                    x = x + rs.getInt("quantity");
                } else {
                    if (x > 0) {
                        drugs.add(temp + "@" + x);
                        System.out.println(temp + "," + x);
                    }
                    temp = rs.getString("drug_name") + "&" + rs.getString("unit");
                    x = rs.getInt("quantity");
                }

            }
            if (x > 0) {
                drugs.add(temp + "@" + x);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }

    public ArrayList<String> getPrescriptions() {
        ArrayList<String> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + "cl", user, sec)) {
            stmt = conn.createStatement();
            String s = "Select p.student_id,p.drug_name, p.date,p.detail,p.unit,p.unit_price,p.expiry_date,p.qty, s.full_name, p.status, p.clinician,p.tax,p.profit_margin, p.total_price from prescription p join patient s on s.student_id = p.student_id where p.status = 'Pending' order by date";
            ResultSet rs = stmt.executeQuery(s);
            int x = 0;
            while (rs.next()) {
                list.add(rs.getString("date") + "@" + rs.getString("student_id") + "@" + rs.getString("full_name").toUpperCase() + '@' + rs.getString("clinician") + "@" + rs.getString("drug_name") + "@" + rs.getString("detail") + "&" + rs.getString("unit") + "&" + rs.getDouble("unit_price") + "&" + rs.getString("expiry_date") + "&" + rs.getInt("qty") + "&" + rs.getString("tax") + "&" + rs.getString("profit_margin") + "&" + rs.getDouble("total_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update_prescription_status(ArrayList<String> selected_prescriptions) throws SQLException {
        for (int i = 0; i < selected_prescriptions.size(); i++) {

            String[] drug = selected_prescriptions.get(i).split("@");
            String date = drug[0];
            String id = drug[1];
            String allDrug = drug[4];

            String[] drug_detail = allDrug.split("\n");
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + "cl", user, sec);
            Connection conn2 = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = conn.createStatement();
            Statement stmt2 = conn2.createStatement();

            for (int j = 0; j < drug_detail.length; j++) {
                String temp_drug = drug_detail[j].substring(0, drug_detail[j].indexOf('&'));
                String px = drug_detail[j].substring(drug_detail[j].indexOf('&'));
                double unit_price = Double.parseDouble(px.split("&")[2]);
                String unit = px.split("&")[1];
                String expiry_date = px.split("&")[3];
                int qty = Integer.parseInt(px.split("&")[4]);
                System.out.println("temp drug...." + temp_drug);
                String drug_name = temp_drug.substring(getFirstindexofDrugName(temp_drug), temp_drug.indexOf('!'));
                String temp_unit = temp_drug.substring(temp_drug.indexOf('!'));
                String stringamount = temp_unit.substring(temp_unit.indexOf('-') + 1);
//                String drug_name_withUnit = drug_name + unit.trim();
                String sql = "UPDATE `prescription` SET `status` = 'Complete' where date = '" + date + "' and drug_name = '" + drug_name + "' and student_id = '" + id + "'";
                stmt.executeUpdate(sql);

                String batch = stringamount.substring(stringamount.indexOf('=') + 1, stringamount.indexOf(')'));
                sql = "INSERT INTO `dispensary_drugs`(`Req_no`, `drug_name`, `unit`, `quantity`, `unit_price`,`batch_number`,`expiry_date`, `transaction_date`) VALUES "
                        + "('" + -1 + "','" + drug_name + "','" + unit + "'," + qty * -1 + "," + unit_price + ",'" + batch + "','" + expiry_date + "',NOW())";
                System.out.println("sql = " + sql);
                stmt2.executeUpdate(sql);
            }
            stmt.close();
            stmt2.close();

        }
    }

    public ArrayList<String> getRecentPrescription(String id) {
        ArrayList<String> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + "cl", user, sec)) {
            stmt = conn.createStatement();
            String s = "Select p.student_id,p.drug_name, p.date,p.detail,p.unit,p.unit_price,p.expiry_date,p.qty, s.full_name, p.status, p.clinician,p.tax,p.profit_margin, p.total_price from prescription p join patient s on s.student_id = p.student_id where p.status = 'Complete' and p.student_id = '" + id + "' order by date";
            ResultSet rs = stmt.executeQuery(s);
            int x = 0;
            while (rs.next()) {
                list.add(rs.getString("date") + "@" + rs.getString("student_id") + "@" + rs.getString("full_name").toUpperCase() + '@' + rs.getString("clinician") + "@" + rs.getString("drug_name") + "@" + rs.getString("detail") + "&" + rs.getString("unit") + "&" + rs.getDouble("unit_price") + "&" + rs.getString("expiry_date") + "&" + rs.getInt("qty") + "&" + rs.getString("tax") + "&" + rs.getString("profit_margin") + "&" + rs.getDouble("total_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getBatchEP(String drugName) {
        ArrayList<String> list = new ArrayList();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "SELECT `batch_number`,`quantity`,`unit_price`, `expiry_date`,`unit` FROM `dispensary_drugs` WHERE drug_name = '" + drugName + "'";
            System.out.println("sql...." + sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("batch_number") + "@" + String.valueOf(rs.getInt("quantity")) + "@" + String.valueOf(rs.getDouble("unit_price")) + "@" + String.valueOf(rs.getDate("expiry_date")) + "@" + rs.getString("unit"));
            }
            // Close the prepared statement object
            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<String> uniqList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!uniqList.contains(list.get(i))) {
                uniqList.add(list.get(i));
            }
        }
        for (int i = 0; i < uniqList.size(); i++) {
            String batchN = uniqList.get(i).split("@")[0] + "@" + uniqList.get(i).split("@")[2] + "@" + uniqList.get(i).split("@")[3] + "@" + uniqList.get(i).split("@")[4];
            int quantity = 0;
            for (int j = 0; j < list.size(); j++) {
                if (uniqList.get(i).equals(list.get(j))) {
                    quantity = quantity + Integer.parseInt(list.get(i).split("@")[1]);
                }
            }
            if (quantity > 0) {
                return batchN;
            }
        }
        return null;
    }

    private int getFirstindexofDrugName(String drug_name) {
        for (int i = 0; i < drug_name.length(); i++) {
            char ch = drug_name.charAt(i);
            if (ch >= 65 && ch <= 90) {
                return i;
            }
        }
        return -1;
    }

    public void addPrescription(ArrayList<Prescription> prescriptions) {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/cl", "admin2", ".[TzO1abD8tb[B)0");
            for (int i = 0; i < prescriptions.size(); i++) {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `prescription`(`student_id`, `drug_name`, `detail`, `unit`,`unit_price`,`expiry_date`, `status`,`clinician`, `qty`,`tax`,`profit_margin`,`total_price`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, prescriptions.get(i).getStudent_id());
                pstmt.setString(2, prescriptions.get(i).getDrug_name());
                pstmt.setString(3, "Offline Entry");
                pstmt.setString(4, prescriptions.get(i).getUnit());
                pstmt.setDouble(5, prescriptions.get(i).getUnitPrice());
                pstmt.setString(6, prescriptions.get(i).getExpiry_date());
                pstmt.setString(7, "Complete");
                pstmt.setString(8, prescriptions.get(i).getClinicianName());
                pstmt.setInt(9, prescriptions.get(i).getQty());
                pstmt.setString(10, prescriptions.get(i).getTax());
                pstmt.setString(11, prescriptions.get(i).getProfit_margin());
                pstmt.setDouble(12, prescriptions.get(i).getTotal_price());

                pstmt.execute();
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

    }

    public boolean update_offline_dispensing(Prescription prescription) throws SQLException {
//        for (int i = 0; i < prescriptions.size(); i++) {
        boolean response = true;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = conn.createStatement();
            String sql = "INSERT INTO `dispensary_drugs`(`Req_no`, `drug_name`, `unit`, `quantity`, `unit_price`,`batch_number`,`expiry_date`, `transaction_date`,`mrn_for_offline`) VALUES "
                    + "('" + -1 + "','" + prescription.getDrug_name() + "','" + prescription.getUnit() + "'," + prescription.getQty() * -1 + "," + prescription.getUnitPrice() + ",'" + prescription.getBatchN() + "','" + prescription.getExpiry_date() + "',NOW(),'" + prescription.getStudent_id() + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            stmt.close();
        }

//        }
        return response;
    }

    public boolean removeOfflinePrescription(Prescription rx) {
        boolean status = true;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String sql = "DELETE FROM `dispensary_drugs` where drug_name = '" + rx.getDrug_name() + "' and transaction_date = NOW() and mrn_for_offline = '" + rx.getStudent_id() + "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            // Print a success message
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return status;
    }

    public ArrayList getDrugNames() {
        ArrayList<String> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            stmt = conn.createStatement();
            String s = "Select * from drug_list";
            ResultSet rs = stmt.executeQuery(s);
            int x = 0;
            while (rs.next()) {
                list.add(rs.getString("DrugNameWithStrength"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

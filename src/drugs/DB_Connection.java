/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jimma University
 */
public class DB_Connection {

    private String dbname = "all_drugs";
    private String sec = "i)//0LACK]LAZ!k]";
    private String user = "admin";
    private java.util.Date dt;
    private String date, ip;

    Connection conn = null;
    Statement stmt = null;

    public void create_connection() {
        this.ip = getIp();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            System.out.println("Db created");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create_database() {
        this.ip = "10.140.103.69";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/", user, sec)) {

            Statement stmt = conn.createStatement();
            // Use the executeUpdate() method to create a new database if it does not exist
            String sql = "CREATE DATABASE IF NOT EXISTS all_drugs";
            stmt.executeUpdate(sql);
            // Close the statement object
            stmt.close();
            // Print a success message
            System.out.println("Database created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void create_table() {
        // Connect to the database server using the JDBC driver
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec)) {
            // Create a statement object to execute SQL commands
            Statement stmt = conn.createStatement();
            // Use the executeUpdate() method to create a new table
            String sql = "CREATE TABLE drugs ("
                    + "drug_name VARCHAR(50),"
                    + "package_unit VARCHAR(200),"
                    + "package_quantity INT,"
                    + "package_unit_price DOUBLE,"
                    + "min_unit_price DOUBLE,"
                    + "batch_number VARCHAR(50),"
                    + "expiry_date DATE,"
                    + "supplied_from VARCHAR(50),"
                    + "sells_invoice_number VARCHAR(50)"
                    + ")";
            stmt.executeUpdate(sql);
            // Close the statement object
            stmt.close();
            // Print a success message
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getIp() {
        String ip = null;
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
//        dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
//        date = sdf.format(dt);

        return ip;
    }

    public static void main(String[] args) {
        DB_Connection db = new DB_Connection();
        db.create_database();
        db.create_table();
    }
}

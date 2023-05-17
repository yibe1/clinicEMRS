/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharm;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yibe1
 */
public class RepoPharma {

    private String dbname = "cl";
    private String sec = "i)//0LACK]LAZ!k]";
    private String user = "admin";
    private java.util.Date dt;
    private String date, ip;

    Connection conn = null;
    Statement stmt = null;

    public RepoPharma() {
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
        dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(dt);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+ip+":3306/" + dbname, user, sec);
            System.out.println("Db created");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void register(Drug drug) {

        try {
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO `drug`(`generic_name`, `brand_name`, `manufacturer`, `basic_unit`, `prefered_unit`, `batch_number`, `expiry_date`,"
                    + " `strength`, `unitprice`, `quantity`, `date`, `tr_type`, `created_by`, `last_modified_by`,`date_last_modified`, `total_modified`) VALUES ('" + drug.getGeneric_name() + "','" + drug.getBrand_name() + "','" + drug.getManufacturer() + "','"
                    + drug.getBasic_unit() + "','" + drug.getPrefered_unit() + "','" + drug.getBatch_number() + "','" + drug.getExpiry_date() + "','"
                    + drug.getStrength() + "'," + drug.getUnit_price() + "," + drug.getQuantity() + ",NOW(),'" + drug.getTr_type() + "','" + drug.getCreated_by()
                    + "','" + drug.getLast_mod_by() + "',NOW()," + drug.getTotal_mod() + ")";
            stmt.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "Registration Complete!\n Now you can login to the system");

//      System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
            JOptionPane.showMessageDialog(null, "Registration Failed!\nChange your username and try again");
        } catch (Exception excep) {
            excep.printStackTrace();
            System.out.println("exception2 is: " + excep);
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");
    }

    public String[] getUser(String userName) {
        String[] userdata = new String[3];
        try {

            stmt = (Statement) conn.createStatement();
            String query1 = "select * from user where user_name = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(query1);
            while (rs.next()) {
                userdata[0] = rs.getString("role");
                userdata[1] = rs.getString("password");
                userdata[2] = rs.getString("name");
            }
        } catch (SQLException excep) {
            excep.printStackTrace();
            System.out.println("exception1 is: " + excep);
        } catch (Exception excep) {
            excep.printStackTrace();
            System.out.println("exception2 is: " + excep);
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return userdata;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yibe1
 */
public class Repo {

    private String dbname = "cl";
    private String sec = ".[TzO1abD8tb[B)0";
    private String user = "admin2";
    private java.util.Date dt;
    private String date, ip;

    Connection conn = null;
    Statement stmt = null;

    public Repo() {
        FileReader fr = null;
        try {
            File file = new File("ip.txt");
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ip = br.readLine();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(dt);

    }

    public void register(String username, String name, String roll, String pass) {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO user " + "VALUES ('" + username + "','" + name + "','" + roll + "','" + pass + "')";
            stmt.executeUpdate(query1);
//            JOptionPane.showMessageDialog(null, "Registration Complete!\n Now you can login to the system");

////      System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
            JOptionPane.showMessageDialog(null, "Registration Failed!\nChange your username and try again");
        } catch (Exception excep) {
            excep.printStackTrace();
//            System.out.println("exception2 is: " + excep);
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
//        System.out.println("Please check it in the MySQL Table......... ……..");
    }

    public String[] getUser(String userName) {
        String[] userdata = new String[3];
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
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
//            System.out.println("exception1 is: " + excep);
        } catch (Exception excep) {
            excep.printStackTrace();
//            System.out.println("exception2 is: " + excep);
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

    /**
     *
     * @author yibe1
     */
    public void register_patient(Patient pt) {
        String id = pt.getStudent_id();
        String fname = pt.getFull_name();
        String age = pt.getBirth_date();
        String sex = pt.getSex();
        String dep = pt.getDepartment();
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String data = "INSERT INTO `patient`(`student_id`, `full_name`, `sex`, `birth_date`, `department`) VALUES ('" + id + "','" + fname + "','" + sex + "','" + age + "','" + dep + "')";
            stmt.execute(data);
//            System.out.println("Db accepted 2");
        } catch (Exception e) {
//            System.out.println("database error: " + e);
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
    }

    public Patient getPatient(String id) {
        Patient pt = new Patient();
        pt.setStudent_id(id);
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select * from `patient` where student_id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(data);

            if (rs.next()) {
                pt.setFull_name(rs.getString("full_name"));
                pt.setSex(rs.getString("sex"));
                pt.setBirth_date(rs.getDate("birth_date").toString());
                pt.setDepartment(rs.getString("department"));
            } else {
                pt = null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
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

        return pt;
    }

    public void add_to_waiting(Patient student) {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String data = "INSERT INTO `waiting_patients`(`student_id`, `status`,`date`,`complete`) VALUES ('" + student.getStudent_id() + "',0, NOW(),0)";
            stmt.execute(data);
//            JOptionPane.showMessageDialog(null, "Success!. Patient added to waiting list!", "Success", 1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Patient already registered", "Error", 0);
//            System.out.println("database error: " + e);
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

    }

    ArrayList<String[]> getWaiting() {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select p.student_id, `full_name`,`room`,`allocated_user`,`status`, TIMEDIFF(NOW(),`t1`) as t from `waiting_patients` w join patient p on w.student_id = p.student_id where date = '" + date + "'order by t1";
            ResultSet rs = stmt.executeQuery(data);
            while (rs.next()) {
                String[] message = new String[5];
                message[0] = rs.getString("full_name") + "(" + rs.getString("student_id") + ")";
                message[1] = String.valueOf(rs.getInt("room"));
                message[2] = rs.getString("allocated_user");
                message[3] = rs.getString("t");
                message[4] = String.valueOf(rs.getInt("status"));
////                System.out.println("status......and...time diff.." + message[4] + ", " + message[3]);
                list.add(message);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
        }
        return list;
    }

//    ArrayList<ArrayList<String>> getWaiting2() {
//        ArrayList<ArrayList<String>> patient_list = new ArrayList<ArrayList<String>>();
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            stmt = (Statement) conn.createStatement();
//            String data = "select * from `waiting_patients` w left join patient p on w.student_id = p.student_id where w.status = 0 and date = '" + date + "'";
//            ResultSet rs = stmt.executeQuery(data);
//
//            while (rs.next()) {
//                list.add(rs.getString("student_id"));
//                list.add(rs.getString("first_name"));
//                list.add(rs.getString("second_name"));
//                patient_list.add(list);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (stmt != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return patient_list;
//    }
    ArrayList<ArrayList<String>> getMyWaiting2(String userId) {
        ArrayList<ArrayList<String>> patient_list = new ArrayList<ArrayList<String>>();

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select * from `waiting_patients` w join patient p on w.student_id = p.student_id where w.status = 2 and date = '" + date + "' and complete = 0 and allocated_user = '" + userId + "'order by date";
            ResultSet rs = stmt.executeQuery(data);

            while (rs.next()) {
                ArrayList<String> list = new ArrayList<>();
                list.add(rs.getString("student_id"));
                list.add(rs.getString("full_name"));
                list.add(rs.getString("date"));
                patient_list.add(list);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
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
        return patient_list;
    }

    ArrayList<Patient_Full_info> getPatient_History(String student_id) {
        int count = 0;
        ArrayList<Patient_Full_info> pt = new ArrayList<Patient_Full_info>();

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            System.out.println("id........" + student_id.toLowerCase());
            String data = "select * from `patient` p join `history` h on p.student_id = h.student_id join diagnoses d on d.student_id = p.student_id  where h.student_id = '" + student_id + "'";
            ResultSet rs = stmt.executeQuery(data);

            Date historyDate;
            while (rs.next()) {
                System.out.println("in...........");
                Patient_Full_info ptinfo = new Patient_Full_info();
                Date date = rs.getDate("h.date");
                ptinfo.getPatient().setBirth_date(rs.getDate("p.birth_date").toString());
                ptinfo.getPatient().setDepartment(rs.getString("p.department"));
                ptinfo.getPatient().setFull_name(rs.getString("p.full_name"));
                ptinfo.getPatient().setSex(rs.getString("p.sex"));
                ptinfo.getPatient().setStudent_id(rs.getString("p.student_id"));

                historyDate = rs.getDate("h.date");
                ptinfo.getHistory().setSubjective(rs.getString("subjective"));
                ptinfo.getHistory().setDate(rs.getDate("date"));
                ptinfo.getHistory().setObjective(rs.getString("objective"));
                ptinfo.getHistory().setAssessment(rs.getString("assessment"));
                ptinfo.getHistory().setPlan(rs.getString("plan"));
                ptinfo.getHistory().setStudent_id(rs.getString("h.student_id"));
                ptinfo.getHistory().setCreatedBy(rs.getString("h.created_by"));
                ptinfo.getHistory().setModifiedBy(rs.getString("h.modified_by"));
                ptinfo.getDx().setDiagnoses(rs.getString("d.diagnoses"));

//                System.out.println("there is data");
//                String labData = "select * from `labratory` where student_id = '" + student_id + "' and date = '" + date + "'";
//                Statement stmt2 = (Statement) conn.createStatement();
////                ResultSet labrs = stmt2.executeQuery(labData);
//                ArrayList<Labratory> labList = new ArrayList<Labratory>();
//
//                while (labrs.next()) {
//                    Labratory lab = new Labratory();
//                    lab.setTestType(labrs.getString("test_type"));
//                    lab.setResult(labrs.getString("result"));
//                    labList.add(lab);
//                }
//                ptinfo.setLab(labList);
//                stmt2.close();
//                ArrayList<Prescription> txList = new ArrayList<Prescription>();
//                stmt2 = (Statement) conn.createStatement();
//                String txData = "select * from `prescription` where student_id = '" + student_id + "' and date = '" + date + "'";
//                ResultSet txrs = stmt2.executeQuery(txData);
//
//                String dxData = "select * from `diagnoses` where student_id = '" + student_id + "' and date = '" + date + "'";
//                Statement stmt3 = (Statement) conn.createStatement();
//                ResultSet dxrs = stmt3.executeQuery(dxData);
//                while(dxrs.next()){
//                   ptinfo.getDx().setDate(dxrs.getDate("date"));
//                ptinfo.getDx().setDiagnoses(dxrs.getString("diagnoses"));
//                ptinfo.getDx().setStudent_id(dxrs.getString("student_id")); 
//                }
//                    
//                while (txrs.next()) {
//                    Prescription tx = new Prescription();
//                    tx.setDrug_name(txrs.getString("drug_name"));
//                    tx.setDetail(txrs.getString("detail"));
//                    txList.add(tx);
//                }
//                stmt2.close();
//                ptinfo.setPrescription(txList);
                pt.add(ptinfo);
                count++;

            }
//           
//            
//            data = "select * from `patient` p left join `history` h on p.student_id = h.student_id left join `diagnoses` d on h.date = d.date and h.student_id = d.student_id where p.student_id = '" + student_id + "'";
//            rs = stmt.executeQuery(data);

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
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

        return pt;
    }

    void changeStatus(String id, String userId, int room, int status) {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();

            String data = "UPDATE `waiting_patients` SET `allocated_user`='" + userId + "',`status`= 1,`room` = " + room + ", `t2` = NOW(),complete = " + 0 + " WHERE student_id = '" + id + "' and date = '" + date + "'";
            stmt.executeUpdate(data);
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ArrayList<Hmis> getDiagnoses() {
        ArrayList<Hmis> db = new ArrayList<>();

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select * from diagnoses_options";
            ResultSet rs = stmt.executeQuery(data);

            while (rs.next()) {
                Hmis hmis = new Hmis();
                hmis.setCode(rs.getString("code"));
                hmis.setDx(rs.getString("name"));
                db.add(hmis);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
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

        return db;
    }

    void setDiagnoses(String dx, String id) {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "INSERT INTO `diagnoses` (`student_id`,`diagnoses`) values('" + id + "','" + dx + "')";
            stmt.execute(data);
        } catch (Exception e) {
//            System.out.println("database error: " + e);
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
    }

    void saveHistory(String student_id, String subjective, String objective, String assessment, String plan, String clinicianName, int st) {
        try {
            System.out.println("arived at save history .....");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "INSERT INTO `history` (`student_id`,`subjective`,`objective`,`assessment`,`plan`,`date`,`created_by`,modified_by,date_modified, status) values('" + student_id + "','" + subjective + "','" + objective + "','" + assessment + "','" + plan + "', NOW(),'" + clinicianName + "','" + clinicianName + "', NOW()," + st + ") ON DUPLICATE KEY UPDATE "
                    + "`subjective`='"+subjective+"',`objective`='"+objective+"',`assessment`='"+assessment+"',`plan`='"+plan+"',modified_by = '"+clinicianName+"',date_modified=NOW(), status="+st;
            
            String query = "INSERT INTO table_name (column1, column2) VALUES (?, ?) ON DUPLICATE KEY UPDATE column1=VALUES(column1), column2=VALUES(column2)";

            boolean n = stmt.execute(data);

            if (n) {
//                JOptionPane.showMessageDialog(null, "History not Saved");
            } else {
//                JOptionPane.showMessageDialog(null, "History Saved");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "database error: " + e);
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
    }

    void saveLab(ArrayList<Labratory> labTest) {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();

            for (int i = 0; i < labTest.size(); i++) {
                String data = "INSERT INTO `labratory` (`student_id`,`test_type`,`result`) values('" + labTest.get(i).getStudent_id() + "','" + labTest.get(i).getTestType() + "','" + labTest.get(i).getResult() + "')";
                stmt.execute(data);
            }

//            System.out.println("Db accepted 2");
        } catch (Exception e) {
//            System.out.println("database error: " + e);
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

    }

    void saveDx(String dx, String student_id) {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();

            String data = "INSERT INTO `diagnoses` (`student_id`,`diagnoses`,date) values('" + student_id + "','" + dx + "', NOW())";
            stmt.execute(data);
//            JOptionPane.showMessageDialog(null, "Saved!");
//            System.out.println("Db accepted 2");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "You already saved this diagnoses\n" + e, "Warning", ERROR_MESSAGE);
//            System.out.println("database error: " + e);
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
    }

//    void savePrescription(ArrayList<Prescription> prescriptions) {
//        try {
//            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
////            System.out.println("Connection is created successfully:");
//            stmt = (Statement) conn.createStatement();
//
//            for (int i = 0; i < prescriptions.size(); i++) {
//                String data = "INSERT INTO `prescription` (`student_id`,`drug_name`,`detail`,`quantity`,`unit`) values('" + prescriptions.get(i).getStudent_id() + "','" + prescriptions.get(i).getDrug_name() + "','" + prescriptions.get(i).getDetail() + "','" + prescriptions.get(i).getQty() + "','" + prescriptions.get(i).getUnit() + "')";
//                stmt.execute(data);
//            }
//
////            System.out.println("Db accepted 2");
//        } catch (Exception e) {
////            System.out.println("database error: " + e);
//        } finally {
//            try {
//                if (stmt != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
    void remove_waiting(String id) {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String data = "DELETE FROM `waiting_patients` WHERE student_id = '" + id + "' and date = '" + date + "'";
            stmt.executeUpdate(data);

//            System.out.println("Db accepted 2");
        } catch (Exception e) {
//            System.out.println("database error: " + e);
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

    }

    ArrayList<Patient> getAllpatients() {
        ArrayList<Patient> pt = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select * from patient";
            ResultSet rs = stmt.executeQuery(data);

            while (rs.next()) {
                Patient p = new Patient();
                p.setStudent_id(rs.getString("student_id").toLowerCase());
                p.setFull_name(rs.getString("full_name").toLowerCase());
                pt.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
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

        return pt;
    }

    void updateHistory(String id, String subjective, String objective, String assessment, String plan, String drName, String date, int st) throws SQLException {
//        System.out.println("student id is..." + id + " plan is " + plan);
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "UPDATE `history` set `subjective` = '" + subjective + "',`objective` = '" + objective + "',`assessment`= '" + assessment + "' ,`plan`= '" + plan + "',`modified_by`='" + drName + "',`date_modified`= NOW() ,`status` =" + st + " where date = '" + date + "' and student_id = '" + id + "'";
            stmt.executeUpdate(data);
//            System.out.println("are we hereeee........");
            data = "UPDATE `waiting_patients` set `complete` =" + st + " where date = '" + date + "' and student_id = '" + id + "'";
            stmt.executeUpdate(data);
//            System.out.println("Noooo hereeee........");

//            JOptionPane.showMessageDialog(null, "Update Sucess!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        } finally {
            conn.close();
        }
    }

    ArrayList<String> getReferals(int room) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String st = "select * from referal where toRoom = " + room + " and status = 0";
            ResultSet rs = stmt.executeQuery(st);

            while (rs.next()) {
                data.add(rs.getString("student_id") + "," + rs.getString("date"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return data;
    }

    void sendReferal(String id, String userId, int room, String reason) throws SQLException {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "INSERT INTO `referal`(`student_id`, `referedBy`, `toRoom`, `reason`) VALUES ('" + id + "','" + userId + "'," + room + ",'" + reason + "')";
            stmt.executeUpdate(data);
            JOptionPane.showMessageDialog(null, "Referal Sent!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        } finally {
            conn.close();
        }
    }

    void updateReferalStatus(String userId, String student_id, String referalDate, int room) throws SQLException {
//        System.out.println("sent to update..........................fffffgdgdfgdf rdate is "+referalDate+" room is "+room+ " id is "+ student_id);
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "UPDATE `referal` SET `referedTo`='" + userId + "',`status`= 1 WHERE date = '" + referalDate + "' and toRoom = " + room + " and student_id = '" + student_id + "'";
            stmt.executeUpdate(data);
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    void updateMissing(String stid) throws SQLException {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date today = new java.sql.Date(utilDate.getTime());
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "UPDATE `waiting_patients` SET `status`= 3 WHERE date = '" + today + "' and student_id = '" + stid + "'";
            stmt.executeUpdate(data);
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

//    ArrayList<String> getAvailableDrugList() {
//         ArrayList<String> list = new ArrayList<>();
//          conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
//            stmt = (Statement) conn.createStatement();
//            String st = "select * from drugs where status = 1";
//            ResultSet rs = stmt.executeQuery(st);
//
//            while (rs.next()) {
//                list.add(rs.getString("student_id") + "," + rs.getString("date"));
//            }
//         
//         return list;
//    }
    void addPrescription(ArrayList<Prescription> prescriptions) {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            for (int i = 0; i < prescriptions.size(); i++) {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `prescription`(`student_id`, `drug_name`, `detail`, `unit`,`unit_price`,`expiry_date`, `status`,`clinician`, `qty`,`tax`,`profit_margin`,`total_price`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, prescriptions.get(i).getStudent_id());
                pstmt.setString(2, prescriptions.get(i).getDrug_name());
                pstmt.setString(3, prescriptions.get(i).getDetail());
                pstmt.setString(4, prescriptions.get(i).getUnit());
                pstmt.setDouble(5, prescriptions.get(i).getUnitPrice());
                pstmt.setString(6, prescriptions.get(i).getExpiry_date());
                pstmt.setString(7, prescriptions.get(i).getStatus());
                pstmt.setString(8, prescriptions.get(i).getClinicianName());
                pstmt.setInt(9, prescriptions.get(i).getQty());
                pstmt.setString(10, prescriptions.get(i).getTax());
                pstmt.setString(11, prescriptions.get(i).getProfit_margin());
                pstmt.setDouble(12, prescriptions.get(i).getTotal_price());

                pstmt.execute();
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

    }

    void changeStaus_as_called(String student_id) throws SQLException {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "UPDATE `waiting_patients` SET `status`= 2 WHERE student_id = '" + student_id + "'";
            stmt.executeUpdate(data);
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    ArrayList<String[]> getWaitingClerk() {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbname, user, sec);
            stmt = (Statement) conn.createStatement();
            String data = "select p.student_id, `full_name`,`room`,`allocated_user`,`status`, TIMEDIFF(NOW(),`t1`) as t from `waiting_patients` w join patient p on w.student_id = p.student_id where date = '" + date + "' order by t1";
            ResultSet rs = stmt.executeQuery(data);
            while (rs.next()) {
                String[] message = new String[5];
                message[0] = rs.getString("full_name") + "(" + rs.getString("student_id") + ")";
                message[1] = String.valueOf(rs.getInt("room"));
                message[2] = rs.getString("allocated_user");
                message[3] = rs.getString("t");
                message[4] = String.valueOf(rs.getInt("status"));
////                System.out.println("status......and...time diff.." + message[4] + ", " + message[3]);
                list.add(message);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
        }
        return list;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.sql.Date;

/**
 *
 * @author yibe1
 */
public class Waiting_patient {
    private String student_id, allocated_user;//allocated user is to mean the clinician who calls the patient
    private int status;//0- waiting, 1- called and on progress, 2 - complete
    private Date date;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAllocated_user() {
        return allocated_user;
    }

    public void setAllocated_user(String allocated_user) {
        this.allocated_user = allocated_user;
    }
    
    
}

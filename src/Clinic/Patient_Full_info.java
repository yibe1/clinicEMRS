/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author yibe1
 */
public class Patient_Full_info {
    private Date date;
    private Patient patient;
    private History history;
    private ArrayList<Labratory> lab;
    private Diagnoses dx;
    private ArrayList<Prescription> prescription;

    public Patient_Full_info() {
   
        this.patient = new Patient();
        this.history = new History();
        this.lab = new ArrayList<Labratory>();
        this.dx = new Diagnoses();
        this.prescription = new ArrayList<Prescription>();
    }
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    
    public Diagnoses getDx() {
        return dx;
    }

    public void setDx(Diagnoses dx) {
        this.dx = dx;
    }

    public ArrayList<Labratory> getLab() {
        return lab;
    }

    public void setLab(ArrayList<Labratory> lab) {
        this.lab = lab;
    }

    public ArrayList<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(ArrayList<Prescription> prescription) {
        this.prescription = prescription;
    }

  
    
}

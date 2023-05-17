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
public class Prescription {

    private String student_id, drug_name, detail, unit, status, clinicianName, batchN, expiry_date;
    private int qty;
    private double unitPrice;
    private Date date;
    private String profit_margin;
    private String tax;
    private double total_price;

    public String getDrug_name() {
        return drug_name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getBatchN() {
        return batchN;
    }

    public void setBatchN(String batchN) {
        this.batchN = batchN;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detaul) {
        this.detail = detaul;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClinicianName() {
        return clinicianName;
    }

    public void setClinicianName(String clinicianName) {
        this.clinicianName = clinicianName;
    }

    public String getProfit_margin() {
        return profit_margin;
    }

    public void setProfit_margin(String profit_margin) {
        this.profit_margin = profit_margin;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

}

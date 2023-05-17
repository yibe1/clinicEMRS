/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharm;

/**
 *
 * @author YIBE
 */
public class Drug {
    private String generic_name, manufacturer,tr_type, created_by, last_mod_by;
    private String strength,brand_name,basic_unit,batch_number, expiry_date, prefered_unit;
    private int  quantity,total_mod;
    private double unit_price;
    private String date, last_mod_date;

    public String getGeneric_name() {
        return generic_name;
    }
    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }
    public String getBrand_name() {
        return brand_name;
    }
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    public String getBasic_unit() {
        return basic_unit;
    }
    public void setBasic_unit(String basic_unit) {
        this.basic_unit = basic_unit;
    }
    public String getPrefered_unit() {
        return prefered_unit;
    }
    public void setPrefered_unit(String prefered_unit) {
        this.prefered_unit = prefered_unit;
    } 
    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }   

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTr_type() {
        return tr_type;
    }

    public void setTr_type(String tr_type) {
        this.tr_type = tr_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_mod_by() {
        return last_mod_by;
    }

    public void setLast_mod_by(String last_mod_by) {
        this.last_mod_by = last_mod_by;
    }

    public int getTotal_mod() {
        return total_mod;
    }

    public void setTotal_mod(int total_mod) {
        this.total_mod = total_mod;
    }

    public String getLast_mod_date() {
        return last_mod_date;
    }

    public void setLast_mod_date(String last_mod_date) {
        this.last_mod_date = last_mod_date;
    }
    
    
}

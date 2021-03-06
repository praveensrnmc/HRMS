package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model class for AllowanceVariant
 * Setter and Getter methods for the class variables
 * Many to One mapping is established for AllowanceVariant model class
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-15
 */
@Entity
@Table(name="allowance_variant")
public class AllowanceVariant {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    
    @OneToOne
    @JoinColumn(name="designation_id")
    private Designation designation; 
    
    @Column(name="houserent_allowance")
    private float houseRentAllowance;
    
    @Column(name="dearness_allowance")
    private float dearnessAllowance;
    
    @Column(name="provident_fund")
    private float providentFund;
    
    @Column(name="medical_allowance")
    private float medicalAllowance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public float getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(float houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public float getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(float dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }

    public float getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(float providentFund) {
        this.providentFund = providentFund;
    }

    public float getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(float medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }
}

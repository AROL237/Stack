/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SIGNING
 */
@Entity
@Table(name = "specialty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialty.findAll", query = "SELECT s FROM Specialty s"),
    @NamedQuery(name = "Specialty.findByOpId", query = "SELECT s FROM Specialty s WHERE s.specialtyPK.opId = :opId"),
    @NamedQuery(name = "Specialty.findBySpCode", query = "SELECT s FROM Specialty s WHERE s.specialtyPK.spCode = :spCode"),
    @NamedQuery(name = "Specialty.findBySpName", query = "SELECT s FROM Specialty s WHERE s.spName = :spName"),
    @NamedQuery(name = "Specialty.findByDescription", query = "SELECT s FROM Specialty s WHERE s.description = :description")})
public class Specialty implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecialtyPK specialtyPK;
    @Basic(optional = false)
    @Column(name = "sp_name")
    private String spName;
    @Column(name = "Description")
    private String description;

    public Specialty() {
    }

    public Specialty(SpecialtyPK specialtyPK) {
        this.specialtyPK = specialtyPK;
    }

    public Specialty(SpecialtyPK specialtyPK, String spName) {
        this.specialtyPK = specialtyPK;
        this.spName = spName;
    }

    public Specialty(int opId, String spCode) {
        this.specialtyPK = new SpecialtyPK(opId, spCode);
    }

    public SpecialtyPK getSpecialtyPK() {
        return specialtyPK;
    }

    public void setSpecialtyPK(SpecialtyPK specialtyPK) {
        this.specialtyPK = specialtyPK;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialtyPK != null ? specialtyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialty)) {
            return false;
        }
        Specialty other = (Specialty) object;
        if ((this.specialtyPK == null && other.specialtyPK != null) || (this.specialtyPK != null && !this.specialtyPK.equals(other.specialtyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.Specialty[ specialtyPK=" + specialtyPK + " ]";
    }
    
}

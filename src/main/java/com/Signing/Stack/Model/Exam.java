/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SIGNING
 */
@Entity
@Table(name = "exam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findByExid", query = "SELECT e FROM Exam e WHERE e.exid = :exid"),
    @NamedQuery(name = "Exam.findByExname", query = "SELECT e FROM Exam e WHERE e.exname = :exname"),
    @NamedQuery(name = "Exam.findByDescription", query = "SELECT e FROM Exam e WHERE e.description = :description")})
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Ex_id")
    private Integer exid;
    @Basic(optional = false)
    @Column(name = "Ex_name")
    private String exname;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "exid")
    private Set<Options> optionsSet;

    public Exam() {
    }

    public Exam(Integer exid) {
        this.exid = exid;
    }

    public Exam(Integer exid, String exname) {
        this.exid = exid;
        this.exname = exname;
    }

    public Integer getExid() {
        return exid;
    }

    public void setExid(Integer exid) {
        this.exid = exid;
    }

    public String getExname() {
        return exname;
    }

    public void setExname(String exname) {
        this.exname = exname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Set<Options> getOptionsSet() {
        return optionsSet;
    }

    public void setOptionsSet(Set<Options> optionsSet) {
        this.optionsSet = optionsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exid != null ? exid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.exid == null && other.exid != null) || (this.exid != null && !this.exid.equals(other.exid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.Exam[ exid=" + exid + " ]";
    }
    
}

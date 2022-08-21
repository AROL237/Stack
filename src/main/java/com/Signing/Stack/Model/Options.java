/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SIGNING
 */
@Entity
@Table(name = "options")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Options.findAll", query = "SELECT o FROM Options o"),
    @NamedQuery(name = "Options.findByOpId", query = "SELECT o FROM Options o WHERE o.opId = :opId"),
    @NamedQuery(name = "Options.findByOpName", query = "SELECT o FROM Options o WHERE o.opName = :opName"),
    @NamedQuery(name = "Options.findByDescription", query = "SELECT o FROM Options o WHERE o.description = :description")})
public class Options implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "op_id")
    private Integer opId;
    @Basic(optional = false)
    @Column(name = "op_name")
    private String opName;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Ex_id", referencedColumnName = "Ex_id")
    @ManyToOne
    private Exam exid;

    public Options() {
    }

    public Options(Integer opId) {
        this.opId = opId;
    }

    public Options(Integer opId, String opName) {
        this.opId = opId;
        this.opName = opName;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exam getExid() {
        return exid;
    }

    public void setExid(Exam exid) {
        this.exid = exid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opId != null ? opId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Options)) {
            return false;
        }
        Options other = (Options) object;
        if ((this.opId == null && other.opId != null) || (this.opId != null && !this.opId.equals(other.opId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.Options[ opId=" + opId + " ]";
    }
    
}

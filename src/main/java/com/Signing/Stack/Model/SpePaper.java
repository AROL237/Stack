/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "spe_paper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpePaper.findAll", query = "SELECT s FROM SpePaper s"),
    @NamedQuery(name = "SpePaper.findByOpId", query = "SELECT s FROM SpePaper s WHERE s.spePaperPK.opId = :opId"),
    @NamedQuery(name = "SpePaper.findBySpCode", query = "SELECT s FROM SpePaper s WHERE s.spePaperPK.spCode = :spCode"),
    @NamedQuery(name = "SpePaper.findByPid", query = "SELECT s FROM SpePaper s WHERE s.spePaperPK.pid = :pid")})
public class SpePaper implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpePaperPK spePaperPK;
    @JoinColumn(name = "P_id", referencedColumnName = "P_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paper paper;

    public SpePaper() {
    }

    public SpePaper(SpePaperPK spePaperPK) {
        this.spePaperPK = spePaperPK;
    }

    public SpePaper(int opId, String spCode, int pid) {
        this.spePaperPK = new SpePaperPK(opId, spCode, pid);
    }

    public SpePaperPK getSpePaperPK() {
        return spePaperPK;
    }

    public void setSpePaperPK(SpePaperPK spePaperPK) {
        this.spePaperPK = spePaperPK;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spePaperPK != null ? spePaperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpePaper)) {
            return false;
        }
        SpePaper other = (SpePaper) object;
        if ((this.spePaperPK == null && other.spePaperPK != null) || (this.spePaperPK != null && !this.spePaperPK.equals(other.spePaperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.SpePaper[ spePaperPK=" + spePaperPK + " ]";
    }
    
}

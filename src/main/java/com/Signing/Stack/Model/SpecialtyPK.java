/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author SIGNING
 */
@Embeddable
public class SpecialtyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "op_id")
    private int opId;
    @Basic(optional = false)
    @Column(name = "sp_code")
    private String spCode;

    public SpecialtyPK() {
    }

    public SpecialtyPK(int opId, String spCode) {
        this.opId = opId;
        this.spCode = spCode;
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) opId;
        hash += (spCode != null ? spCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialtyPK)) {
            return false;
        }
        SpecialtyPK other = (SpecialtyPK) object;
        if (this.opId != other.opId) {
            return false;
        }
        if ((this.spCode == null && other.spCode != null) || (this.spCode != null && !this.spCode.equals(other.spCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.SpecialtyPK[ opId=" + opId + ", spCode=" + spCode + " ]";
    }
    
}

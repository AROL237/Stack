/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "paper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paper.findAll", query = "SELECT p FROM Paper p"),
    @NamedQuery(name = "Paper.findByPid", query = "SELECT p FROM Paper p WHERE p.pid = :pid"),
    @NamedQuery(name = "Paper.findByCourseCode", query = "SELECT p FROM Paper p WHERE p.courseCode = :courseCode"),
    @NamedQuery(name = "Paper.findByCourseName", query = "SELECT p FROM Paper p WHERE p.courseName = :courseName"),
    @NamedQuery(name = "Paper.findByQuestiondoc", query = "SELECT p FROM Paper p WHERE p.questiondoc = :questiondoc"),
    @NamedQuery(name = "Paper.findBySolutionContent", query = "SELECT p FROM Paper p WHERE p.solutionContent = :solutionContent"),
    @NamedQuery(name = "Paper.findByYear", query = "SELECT p FROM Paper p WHERE p.year = :year"),
    @NamedQuery(name = "Paper.findByLevel", query = "SELECT p FROM Paper p WHERE p.level = :level")})
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_id")
    private Integer pid;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "Question_doc")
    private byte[] questiondoc;
    @Column(name = "solution_content")
    private byte[] solutionContent;
    @Column(name = "year")
    private String year;

    @Column(name = "level")
    private int level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paper")
    private Set<SpePaper> spePaperSet;

    public Paper() {
    }

    public Paper(Integer pid) {
        this.pid = pid;
    }

    public Paper(Integer pid, int level) {
        this.pid = pid;
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public byte[] getQuestiondoc() {
        return questiondoc;
    }

    public void setQuestiondoc(byte[] questiondoc) {
        this.questiondoc = questiondoc;
    }

    public byte[] getSolutionContent() {
        return solutionContent;
    }

    public void setSolutionContent(byte[] solutionContent) {
        this.solutionContent = solutionContent;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public Set<SpePaper> getSpePaperSet() {
        return spePaperSet;
    }

    public void setSpePaperSet(Set<SpePaper> spePaperSet) {
        this.spePaperSet = spePaperSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paper)) {
            return false;
        }
        Paper other = (Paper) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Signing.Stack.Model.Paper[ pid=" + pid + " ]";
    }
    
}

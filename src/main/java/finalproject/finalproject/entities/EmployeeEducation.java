/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RR17
 */
@Entity
@Table(name = "employee_education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeEducation.findAll", query = "SELECT e FROM EmployeeEducation e")
    , @NamedQuery(name = "EmployeeEducation.findById", query = "SELECT e FROM EmployeeEducation e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeEducation.findByGpa", query = "SELECT e FROM EmployeeEducation e WHERE e.gpa = :gpa")
    , @NamedQuery(name = "EmployeeEducation.findByStartDate", query = "SELECT e FROM EmployeeEducation e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "EmployeeEducation.findByEndDate", query = "SELECT e FROM EmployeeEducation e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "EmployeeEducation.findByIsDelete", query = "SELECT e FROM EmployeeEducation e WHERE e.isDelete = :isDelete")})
public class EmployeeEducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gpa")
    private float gpa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "is_delete")
    private String isDelete;
    @JoinColumn(name = "id_education", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Education idEducation;
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee idEmployee;

    public EmployeeEducation() {
    }

    public EmployeeEducation(Integer id) {
        this.id = id;
    }

    public EmployeeEducation(Integer id, float gpa, Date startDate, Date endDate, String isDelete) {
        this.id = id;
        this.gpa = gpa;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Education getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Education idEducation) {
        this.idEducation = idEducation;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEducation)) {
            return false;
        }
        EmployeeEducation other = (EmployeeEducation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.EmployeeEducation[ id=" + id + " ]";
    }
    
}

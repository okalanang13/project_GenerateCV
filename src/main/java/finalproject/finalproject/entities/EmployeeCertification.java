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
 * @author ASUS
 */
@Entity
@Table(name = "employee_certification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCertification.findAll", query = "SELECT e FROM EmployeeCertification e")
    , @NamedQuery(name = "EmployeeCertification.findById", query = "SELECT e FROM EmployeeCertification e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeCertification.findByName", query = "SELECT e FROM EmployeeCertification e WHERE e.name = :name")
    , @NamedQuery(name = "EmployeeCertification.findByDescription", query = "SELECT e FROM EmployeeCertification e WHERE e.description = :description")
    , @NamedQuery(name = "EmployeeCertification.findByStartDate", query = "SELECT e FROM EmployeeCertification e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "EmployeeCertification.findByEndDate", query = "SELECT e FROM EmployeeCertification e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "EmployeeCertification.findByIsDelete", query = "SELECT e FROM EmployeeCertification e WHERE e.isDelete = :isDelete")})
public class EmployeeCertification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "isDelete")
    private Character isDelete;
    @JoinColumn(name = "id_certification", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Certification idCertification;
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee idEmployee;

    public EmployeeCertification() {
    }

    public EmployeeCertification(Integer id) {
        this.id = id;
    }

    public EmployeeCertification(Integer id, String name, String description, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    public Certification getIdCertification() {
        return idCertification;
    }

    public void setIdCertification(Certification idCertification) {
        this.idCertification = idCertification;
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
        if (!(object instanceof EmployeeCertification)) {
            return false;
        }
        EmployeeCertification other = (EmployeeCertification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.EmployeeCertification[ id=" + id + " ]";
    }
    
}

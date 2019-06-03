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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RR17
 */
@Entity
@Table(name = "work_assignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkAssignment.findAll", query = "SELECT w FROM WorkAssignment w")
    , @NamedQuery(name = "WorkAssignment.findById", query = "SELECT w FROM WorkAssignment w WHERE w.id = :id")
    , @NamedQuery(name = "WorkAssignment.findByStartDate", query = "SELECT w FROM WorkAssignment w WHERE w.startDate = :startDate")
    , @NamedQuery(name = "WorkAssignment.findByEndDate", query = "SELECT w FROM WorkAssignment w WHERE w.endDate = :endDate")
    , @NamedQuery(name = "WorkAssignment.findByIsDelete", query = "SELECT w FROM WorkAssignment w WHERE w.isDelete = :isDelete")})
public class WorkAssignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "is_delete")
    private Character isDelete;
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee idEmployee;
    @JoinColumn(name = "id_job", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job idJob;

    public WorkAssignment() {
    }

    public WorkAssignment(Integer id) {
        this.id = id;
    }

    public WorkAssignment(Integer id, Date startDate, Date endDate, Character isDelete) {
        this.id = id;
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

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Job getIdJob() {
        return idJob;
    }

    public void setIdJob(Job idJob) {
        this.idJob = idJob;
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
        if (!(object instanceof WorkAssignment)) {
            return false;
        }
        WorkAssignment other = (WorkAssignment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.WorkAssignment[ id=" + id + " ]";
    }
    
}

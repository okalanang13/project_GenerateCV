/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RR17
 */
@Entity
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findById", query = "SELECT e FROM Education e WHERE e.id = :id")
    , @NamedQuery(name = "Education.findByIsDelete", query = "SELECT e FROM Education e WHERE e.isDelete = :isDelete")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "is_delete")
    private String isDelete;
    @JoinColumn(name = "id_college", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private College idCollege;
    @JoinColumn(name = "id_degree", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Degree idDegree;
    @JoinColumn(name = "id_major", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Major idMajor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEducation", fetch = FetchType.LAZY)
    private List<EmployeeEducation> employeeEducationList;

    public Education() {
    }

    public Education(String id) {
        this.id = id;
    }

    public Education(String id, String isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public College getIdCollege() {
        return idCollege;
    }

    public void setIdCollege(College idCollege) {
        this.idCollege = idCollege;
    }

    public Degree getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Degree idDegree) {
        this.idDegree = idDegree;
    }

    public Major getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(Major idMajor) {
        this.idMajor = idMajor;
    }

    @XmlTransient
    public List<EmployeeEducation> getEmployeeEducationList() {
        return employeeEducationList;
    }

    public void setEmployeeEducationList(List<EmployeeEducation> employeeEducationList) {
        this.employeeEducationList = employeeEducationList;
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
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.Education[ id=" + id + " ]";
    }
    
}

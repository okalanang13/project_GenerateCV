/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RR17
 */
@Entity
@Table(name = "employee_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeLanguage.findAll", query = "SELECT e FROM EmployeeLanguage e")
    , @NamedQuery(name = "EmployeeLanguage.findById", query = "SELECT e FROM EmployeeLanguage e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeLanguage.findByIsDelete", query = "SELECT e FROM EmployeeLanguage e WHERE e.isDelete = :isDelete")})
public class EmployeeLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_delete")
    private Character isDelete;
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee idEmployee;
    @JoinColumn(name = "id_language", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language idLanguage;

    public EmployeeLanguage() {
    }

    public EmployeeLanguage(Integer id) {
        this.id = id;
    }

    public EmployeeLanguage(Integer id, Character isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Language getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Language idLanguage) {
        this.idLanguage = idLanguage;
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
        if (!(object instanceof EmployeeLanguage)) {
            return false;
        }
        EmployeeLanguage other = (EmployeeLanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.EmployeeLanguage[ id=" + id + " ]";
    }
    
}

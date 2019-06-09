/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "employee_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeSkill.findAll", query = "SELECT e FROM EmployeeSkill e")
    , @NamedQuery(name = "EmployeeSkill.findById", query = "SELECT e FROM EmployeeSkill e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeSkill.findByRating", query = "SELECT e FROM EmployeeSkill e WHERE e.rating = :rating")
    , @NamedQuery(name = "EmployeeSkill.findByIsDelete", query = "SELECT e FROM EmployeeSkill e WHERE e.isDelete = :isDelete")})
public class EmployeeSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rating")
    private String rating;
    @Column(name = "is_delete")
    private Character isDelete;
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee idEmployee;
    @JoinColumn(name = "id_skill", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Skill idSkill;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Integer id) {
        this.id = id;
    }

    public EmployeeSkill(Integer id, String rating) {
        this.id = id;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public Skill getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Skill idSkill) {
        this.idSkill = idSkill;
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
        if (!(object instanceof EmployeeSkill)) {
            return false;
        }
        EmployeeSkill other = (EmployeeSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.mii.bootcamp.mii.entities.EmployeeSkill[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author ASUS
 */
@Entity
@Table(name = "training")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t")
    , @NamedQuery(name = "Training.findById", query = "SELECT t FROM Training t WHERE t.id = :id")
    , @NamedQuery(name = "Training.findByName", query = "SELECT t FROM Training t WHERE t.name = :name")
    , @NamedQuery(name = "Training.findByIsDelete", query = "SELECT t FROM Training t WHERE t.isDelete = :isDelete")})
public class Training implements Serializable {

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
    @Column(name = "isDelete")
    private Character isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTraining", fetch = FetchType.LAZY)
    private List<EmployeeTraining> employeeTrainingList;

    public Training() {
    }

    public Training(Integer id) {
        this.id = id;
    }

    public Training(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<EmployeeTraining> getEmployeeTrainingList() {
        return employeeTrainingList;
    }

    public void setEmployeeTrainingList(List<EmployeeTraining> employeeTrainingList) {
        this.employeeTrainingList = employeeTrainingList;
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
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.Training[ id=" + id + " ]";
    }
    
}

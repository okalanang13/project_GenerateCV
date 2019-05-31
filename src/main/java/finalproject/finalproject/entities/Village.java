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
@Table(name = "village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Village.findAll", query = "SELECT v FROM Village v")
    , @NamedQuery(name = "Village.findById", query = "SELECT v FROM Village v WHERE v.id = :id")
    , @NamedQuery(name = "Village.findByName", query = "SELECT v FROM Village v WHERE v.name = :name")
    , @NamedQuery(name = "Village.findByPostalCode", query = "SELECT v FROM Village v WHERE v.postalCode = :postalCode")
    , @NamedQuery(name = "Village.findByIsDelete", query = "SELECT v FROM Village v WHERE v.isDelete = :isDelete")})
public class Village implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_delete")
    private Character isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVillage", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "id_subdistrict", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdistrict idSubdistrict;

    public Village() {
    }

    public Village(String id) {
        this.id = id;
    }

    public Village(String id, String name, String postalCode, Character isDelete) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Subdistrict getIdSubdistrict() {
        return idSubdistrict;
    }

    public void setIdSubdistrict(Subdistrict idSubdistrict) {
        this.idSubdistrict = idSubdistrict;
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
        if (!(object instanceof Village)) {
            return false;
        }
        Village other = (Village) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.finalproject.entities.Village[ id=" + id + " ]";
    }
    
}
